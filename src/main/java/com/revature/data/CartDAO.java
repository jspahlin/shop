package com.revature.data;

import java.util.List;

import com.revature.beans.Cart;

public interface CartDAO {
	public Cart get(int id);
	public Cart save(Cart cart);
	public Cart update(Cart cart);
	public void delete(Cart cart);
	
	public List<Cart> list();
}
