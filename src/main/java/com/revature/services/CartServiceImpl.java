package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Cart;
import com.revature.data.CartDAO;

public class CartServiceImpl implements CartService{
	@Autowired
	CartDAO cd;
	
	@Override
	public Cart getCart(int id) {
		Cart cart = cd.get(id); 
		return cart;
	}
}
