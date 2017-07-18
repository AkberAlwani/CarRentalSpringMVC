package cs544.carrental.dao;

import cs544.carrental.domain.UserCredentials;

public interface UserCredentialsDao extends GenericDao<UserCredentials> {
  
	public UserCredentials findByUserName(String userName);
}
