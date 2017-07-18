package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.MemberDao;
import cs544.carrental.domain.Customer;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements cs544.carrental.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
// 	UserCredentialsService credentialsService;
 	AccountService accountService;

    public void save( Customer customer) {  		
		memberDao.save(customer);
	}
	
 	
    @Override
   	public void saveFull( Customer customer) {  		
    	accountService.save(customer.getAccount());
  		memberDao.save(customer);
	}
  	

	public List<Customer> findAll() {
		return (List<Customer>)memberDao.findAll();
	}

 	public Customer findOne(Long id) {
		return memberDao.findOne(id);
	}
	
 
}
