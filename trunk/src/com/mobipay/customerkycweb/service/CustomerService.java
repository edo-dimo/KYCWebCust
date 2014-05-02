package com.mobipay.customerkycweb.service;

import java.util.List;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.model.User;

public interface CustomerService {
	
	public List<Customer> searchByName(String name);	
	public void customerUpdateUploadPhoto(Customer customer);	
}
