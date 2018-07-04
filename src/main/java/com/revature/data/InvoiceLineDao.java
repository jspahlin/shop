package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Invoice;
import com.revature.beans.InvoiceLine;

public interface InvoiceLineDao {
	
		public InvoiceLine get(int id);
		public boolean update(InvoiceLine invoiceLine);
		public Invoice insert(InvoiceLine invoiceline);
		public List<InvoiceLine> list();
		public Set<InvoiceLine> listByInvoice(int invouceId);
		
	}

