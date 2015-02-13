/**
Project Name: CustomerKYCWeb
Package     : com.mobipay.customerkycweb.util
Created Date: Sep 30, 2013
Created By  : ys.tjia
*/
package com.mobipay.customerkycweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;


public abstract class Utils {
	
	public static String generateOTP(){    		
        int len = Constant.OTP_LENGTH;
        String values = "0123456789abcdefghijklmnopqrstuvwxyz";
        
        Random rnd = new Random((new Date()).getTime());
        StringBuilder sb = new StringBuilder(len);
        
        for( int i = 0; i < len; i++ ) 
            sb.append(values.charAt( rnd.nextInt(values.length())));
        
        return sb.toString();
    }
	
	public static String generateTempPass(){    		
        int len = 11;
        String values = "ABCDEFGHIZKLMNOPQRSTUVWXYZ!@#$%^&*_=+-/0123456789abcdefghijklmnopqrstuvwxyz";
        
        Random rnd = new Random((new Date()).getTime());
        StringBuilder sb = new StringBuilder(len);
        
        for( int i = 0; i < len; i++ ) 
            sb.append(values.charAt( rnd.nextInt(values.length())));
        
        return sb.toString();
    }
	
	public static String sendOTP(String mdn, String sOTP, String otp_link) {   
		HttpURLConnection con = null;
		try{
			String sURL = otp_link;
			sURL = sURL + "shortcode=" + Constant.OTP_SC + "&to=" + mdn + "&message=your%20SMS%20Token%20is%20" + sOTP;
			
			URL url = new URL(sURL);
			System.out.println(">>>> " + url + " <<< ");
			con = (HttpURLConnection) url.openConnection();
	 		
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setReadTimeout(10000);                 
			con.connect();
			
			BufferedReader rd  = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
	       
			String line = null;
	        while ((line = rd.readLine()) != null) {
	             sb.append(line + '\n');
	        }
	       
	        System.out.println(sb.toString());
			
			return "success";
		}
		catch (MalformedURLException e) {
	          e.printStackTrace();
	          return "fail";
	    }
		catch (ProtocolException e) {
	          e.printStackTrace();
	          return "fail";
	    }
		catch (IOException e) {
	          e.printStackTrace();
	          return "fail";
	    }
	    finally {
	          //close the connection, set all objects to null
	          con.disconnect();
	    }
	}
		
	public static String getUsername(){   
		String sMDN = SecurityContextHolder.getContext().getAuthentication().getName().toString();		
		
	    return sMDN;
	}
}
