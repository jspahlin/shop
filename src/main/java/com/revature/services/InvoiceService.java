package com.revature.services;

import com.revature.beans.Invoice;

public interface InvoiceService {
	public Invoice getInvoice(int id);
	public Invoice update(Invoice invoice);
}
