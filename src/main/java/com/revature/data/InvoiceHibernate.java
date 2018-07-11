package com.revature.data;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Customer;
import com.revature.beans.Invoice;
import com.revature.beans.InvoiceLine;
import com.revature.beans.Login;

@Component
public class InvoiceHibernate implements InvoiceDao, HibernateSession {
	private Session session;
	private CustomerDao cd;
	private LoginDao ld;
	
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
	public Invoice getByUser(Customer cust) {
		System.out.println("here");
		
		Query<Invoice> q = session.createQuery("From com.revature.beans.Invoice i where i.customerId=:customerId and i.status=:status", Invoice.class);
		q.setParameter("customerId", cust);
		q.setParameter("status", "CURRENT");
		return q.getSingleResult();
	}
	
	@Override
	public List<Invoice> listByUser(int userId) {
		Query<Invoice> q = session.createQuery("From com.revature.beans.Invoice i where i.customer_id=:customerId", Invoice.class);
		q.setParameter("customerId", userId );
		return q.list();
	}

	@Override
	public List<Invoice> list() {
		return (List<Invoice>) session.createQuery("From com.revature.beans.Invoice", Invoice.class).list();
	}

}
