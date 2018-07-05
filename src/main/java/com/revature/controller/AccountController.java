package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Customer;
import com.revature.beans.Login;
import com.revature.services.UserService;

@Controller
public class AccountController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	UserService us;
	
	@RequestMapping(value="/account/login", method=RequestMethod.PUT)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String registerCustomerFromLogin(@RequestBody CustomerDetails cd, HttpSession httpSession) throws JsonProcessingException {
		// updating your own customer details.
		Login user = (Login) httpSession.getAttribute("currentUser");
		if(!(user instanceof Customer)) {
			user = new Customer(user);
		} 
		((Customer) user).setBillingAdress(cd.billingAddress);
		((Customer) user).setShippingAddress(cd.billingAddress);
		us.update(user);
		httpSession.setAttribute("currentUser", user);
		return om.writeValueAsString(new UserAndRole(user));
	}
}

@Component
class CustomerDetails {
	public String billingAddress;
	public String shippingAddress;
}
