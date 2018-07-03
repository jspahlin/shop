package com.revature.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	 @RequestMapping(value="/home", method=RequestMethod.GET)
     public String getHomepage(HttpSession s) {
		 return "static/index.html";
     }
}
