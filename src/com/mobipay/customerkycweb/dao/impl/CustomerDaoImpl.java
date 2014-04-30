package com.mobipay.customerkycweb.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mobipay.customerkycweb.dao.CustomerDaoInterface;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.model.User;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Serializable>
		implements CustomerDaoInterface {

	@SuppressWarnings("unchecked")
	public Class domainClass;

	private static final Log log = LogFactory.getLog(CustomerDaoImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public CustomerDaoImpl(SessionFactory ses) {
		super.setSessionFactory(ses);
	}

	@SuppressWarnings("unchecked")
	// @Override
	public List<Customer> searchByName(String name) throws DataAccessException {
		String query = "from Customer where mobileNumber = '" + name + "'";
		List<Customer> list = getHibernateTemplate().find(query);
		return list;
	}

	//@Override
	public void customerUpdateUploadPhoto(Customer customer) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery("update Customer set customerIDPhoto=:customerIDPhoto, status=:status where mobileNumber=:mobileNumber");
		query.setString("customerIDPhoto", customer.getCustomerIDPhoto());
		query.setString("status", customer.getStatus());
		query.setString("mobileNumber", customer.getMobileNumber());
		query.executeUpdate();
		t.commit();
		s.close();
	}


}
