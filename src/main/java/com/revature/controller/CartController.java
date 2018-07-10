package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.beans.Login;
import com.revature.services.CartService;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CartService cs;
	
	@RequestMapping(method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getCart(HttpSession httpSession) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		
		return om.writeValueAsString(cs.getCart(user.getId()));
	}
}