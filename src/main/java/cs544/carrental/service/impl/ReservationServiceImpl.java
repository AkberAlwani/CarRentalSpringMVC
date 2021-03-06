package cs544.carrental.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.ReservationDao;
import cs544.carrental.domain.Reservation;
import cs544.carrental.service.ReservationService;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired 
	ReservationDao reservationDao;

	@Override
	public void save(Reservation reservation) {
		
		reservation.setReservationDateTime(new Date());
		reservationDao.save(reservation);
	}

	@Override
	public List<Reservation> getAll(int state) {
		// TODO Auto-generated method stub
		return reservationDao.findAllState(state);
//		return reservationDao.findAllOrderbyreservationIdDesc();
	}

	
	@Override
	public void delete(long id) {
		reservationDao.delete(id);
	}

	@Override
	public Reservation findById(int id) {
		return reservationDao.findByReservationId(id);
	}

	@Override
	public void update(Reservation res) {
		reservationDao.update(res);
	}

	@Override
	public Reservation findById(long id) {
		return reservationDao.findOne(id);
	}
	
	@Override
	public List<Reservation> findAllByCustomerId(long id) {
		return reservationDao.findAllByCustomerId(id);
	}

	@Override
	public Reservation getReport(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
