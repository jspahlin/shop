package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inventory_gen")
	@SequenceGenerator(name="inventory_gen", sequenceName="inventory_seq", allocationSize=1)	
	private int id;
	//@OneToMany(fetch=FetchType.EAGER, mappedBy="inventory")
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="card_id")
	//@OneToOne(fetch = FetchType.EAGER,
    //        cascade =  CascadeType.ALL,
    //        mappedBy = "card")
	private Card card;
	private int quantity;
	private int amountSold;
	
	public Inventory() {
	super();
	}

	public Inventory(int id, Card card, int quantity, int amountSold) {
		super();
		this.id = id;
		this.card = card;
		this.quantity = quantity;
		this.amountSold = amountSold;
	}

	public Card getCard() {
	return card;
	}
	public void setCard(Card card) {
	this.card = card;
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public int getQuantity() {
	return quantity;
	}
	public void setQuantity(int quantity) {
	this.quantity = quantity;
	}
	public int getAmountSold() {
	return amountSold;
	}
	public void setAmountSold(int amountSold) {
	this.amountSold = amountSold;
	}


	public Inventory(Card card, int id, int quantity, int amountSold) {
	super();
	this.card = card;
	this.id = id;
	this.quantity = quantity;
	this.amountSold = amountSold;
	}
	@Override
	public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + amountSold;
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
	Inventory other = (Inventory) obj;
	if (amountSold != other.amountSold)
		return false;
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
	return "Inventory [card=" + card + ", id=" + id + ", quantity=" + quantity + ", amountSold=" + amountSold + "]";
	}
}
