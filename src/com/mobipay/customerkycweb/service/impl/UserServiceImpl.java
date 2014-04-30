package com.mobipay.customerkycweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobipay.customerkycweb.dao.UserDaoInterface;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.model.User;
import com.mobipay.customerkycweb.service.UserService;

@Service("UserHibernateService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoInterface UserDaoH;

	//@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return UserDaoH.findAll();
		
	}
	
	//@Override
	public void updateOrSaveUser(User user) {		
		// TODO Auto-generated method stub
		UserDaoH.save(user);
	}
	
	//@Override
	public List<User> searchByMDN(String mdn) {
		return UserDaoH.searchByMDN(mdn);
	}

	public void customUpdateUser(User user) {
		// TODO Auto-generated method stub
		UserDaoH.CustomUpdatetUser(user);
	}
	
}
