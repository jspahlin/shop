package com.revature.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.CardRarity;
import com.revature.data.CardRarityDao;

@Controller
public class HomeController {
	@Autowired
	ApplicationContext ac;
	@RequestMapping(value="/home1", method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
     public String getHomepage(HttpSession s) {
		 CardRarityDao crd = (CardRarityDao) ac.getBean(CardRarityDao.class);
		 crd.save(new CardRarity(0, "Rare"));
		 System.out.println(crd.list());
		 return "static/index.html";
     }
}
