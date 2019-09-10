package com.warehousemanagement;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Bean.ItemInfo;
import com.warehousemanagement.Bean.Transactions;
/*
 * This controller is used for billing first it will check the value in customer_info and item_info table if the value is present
 * than it will do billing
 */
@Controller
@RequestMapping("transactioncontrol")
public class BillingController {
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck( String customer_id,String item_id,String quantity,HttpSession session)
	{
		//this url is used to check whether id is present in customer_info table
		String url="http://localhost:8182/customerinfo/check";
		RestTemplate restTemplate=new RestTemplate();
		String  status=restTemplate.postForObject(url, customer_id, String.class);
		//if id is present it will enter in this block of code
	    if(status.equals("Yes")) {
	    	//this url is used to check whether id is present in item_info table
	    	url="http://localhost:8182/iteminfo/check";
	    	status=restTemplate.postForObject(url, item_id, String.class);
	    	//if id is present it will enter in this block of code
	        if(status.equals("Yes")) {
	        	LocalDate transactiondate=java.time.LocalDate.now();
	    		Date transaction_date=Date.valueOf(transactiondate);
	    		ItemInfo itemobj=new ItemInfo();
	    		int itemid=Integer.parseInt(item_id);
	    		itemobj.setItem_id(itemid);
	    		CustomerInfo custobj=new CustomerInfo();
	    		int custid=Integer.parseInt(customer_id);
	    		custobj.setCustomer_id(custid);
	    		int quant=Integer.parseInt(quantity);
	    		//this condition is used to check quantity
	    		if(quant>0) {
	    		Transactions tranobj=new Transactions();
	    		tranobj.setCustObj(custobj);
	    		tranobj.setItemObj(itemobj);
	    		tranobj.setQuantity(quant);
	    		tranobj.setTransaction_date(transaction_date);
	    		//if values are in object it will get inserted in this url and it is directed to rest
	    		url="http://localhost:8182/transactions/insert";
		    	status=restTemplate.postForObject(url, tranobj, String.class);
		    	//in this jsp it will our status or message whether it is inserted or not
		    	ModelAndView modelAndView=new ModelAndView("Display.jsp");
		    	modelAndView.addObject("obj",status);
		    	return modelAndView;
	    		}
	    		//if quantity is less than it will enter in this block of code
	    		else {
	    			ModelAndView modelAndView=new ModelAndView("Display.jsp");
	    			status="Quantity must be a positive value";
	    			modelAndView.addObject("obj",status);
			    	return modelAndView;
	    			
	    		}
		    }
	        //if item is not found in item_info table than it will enter in this block of code
	        else{
	    		ModelAndView modelAndView=new ModelAndView("Display.jsp");
	    		String obj="item not found";
	    		modelAndView.addObject("obj",obj);
	    		return modelAndView;
	    	}
	    	}
	    //if item is not found in customer_info table than it will enter in this block of code
	    else{
    		ModelAndView modelAndView=new ModelAndView("Display.jsp");
    		String obj="customer not found";
    		modelAndView.addObject("obj",obj);
    		return modelAndView;
    	}
	}
}
