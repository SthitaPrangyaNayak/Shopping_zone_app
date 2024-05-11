package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.UserDao;
import com.org.dto.User;
@Component
public class UserDaoImpl implements UserDao {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("rishi");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	@Override
	public void saveAndUpdateUser(User user) {
		// TODO Auto-generated method stub
		et.begin();
		em.merge(user);
		et.commit();
		
		
	}
	@Override
	public User fetchUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		String jpql= "select user from User user where email=?1 and password=?2";
		Query query= em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> user= query.getResultList();
		return user.get(0);
		
		}
	@Override
	public User fetchUserByID(int id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}
	
	
	
	
	

}
