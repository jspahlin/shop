package com.revature.data;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.beans.Invoice;
import com.revature.beans.InvoiceLine;

public class InvoiceHibernate implements InvoiceDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;

	}

	@Override
	public Invoice get(int id) {
		return (Invoice) session.get(Invoice.class, id);
	}

	@Override
	public Invoice update(Invoice invoice) {
		session.update(invoice);
		return invoice;
	}

	@Override
	public Invoice save(Invoice invoice) {
		session.save(invoice);
		return invoice;
	}

	@Override
	public void delete(Invoice invoice) {
		session.delete(invoice);
	}

	
	@Override
	public List<Invoice> listByUser(int userId) {
		Query<Invoice> q = session.createQuery("From com.revature.beans.Invoice in where in.customer_id=:customerId", Invoice.class);
		q.setParameter("customerId", userId );
		return q.list();
	}

	@Override
	public List<Invoice> list() {
		return (List<Invoice>) session.createQuery("From com.revature.beans.Invoice", Invoice.class).list();
	}

}
