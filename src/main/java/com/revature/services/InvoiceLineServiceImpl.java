package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.InvoiceLine;
import com.revature.data.InvoiceLineDao;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService{
	@Autowired
	private InvoiceLineDao id;
	
	
	@Override
	public InvoiceLine getInvoiceLine(int id) {
		InvoiceLine invoiceLine = this.id.getByID(id);
		return invoiceLine;
	}
	
	@Override
	public InvoiceLine add(InvoiceLine invoiceLine) {
		return id.save(invoiceLine);
	}
	
	@Override
	public InvoiceLine update(InvoiceLine invoiceLine) {
		return id.update(invoiceLine);
	}
	
	@Override
	public void delete(int id) {
		InvoiceLine invoiceLine = this.id.getByID(id);
		this.id.delete(invoiceLine);
	}
}
