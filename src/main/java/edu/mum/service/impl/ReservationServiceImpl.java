package edu.mum.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;

import edu.mum.dao.ReservationDao;
import edu.mum.domain.Reservation;
import edu.mum.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired 
	ReservationDao reservationDao;
	
	@Override
	public void save(Reservation reservation) {
		
		reservation.setReservationDateTime(new Date());
		reservationDao.save(reservation);
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return reservationDao.findAllOrderbyreservationIdDesc();
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
		java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(res.getPickUpDateTime());
		sdf.format( res.getReturnDateTime());
		
		reservationDao.update(new Date(),res.getPickUpDateTime(),res.getReturnDateTime(),res.getReservationId());
	}

	@Override
	public Reservation findById(long id) {
		return reservationDao.findOne(id);
	}

}
