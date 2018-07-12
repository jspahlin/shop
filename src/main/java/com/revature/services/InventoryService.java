package com.revature.services;

import java.util.List;

import com.revature.beans.Inventory;

public interface InventoryService {
	public List<Inventory> list();
	public Inventory get(int id);
	public List<Inventory> search(String text);
	public Inventory save(Inventory inventory);
}
