package com.revature.controller;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Card;
import com.revature.beans.Customer;
import com.revature.beans.Inventory;
import com.revature.beans.Invoice;
import com.revature.beans.InvoiceLine;
import com.revature.beans.Login;
import com.revature.services.CardService;
import com.revature.services.InventoryService;
import com.revature.services.InvoiceLineService;
import com.revature.services.InvoiceService;

@Controller
public class InvoiceController {
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	InvoiceService is;
	
	@Autowired
	InvoiceLineService ils;
	
	@Autowired
	InventoryService ivs;
	
	@Autowired
	CardService cs;
	
	@RequestMapping(value = "/cart", method=RequestMethod.GET)
	@ResponseBody
	public String getInvoice (HttpSession httpSession) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		Customer cust = (Customer) user;
		Invoice invoice = is.getInvoiceByCustomer(cust);
		
		return om.writeValueAsString(invoice);
	}
	
	@RequestMapping(value = "/cart/get", method=RequestMethod.GET)
	@ResponseBody
	public String getAllInvoice (HttpSession httpSession) throws JsonProcessingException {
		return om.writeValueAsString(is.getAllInvoice());
	}
	
	@RequestMapping(value = "/cart/add", method=RequestMethod.POST)
	@ResponseBody
	public String addInvoiceLine (@RequestBody Variables variables, HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		InvoiceLine iLine = new InvoiceLine();
		Card card = cs.getCardByID(variables.getCardID());

		iLine.setCard(card);
		iLine.setQuantity(variables.getQuantity());
		iLine.setInvoice(is.getInvoice(variables.getCartID()));
		iLine.setId(0);
		iLine.setUnitPrice(card.getPrice());
		
		iLine = ils.add(iLine);
		
		System.out.println(iLine);
		
		Customer cust = (Customer) user;
		Invoice invoice = is.getInvoiceByCustomer(cust);
		
		return om.writeValueAsString(invoice);		
	}
	
	@RequestMapping(value = "/cart/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateInvoice (@RequestBody Variables variables, HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		InvoiceLine iLine = ils.getInvoiceLine(variables.getLineID());
		
		iLine.setQuantity(variables.getQuantity());
		ils.update(iLine);
		
		Customer cust = (Customer) user;
		Invoice invoice = is.getInvoiceByCustomer(cust);
		
		return om.writeValueAsString(invoice);
	}
	
	@RequestMapping(value = "/cart/approve", method=RequestMethod.POST)
	@ResponseBody
	public String approveInvoice (@RequestBody Variables variables, HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Invoice invoice = is.getInvoice(variables.getCartID());
		Inventory inventory = null;
		Card card = null;
		int stock = 0, buy = 0, sold = 0;
		
		
		Set<InvoiceLine> iLines = invoice.getInvoiceLines();
		
		for(InvoiceLine iLine : iLines) {
			card = iLine.getCard();
			inventory = ivs.getByCard(card);
			
			stock = inventory.getQuantity();
			sold = inventory.getAmountSold();
			buy = iLine.getQuantity();
			
			if(buy < stock)
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			else {
				stock = stock - buy;
				inventory.setQuantity(stock);
				sold = sold + buy;
				inventory.setAmountSold(sold);

				invoice.setStatus("SHIPPED");
				
				ivs.update(inventory);
				is.update(invoice);		
			}
		}
		return om.writeValueAsString(is.getAllInvoice());		
	}
	
	@RequestMapping(value = "/cart/item/remove/{lineID}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteInvoiceLine (@PathVariable("lineID") int lineID, HttpSession httpSession) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		
		ils.delete(lineID);
		
		Customer cust = (Customer) user;
		Invoice invoice = is.getInvoiceByCustomer(cust);
		
		return om.writeValueAsString(invoice);		
	}
	
	@RequestMapping(value = "/cart/purchase", method=RequestMethod.POST)
	@ResponseBody
	public String purchaseInvoice (HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		Customer cust = (Customer) user;
		Invoice invoice = is.getInvoiceByCustomer(cust);
		
		invoice.setStatus("PENDINGAPPROVAL");
		is.update(invoice);
		
		Invoice newInvoice = new Invoice();
		newInvoice.setCustomerId(cust);
		newInvoice.setStatus("CURRENT");
		newInvoice.setId(1);
		newInvoice.setInvoiceLines(null);
		
		is.save(newInvoice);
		
		return om.writeValueAsString(newInvoice);
	}
}

@Component
class Variables {
	private int cartID;
	private int cardID;
	private int lineID;
	private int quantity;
	
	public Variables() {
		super();
	}

	public Variables(int cartID, int cardID, int lineID, int quantity) {
		super();
		this.cartID = cartID;
		this.cardID = cardID;
		this.lineID = lineID;
		this.quantity = quantity;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardID;
		result = prime * result + cartID;
		result = prime * result + lineID;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variables other = (Variables) obj;
		if (cardID != other.cardID)
			return false;
		if (cartID != other.cartID)
			return false;
		if (lineID != other.lineID)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Variables [cartID=" + cartID + ", cardID=" + cardID + ", lineID=" + lineID + ", quantity=" + quantity
				+ "]";
	}
}