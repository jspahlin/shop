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
import com.revature.beans.CardSet;
import com.revature.data.CardSetDao;

@Controller
public class CardSetController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardSetDao csd;
	
	@PostConstruct
	public void addSomeSets() {
		csd.save(new CardSet(0, "Dominaria"));
		csd.save(new CardSet(0, "Ixalan"));
		csd.save(new CardSet(0, "Hour of Devastation"));
		csd.save(new CardSet(0, "Revolt"));
		csd.save(new CardSet(0, "Kaladesh"));
		csd.save(new CardSet(0, "Eldritch Moon"));
		csd.save(new CardSet(0, "Shadows over Innistrad"));
	}
	
	@RequestMapping(value="/card/set", method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getCardType() throws JsonProcessingException {	
		return om.writeValueAsString(csd.list());
	}
}

