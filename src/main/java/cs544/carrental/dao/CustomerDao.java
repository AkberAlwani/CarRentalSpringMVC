package cs544.carrental.dao;

import java.util.List;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;


public interface CustomerDao extends  GenericDao<Customer> {

	public abstract List<Customer> findByNameIgnoringCase(String name);
 
	public abstract Customer findByCustomerNumber(String customerNumber);
	public abstract Customer findByName(String name);
	public abstract Customer findByAccount(Account account);
	public abstract Customer getLoggedInPersonByAccount(Account account);

//	List<Person> findAll();
//	public abstract void setPersonByPersonId(String name, String identificationNumber, String phoneNumber, String email, String country, String street, String city, String state, String zip, Integer accountId, Integer personId);
	
//	@Modifying
//	@Query("update Person p set p.name = ?1, p.identificationNumber = ?2, p.phoneNumber =?3, p.email = ?4, p.address.country = ?5, p.address.street = ?6, p.address.city = ?7, p.address.state = ?8, p.address.zip = ?9 ,p.account.accountId =?10  where PersonId =?11")
//	public abstract void setPersonByPersonId(String name, String identificationNumber, String phoneNumber, String email, String country, String street, String city, String state, String zip, Integer accountId, Integer personId);
	Customer getLoggedInPersonByName(String name);

	Customer findByUsername(String userName);
}