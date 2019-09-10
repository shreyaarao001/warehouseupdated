package com.warehousemanagement.Repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Interfaces.CustomerInterface;
/*
 * These class is like dao where we will can update,save and delete.
 */
@Service
@Component
@EnableAutoConfiguration
public class CustomerInfoDAO {

	@Autowired
	CustomerInterface customerinterface;
	//these method is used to check data is present in table using get and set.
	public CustomerInfo check(String cust) {
		ArrayList<CustomerInfo> customerObj=(ArrayList<CustomerInfo>) customerinterface.findAll();
		CustomerInfo custObj=new CustomerInfo();
		int cust_id=Integer.parseInt(cust);
		for (int i = 0; i < customerObj.size(); i++) {
			if(cust_id==customerObj.get(i).getCustomer_id()) {
				custObj.setCustomer_id(customerObj.get(i).getCustomer_id());
				custObj.setAdderss(customerObj.get(i).getAdderss());
				custObj.setName(customerObj.get(i).getName());
				custObj.setPhonenumber(customerObj.get(i).getPhonenumber());
			}
		}
		return custObj;
	}
	//these method is used to view customer using list,get and set from bean class.
	public CustomerInfo viewCustomer(String custid){
		int cust_id=Integer.parseInt(custid);
		ArrayList<CustomerInfo> customerObj=(ArrayList<CustomerInfo>) customerinterface.findAll();
		CustomerInfo custObj=new CustomerInfo();
		for (int i = 0; i < customerObj.size(); i++) {
			if(cust_id==customerObj.get(i).getCustomer_id()) {
				custObj.setCustomer_id(customerObj.get(i).getCustomer_id());
				custObj.setAdderss(customerObj.get(i).getAdderss());
				custObj.setName(customerObj.get(i).getName());
				custObj.setPhonenumber(customerObj.get(i).getPhonenumber());
			}
		}
		return custObj;
	}

	
//these method is used to add customer using save.
	public String addCustomer(CustomerInfo cus){
    customerinterface.save(cus);
		return "Customer inserted successfully where customer_id is:"+cus.getCustomer_id();
	}
	
//these method is used view all customers in table using list.
	public List<CustomerInfo> viewCustomer() {
		
   List<CustomerInfo> customer=(List<CustomerInfo>) customerinterface.findAll();
		
		return customer;
	}

	
}
