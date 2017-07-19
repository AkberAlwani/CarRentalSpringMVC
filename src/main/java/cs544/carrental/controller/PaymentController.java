package cs544.carrental.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.PaymentService;
import cs544.carrental.service.ReservationService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	AccountService accountService;
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value = "/admin/allPayment", method = RequestMethod.GET)
	public String allPayment(Model model, HttpSession viewSession) {
		List<Payment> paymentLst = paymentService.findAllPayment();
		model.addAttribute("paymentList", paymentLst);
		return "payment/admin/paymentList";
	}

	
	@RequestMapping(value = "/admin/searchPayment", method = RequestMethod.POST)
	public String searchPayment(@RequestParam("customerName") String customerName, Model model) {
		List<Payment> paymentList = paymentService.searchPaymentByCustomerName(customerName);
		model.addAttribute("paymentList", paymentList);
		model.addAttribute("customerName", customerName);
		return "payment/admin/paymentList";

	}
	
	
	@RequestMapping(value = "/add-payment", method = RequestMethod.GET)
	public String addPayment(Payment payment, HttpSession sessionAdd, Model model) {
		System.out.println("shova"+sessionAdd.getAttribute("totalPriceSession"));
		sessionAdd.setAttribute("amountValue", sessionAdd.getAttribute("totalPriceSession"));
		
		return "payment/add-payment";
	}

	@RequestMapping(value = "/pay-bill", method = RequestMethod.POST)
	public String payBill(@Valid Payment payment, BindingResult bindingResult, HttpSession sessionReservation) {
		if (bindingResult.hasErrors())
			return "payment/add-payment";
		
		Reservation reservation = (Reservation) sessionReservation.getAttribute("reservationObject");
		payment.setReservation(reservation);
		paymentService.save(payment);
		return "redirect:view-all-payment";
	}

	@RequestMapping(value = "/view-payment/{paymentid}", method = RequestMethod.GET)
	public String viewPayment(@PathVariable("paymentid") long paymentid, Model model, HttpSession mySession) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		Account acct = accountService.findByUserName(userDetails.getUsername());
		Customer p = acct.getCustomer();
		//Customer p=(Customer) mySession.getAttribute("customer");
		
		if (p.isAdmin()) {
			model.addAttribute("isAdmin", p.isAdmin());
		} else {
			model.addAttribute("isAdmin", false);
		}
		
		Payment paymentList = paymentService.findPaymentByID(paymentid);
		model.addAttribute("paymentList", paymentList);
		return "payment/view-payment";
	}

	@RequestMapping(value = "/view-all-payment", method = RequestMethod.GET)
	public String viewAllPayment(Model model, HttpSession viewSession) {
		System.out.println("view-all-payment");
		List<Payment> paymentLst = paymentService.findAllPayment();
		
		for(Payment payment : paymentLst)
			System.out.print("Amount" + payment.getAmount());
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
//		Customer p=(Customer) viewSession.getAttribute("customer");	
		Account acct = accountService.findByUserName(userDetails.getUsername());
		Customer p = acct.getCustomer();
		
		System.out.println("First Name"+ p.getFirstName());
		System.out.println("Account Role"+ p.getAccount().getAuthority());
		if (viewSession.getAttribute("person") != null) {
			model.addAttribute("isAdmin", p.isAdmin());
		} else {
			model.addAttribute("isAdmin", false);
		}
		System.out.println("Checking "+ p);
		model.addAttribute("paymentList", paymentLst);
		model.addAttribute("totalAmount", paymentService.findTotalAmount(paymentLst));
		return "payment/view-all-payments";
	}

	@RequestMapping(value = "/cancel-payment/{paymentid}", method = RequestMethod.GET)
	public String cancelPayment(@PathVariable("paymentid") long paymentid) {
		Payment payment = paymentService.findPaymentByID(paymentid);
		Reservation reserve = payment.getReservation();
		reserve.setState(1); //Set Cancelled
//		reserve.setReservationId(reserve.getReservationId());
		reservationService.update(reserve);
		paymentService.cancelPayment(paymentid);
		
		return "redirect:/payment/view-all-payment";

	}

	@RequestMapping(value = "/update-payment/{paymentid}", method = RequestMethod.GET)
	public String updatePayment(@PathVariable("paymentid") long paymentid, Model model, HttpSession sessionObj) {
		sessionObj.setAttribute("paymentObject", paymentService.getPaymentObject(paymentid));
		model.addAttribute("paymentObject", paymentService.getPaymentObject(paymentid));
		return "payment/update-payment-form";

	}

	@RequestMapping(value = "/payment-updated", method = RequestMethod.POST)
	public String paymentUpdated(@Valid @ModelAttribute("payment") Payment payment, BindingResult bindingResult,
			@RequestParam("amount") double amount, Model model, HttpSession sessionObj) {
		Payment paymentObject = (Payment) sessionObj.getAttribute("paymentObject");
		paymentService.paymentUpdated(paymentObject, amount);
		return "redirect:/payment/view-all-payment";

	}

	// search list of payments based on customer name
	@RequestMapping(value = "/search-payment", method = RequestMethod.POST)
	public String paymentSearched(@RequestParam("customerName") String customerName, Model model) {
		List<Payment> paymentList = paymentService.searchPaymentByCustomerName(customerName);
		model.addAttribute("paymentList", paymentList);
		model.addAttribute("totalAmount", paymentService.findTotalAmount(paymentList));
		return "payment/view-all-payments";

	}
}