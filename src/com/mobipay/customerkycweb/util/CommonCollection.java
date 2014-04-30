/**
Project Name: KYCWebTool
Package     : com.mobipay.kycwebtool.repository
Created Date: Oct 25, 2013
Created By  : megi.permana
*/
package com.mobipay.customerkycweb.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobipay.customerkycweb.dao.CountryCodeDao;
import com.mobipay.customerkycweb.model.CountryCode;
import com.mobipay.customerkycweb.util.Constant;

@Component
public class CommonCollection {

	private static final Log log = LogFactory.getLog(CommonCollection.class);
	
	@Autowired 
	private CountryCodeDao countryCodeDao;
	
	private static List<CountryCode> countryCodeList = new LinkedList<CountryCode>();
	
	public static List<CountryCode> getCountryCode(){
		return countryCodeList;
	}
	
	@PostConstruct
	public void init(){
		log.info("Initialize CommonStatusCollection ............");
		loadCountryCode();
	}
	
	public void loadCountryCode(){
		synchronized (countryCodeList) {
			countryCodeList = countryCodeDao.findAll();
		}
	}
	
}

