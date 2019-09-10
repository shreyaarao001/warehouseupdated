package com.warehousemanagement;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.ItemInfo;

@Controller
public class StockController {
	//this method is used to check and display items.
	@RequestMapping(value="checkItem" , method = RequestMethod.POST)
	public ModelAndView CheckItem( String item_id,HttpSession session)
	{ //this url is used to check item.
		String url="http://localhost:8182/iteminfo/check";
		RestTemplate restTemplate=new RestTemplate();
		String  status=restTemplate.postForObject(url, item_id, String.class);
		//if item is present it will go to these block and display the details of item.
	    if(status.equals("Yes")) {
	    	//these url is used to display the item information.
	    	url="http://localhost:8182/iteminfo/display";
	    	ItemInfo item=restTemplate.postForObject(url, item_id, ItemInfo.class);
	    	session.setAttribute("itemobj", item);
	    	//Based on item information here we are going add stock.
	    	ModelAndView modelAndView=new ModelAndView("ItemInfo1.jsp");
	    	modelAndView.addObject("obj",item);
	    	return modelAndView;
	    }
	    //if item is not present it will add item and we can add stock
	    else {
	    	ModelAndView modelAndView=new ModelAndView();
	    	modelAndView.setViewName("NewItem.jsp");
	    	return modelAndView;
	    }
}
	//this method is used to add stock.
	@RequestMapping(value="addStock" , method = RequestMethod.POST)
public ModelAndView addStock( String stock,HttpSession session)
{

	ModelAndView modelAndView=new ModelAndView("Display.jsp");
	RestTemplate restTemplate=new RestTemplate();
	ItemInfo itemobj=(ItemInfo)session.getAttribute("itemobj");
	int itemid=itemobj.getItem_id();
	//this url is used to add stock after displaying item information.
	String url="http://localhost:8182/iteminfo/addstock/"+itemid;
	String  status=restTemplate.postForObject(url, stock, String.class);
	//if stock is added it will go these block of code.
    if(status.equals("Yes")) {
    	modelAndView.addObject("obj",status);
    	return modelAndView;
    }
    //if stock is not added it will go to these block of code.
    else {
    	modelAndView.addObject("obj",status);
    	return modelAndView;
    }
	
}
}
