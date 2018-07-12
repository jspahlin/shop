package com.revature.data;

import java.util.List;

import com.revature.beans.Card;
import com.revature.beans.Inventory;

public interface InventoryDao {
	public Inventory get(int id);
	public Inventory getByCard(Card card);
	public Inventory save(Inventory inventory);
	public Inventory update(Inventory inventory);
	public void delete(Inventory inventory);
	
	public List<Inventory> list();
	public List<Inventory> search(String text);
	public Inventory topSeller();
}
