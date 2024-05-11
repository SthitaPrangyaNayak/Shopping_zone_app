package com.org.dao;


import com.org.dto.User;

public interface UserDao {
	
	void saveAndUpdateUser(User user);
	User fetchUserByEmailAndPassword(String email, String password);
	User fetchUserByID(int id);
	

}
