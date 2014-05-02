package com.mobipay.customerkycweb.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem
{
	private String filename;
	private CommonsMultipartFile fileData;	
	// user Customer object
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getFilename(){
		return filename;
	}

	public void setFilename(String filename){
		this.filename = filename;
	}

	public CommonsMultipartFile getFileData(){
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData){
		this.fileData = fileData;
	}
}