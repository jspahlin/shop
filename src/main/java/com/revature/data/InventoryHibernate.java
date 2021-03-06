package com.revature.data;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Card;
import com.revature.beans.Inventory;
import com.revature.beans.Invoice;

@Component
public class InventoryHibernate implements InventoryDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;

	}

	@Override
	public Inventory get(int id) {
		return (Inventory) session.get(Inventory.class, id);
	}
	
	@Override
	public Inventory getByCard(Card card) {
		Query<Inventory> q = session.createQuery("From com.revature.beans.Inventory i where i.card=:card", Inventory.class);
		q.setParameter("card", card );		
		return q.getSingleResult();
	}

	@Override
	public Inventory save(Inventory inventory) {
		session.save(inventory);
		return inventory;
	}

	@Override
	public Inventory update(Inventory inventory) {
		session.update(inventory);
		return inventory;
	}

	@Override
	public void delete(Inventory inventory) {
		session.delete(inventory);

	}

	@Override
	public List<Inventory> list() {
		return (List<Inventory>) session.createQuery("From com.revature.beans.Inventory", Inventory.class).list();
	}

	@Override
	public List<Inventory> search(String text) {
		List<Inventory> result = session.createQuery("From com.revature.beans.Inventory", Inventory.class).list();
		return result.stream().filter(inv->inv.getCard().getName().toLowerCase()
				.contains(text.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public Inventory topSeller() {
		return list().stream().reduce((a,b)->{
			if(a.getAmountSold() > b.getAmountSold()) {
				return a;
			} else {
				return b;
			}
		}).orElse(null);
	}

}
