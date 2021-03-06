package com.revature.beans;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoice")
public class Invoice {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="invoice_gen")
    @SequenceGenerator(name="invoice_gen", sequenceName="invoice_seq", allocationSize=1)
	// invoice id 
	private int id;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="invoice")
	@JsonIgnoreProperties(value = "invoice")
	private Set<InvoiceLine> invoiceLines;
	@ManyToOne(fetch=FetchType.EAGER)
	
	@JoinColumn(name="customer_id")
	private Customer customerId;
	private String status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines.stream().sorted((a,b)->{
			if(a.getId()>b.getId()) {
				return 1;
			} else {
				return -1;
			}
		}).collect(Collectors.toList());
	}
	public void setInvoiceLines(Set<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int id, Set<InvoiceLine> invoiceLines, Customer customerId, String status) {
		super();
		this.id = id;
		this.invoiceLines = invoiceLines;
		this.customerId = customerId;
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + id;
		result = prime * result + ((invoiceLines == null) ? 0 : invoiceLines.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Invoice other = (Invoice) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id != other.id)
			return false;
		if (invoiceLines == null) {
			if (other.invoiceLines != null)
				return false;
		} else if (!invoiceLines.equals(other.invoiceLines))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceLines=" + invoiceLines + ", customerId=" + customerId + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
