package cs544.carrental.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String PostLogin(Account credentials, Model model) {

		Account validCredentials = accountService.findByUserName(credentials.getUsername());
		System.out.println(validCredentials.getUsername());
		if (validCredentials == null)
			return "login";

		model.addAttribute("customer", validCredentials.getCustomer());
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		status.setComplete();
		return "redirect:/welcome";
	}
}
