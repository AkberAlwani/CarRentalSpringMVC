package cs544.carrental.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.LocationDao;
import cs544.carrental.domain.Location;
import cs544.carrental.service.LocationService;



@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Location location) {
		locationDao.save(location);

	}

	@Override
	public List<Location> findAll() {
		return locationDao.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(long Id) {
		locationDao.delete(Id);

	}

	@Override
	public void update(Location location) {
		locationDao.update(location);

	}

	@Override
	public Location findById(long Id) {
		return locationDao.findOne(Id);
	}

}
