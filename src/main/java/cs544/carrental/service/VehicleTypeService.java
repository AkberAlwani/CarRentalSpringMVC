package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.VehicleType;

public interface VehicleTypeService {
	public void save(VehicleType vehicleType);
	public List<VehicleType> findAll();
	public void delete(long Id);
	public void update(VehicleType vehicleType);
	

	public VehicleType findById(long Id);
}
