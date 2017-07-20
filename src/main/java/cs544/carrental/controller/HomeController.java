package cs544.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/welcome" })
	public String welcome(Model model) {

		model.addAttribute("greeting", "Welcome to our Car Reservation System!!");
		model.addAttribute("tagline", "The most convienient way to get a car!");
		return "welcome";
	}

}
