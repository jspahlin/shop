package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.CardSetDao;

@Controller
public class CardSetController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardSetDao csd;
	@RequestMapping(value="/card/set")
	@ResponseBody
	public String getCardType() throws JsonProcessingException {
		
		return om.writeValueAsString(csd.list());
	}
}

