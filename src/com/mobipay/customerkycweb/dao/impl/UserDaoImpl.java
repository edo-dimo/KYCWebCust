package com.mobipay.customerkycweb.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mobipay.customerkycweb.dao.UserDaoInterface;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.model.User;
import com.mobipay.customerkycweb.util.EncryptSHA;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Serializable> implements UserDaoInterface {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	EncryptSHA enc = new EncryptSHA();
	
	@Autowired
	public UserDaoImpl(SessionFactory ses){
		super.setSessionFactory(ses);
	}
	private transient  final Log log = LogFactory.getLog(this.getClass());
	
	public void CustomUpdatetUser(User user){
		Session s = getSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery("update User set mdn=:mdn, otp=:otp, password=:password, lastupdate=:lastupdate where mdn=:mdn");
		query.setString("mdn", user.getMdn());
		query.setString("otp", user.getOtp());
		query.setString("password", enc.Encrypt(user.getOtp())); 
		query.setString("lastupdate", dateFormat.format(date));
		query.setString("mdn", user.getMdn());
		query.executeUpdate();
		t.commit();
		s.close();
	}
	
	@SuppressWarnings("unchecked")
	// @Override
	public List<User> searchByMDN(String mdn) throws DataAccessException {
		String query = "from User where mdn = '" + mdn + "'";
		List<User> list = getHibernateTemplate().find(query);
		return list;
	}
	
}
