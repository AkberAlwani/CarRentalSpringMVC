package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.VehicleDao;
import edu.mum.domain.Vehicle;


@SuppressWarnings("unchecked")
@Repository
public class VehicleDaoImpl extends GenericDaoImpl<Vehicle> implements VehicleDao {

	@Override
	public List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualAndIsAvailableOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice, boolean avaliable) {
		Query query = entityManager.createQuery("select v from Vehicle v where p.numberOfSeats >=:seats and p.maxPrice>=maxDailyPrice and p.minPrice>=minDailyPrice and p.isAvailable=avaliable" );
		return query.setParameter("seats", seats).setParameter("maxDailyPrice", maxDailyPrice)
				.setParameter("minDailyPrice", minDailyPrice).setParameter("avaliable", avaliable)
				.getResultList();
		}

	@Override
	public List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice) {
		
		return null;
	}
	
	public List<Vehicle> isAvaialble(Boolean flag){
		Query query = entityManager.createQuery("select v from Vehicle v  where v.isAvailable =:flag");
		return query.setParameter("flag", flag).getResultList();
		
	}

	@Override
	public List<Vehicle> searh(Integer seats, Double minPrice, Double maxPrice, Boolean isAvailable) {
		Query query = entityManager.createQuery("select v from Vehicle v  where v.numberOfSeats =:seats");
		return query.setParameter("seats", seats).getResultList();
	}

	

	

}
