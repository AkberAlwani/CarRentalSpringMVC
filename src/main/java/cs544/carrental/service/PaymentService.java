package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;


public interface PaymentService {
//	public void addPayment(Payment payment, Reservation reservation);

	public Payment findPaymentByID(long paymentId);

	public List<Payment> findAllPayment();
	public void save(Payment payment);
	public void cancelPayment(long paymentId);
	public void delete(long paymentId);

	public Payment getPaymentObject(long paymentId);

	public void paymentUpdated(Payment payment, double amount);

	public double findTotalAmount(List<Payment> list);

	public List<Payment> searchPaymentByCustomerName(String customerName);
	public Payment findPaymentByReservationID(long reservationId);
}
