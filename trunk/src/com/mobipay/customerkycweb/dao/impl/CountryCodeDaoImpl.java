/**
Project Name: KYCWebTool
Package     : com.mobipay.kycwebtool.dao.impl
Created Date: Oct 28, 2013
Created By  : megi.permana
*/
package com.mobipay.customerkycweb.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobipay.customerkycweb.dao.CountryCodeDao;
import com.mobipay.customerkycweb.model.CountryCode;

@Repository
public class CountryCodeDaoImpl extends GenericDaoImpl<CountryCode, Serializable> implements CountryCodeDao  {
	
	@Autowired
	public CountryCodeDaoImpl(SessionFactory ses) {
		super.setSessionFactory(ses);
	}
	
}

