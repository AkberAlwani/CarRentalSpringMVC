package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Location;

public interface LocationService {
	public void save(Location location);
	public List<Location> findAll();
	public void delete(long Id);
	public void update(Location location);
	

	public Location findById(long Id);
}
