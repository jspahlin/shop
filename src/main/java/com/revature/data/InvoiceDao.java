package com.revature.data;

import java.util.List;
import com.revature.beans.Invoice;

public interface InvoiceDao {
	public Invoice get(int id);
	public Invoice update(Invoice invoice);
	public Invoice save(Invoice invoice);
	public void delete(Invoice invoice);
	public Invoice getByUser(int userID);
	public List<Invoice> listByUser(int userId);
	public List<Invoice> list();
}
