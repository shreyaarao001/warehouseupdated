package com.warehousemanagement;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Repository.CustomerInfoDAO;
/*
 * this controller is used to view one customer base don customer_id.
 */
@Controller
@RequestMapping("customer")
public class ViewCustomerController {
	@Autowired
	CustomerInfoDAO custdao;
	//this metjod is used to check customer_id and view customer.
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView customerCheck(String customer_id,HttpSession session) {
		//this url is used to check customer_id.
		String url="http://localhost:8182/customerinfo/check";
		RestTemplate restTemplate=new RestTemplate();
		session.setAttribute("custid",customer_id);
		String  status=restTemplate.postForObject(url, customer_id, String.class);
		//if customer is present db it will enter in this block of code.
		  if(status.equals("Yes")) {
		    	url="http://localhost:8182/customerinfo/display";
		    	CustomerInfo cust=restTemplate.postForObject(url, customer_id, CustomerInfo.class);
		    	ModelAndView modelAndView=new ModelAndView("CustomerInfo.jsp");
		    	modelAndView.addObject("obj",cust);
		    	return modelAndView;
		    }
		  //if customer is not their it will enter in these block of code
		    else {
		    	ModelAndView modelAndView=new ModelAndView();
		    	modelAndView.setViewName("CreateCustomer.jsp");
		    	return modelAndView;
		    }
			
		
		
		
	}
	
	
}
