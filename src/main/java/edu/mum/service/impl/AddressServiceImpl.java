package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.AddressDao;
import edu.mum.domain.Address2;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	
	
 	@Autowired
	private AddressDao memberDao;

    public void save( Address2 address) {  		
		memberDao.save(address);
	}
	
	
    public void update( Address2 address) {  		
		memberDao.update(address);
	}
	
	
	public List<Address2> findAll() {
		return (List<Address2>)memberDao.findAll();
	}

 	public Address2 findOne(Long id) {
		return memberDao.findOne(id);
	}


	
 
}
