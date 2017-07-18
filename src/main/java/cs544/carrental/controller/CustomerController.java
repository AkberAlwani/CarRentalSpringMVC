package cs544.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.carrental.domain.Customer;
import cs544.carrental.service.CustomerService;
import cs544.carrental.service.MemberService;

@Controller
@RequestMapping({ "/customers" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public String listMembers(Model model) {
		model.addAttribute("members", customerService.findAll());
		return "members";
	}

	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Customer member = customerService.findOne(id);
		model.addAttribute("member", member);

		return "member";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newMember") Customer newMember) {
		return "addMember";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newMember") @Valid Customer memberToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addMember";
		}

		// Error caught by ControllerAdvice IF no authorization...
		customerService.saveFull(memberToBeAdded);
		
		return "redirect:/members";

	}

}
