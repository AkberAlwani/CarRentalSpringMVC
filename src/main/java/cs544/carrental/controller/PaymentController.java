package cs544.carrental.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;
import cs544.carrental.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

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
	
	//========================================================
	//========================================================
	//========================================================
	//========================================================
	
	
	@RequestMapping(value = "/add-payment", method = RequestMethod.GET)
	public String addPayment(Payment payment, HttpSession sessionAdd, Model model) {
		System.out.println("shova" + sessionAdd.getAttribute("totalPriceSession"));
		sessionAdd.setAttribute("amountValue", sessionAdd.getAttribute("totalPriceSession"));

		return "payment/add-payment";
	}

	@RequestMapping(value = "/pay-bill", method = RequestMethod.POST)
	public String payBill(@Valid Payment payment, BindingResult bindingResult, HttpSession sessionReservation) {
		if (bindingResult.hasErrors())
			return "payment/add-payment";
		Reservation reservationObject = (Reservation) sessionReservation.getAttribute("reservationObject");
		paymentService.addPayment(payment, reservationObject);
		return "redirect:view-all-payment";
	}

	@RequestMapping(value = "/view-payment/{paymentid}", method = RequestMethod.GET)
	public String viewPayment(@PathVariable("paymentid") String paymentid, Model model, HttpSession mySession) {
		Customer p = (Customer) mySession.getAttribute("customer");

		if (mySession.getAttribute("customer") != null) {
			model.addAttribute("isAdmin", ((Customer) mySession.getAttribute("customer")).isAdmin());
		} else {
			model.addAttribute("isAdmin", false);
		}

		List<Payment> paymentList = paymentService.findPaymentByID(paymentid);
		model.addAttribute("paymentList", paymentList);
		return "payment/view-payment";
	}

	@RequestMapping(value = "/view-all-payment", method = RequestMethod.GET)
	public String viewAllPayment(Model model, HttpSession viewSession) {
		List<Payment> paymentLst = paymentService.findAllPayment();
		Customer p = (Customer) viewSession.getAttribute("customer");
		System.out.println("First Name" + p.getFirstName());
		System.out.println("Account Role" + p.getAccount().getAuthority());
		if (viewSession.getAttribute("person") != null) {
			model.addAttribute("isAdmin", ((Customer) viewSession.getAttribute("customer")).isAdmin());
		} else {
			model.addAttribute("isAdmin", false);
		}
		System.out.println("Checking " + p);
		model.addAttribute("paymentList", paymentLst);
		model.addAttribute("totalAmount", paymentService.findTotalAmount(paymentLst));
		return "payment/view-all-payments";
	}

	@RequestMapping(value = "/cancel-payment/{paymentid}", method = RequestMethod.GET)
	public String cancelPayment(@PathVariable("paymentid") String paymentid) {
		paymentService.cancelPayment(paymentid);
		return "redirect:/payment/view-all-payment";

	}

	@RequestMapping(value = "/update-payment/{paymentid}", method = RequestMethod.GET)
	public String updatePayment(@PathVariable("paymentid") String paymentid, Model model, HttpSession sessionObj) {
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
