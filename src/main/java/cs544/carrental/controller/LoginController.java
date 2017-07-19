package cs544.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cs544.carrental.domain.Account;
import cs544.carrental.service.AccountService;

@Controller
@SessionAttributes("customer")
public class LoginController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(Account credentials, Model model) {

		Account validCredentials = accountService.findByUserName(credentials.getUsername());
		System.out.println(validCredentials.getUsername());
		if (validCredentials == null)
			return  "login";
 
		model.addAttribute("customer", validCredentials.getCustomer());
 		return "redirect:/welcome";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
 		return "redirect:/welcome";
 	}
}
