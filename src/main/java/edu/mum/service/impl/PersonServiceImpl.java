package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.PersonDao;
import edu.mum.domain.Account;
import edu.mum.domain.Person;
import edu.mum.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService{

	@Autowired 
	PersonDao personDAO;
	
	@Override
	public void save(Person person) {
		
		personDAO.save(person);
	}

	@Override
	public List<Person> findAll() {
		
		return personDAO.findAll();
	}

	

	@Override
	public void delete(long id) {
		
		personDAO.delete(id);
	}

	

	@Override
	public void update(Person person) {
		personDAO.update(person);
		
	}

	@Override
	public Person findByIdentificationNumber(String identificationNumber) {
		return personDAO.findByIdentificationNumber(identificationNumber);
	}

	@Override
	public Person getLoggedInPersonByAccount(Account account) {
		return personDAO.getLoggedInPersonByAccount(account);
	}

	@Override
	public Person findByUsername(String userName) {
		return personDAO.findByUsername(userName);
	}

	@Override
	public Person findOne(long id) {
		return personDAO.findOne(id);
	}

}
