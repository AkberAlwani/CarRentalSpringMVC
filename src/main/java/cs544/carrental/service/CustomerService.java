package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	
	void save(Customer customer);
	void saveFull(Customer customer);
	void delete(long id);
	void update(Customer customer);
	
	Customer findOne(long id);
	Customer findByCustomerNumber(String customerNo);
	Customer getLoggedInPersonByAccount(Account account);
	Customer findByUsername(String userName);
	String MD5(String md5);
	
}
