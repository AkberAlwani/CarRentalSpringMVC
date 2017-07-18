package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Address2;
 
public interface AddressService {

	public void save(Address2 address);
	public void update(Address2 address);
	public List<Address2> findAll();
 
	public Address2 findOne(Long id);

}
