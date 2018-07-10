package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Cart;
import com.revature.beans.Inventory;

@Component
public class CartHibernate implements CartDAO, HibernateSession{
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Cart get(int id) {
		return (Cart) session.get(Cart.class, id);
	}

	@Override
	public Cart save(Cart cart) {
		session.save(cart);
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
		session.update(cart);
		return cart;
	}

	@Override
	public void delete(Cart cart) {
		session.delete(cart);		
	}

	@Override
	public List<Cart> list() {
		return (List<Cart>) session.createQuery("From com.revature.beans.Cart", Cart.class).list();
	}
}
