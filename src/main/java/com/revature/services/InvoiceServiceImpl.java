package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Invoice;
import com.revature.beans.Login;
import com.revature.data.InvoiceDao;
import com.revature.data.InvoiceLineDao;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao id;
	@Autowired
	private InvoiceLineDao ild;

	@Override
	public Invoice getInvoice(int id) {
		Invoice invoice = this.id.getByUser(id);		
		return invoice;
	}
	
	@Override
	public Invoice update(Invoice invoice) {
		return id.update(invoice);
	}
}
