package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.SellerDao;
import com.org.dto.Seller;

@Component
public class SellerDaoImpl implements SellerDao {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("rishi");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();

	@Override
	public void saveAndUpdateSeller(Seller seller) {
		// TODO Auto-generated method stub
		
		et.begin();
		em.merge(seller);
		et.commit();
		
	}

	@Override
	public Seller fetchSellerByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		String jpql= "select seller from Seller seller where email=?1 and password=?2";
		Query query= em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Seller> seller= query.getResultList();
		return seller.get(0);
		
	}

	@Override
	public Seller fetchSellerByID(int id) {
		// TODO Auto-generated method stub
		return em.find(Seller.class, id);
	}

}
