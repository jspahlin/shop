package com.revature.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.CardColor;
import com.revature.data.CardColorDao;

@Controller
public class CardColorController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardColorDao ccd;
	
	/*@PostConstruct
	public void addSomeColors() {
		ccd.save(new CardColor(0, "Blue"));
		ccd.save(new CardColor(0, "White"));
		ccd.save(new CardColor(0, "Green"));
		ccd.save(new CardColor(0, "Red"));
		ccd.save(new CardColor(0, "Black"));
		ccd.save(new CardColor(0, "Colorless"));
	}*/
	
	@RequestMapping(value="/card/color", method=RequestMethod.GET)
	@ResponseBody
	public String getColorType() throws JsonProcessingException {
		
		return om.writeValueAsString(ccd.list());
	}
}

