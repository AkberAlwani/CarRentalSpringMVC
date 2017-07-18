package cs544.carrental.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Reservation;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.service.CustomerService;
import cs544.carrental.service.ReservationService;
import cs544.carrental.service.VehicleService;

@RequestMapping("/reservation/")
@Controller
public class ReservationController {
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String showList(Model model) {
		List<Reservation> list = reservationService.getAll();
		model.addAttribute("reservations", list);
		return "reservation/reservationList";
	}
	
	
	final private String URL = "/reservation/";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	private Logger logger = Logger.getLogger(ReservationController.class);
	@Autowired
	ReservationService reservationService;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	CustomerService personService;

	@RequestMapping("add/{carid}")
	public String showForm(@PathVariable("carid") int carNumber, Reservation reservation, Model model) {
		model.addAttribute("carNumber", carNumber);
		return "reservation/addreservation";
	}

	@RequestMapping(value="add/{carid}",method=RequestMethod.POST)
	public String add(@PathVariable("carid") int carNumber, @ModelAttribute Reservation reservation, Model model,
			BindingResult bindingResult, HttpSession sessionRev, @RequestParam("addPayment") String addPayment) {
		// Person person = (Person) session.getAttribute("person");
		Vehicle vehicle = vehicleService.findByVehicleId(carNumber);
		//Person person = personService.findById(1);
		Customer customer= (Customer) sessionRev.getAttribute("customer");
		reservation.setCustomer(customer);
		reservation.setVehicle(vehicle);
		reservationService.save(reservation);
		vehicle.setIsAvailable(false);
		vehicleService.save(vehicle);
		sessionRev.setAttribute("reservationObject", reservation);
		double totalDay = reservation.getReturnDateTime().getDay() - reservation.getPickUpDateTime().getDay();
		double dayPrice = vehicle.getDailyRate();
		double totalPrice = totalDay * dayPrice;
		System.out.println("mum"+totalPrice);
		sessionRev.setAttribute("totalPriceSession", totalPrice);
		if(addPayment.equals("Yes")){
			return "redirect:/payment/add-payment";
		}
		model.addAttribute("reservations", reservationService.getAll());
		return "redirect:/reservation/list";
	}

	@RequestMapping(value="update/{carid}",method = RequestMethod.GET)
	public String update(@PathVariable("carid") int carNumber, @ModelAttribute Reservation reservation, Model model,
			BindingResult bindingResult, HttpSession session) {
		// Person person = (Person) session.getAttribute("person");
		Reservation res = reservationService.findById(reservation.getReservationId());
		res.setPickUpDateTime(reservation.getPickUpDateTime());
		res.setReservationDateTime(reservation.getReservationDateTime());
		res.setReturnDateTime(reservation.getReturnDateTime());
		reservationService.update(reservation);
		return "redirect:/reservation/list";
	}



	@RequestMapping(value="delete/{resid}",method=RequestMethod.GET)
	public String delete(@PathVariable("resid") int resId) {
		Reservation reservation = reservationService.findById(resId);
		Vehicle vehicle =  reservation.getVehicle();
		vehicle.setIsAvailable(true);
		vehicleService.save(vehicle);
		reservationService.delete(resId);

		return "redirect:/reservation/list";
	}

	@RequestMapping(value="edit/{resid}",method=RequestMethod.GET)
	public String edit(@PathVariable("resid") int resId, Model model) {
		Reservation res = reservationService.findById(resId);
		model.addAttribute("carNumber", res.getVehicle().getVehicleId());
		model.addAttribute("reservation", res);
		return "editReservation";
	}
}
