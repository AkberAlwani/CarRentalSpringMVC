package cs544.carrental.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.VehicleDao;
import cs544.carrental.dao.VehicleTypeDao;
import cs544.carrental.domain.VehicleType;
import cs544.carrental.service.VehicleTypeService;

@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	private VehicleTypeDao vehicleTypeDao;
	
	@Override
	public void save(VehicleType vehicleType) {
		vehicleTypeDao.save(vehicleType);

	}

	@Override
	public List<VehicleType> findAll() {
		return vehicleTypeDao.findAll();
	}

	@Override
	public void delete(long Id) {
		vehicleTypeDao.delete(Id);

	}

	@Override
	public void update(VehicleType vehicleType) {
		vehicleTypeDao.update(vehicleType);

	}

	@Override
	public VehicleType findById(long Id) {
		return vehicleTypeDao.findOne(Id);
	}

}
