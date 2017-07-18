package edu.mum.service;

import java.util.List;

import edu.mum.domain.Reservation;


public interface ReservationService {
	void save(Reservation reservation);
	List<Reservation> getAll();
	
	void delete(long id);
	Reservation findById(long id);
	void update(Reservation res);
	Reservation findById(int id);
	
}
