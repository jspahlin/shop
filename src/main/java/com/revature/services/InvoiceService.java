package com.revature.services;



import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Invoice;

public interface InvoiceService {
	public Invoice getInvoiceByCustomer(Customer cust);
	public Invoice getInvoice(int id);
	public List<Invoice> getAllInvoice();
	public Invoice save(Invoice invoice);
	public Invoice update(Invoice invoice);
}
