package com.warehousemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.warehousemanagement.Bean.login;

/*
 * In this controller we are using url which will go to rest class(Rest) we should specify mapping in rest.
 */

@Controller
@RequestMapping("/control")
@SessionAttributes("login")
public class LoginController {

@RequestMapping(method = RequestMethod.GET)
public ModelAndView logincontroller()
{
	ModelAndView modelAndView=new ModelAndView("login.jsp");
	login log=new login();
	modelAndView.addObject(log);
	return modelAndView;
}
/*
 * In this method we called post in login.jsp so it will enter into this method and go to rest.
 */
@RequestMapping(method = RequestMethod.POST)
public String logincontrol( login log)
{
	String url="http://localhost:8182/valid/insert";
	RestTemplate restTemplate=new RestTemplate();
	String  status=restTemplate.postForObject(url, log, String.class);
	/*
	 * If return type is admin than it will enter in this block of code or else it will go to error block
	 */
    if(status.equals("admin")) {
    	return "redirect:Home.jsp";
    }
    else if(status.equals("error")) {
    	return "redirect:Error.jsp";
    }
    else {
    	return "redirect:Error.jsp";
    }
	
}
}
