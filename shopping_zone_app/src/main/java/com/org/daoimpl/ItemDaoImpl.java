package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ItemDao;
import com.org.dto.Item;
@Component
public class ItemDaoImpl implements ItemDao {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("rishi");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();

	@Override
	public void saveAndUpdateItem(Item item) {
		// TODO Auto-generated method stub
		
		et.begin();
		em.merge(item);
		et.commit();
		
		
	}

	@Override
	public Item fetchItemByID(int id) {
		// TODO Auto-generated method stub
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> fetchAllitems() {
		// TODO Auto-generated method stub
		String jpql="select item from Item item";
		Query query= em.createQuery(jpql);
		return query.getResultList();
		
		
			}

}
