package cs544.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs544.carrental.domain.Location;
import cs544.carrental.domain.VehicleType;
import cs544.carrental.service.LocationService;
import cs544.carrental.service.VehicleTypeService;;

@Controller
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("locations", locationService.findAll());
		return "location/admin/locations";
	}
	
 	@RequestMapping("/location")
	public String getLocationId(Model model, @RequestParam("id") Long id) {

		Location location= locationService.findById(id);
		model.addAttribute("locatioin", location);
		return "location/admin/location";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newLocation") Location newLoc) {
	   return "location/admin/addLocation";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newLocation") @Valid Location newLocation, BindingResult result) {
		if(result.hasErrors()) {
			return "location/admin/addLocation";
		}

		locationService.save(newLocation);
		
	   	return "redirect:/location/admin/locations";
	}
	
   
}
