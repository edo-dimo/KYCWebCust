package com.mobipay.customerkycweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mobipay.customerkycweb.model.Customer;

@Entity
@Table(name="status")
public class Status {
	
	@Id
	@Column(name="status")
	private String statusid;
	
	@Column(name="module")
	private String module;
	
	@Column(name="description")
	private String description;
	
	@Column(name="customerdescription")
	private String customerdescription;
	
	@Column(name="nextstatus")
	private String nextstatus;
	
	public String getNextstatus() {
		return nextstatus;
	}

	public void setNextstatus(String nextstatus) {
		this.nextstatus = nextstatus;
	}

	@OneToMany(mappedBy="status")
	private List<Customer> customer;	

	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public String getCustomerdescription() {
		return customerdescription;
	}

	public void setCustomerdescription(String customerdescription) {
		this.customerdescription = customerdescription;
	}

}
