package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.GenericDao;
import cs544.carrental.dao.UserCredentialsDao;
import cs544.carrental.domain.UserCredentials;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements cs544.carrental.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsDao userCredentialsDao;

 	
    public void save( UserCredentials userCredentials) {  		
 		userCredentialsDao.save(userCredentials);
	}
 	
    public void update( UserCredentials userCredentials) {  		
 		userCredentialsDao.update(userCredentials);
	}
 	
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsDao.findAll();
	}
	
	public UserCredentials findOne(Long id){
		return userCredentialsDao.findOne(id);
	}


	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

}
