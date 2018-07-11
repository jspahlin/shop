package com.revature.services;

import java.util.List;

import com.revature.beans.Invoice;

public interface InvoiceService {
	public List<Invoice> list();
	public Invoice get(int id);
	
	public Invoice save(Invoice invoice);
}
