package com.revature.services;

import com.revature.beans.Customer;
import com.revature.beans.Invoice;

public interface InvoiceService {
	public Invoice getInvoice(Customer cust);
	public Invoice update(Invoice invoice);
}
