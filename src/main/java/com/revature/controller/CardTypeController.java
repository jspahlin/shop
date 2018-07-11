package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.CardTypeDao;

@Controller
public class CardTypeController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardTypeDao ctd;
	@RequestMapping(value="/card/type", method=RequestMethod.GET)
	@ResponseBody
	public String getCardType() throws JsonProcessingException {
		
		return om.writeValueAsString(ctd.list());
	}
}
