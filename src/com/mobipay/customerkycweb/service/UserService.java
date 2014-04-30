package com.mobipay.customerkycweb.service;

import java.util.List;

import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.model.User;

public interface UserService {

	public List<User> getAll();
	public List<User> searchByMDN(String mdn);	
	public void updateOrSaveUser(User user);
	public void customUpdateUser(User user);
}
