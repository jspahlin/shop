package com.revature.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
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
import com.revature.beans.Admin;
import com.revature.beans.CardRarity;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.data.CardRarityDao;
import com.revature.services.UserService;

@Controller
public class LoginController {
	
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	UserService us;
	@Autowired
	CardRarityDao crd;
	
	/*
	@PostConstruct
	public void doSomethingAfterStartup() {
		Login user = new Admin(0, "admin", "password", "jspahlin+admin@gmail.com", "123 Fake RD, Alaska", "123 Fake RD, Alaska");
		us.addUser(user);
		user = new Employee(0, "employee", "password", "jspahlin+employee@gmail.com", "123 Fake RD, Alaska", "123 Fake RD, Alaska");
		us.addUser(user);
		user = new Customer(0, "customer", "password", "jspahlin+customer@gmail.com", "123 Fake RD, Alaska", "123 Fake RD, Alaska");
		us.addUser(user);
		user = new Login(0, "login", "password", "jspahlin+login@gmail.com");
		us.addUser(user);
		
		crd.save(new CardRarity(0, "Common"));
		crd.save(new CardRarity(0, "Uncommon"));
		crd.save(new CardRarity(0, "Rare"));
		crd.save(new CardRarity(0, "Mythic"));
		
	    System.out.println("hello world, I have just started up");
	}
	*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String doLogin(@RequestBody UserPass up, HttpSession httpSession,
			HttpServletResponse response) throws JsonProcessingException {
		Login user = us.login(up.getUsername(), up.getPassword());
		if(user != null) {
			httpSession.setAttribute("currentUser", user);
			return om.writeValueAsString(new UserAndRole(user));
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getSession(HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		if(user != null) {
			return om.writeValueAsString(new UserAndRole(user));
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "";
		}
	}
	
	@RequestMapping(value="/account/new/login", method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String makeNewAccount(@RequestBody Login login, HttpSession httpSession, HttpServletResponse response) throws JsonProcessingException {
		Login user = (Login) httpSession.getAttribute("currentUser");
		if (user != null) { // can't make a new account if you are already logged in.
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "";
		} else {
			Login newLogin = us.addUser(login);
			if(newLogin==null) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return "";
			}
			return om.writeValueAsString(new UserAndRole(newLogin));
		}
	}
	@RequestMapping(value="/login", method=RequestMethod.DELETE)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String doLogout( HttpSession httpSession,
			HttpServletResponse response) throws JsonProcessingException {
		httpSession.invalidate();
		return "";
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