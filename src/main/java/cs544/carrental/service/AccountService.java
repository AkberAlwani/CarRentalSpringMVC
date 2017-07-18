package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Account;

public interface AccountService {
	
	public void save(Account account);
	public void update(Account account);
	public void delete(long accountId);
	
	public List<Account> findAll();
	public Account findOne(Long id);
	public Account findByUserName(String userName);

	public String MD5(String md5);
	
}
