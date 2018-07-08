package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.CardColorDao;

@Controller
public class CardColorController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	CardColorDao ccd;
	@RequestMapping(value="/card/color", method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getColorType() throws JsonProcessingException {
		return om.writeValueAsString(ccd.list());
	}
}

