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

@Controller
@RequestMapping({ "/customers" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customers";
	}

	@RequestMapping("/{id}")
	public String getCustomerById(@PathVariable("id") Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);

		return "customer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		return "addCustomer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") @Valid Customer customerToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addCustomer";
		}

		// Error caught by ControllerAdvice IF no authorization...
		customerService.saveFull(customerToBeAdded);
		
		return "redirect:/customers";

	}

}
