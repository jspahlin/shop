package com.revature.controller;

import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Card;
import com.revature.beans.CardColor;
import com.revature.beans.CardCreatureType;
import com.revature.beans.CardType;
import com.revature.beans.Inventory;
import com.revature.services.InventoryService;

@Controller
@RequestMapping(value="/inventory")
public class InventoryController {
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	InventoryService is;
	
	@PostConstruct
	public void addInventoryTest() {
		Card test = new Card(0, "Banana", "gives monkeys +1/+1", "http://blah.com", 100, 9, null,null,
				new HashSet<CardType>(), new HashSet<CardColor>(), new HashSet<CardCreatureType>());
		Inventory test2 = new Inventory(0,test, 5, 2);
		is.save(test2);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String getInventory () throws JsonProcessingException {
		return om.writeValueAsString(is.list());
	}

}
