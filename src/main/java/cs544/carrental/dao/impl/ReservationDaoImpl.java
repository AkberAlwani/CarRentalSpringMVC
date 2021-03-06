package cs544.carrental.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.ReservationDao;
import cs544.carrental.domain.Reservation;

@SuppressWarnings("unchecked")
@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation> implements ReservationDao {

	public ReservationDaoImpl() {
		super.setDaoType(Reservation.class );
	}

	@Override
	public Reservation findByReservationId(int id) {
		Query query = entityManager.createQuery("select r from Reservation r  where r.reservationId=:id");
		return (Reservation) query.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Reservation> findAllOrderbyreservationIdDesc() {
		Query query = entityManager.createQuery("select r from Reservation r  order by r.reservationId desc");
		return  query.getResultList();
	}
	
	@Override
	public List<Reservation> findAllByCustomerId(long customerId) {
		Query query = entityManager.createQuery("select r from Reservation r where r.customer.id=:customerId and r.state = 0");
		return  (List<Reservation>)query.setParameter("customerId", customerId).getResultList();
	}
	
//	@Override
//	public void update(Date date, Date pickUpDateTime, Date returnDateTime, long reservationId) {
//		Query query = entityManager.createQuery("Update Reservation set ");
//		//return  query.getResultList();
//		
//		
//	}
	
//	@Override
//	public Reservation update(Reservation reserve) {
//		entityManager.merge(reserve);
		//return  query.getResultList();
		
		
//	}

	
	@Override
	public List<Reservation> findAllState(int state) {
		Query query = entityManager.createQuery("select r from Reservation r ,Payment p  where r.state=:state and r = p.reservation and p.isConfirm = 'PAID'");
		return  query.setParameter("state", state).getResultList();
	}

	@Override
	public void update(Date date, Date pickUpDateTime, Date returnDateTime, long reservationId) {
		// TODO Auto-generated method stub
		
	}


	
}
