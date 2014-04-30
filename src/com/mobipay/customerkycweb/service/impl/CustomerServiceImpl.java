package com.mobipay.customerkycweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobipay.customerkycweb.dao.CustomerDaoInterface;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.service.CustomerService;


@Service("CustomerHibernateService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoInterface customerDaoH;
	
	//@Override
	public List<Customer> searchByName(String name) {
		return customerDaoH.searchByName(name);
	}

	//@Override
	public void customerUpdateUploadPhoto(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoH.customerUpdateUploadPhoto(customer);
	}
	
}
