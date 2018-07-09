package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Inventory;

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

}
