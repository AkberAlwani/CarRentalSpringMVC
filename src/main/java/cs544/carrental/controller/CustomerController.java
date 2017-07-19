package cs544.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Address;
import cs544.carrental.domain.Authority;
import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Reservation;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.CustomerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
@RequestMapping({ "/customers" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value={"","/","/all"})
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customer/admin/customerList";
	}

	@RequestMapping("/{id}")
	public String getCustomerById(@PathVariable("id") Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		return "customer/admin/customer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		return "customer/admin/addCustomer";
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") @Valid Customer customer,
			BindingResult result) {

		if (result.hasErrors()) {
			return "customer/admin/addCustomer";
		}
		 
		//customer.setAddress(address);
		
		  //...

		//String password = customerService.MD5(customer.getAccount().getPassword());
		//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String hashedPassword = passwordEncoder.encode(password);
		//Address address = new Address();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(customer.getAccount().getPassword());
		
		customer.getAccount().setPassword(password);
		Authority authority = new Authority();
		authority.setAuthority("CUSTOMER");
		authority.setUsername(customer.getAccount().getUsername());
		customer.getAccount().setAuthority(authority);
		// Error caught by ControllerAdvice IF no authorization...
		customerService.saveFull(customer);
		
		return "redirect:/welcome/";

	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") long Id) {
		Customer customer = customerService.findOne(Id);
		Account account = accountService.findByUserName(customer.getAccount().getUsername());
		System.out.println("About to Delete Customer");
		customerService.delete(Id);
		accountService.delete(account.getAccountId());

		return "redirect:/customer/admin/customerList";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateCustomerForm(Model model) {
		//get the current user	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
																    .getAuthentication()
																    .getPrincipal();
		
		//System.out.println( userDetails.getUsername() );
		Customer customer = customerService.findByUsername( userDetails.getUsername() );
		model.addAttribute("newCustomer", customer);		
		
		//return "addCustomer";
		return "customer/admin/updateCustomer";
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public String processUpdateCustomerForm(@ModelAttribute("newCustomer") @Valid Customer customerToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "customer/admin/updateCustomer";
		}
		// Error caught by ControllerAdvice IF no authorization...
		
		System.out.println( customerToBeAdded.getId() );
		Customer c = customerService.findByUsername( customerToBeAdded.getAccount().getUsername() );
		customerToBeAdded.setId(c.getId());
		customerService.update(customerToBeAdded);
		
		return "redirect:/customers/" + customerToBeAdded.getId();

	}
	
	

}
