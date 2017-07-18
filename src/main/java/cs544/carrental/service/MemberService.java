package cs544.carrental.service;

import java.util.List;
import java.util.Set;

import cs544.carrental.domain.Customer;
 
public interface MemberService {

	public void save(Customer member);
    	public void saveFull( Customer member);  		

	public List<Customer> findAll();
 	public Customer findOne(Long id);
 		
}
