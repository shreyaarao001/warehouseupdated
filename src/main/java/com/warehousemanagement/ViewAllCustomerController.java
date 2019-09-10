package com.warehousemanagement;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.CustomerInfo;
/*
 * In these controller we are going to view all cutomers.
 */
@Controller
public class ViewAllCustomerController {
	//if we are going to view customer it will enter in these block of code
	@RequestMapping("/allcustomers")
	public ModelAndView viewCustomers() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8182/customerinfo/view_customer";
		ResponseEntity<List<CustomerInfo>> customerlist = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerInfo>>() {
				});
		List<CustomerInfo> customer_details=customerlist.getBody();
		ModelAndView modelAndView = new ModelAndView("/ViewAllCustomers.jsp");
		modelAndView.addObject("customer_details", customer_details);
		return modelAndView;
	}

}
