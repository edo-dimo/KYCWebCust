package com.mobipay.customerkycweb.web;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import com.mobipay.customerkycweb.model.Customer;
import com.mobipay.customerkycweb.service.CustomerService;
import com.mobipay.customerkycweb.util.Constant;
import com.mobipay.customerkycweb.util.Utils;
import com.mobipay.customerkycweb.model.UploadItem;

@Controller
public class CustomerController {	  
	@Autowired
	private CustomerService custService; 
	
	@Value("${img.id.path}")
	private String pathIDImage;
	
	@Value("${upload.img.id.path}")
	private String uploadIDPath;
	
	@Value("${img.form.path}")
	private String pathFormImage;
	
	protected static Logger logger = Logger.getLogger("controller");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	@RequestMapping(value = "/status.do", method = RequestMethod.GET)
	public String getCustomerPage(ModelMap model, HttpServletRequest request, UploadItem uploadItem) {
		logger.debug("Received request to show customer page");

		System.out.println("huhuh " + System.getProperty("catalina.home"));
		
		List<Customer> listCust =  custService.searchByName(Utils.getUsername());
		if(listCust.size() > 0){
			uploadItem.setCustomer(listCust.get(0));
			model.addAttribute("listCust", listCust);
			model.addAttribute("uploadItem", uploadItem);
			
			return "custstatus";
		}
		else{
			return "redirect:error.do";
		}
	}
		
	@RequestMapping(value = "/status.do", method = RequestMethod.POST)
	public String getCustomerPagePost(ModelMap model, HttpServletRequest request, UploadItem uploadItem)  throws Exception{
		logger.debug("Received request to show Customer page");
		
		MultipartFile file = uploadItem.getFileData();
		
		if (file.getOriginalFilename() != null && !("").equals(file.getOriginalFilename())) {
			InputStream inputStream = file.getInputStream();
			String sFilePath = uploadIDPath + "/"
					+ Utils.getUsername() + "_CUSTOMERID"
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'), file.getOriginalFilename().length());
			
			String sFileName = Utils.getUsername() + "_CUSTOMERID" + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'), file.getOriginalFilename().length());
			
			//customer update the Photo
			Customer cust = new Customer();
			cust.setMobileNumber(Utils.getUsername());
			cust.setCustomerIDPhoto(sFileName);
			cust.setStatus("8");
			custService.customerUpdateUploadPhoto(cust);
						
			//save the pic to server
			OutputStream outputStream = new FileOutputStream(sFilePath);

			// write the file to disk
			int readBytes = 0;
			byte[] buffer = new byte[Constant.MAX_IMG_SIZE];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();						
		}
		
		return "redirect:custstatus.do";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String doGetCustDetail(ModelMap customerModelMap) {				
		List<Customer> customerList =  custService.searchByName(Utils.getUsername());
		Customer customer = customerList.get(0);			
	
		customerModelMap.addAttribute("customer", customer);
		return "custdetail";
	}
	
	@RequestMapping(value = "/viewid.do", method = RequestMethod.GET)
	public String doGetCustID(ModelMap customerModelMap, HttpServletRequest request, UploadItem uploadItem) throws Exception{							
		
		List<Customer> customerList =  custService.searchByName(Utils.getUsername());
		Customer customer = customerList.get(0);	
		
		customerModelMap.addAttribute("pathIDImage", pathIDImage);
		customerModelMap.addAttribute("customer", customer);
		return "viewid";	
	}
	
	@RequestMapping(value = "/viewform.do", method = RequestMethod.GET)
	public String doGetCustForm(ModelMap customerModelMap) throws Exception{							
		
		List<Customer> customerList =  custService.searchByName(Utils.getUsername());
		Customer customer = customerList.get(0);	
		
		customerModelMap.addAttribute("pathFormImage", pathFormImage);
		customerModelMap.addAttribute("customer", customer);
		return "viewform";	
	}
	
	@RequestMapping(value = "/viewid.do", method = RequestMethod.POST)
	public String doGetCustIDPost(ModelMap customerModelMap, HttpServletRequest request, UploadItem uploadItem) throws Exception{			
		
		MultipartFile file = uploadItem.getFileData();
		
		if (file.getOriginalFilename() != null && !("").equals(file.getOriginalFilename())) {
			InputStream inputStream = file.getInputStream();
			String sFilePath = uploadIDPath + "/"
					+ Utils.getUsername() + "_CUSTOMERID"
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'), file.getOriginalFilename().length());
			
			String sFileName = Utils.getUsername() + "_CUSTOMERID" + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'), file.getOriginalFilename().length());
			
			//save the pic to server
			OutputStream outputStream = new FileOutputStream(sFilePath);

			// write the file to disk
			int readBytes = 0;
			byte[] buffer = new byte[Constant.MAX_IMG_SIZE];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
						
			//customer update the Photo
			Customer cust = new Customer();
			cust.setMobileNumber(Utils.getUsername());
			cust.setCustomerIDPhoto(sFileName);
			cust.setStatus("8");
			custService.customerUpdateUploadPhoto(cust);
		}
				
		return "redirect:viewid.do";	
	}
	
	// ERROR PAGE
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	String doGetErrorPage() {
		return "error";
	}
}