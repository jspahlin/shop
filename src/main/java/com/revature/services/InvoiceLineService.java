package com.revature.services;

import com.revature.beans.InvoiceLine;

public interface InvoiceLineService {
	public InvoiceLine getInvoiceLine(int id);
	public InvoiceLine add(InvoiceLine invoiceLine);
	public InvoiceLine update(InvoiceLine invoiceLine);
	public void delete(int id);
}
