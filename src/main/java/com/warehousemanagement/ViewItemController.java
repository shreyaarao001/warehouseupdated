package com.warehousemanagement;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Bean.ItemInfo;
import com.warehousemanagement.Repository.CustomerInfoDAO;
import com.warehousemanagement.Repository.ItemInfoDAO;
/*
 * In these we are going to view items based on item_id.
 */
@Controller
@RequestMapping("viewitem")
public class ViewItemController {
	@Autowired
	ItemInfoDAO iteminfodao;
	//if we want to view item we will check item and than we wil view item,if item is not their it will add item.
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView customerCheck(String item_id,HttpSession session) {
		//these url is used to check if item is their or not
		String url="http://localhost:8182/iteminfo/check";
		RestTemplate restTemplate=new RestTemplate();
		session.setAttribute("itemid",item_id);
		String  status=restTemplate.postForObject(url, item_id, String.class);
		//if item is present in db it will enter in these block of code
		  if(status.equals("Yes")) {
		    	url="http://localhost:8182/iteminfo/display";
		    	ItemInfo item=restTemplate.postForObject(url, item_id, ItemInfo.class);
		    	ModelAndView modelAndView=new ModelAndView("ItemInfo.jsp");
		    	int discount=0;
		    	int price=(int)item.getPrice();
		    	int difference;
		    	//in these block we are going to specify discount for each item if price is greater than 10 and less than 100
		    	if(item.getPrice()>10 || item.getPrice()<100){
		    		difference = (int) (price * 0.1);
		    	discount=(price-difference);
		    	}
		    	//if price is greater than 100.
		    	if(item.getPrice()>100){
		    		difference = (int) (price * 0.2);
		    	discount=(price-difference);
		    	}
		    	//if price is less than 10
		    	if(item.getPrice()<10){
		    	discount=price;
		    	}
		    	modelAndView.addObject("obj",item);
		    	modelAndView.addObject("obj1",discount);
		    	return modelAndView;
		    }
		  //If these is not their in table it will enter will go to additem block of code.
		    else {
		    	ModelAndView modelAndView=new ModelAndView();
		    	modelAndView.setViewName("NewItems.jsp");
		    	return modelAndView;
		    }
}
}
