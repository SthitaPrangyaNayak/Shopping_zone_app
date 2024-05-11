package com.org.dao;

import java.util.List;

import com.org.dto.Product;
import com.org.dto.User;

public interface ProductDao {
	
	void saveAndUpdateProduct(Product product);
	
	Product fertchProductByID(int id);
	
	List<Product> fetchAllProducts();
	
	void deleteProductById(int id);

}
