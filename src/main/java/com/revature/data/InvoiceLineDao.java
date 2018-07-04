package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Invoice;
import com.revature.beans.InvoiceLine;

public interface InvoiceLineDao {
	
		public InvoiceLine get(int id);
		public InvoiceLine update(InvoiceLine invoiceLine);
		public InvoiceLine save(InvoiceLine invoiceline);
		public List<InvoiceLine> list();
		public List<InvoiceLine> listByInvoice(int invouceId);
		
	}

