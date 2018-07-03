package com.revature.data;

import java.util.Set;

import com.revature.beans.Inventory;

public interface InventoryDao {
	public Inventory get(int id);
	public Inventory get(Inventory inventory);
	public Inventory insert(Inventory inventory);
	public boolean update(Inventory inventory);
	public Set<Inventory> list();
}
