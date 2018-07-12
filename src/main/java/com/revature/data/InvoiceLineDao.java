package com.revature.data;

import java.util.List;
import com.revature.beans.InvoiceLine;

public interface InvoiceLineDao {
	
	public InvoiceLine get(int id);
	public InvoiceLine getByID(int id);
	public InvoiceLine update(InvoiceLine invoiceLine);
	public InvoiceLine save(InvoiceLine invoiceline);
	public void delete(InvoiceLine invoiceline);
	public List<InvoiceLine> list();
	public List<InvoiceLine> listByInvoice(int invoiceId);
		
	}

