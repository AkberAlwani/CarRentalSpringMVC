package cs544.carrental.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Reservation;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.CustomerService;
import cs544.carrental.service.ReservationService;
import cs544.carrental.service.VehicleService;

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

	// ========================Yong=============================

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
		Vehicle vehicle = reservation.getVehicle();
		System.out.println(vehicle.toString());
		vehicle.setIsAvailable(true);
		vehicleService.update(vehicle);
		reservationService.delete(resId);

		return "redirect:/reservation/admin/list";
	}

	// =====================================================

	// ======================Tao===============================
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
	public String showForm(@PathVariable("carid") int carNumber, Reservation reservation, Model model) {
		model.addAttribute("carNumber", carNumber);
		return "reservation/addreservation";
	}

	@RequestMapping(value = "add/{carid}", method = RequestMethod.POST)
	public String add(@PathVariable("carid") int carNumber, @ModelAttribute Reservation reservation, Model model,
			BindingResult bindingResult, HttpSession sessionRev) {
		// Person person = (Person) session.getAttribute("person");
		System.out.println("car number:" + carNumber);
		Vehicle vehicle = vehicleService.findByVehicleId(carNumber);
		System.out.println(vehicle.getDailyRate());
		// Person person = personService.findById(1);
		// Customer customer= (Customer) sessionRev.getAttribute("customer");
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

		sessionRev.setAttribute("reservationObject", reservation);
		double totalDay = reservation.getReturnDateTime().getDay() - reservation.getPickUpDateTime().getDay();
		double dayPrice = vehicle.getDailyRate();
		double totalPrice = totalDay * dayPrice;
		System.out.println("totalPrice:" + totalPrice);
		sessionRev.setAttribute("totalPriceSession", totalPrice);
		// if(addPayment.equals("Yes")){
		return "redirect:/payment/add-payment";
		// }
		// model.addAttribute("reservations", reservationService.getAll());
		// return "redirect:/reservation/list";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/returnlist", method = RequestMethod.GET)
	public String showCustomerCurrentReservations(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = accountService.findByUserName(userDetails.getUsername());
		long customerId = account.getCustomer().getId();
		List<Reservation> list = reservationService.findAllByCustomerId(customerId);
		
//		List<Double> totalPrices = null;
//		for(Reservation reservation : list) {
//			double totalDay = reservation.getReturnDateTime().getDay() - reservation.getPickUpDateTime().getDay();
//			double dayPrice = reservation.getVehicle().getDailyRate();
//			totalPrices.add(totalDay * dayPrice);
//		}
//
//		model.addAttribute("totalPriceList", totalPrices);
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
	
	// ======================Tao=========end======================

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf.setLenient(true);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
//
//	@RequestMapping(value = "update/{carid}", method = RequestMethod.GET)
//	public String update(@PathVariable("carid") int carNumber, @ModelAttribute Reservation reservation, Model model,
//			BindingResult bindingResult, HttpSession session) {
//		// Person person = (Person) session.getAttribute("person");
//		Reservation res = reservationService.findById(reservation.getReservationId());
//		res.setPickUpDateTime(reservation.getPickUpDateTime());
//		res.setReservationDateTime(reservation.getReservationDateTime());
//		res.setReturnDateTime(reservation.getReturnDateTime());
//		reservationService.update(reservation);
//		return "redirect:/reservation/list";
//	}
//
//	@RequestMapping(value = "edit/{resid}", method = RequestMethod.GET)
//	public String edit(@PathVariable("resid") int resId, Model model) {
//		Reservation res = reservationService.findById(resId);
//		model.addAttribute("carNumber", res.getVehicle().getVehicleId());
//		model.addAttribute("reservation", res);
//		return "editReservation";
//	}
}
