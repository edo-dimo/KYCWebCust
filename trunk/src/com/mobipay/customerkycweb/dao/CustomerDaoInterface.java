package com.mobipay.customerkycweb.dao;

import java.io.Serializable;
import java.util.List;

import com.mobipay.customerkycweb.model.Customer;

public interface CustomerDaoInterface extends GenericDao<Customer, Serializable>{
	
	public List<Customer> searchByName(String name);
	public void customerUpdateUploadPhoto(Customer customer);
	
}
