package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.InvoiceLine;

@Component
public class InvoiceLineHibernate implements InvoiceLineDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public InvoiceLine get(int id) {
		return (InvoiceLine) session.get(InvoiceLine.class, id);
}
	@Override
	public InvoiceLine getByID(int id) {
		Query<InvoiceLine> q = session.createQuery("From com.revature.beans.InvoiceLine i where i.id=:id", InvoiceLine.class);
		q.setParameter("id", id);

		return q.getSingleResult();
}

	@Override
	public InvoiceLine update(InvoiceLine invoiceLine) {
		session.update(invoiceLine);
		return invoiceLine;
}

	@Override
	public InvoiceLine save(InvoiceLine invoiceline) {
		session.save(invoiceline);
		return invoiceline;
	}
	
	@Override
	public void delete(InvoiceLine invoiceline) {
		session.delete(invoiceline);
	}

	@Override
	public List<InvoiceLine> list() {
		return (List<InvoiceLine>) session.createQuery("From com.revature.beans.InvoiceLine", InvoiceLine.class).list();
	}

	@Override
	public List<InvoiceLine> listByInvoice(int invoiceId) {
		Query<InvoiceLine> q = session.createQuery("From com.revature.beans.InvoiceLine i where i.invoice_id=:id", InvoiceLine.class);
		q.setParameter("id", invoiceId);
		return q.list();
	}

}
