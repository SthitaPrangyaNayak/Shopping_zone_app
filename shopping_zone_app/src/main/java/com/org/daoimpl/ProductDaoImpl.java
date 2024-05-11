package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ProductDao;

import com.org.dto.Product;
import com.org.dto.Seller;
@Component
public class ProductDaoImpl implements ProductDao {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("rishi");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();

	@Override
	public void saveAndUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		
		et.begin();
		em.merge(product);
		et.commit();
		
		
	}

	@Override
	public Product fertchProductByID(int id) {
		// TODO Auto-generated method stub
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		String jpql="select product from Product product";
		Query query= em.createQuery(jpql);
		
		
		return query.getResultList();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
		Product product= em.find(Product.class, id);
		Seller seller= product.getSeller();
		List<Product> products= seller.getProducts();
		products.remove(product);
		
		et.begin();
		em.remove(products);
		em.merge(seller);
		et.commit();
	}

}
