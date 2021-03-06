package cs544.carrental.dao;

import java.util.List;

import cs544.carrental.domain.Payment;

public interface PaymentDao extends GenericDao<Payment> {
	Payment findByPaymentId(long paymentId);
//	Page<Payment> findAll(Pageable pageable);
	List<Payment> findAll();
	Payment findPaymentByReservationID(long reservationId);
	
}
