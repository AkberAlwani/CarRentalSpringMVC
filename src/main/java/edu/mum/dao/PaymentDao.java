package edu.mum.dao;

import java.util.List;



import edu.mum.domain.Payment;

public interface PaymentDao extends GenericDao<Payment> {
	List<Payment> findByPaymentId(int paymentId);
//	Page<Payment> findAll(Pageable pageable);
	List<Payment> findAll();
	
}
