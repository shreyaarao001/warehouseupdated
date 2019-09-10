package com.warehousemanagement.Rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Interfaces.CustomerInterface;
import com.warehousemanagement.Repository.CustomerInfoDAO;
/*
 * These class is used as restful services where we can call using url.
 */
@RestController
@RequestMapping("customerinfo")
public class CustomerRest {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	CustomerInterface customerinterface;
	@Autowired
	CustomerInfoDAO custdao;
	//these method is used check customer inforamtion and we will call dao call in these method
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public String findCustomer(@RequestBody String cust) {
		CustomerInfo custObj=custdao.check(cust);
		   String status;
		   if (custObj.getAdderss()!=null)
			   status="Yes";
		   else
			   status="No";
			return status; 
	   }
	//these method is used display customer inforamtion and we will call dao call in these method
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	   public CustomerInfo displayCustomer(@RequestBody String cust) {
		   CustomerInfo status=custdao.viewCustomer(cust);
			return status; 
	   }
	//these method is used insert customer inforamtion and we will call dao call in these method
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String insert(@RequestBody CustomerInfo cust){
	String status=custdao.addCustomer(cust);
		   return status; 
		
 	
	}
	//these method is used view_customer customer inforamtion and we will call dao call in these method
	@RequestMapping(value = "/view_customer", method = RequestMethod.GET)
	   public List<CustomerInfo> viewCustomer() {
		List<CustomerInfo> customer=custdao.viewCustomer();
			return customer;	
		   }
	
}
