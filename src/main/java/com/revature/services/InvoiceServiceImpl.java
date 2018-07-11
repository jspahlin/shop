package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Invoice;
import com.revature.data.InvoiceDao;

public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao id;
	
	
	@Override
	public List<Invoice> list() {
		
		return id.list();
	}

	@Override
	public Invoice get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice save(Invoice invoice) {
		
		return id.save(invoice);
	}

}
