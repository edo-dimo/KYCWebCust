/**
Project Name: KYCWebTool
Package     : com.mobipay.kycwebtool.model
Created Date: Oct 28, 2013
Created By  : megi.permana
*/
package com.mobipay.customerkycweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_code")
public class CountryCode {

	@Id
	@Column(name="Code")
	private String code;
	@Column(name="Country")
	private String country;
	@Column(name="Description")
	private String description;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

