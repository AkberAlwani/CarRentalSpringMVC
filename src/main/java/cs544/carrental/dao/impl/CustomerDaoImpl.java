package cs544.carrental.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.CustomerDao;
import cs544.carrental.domain.Account;
import cs544.carrental.domain.Customer;

@SuppressWarnings("unchecked")
@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {
	
	public CustomerDaoImpl() {
		super.setDaoType(Customer.class );
	}
	
	@Override
	public List<Customer> findByNameIgnoringCase(String name) {
		Query query = entityManager.createQuery("select p from Customer p  where p.name =:name");
		return query.setParameter("name", name).getResultList();
	}

	@Override
	public Customer findByCustomerNumber(String customerNumber) {
		Query query = entityManager.createQuery("select p from Customer p  where p.identificationNumber =:identificationNumber");
		return (Customer) query.setParameter("identificationNumber", customerNumber).getSingleResult();
	}

	@Override
	public Customer findByName(String name) {
		Query query = entityManager.createQuery("select p from Customer p where p.name =:name");
		return (Customer) query.setParameter("name", name).getSingleResult();
	}

	@Override
	public Customer findByAccount(Account account) {
		Query query = entityManager.createQuery("select p from Customer p  where p.Account =:account");
		return (Customer) query.setParameter("account", account).getSingleResult();
	}

	@Override
	public Customer getLoggedInPersonByAccount(Account account) {
		Query query = entityManager.createQuery("select p from Person p  where p.Account =:account");
		return (Customer) query.setParameter("account", account).getSingleResult();
	}

	

	@Override
	public Customer getLoggedInPersonByName(String name) {
		Query query = entityManager.createQuery("select p from Customer p  where p.name =:name");
		return (Customer) query.setParameter("name", name).getSingleResult();
	}

	@Override
	public Customer findByUsername(String userName) {
		Query query = entityManager.createQuery("select p from Customer p where p.account.username =:userName");
		return (Customer) query.setParameter("userName", userName).getSingleResult();
	}

}
