package com.revature.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Inventory;
import com.revature.data.InventoryDao;


@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryDao id;
	
	@Override
	public List<Inventory> list() {
		return id.list();
	}


	@Override
	public Inventory save(Inventory card) {
		return id.save(card);
	}

}
