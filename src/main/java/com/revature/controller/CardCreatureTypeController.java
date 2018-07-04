package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.CardCreatureTypeDao;

public class CardCreatureTypeController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardCreatureTypeDao cctd;
	@RequestMapping(value="/card/creature/type", method=RequestMethod.GET)
	@ResponseBody
	public String getCardType() throws JsonProcessingException {
		return om.writeValueAsString(cctd.list());
	}
}
