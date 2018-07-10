package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Cart;
import com.revature.data.CartDAO;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cd;
	
	@Override
	public Cart getCart(int id) {
		Cart cart = cd.get(id); 
		return cart;
	}
}
