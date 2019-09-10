package com.warehousemanagement;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.Transactions;

@Controller
@RequestMapping("displayTransaction")
public class DisplayTransactionController {
	//In this method going to check transactions
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView CheckTransaction( String transaction_date,HttpSession session)
	{
		//these url is used to redirect to rest(CustomerRest).
		String url="http://localhost:8182/transactions/check";
		HttpHeaders requestHeaders=new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(transaction_date, requestHeaders);
		//here it consumes restful method services
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<List<Transactions>>  status=restTemplate.exchange(url, HttpMethod.POST,requestEntity, new ParameterizedTypeReference<List<Transactions>>() {});
	    //here we use exchange to consume all http method and we will redirect to ViewTransaction.jsp.
		ModelAndView modelAndView=new ModelAndView("ViewTransactions.jsp");
	    modelAndView.addObject("obj",status.getBody());
	    return modelAndView;
	   
		
	}

}
