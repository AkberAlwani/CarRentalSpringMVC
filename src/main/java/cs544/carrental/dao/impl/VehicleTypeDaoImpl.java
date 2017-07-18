package cs544.carrental.dao.impl;


import org.springframework.stereotype.Repository;

import cs544.carrental.dao.VehicleTypeDao;

import cs544.carrental.domain.VehicleType;


@Repository
public class VehicleTypeDaoImpl extends GenericDaoImpl<VehicleType> implements VehicleTypeDao {
	public VehicleTypeDaoImpl() {
		super.setDaoType(VehicleType.class);
	}

	

}
