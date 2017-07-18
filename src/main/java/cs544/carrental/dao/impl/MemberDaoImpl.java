package cs544.carrental.dao.impl;

 

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.MemberDao;
import cs544.carrental.domain.Customer;


@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Customer> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Customer.class );
		}

 
 }