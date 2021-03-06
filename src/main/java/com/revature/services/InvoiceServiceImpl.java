package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Customer;
import com.revature.beans.Invoice;
import com.revature.data.InvoiceDao;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao id;

	@Override
	public Invoice getInvoiceByCustomer(Customer cust) {
		Invoice invoice = this.id.getByUser(cust);		
		return invoice;
	}
	
	@Override
	public Invoice save(Invoice invoice) {
		return id.save(invoice);
	}
	
	@Override
	public Invoice getInvoice(int id) {
		Invoice invoice = this.id.get(id);
		return invoice;
	}
	
	@Override
	public List<Invoice> getAllInvoice(){
		return id.list();
	}
	
	@Override
	public Invoice update(Invoice invoice) {
		return id.update(invoice);
	}
}
