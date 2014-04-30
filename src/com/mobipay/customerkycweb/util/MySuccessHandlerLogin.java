package com.mobipay.customerkycweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.mobipay.customerkycweb.model.User;
import com.mobipay.customerkycweb.service.UserService;

@Component
public class MySuccessHandlerLogin implements ApplicationListener<AuthenticationSuccessEvent> {
	@Autowired
	private UserService userService;
	
	//@Override
	public void onApplicationEvent(AuthenticationSuccessEvent arg0) {
		// TODO Auto-generated method stub
		String myMDN = arg0.getAuthentication().getName();
		if(myMDN.startsWith("0")) myMDN = "62" + myMDN.substring(1, myMDN.length());
		if(myMDN.startsWith("8")) myMDN = "62" + myMDN.substring(0, myMDN.length());
				
		String sOTP = com.mobipay.customerkycweb.util.Utils.generateTempPass();
		
		User user = new User();
		user.setMdn(myMDN);
		user.setOtp(sOTP);
		userService.customUpdateUser(user);	
		
	}
		
}