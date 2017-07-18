package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.CustomerDao;
import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	CustomerDao customerDao;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public void save(Customer customer) {
		
		customerDao.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	

	@Override
	public void delete(long id) {
		
		customerDao.delete(id);
	}

	

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Override
	public Customer findByCustomerNumber(String customerNumber) {
		return customerDao.findByCustomerNumber(customerNumber);
	}

	@Override
	public Customer getLoggedInPersonByAccount(Account account) {
		return customerDao.getLoggedInPersonByAccount(account);
	}

	@Override
	public Customer findByUsername(String userName) {
		return customerDao.findByUsername(userName);
	}

	@Override
	public Customer findOne(long id) {
		return customerDao.findOne(id);
	}

	@Override
	public void saveFull(Customer customer) {
		accountService.save(customer.getAccount());
		customerDao.save(customer);
		
	}

}
