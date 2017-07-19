package cs544.carrental.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.PaymentDao;
import cs544.carrental.domain.Payment;

@SuppressWarnings("unchecked")
@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Payment> implements PaymentDao{
	
	public PaymentDaoImpl() {
		super.setDaoType(Payment.class );
	}
	@Override
	public Payment findByPaymentId(long paymentId) {
		
		Query query = entityManager.createQuery("select p from Payment p  where p.paymentId =:paymentId");
//		return query.setParameter("paymentId", paymentId).getResultList();
		return (Payment)(query.setParameter("paymentId", paymentId).getSingleResult());
	}
	
	@Override
	public Payment findPaymentByReservationID(long reservationId) {
		Query query = entityManager.createQuery("select p from Payment p  where p.reservation.reservationId =:reservationId");
//		return query.setParameter("paymentId", paymentId).getResultList();
		return (Payment)(query.setParameter("reservationId", reservationId).getSingleResult());
	}

}
