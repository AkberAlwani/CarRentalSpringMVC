package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Address;
 
public interface AddressService {

	public void save(Address address);
	public void update(Address address);
	public List<Address> findAll();
 
	public Address findOne(Long id);

}
