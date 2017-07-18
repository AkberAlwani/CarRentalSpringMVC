package cs544.carrental.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.AddressDao;
import cs544.carrental.domain.Address2;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address2> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(Address2.class );
		}

 
 }