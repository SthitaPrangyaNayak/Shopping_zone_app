package com.org.dao;

import java.util.List;

import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.User;

public interface ItemDao {
	
    void saveAndUpdateItem(Item item);
	
	Item fetchItemByID(int id);
	
	List<Item> fetchAllitems();

}
