package com.warehousemanagement.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.warehousemanagement.Bean.ItemInfo;
import com.warehousemanagement.Interfaces.ItemInterface;
import com.warehousemanagement.Repository.ItemInfoDAO;
/*
 * These class is like rest when we specify url it will come this class
 */
@RestController
@RequestMapping("iteminfo")
public class ItemRest {
	/*
	 *  we use to auto wire bean on the setter method, constructor or a field.
	 */
		@Autowired
		ItemInterface iteminterface;
		@Autowired
		ItemInfoDAO iteminfodao;
		//these method is used add customer inforamtion and we will call dao call in these method
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		   public String insert(@RequestBody ItemInfo item){
		String status=iteminfodao.addItem(item);
			   return status; 
		
}//these method is used check item inforamtion and we will call dao call in these method
		@RequestMapping(value = "/check", method = RequestMethod.POST)
		   public String findCustomer(@RequestBody String item_id) {
			ItemInfo itemObj=iteminfodao.check(item_id);
			   String status;
			   if (itemObj.getName()!=null)
				   status="Yes";
			   else
				   status="No";
				return status; 
		   }
		//these method is used display item inforamtion and we will call dao call in these method
		@RequestMapping(value = "/display", method = RequestMethod.POST)
		   public ItemInfo displayCustomer(@RequestBody String item_id) {
			   ItemInfo status=iteminfodao.viewItem(item_id);
				return status; 
		   }
		//these method is used addstock in item inforamtion and we will call dao call in these method
		@RequestMapping(value = "/addstock/{id}", method = RequestMethod.POST)
		   public String addStock(@RequestBody String stock,@PathVariable("id") int id) {
			String status=iteminfodao.addStock(id,stock);
				return status; 
		   }
		
}
