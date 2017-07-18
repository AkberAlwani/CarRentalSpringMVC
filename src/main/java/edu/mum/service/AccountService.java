package edu.mum.service;

import edu.mum.domain.Account;

public interface AccountService {
	
	public void save(Account account);
	public void update(Account account);
	public void delete(long accountId);
	public Account findByUsername(String username);
	public String MD5(String md5);
	
}
