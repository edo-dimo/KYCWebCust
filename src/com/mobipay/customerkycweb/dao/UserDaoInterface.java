package com.mobipay.customerkycweb.dao;

import java.io.Serializable;
import java.util.List;

import com.mobipay.customerkycweb.model.User;

public interface UserDaoInterface extends GenericDao<User, Serializable>{
	public List<User> searchByMDN(String mdn);	
	public void CustomUpdatetUser(User user);
}
