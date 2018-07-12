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


	@Override
	public Inventory get(int id) {
		return this.id.get(id);
	}
	
	@Override
	public Inventory getByCard(Card card) {
		return id.getByCard(card);
	}
	
	@Override
	public Inventory update(Inventory inventory) {
		return id.update(inventory);
	}


	@Override
	public List<Inventory> search(String text) {
		return id.search(text);
	}


	@Override
	public Inventory topSeller() {
		return id.topSeller();
	}


	@Override
	public List<Inventory> search(String text) {
		return id.search(text);
	}


	@Override
	public Inventory topSeller() {
		return id.topSeller();
	}

}
