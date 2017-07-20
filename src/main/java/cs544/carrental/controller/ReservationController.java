package cs544.carrental.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.emailservice.EmailService;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.CustomerService;
import cs544.carrental.service.PaymentService;
import cs544.carrental.service.ReservationService;
import cs544.carrental.service.VehicleService;
import cs544.carrental.service.impl.CustomerServiceImpl;
import cs544.carrental.service.impl.VehicleServiceImpl;

@RequestMapping("/reservation/")
@Controller
public class ReservationController {

	@Autowired
	VehicleService vehicleService;
	@Autowired
	CustomerService personService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	AccountService accountService;
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	EmailService emailServiceJAVA;

	@RequestMapping(value = "admin/list/{state}", method = RequestMethod.GET)
	public String showList(@PathVariable("state") int state, Model model) {
		List<Reservation> list = reservationService.getAll(state);
		model.addAttribute("reservations", list);
		model.addAttribute("stateName", state == 0 ? "Active" : state == 2 ? "History" : "");

		return "reservation/admin/reservationList";

	}

	@RequestMapping(value = "admin/delete/{resid}", method = RequestMethod.GET)
	public String delete(@PathVariable("resid") long resId) {
		Reservation reservation = reservationService.findById(resId);
		int state = reservation.getState();

		Vehicle vehicle = reservation.getVehicle();
		System.out.println(vehicle.toString());
		vehicle.setIsAvailable(true);
		vehicleService.update(vehicle);

		Payment payment = paymentService.findPaymentByReservationID(resId);
		paymentService.delete(payment.getPaymentId());

		reservationService.delete(resId);

		return "redirect:/reservation/admin/list/" + state + "";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showCustomerList(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = accountService.findByUserName(userDetails.getUsername());
		long customerId = account.getCustomer().getId();
		List<Reservation> list = reservationService.findAllByCustomerId(customerId);

		model.addAttribute("reservations", list);
		return "reservation/reservationList";
	}

	@RequestMapping(value = "cancel/{resid}", method = RequestMethod.GET)
	public String cancelCustomerReservation(@PathVariable("resid") long resId) {
		Reservation reservation = reservationService.findById(resId);
		Vehicle vehicle = reservation.getVehicle();
		System.out.println(vehicle.toString());
		vehicle.setIsAvailable(true);
		vehicleService.update(vehicle);

		reservation.setState(1); // Cancelled
		reservationService.update(reservation);

		return "redirect:/reservation/list";
	}

	@RequestMapping("add/{carid}")
	public String showForm(@PathVariable("carid") int carNumber, Reservation reservation, Model model,
			HttpSession session) {
		model.addAttribute("carNumber", carNumber);
		session.setAttribute("order", reservation);
		return "reservation/addreservation";
	}

	@RequestMapping(value = "add/{carid}", method = RequestMethod.POST)
	public String add(@PathVariable("carid") int carNumber, @ModelAttribute Reservation reservation, Model model,
			BindingResult bindingResult, HttpSession session) throws MessagingException {
		System.out.println("car number:" + carNumber);
		Vehicle vehicle = vehicleService.findByVehicleId(carNumber);
		System.out.println(vehicle.getDailyRate());

		Reservation cart = (Reservation) session.getAttribute("order");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("username:" + userDetails.getUsername());
		Account acct = accountService.findByUserName(userDetails.getUsername());
		Customer customer = acct.getCustomer();
		System.out.println(customer.getEmail());
		reservation.setCustomer(customer);
		reservation.setVehicle(vehicle);

		vehicle.setVehicleId(carNumber);
		reservationService.save(reservation);
		vehicle.setIsAvailable(false);
		vehicleService.update(vehicle);

		session.setAttribute("reservationObject", reservation);
		double totalDay = reservation.getReturnDateTime().getDay() - reservation.getPickUpDateTime().getDay();
		double dayPrice = vehicle.getDailyRate();
		double totalPrice = totalDay * dayPrice;
		System.out.println("totalPrice:" + totalPrice);
		session.setAttribute("totalPriceSession", totalPrice);

		sendEmail(reservation);
		return "redirect:/payment/add-payment";
	}

	

	@SuppressWarnings("null")
	@RequestMapping(value = "/returnlist", method = RequestMethod.GET)
	public String showCustomerCurrentReservations(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = accountService.findByUserName(userDetails.getUsername());
		long customerId = account.getCustomer().getId();
		List<Reservation> list = reservationService.findAllByCustomerId(customerId);

		model.addAttribute("reservations", list);
		return "reservation/returnvehicle";
	}

	@RequestMapping(value = "/return/{resid}", method = RequestMethod.GET)
	public String returnVehicle(@PathVariable("resid") long resId) {
		Reservation reservation = reservationService.findById(resId);
		Vehicle vehicle = reservation.getVehicle();
		System.out.println(vehicle.toString());
		vehicle.setIsAvailable(true);
		vehicleService.update(vehicle);

		reservation.setState(2); // Returned
		reservationService.update(reservation);

		return "redirect:/reservation/returnlist";
	}
	
	private void sendEmail(Reservation reservation) throws MessagingException {
//		Calendar cal = Calendar.getInstance(); 
//	    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//	    Date d1 = df.parse("07-18-2017"); // for example, today's date
//	    Date d2 = df.parse("07-20-2017"); // use your own dates, of course
	    
		Vehicle vehicle = reservation.getVehicle();
		Customer customer = reservation.getCustomer();
	    
	    Reservation order = new Reservation(reservation.getPickUpDateTime(),reservation.getReservationDateTime() 
	    		,reservation.getMileageIn(),reservation.getDailyRate(),reservation.getFinePerDay(),reservation.getPricePerDay(),1,vehicle,customer);
	    String documentName = "AlarmClock.docx";
//	    EmailService emailService = (EmailService) context.getBean("emailService");
	    emailServiceJAVA.sendOrderReceivedMail("CarRental", customer.getCustomerNumber(),order,documentName,new Locale("en"));
	  
	    System.out.println("You Have BOOKED with us Car !!");
		
	}
}
