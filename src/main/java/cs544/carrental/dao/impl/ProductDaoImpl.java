package cs544.carrental.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.ProductDao;
import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Product;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao
{
	
	public ProductDaoImpl() {
		super.setDaoType(Product.class);
	}
}

