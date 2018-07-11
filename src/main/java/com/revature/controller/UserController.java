package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

@Controller
public class UserController {
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	UserService us;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	public String employeeRespondWithList() throws JsonProcessingException {
		return om.writeValueAsString(us.listAll().stream().map(u->new UserAndRole(u)).toArray());
	}
	
}
