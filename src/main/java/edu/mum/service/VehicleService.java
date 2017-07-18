package edu.mum.service;


import java.util.List;



import edu.mum.domain.Vehicle;


public interface VehicleService {
	public void save(Vehicle vehicle);
	public List<Vehicle> getAll();
	public void delete(long vehicleId);
	public void update(Vehicle vehicle);
	
	public List<Vehicle> search(Integer seats, Double minPrice, Double maxPrice, Boolean isAvailable);
	public List<Vehicle> isAvailable(Boolean flag);
	public Vehicle findByVehicleId(long vehicleId);
	

}
