package cs544.carrental.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.domain.VehicleSpec;
import cs544.carrental.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

//	final private String URL = "/vehicle/";
	// private boolean testing = true;

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping({ "", "/all" })
	public String list(Model model) {
//		setRole(session, model);
		List<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleService.getAllVehicles();
		for(Vehicle v: list){
			System.out.println(v);
		}
		model.addAttribute("vehicles", list);
		return "vehicles";
	}

	// @RequestMapping(value = "vehicles", method = { RequestMethod.GET,
	// RequestMethod.POST })
	// public String vehicles(@ModelAttribute("vs") VehicleSpec vs,
	// BindingResult result, HttpSession session,
	// Model model) {
	// setRole(session, model);
	// List<Vehicle> found = vehicleService.search(vs.getMinSeats(),
	// vs.getMinPrice(), vs.getMaxPrice(), null);
	// model.addAttribute("vehicles", found);
	// return URL + "vehicles";
	// }

	

	// @Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newVehicle") Vehicle newVehicle, HttpSession session) {
//		authenticate(session);
		return "addVehicle";

		// public String add(HttpSession session, Model model) {
		// authenticate(session);

		// Vehicle vehicle = new Vehicle();
		// vehicle.setIsAvailable(false);
		// model.addAttribute("added", false);
		// model.addAttribute("vehicle", vehicle);
		// return URL + "add";
	}

	// @Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String add(@Valid Vehicle vehicle, BindingResult result,
	// HttpSession session, Model model) {
	public String add(@ModelAttribute("newVehicle") @Valid Vehicle vehicle, BindingResult result, HttpSession session) {
//		authenticate(session);
		if (result.hasErrors()) {
			return "addVehicle";
		}

		vehicleService.save(vehicle);

		return "redirect:/vehicles";
		// if (!result.hasErrors()) {
		// model.addAttribute("added", true);
		// vehicleService.save(vehicle);
		// } else {
		// model.addAttribute("added", false);
		// model.addAttribute("vehicle", vehicle);
		// }
		// return URL + "add";
	}
	@RequestMapping(value = "vehicle/{vehicleId}", method = RequestMethod.GET)
	public String vehicleDetail(@PathVariable Integer vehicleId, Model model) {
		Vehicle vehicle = vehicleService.findByVehicleId(vehicleId);
		model.addAttribute("vehicle", vehicle);
		return "vehicle";
	}
//	private void setRole(HttpSession session, Model model) {
//
//		if (session.getAttribute("person") != null) {
//			model.addAttribute("isAdmin", ((Person) session.getAttribute("person")).isAdmin());
//		} else {
//			model.addAttribute("isAdmin", false);
//		}
//	}

//	private void authenticate(HttpSession mySession) {
//		if (mySession.getAttribute("person") == null || !((Person) mySession.getAttribute("person")).isAdmin()) {
//			throw new RuntimeException("Not authenticated to do the operation.");
//		}
//	}

	// @Secured("ROLE_ADMIN")
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public @ResponseBody String delete(int vehicleId, HttpSession session) {
//		authenticate(session);
//		vehicleService.delete(vehicleId);
////		return "redirect:" + URL + "vehicles";
//		return "redirect:/vehicles";
//	}

	// @Secured("ROLE_ADMIN")
//	@RequestMapping(value = "update/{vehicleId}", method = RequestMethod.GET)
//	public String update(@PathVariable int vehicleId, HttpSession session, Model model) {
//		// authenticate(session);
//		Vehicle vehicle = this.vehicleService.findByVehicleId(vehicleId);
//		model.addAttribute("updated", false);
//		model.addAttribute("vehicle", vehicle);
////		return URL + "update";
//		return "redirect:/vehicles";
//	}

	// @Secured("ROLE_ADMIN")
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(@Valid Vehicle vehicle, BindingResult result, HttpSession session, Model model) {
//
//		authenticate(session);
//
//		if (!result.hasErrors()) {
//			vehicleService.update(vehicle);
//			model.addAttribute("updated", true);
//			model.addAttribute("vehicle", vehicle);
//			model.addAttribute("available", vehicle.getIsAvailable() ? "YES" : "NO");
//			//return "redirect:" + URL + "vehicles";
//			return "redirect:/vehicles";
//		}
//		model.addAttribute("updated", false);
//		model.addAttribute("vehicle", vehicle);
//		//return URL + "update";
//		return "redirect:/vehicles";
//	}
//
//	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
//	public String searchVehicles(@ModelAttribute("vs") VehicleSpec vs, BindingResult result, HttpSession session,
//			Model model) {
//		setRole(session, model);
//
//		List<Vehicle> found = this.vehicleService.search(vs.getMinSeats(), vs.getMinPrice(), vs.getMaxPrice(), null);
//		model.addAttribute("vehicles", found);
//
//		return "search";
//	}

}
