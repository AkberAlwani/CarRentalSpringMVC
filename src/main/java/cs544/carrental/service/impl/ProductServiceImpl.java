package cs544.carrental.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.ProductDao;
import cs544.carrental.domain.Product;
import cs544.carrental.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Product product) {
		   productDao.save(product);
	}
	
	public Product findOne(long productID) {
		return productDao.findOne(productID);
	}

 
 


}
