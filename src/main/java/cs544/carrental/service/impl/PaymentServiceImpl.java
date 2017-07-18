package cs544.carrental.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.PaymentDao;
import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;
import cs544.carrental.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDao paymentDao;

	@Override
	public void addPayment(Payment payment, Reservation reservation) {
		payment.setPaymentDateTime(new Date());
		payment.setReservation(reservation);
		payment.setIsConfirm("PAID");
		paymentDao.save(payment);
	}

	@Override
	public List<Payment> findPaymentByID(long paymentId) {
		List<Payment> paymentList = paymentDao.findByPaymentId(paymentId);
		return paymentList;
	}

	@Override
	public List<Payment> findAllPayment() {
		List<Payment> paymentList = paymentDao.findAll();
		return paymentList;
	}

	@Override
	public void cancelPayment(String paymentId) {
		List<Payment> paymentList = paymentDao.findByPaymentId(Integer.parseInt(paymentId));
		for (Payment p : paymentList) {
			if (paymentId.equals(p.getPaymentId() + "")) {
				paymentDao.delete(p.getPaymentId());
			}
		}
	}

	@Override
	public double findTotalAmount(List<Payment> list) {
		double amount = 0.0;
		for (Payment p : list)
			amount += p.getAmount();
		return amount;
	}

	@Override
	public Payment getPaymentObject(String paymentId) {
		List<Payment> paymentList = paymentDao.findByPaymentId(Integer.parseInt(paymentId));
		for (Payment p : paymentList) {
			if (paymentId.equals(p.getPaymentId() + "")) {
				return p;
			}
		}
		return null;
		
	}

	@Override
	public void paymentUpdated(Payment payment, double amount) {
		if (payment != null) {
			payment.setAmount(amount);
			paymentDao.save(payment);
		}

	}

	@Override
	public List<Payment> searchPaymentByCustomerName(String customerName) {
		List<Payment> paymentList = new ArrayList<>();
		for (Payment p : paymentDao.findAll()) {
			if (p.getReservation().getCustomer().getFirstName().toLowerCase().startsWith(customerName.toLowerCase()))
				paymentList.add(p);
		}
		return paymentList;
	}

}
