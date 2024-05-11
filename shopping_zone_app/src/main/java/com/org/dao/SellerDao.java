package com.org.dao;

import com.org.dto.Seller;
import com.org.dto.User;

public interface SellerDao {
	
	void saveAndUpdateSeller(Seller seller);
	Seller fetchSellerByEmailAndPassword(String email, String password);
	Seller fetchSellerByID(int id);

}
