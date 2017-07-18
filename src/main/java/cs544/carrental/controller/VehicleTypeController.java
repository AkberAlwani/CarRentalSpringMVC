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

import cs544.carrental.domain.VehicleType;
import cs544.carrental.service.VehicleTypeService;;

@Controller
@RequestMapping("/types")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService typeService;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("types", typeService.findAll());
		return "types";
	}
	
 	@RequestMapping("/type")
	public String getProductById(Model model, @RequestParam("id") Long id) {

		VehicleType type= typeService.findById(id);
		model.addAttribute("type", type);
		return "type";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newType") VehicleType newType) {
	   return "addType";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newType") @Valid VehicleType typeToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addType";
		}

		typeService.save(typeToBeAdded);
		
	   	return "redirect:/types";
	}
	
   
}
