package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
// A single card should be mentioned only once per invoice.
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"invoice_id", "card_id"})})
public class InvoiceLine {
	@Id
	@Column
	@SequenceGenerator(name="invoice_line_gen", sequenceName="invoice_line_seq", allocationSize=1)
    @GeneratedValue(generator="invoice_line_gen", strategy=GenerationType.SEQUENCE)
	// id for invoice line
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="card_id")
	private Card card;
	private int quantity;
	// invoice id call
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	
	@Column(name="unit_price")
	private int unitPrice; // price that a single unit was sold at.
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public InvoiceLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceLine(Card card, int quantity, int id) {
		super();
		this.card = card;
		this.quantity = quantity;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + id;
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
		InvoiceLine other = (InvoiceLine) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (id != other.id)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InvoiceLine [card=" + card + ", quantity=" + quantity + ", id=" + id + ", unitPrice=" + unitPrice + "]";
	}
	
	
}
