package com.mobipay.customerkycweb.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobipay.customerkycweb.model.User;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.service.UserService;
import com.mobipay.customerkycweb.service.CustomerService;
import com.mobipay.customerkycweb.util.EncryptSHA;
import com.mobipay.customerkycweb.util.CommonCollection;

@Controller
public class LoginLogoutController {
	@Autowired
	private UserService userService;    
	@Autowired
	private CustomerService custService; 
	
	@Value("${otp.url}")
	private String otp_link;
	
	protected static Logger logger = Logger.getLogger("controller");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model, HttpServletRequest request) {
		logger.debug("Received request to show login page");

		if (error == true) { 
			model.put("error", "Login Failed");
		} 
		else { model.put("error", "");}
		
		return "login";
	}
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String getMainPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		logger.debug("Received request to show Main page");	
		
		return "main";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String getIndexPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		logger.debug("Received request to show Index page POST");	
		
		if (rpHash(request.getParameter("defaultReal")).equals(request.getParameter("defaultRealHash"))) { 
			//if enter here means valid
			//here we generate OTP			
			//String sOTP = com.mobipay.customerkycweb.util.Utils.generateOTP();
			String sOTP = "12345";
			String sMDN = request.getParameter("mdn");
			if(sMDN.startsWith("0")) sMDN =  sMDN.substring(1, sMDN.length());
			String sCountryCode = request.getParameter("countrycode");
			sMDN = sCountryCode + sMDN;
			System.out.println(">>>>>> " + sMDN + "<<<<<<<");
			
			User user = new User();
			user.setMdn(sMDN);
			user.setOtp(sOTP);
			
			//check if MDN already in registered as customer
			List<Customer> listCust = custService.searchByName(sMDN);
			if(listCust.size() < 1){
				model.addAttribute("errors", "You are not registered as User!");
				model.addAttribute("countryCodeList", CommonCollection.getCountryCode());
				return "index";
			}			
			else{
				//check if user exist > create new user in DB if not exist
				List<User> listUser = userService.searchByMDN(sMDN);
				if(listUser.size() < 1){
					user.setPassword( new EncryptSHA().Encrypt(sOTP));
					user.setRoleid(1);
					user.setStatus("1");
					user.setLastupdate(dateFormat.format(date));
					userService.updateOrSaveUser(user);
				}
				else{
					//save newest OTP become password
					userService.customUpdateUser(user);					
				}
				
				//send OTP to customer
				String sResult = com.mobipay.customerkycweb.util.Utils.sendOTP(sMDN, sOTP, otp_link);
				
				System.out.println("%%%%%%>>> " + sOTP + " " + sResult);
				
				redirectAttributes.addFlashAttribute("mdn", sMDN);
				
				return "redirect:login.do";
			}
		}
		else {
			model.addAttribute("errors", "Please Enter Correct Captcha!!");
			model.addAttribute("countryCodeList", CommonCollection.getCountryCode());
			return "index";
		}
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String getIndex2Page(@RequestParam(value="defaultReal", required=false) boolean error, 
			ModelMap modelMap) {
		logger.debug("Received request to show Index page");
		
		modelMap.addAttribute("countryCodeList", CommonCollection.getCountryCode());
		return "index";
	}
	
	@RequestMapping(value = "/sendotp.do")
	public @ResponseBody String sendOTP(@RequestParam(value="mobileNumber", required=false) String mobileNumber, 
			ModelMap model){
		
		logger.debug("RESEND OTP " + mobileNumber);
		
		String sOTP = com.mobipay.customerkycweb.util.Utils.generateOTP();
		String sMDN = mobileNumber;
		
		User user = new User();
		user.setMdn(sMDN);
		user.setOtp(sOTP);
		
		//check if user exist > create new user in DB if not exist
		List<User> listUser = userService.searchByMDN(mobileNumber);
		if(listUser.size() < 1){
			user.setPassword( new EncryptSHA().Encrypt(sOTP));
			user.setRoleid(1);
			user.setStatus("1");
			user.setLastupdate(dateFormat.format(date));
			userService.updateOrSaveUser(user);
		}
		else{
			//save newest OTP become password
			userService.customUpdateUser(user);					
		}
		
		//send OTP to customer
		String sResult = com.mobipay.customerkycweb.util.Utils.sendOTP(sMDN, sOTP, otp_link);
		
		System.out.println(sResult);
		String result="";
		if(sResult == "success") result = "0";
		
		return result;
	}
	
	
	private String rpHash(String value) { 
	    int hash = 5381; 
	    value = value.toUpperCase(); 
	    for(int i = 0; i < value.length(); i++) { 
	        hash = ((hash << 5) + hash) + value.charAt(i); 
	    } 
	    return String.valueOf(hash); 
	} 
		
}