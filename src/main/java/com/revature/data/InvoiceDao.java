package com.revature.data;

import java.util.Set;

import com.revature.beans.Invoice;

public interface InvoiceDao {
	public Invoice get(int id);
	public boolean update(Invoice invoice);
	public Invoice insert(Invoice invoice);
	public Set<Invoice> listByUser(int userId);
	public Set<Invoice> list();
}
