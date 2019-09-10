package com.warehousemanagement;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
/*
 * In this controller we are deleting the transaction or cancel transaction from transactions table based on transaction_id
 */
@Controller
@RequestMapping("cancelTransactionControl")
public class CancelTransactionController {
	//in this method first it will check whether trnsaction_id is their or not if it their it will go delete path
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck( String transaction_id,HttpSession session)
	{
		String url="http://localhost:8182/transactions/delete";
		RestTemplate restTemplate=new RestTemplate();
		String  status=restTemplate.postForObject(url, transaction_id, String.class);
	    ModelAndView modelAndView =new ModelAndView("Display.jsp");
	    modelAndView.addObject("obj",status);
	    return modelAndView;
		
	}
}
