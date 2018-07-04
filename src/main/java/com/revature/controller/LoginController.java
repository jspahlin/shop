package com.revature.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.services.UserService;

@Controller
public class LoginController {
	
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	UserService us;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(@RequestBody UserPass up, HttpSession httpSession,
			HttpServletResponse response) throws JsonProcessingException {
		Login user = us.login(up.getUsername(), up.getPassword());
		if(user != null) {
			httpSession.setAttribute("currentUser", user);
			return om.writeValueAsString(user);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public String getSession(HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		if(user != null) {
			return om.writeValueAsString(user);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "";
		}
	}
}


@Component
class UserPass {
	private String username;
	private String password;
	public UserPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}