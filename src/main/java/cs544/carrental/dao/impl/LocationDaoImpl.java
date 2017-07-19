package cs544.carrental.dao.impl;


import org.springframework.stereotype.Repository;

import cs544.carrental.dao.LocationDao;

import cs544.carrental.domain.Location;


@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements LocationDao {
	public LocationDaoImpl() {
		super.setDaoType(Location.class);
	}

	

}
