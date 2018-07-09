package com.revature.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Card;
import com.revature.beans.CardColor;
import com.revature.beans.CardCreatureType;
import com.revature.beans.CardRarity;
import com.revature.beans.CardSet;
import com.revature.beans.CardType;
import com.revature.services.CardService;

@Controller
@RequestMapping(value="/card")
public class CardController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardService cs;
	
	@RequestMapping(method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getCardType() throws JsonProcessingException {
		Set<CardColor> colors = new HashSet<CardColor>();
		colors.add(new CardColor(0, "Blue"));
		Card test = new Card(0, "TEST", "Card text", "http://blah.com", 100, 9, new CardRarity(0, "Rare"), new CardSet(0, "Alpha"),
				new HashSet<CardType>(), new HashSet<CardColor>(), new HashSet<CardCreatureType>());
		
		Card testResult = cs.save(test);
		return om.writeValueAsString(cs.list());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String employeeSaveCard(@RequestBody Card card) throws JsonProcessingException {
		return om.writeValueAsString(cs.save(card));
	}
}