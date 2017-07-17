package edu.mum.dao;

import java.util.List;



import edu.mum.domain.Account;
import edu.mum.domain.Person;


public interface PersonDao extends  GenericDao<Person> {

	public abstract List<Person> findByNameIgnoringCase(String name);
 
	public abstract Person findByIdentificationNumber(String identificationNumber);
	public abstract Person findByName(String name);
	public abstract Person findByAccount(Account account);
	public abstract Person getLoggedInPersonByAccount(Account account);

//	List<Person> findAll();
//	public abstract void setPersonByPersonId(String name, String identificationNumber, String phoneNumber, String email, String country, String street, String city, String state, String zip, Integer accountId, Integer personId);
	
//	@Modifying
//	@Query("update Person p set p.name = ?1, p.identificationNumber = ?2, p.phoneNumber =?3, p.email = ?4, p.address.country = ?5, p.address.street = ?6, p.address.city = ?7, p.address.state = ?8, p.address.zip = ?9 ,p.account.accountId =?10  where PersonId =?11")
//	public abstract void setPersonByPersonId(String name, String identificationNumber, String phoneNumber, String email, String country, String street, String city, String state, String zip, Integer accountId, Integer personId);
	Person getLoggedInPersonByName(String name);

	Person findByUsername(String userName);
}