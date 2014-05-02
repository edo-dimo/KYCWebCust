package com.mobipay.customerkycweb.util;


import java.security.*;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

public class EncryptSHA {
	private transient  final Log log = LogFactory.getLog(this.getClass());
	

	
	public String Encrypt(String input) {
		log.info(" Encrypting Password ");
		String hash;
		hash = byteArytoHexStr(getHash(input));		
	    return hash;
	}
	
	static String byteArytoHexStr(byte[] input){
		  String output;
		  int parse;
		  StringBuffer buff = new StringBuffer(input.length * 2);
		  for (int i = 0; i < input.length; i++){
			  parse = input[i] & 0xff;
			  if (parse < 16) 
				  buff.append('0');
			  buff.append(Integer.toHexString(parse));
		  }
		  output = buff.toString();
		  return output;
	  }
	
	  static byte[] getHash(String toHash) {
	     java.security.MessageDigest parse =null;
	     try {
			parse = java.security.MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException NSAE) {
			NSAE.printStackTrace();
		}
	     parse.reset();
	     parse.update(toHash.getBytes());
	     return parse.digest();
	  }
}

