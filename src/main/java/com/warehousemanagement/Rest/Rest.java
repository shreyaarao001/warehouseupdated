package com.warehousemanagement.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.warehousemanagement.Bean.login;
import com.warehousemanagement.Repository.LoginDao;
/*
 * These class is like rest it is called when we specify url.
 */
@RestController
@RequestMapping("valid")
public class Rest {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	LoginDao logindao;
	//these method is used check in login inforamtion and we will call dao call in these method
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String insert(@RequestBody login log) {
		   String status=logindao.check(log);
			return status;
		   
		   
	   }
}
