package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Invoice;
import com.revature.beans.Login;
import com.revature.services.InvoiceService;

@Controller
@RequestMapping(value="/cart")
public class InvoiceController {
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	InvoiceService is;
	
	@RequestMapping(value = "/cart/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getInvoice (HttpSession httpSession) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		int id = user.getId();
		return om.writeValueAsString(is.getInvoice(id));
	}
	
	@RequestMapping(value="/cart/purchase", method=RequestMethod.POST)
	@ResponseBody
	public String purchase (HttpSession httpSession) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		int id = user.getId();
		Invoice invoice = is.getInvoice(id);
		invoice.setStatus("pendingApproval");
		is.update(invoice);
		return invoice.getStatus();
	}
}