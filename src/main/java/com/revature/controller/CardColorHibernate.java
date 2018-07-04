package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.CardColorDao;

public class CardColorHibernate {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardColorDao ccd;
	@RequestMapping(value="/card/color")
	@ResponseBody
	public String getColorType() throws JsonProcessingException {
		
		return om.writeValueAsString(ccd.list());
	}
}