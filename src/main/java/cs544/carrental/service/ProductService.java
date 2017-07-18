package cs544.carrental.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cs544.carrental.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

  	void save(Product product);

	Product findOne(long id);
 
 

}
