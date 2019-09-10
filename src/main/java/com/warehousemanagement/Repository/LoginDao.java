package com.warehousemanagement.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.warehousemanagement.Bean.login;
import com.warehousemanagement.Interfaces.LoginRepo;
/*
 * These class is like dao where we can add,delete and check data.
 */
@EnableAutoConfiguration
@Service
@Component
public class LoginDao {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	LoginRepo loginrepo;
	//in these are going to check id,password by getting data from db.
	public String check(login log) {
		String role = null;
		login list =loginrepo.findById(log.getId()).get();
		//if id and password is equal to db id and password it will tp thos method.
		if (list.getId().equals(log.getId()) && list.getPassword().equals(log.getPassword())) {
         role="admin";
			}
			//if entered id and password is null than it will go to this block of code
			else if(list.getId()==null&&list.getPassword().equals(null)) {
				 role="error";
			}
			//if id or password is not correct it will to these block of code.
			else {
				 role="invalid";
			}
		
		return role;
	}
	}


