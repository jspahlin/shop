package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Card;
import com.revature.services.CardService;

@Controller
@RequestMapping(value="/card")
public class CardController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardService cs;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getCardType() throws JsonProcessingException {
		return om.writeValueAsString(cs.list());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String employeeSaveCard(@RequestBody Card card) throws JsonProcessingException {
		return om.writeValueAsString(cs.save(card));
	}
}