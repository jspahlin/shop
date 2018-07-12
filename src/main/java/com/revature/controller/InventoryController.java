package com.revature.controller;

import java.util.HashSet;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Inventory;
import com.revature.beans.Login;
import com.revature.services.InventoryService;

@Controller
@RequestMapping(value="/inventory")
public class InventoryController {
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	InventoryService is;
	@RequestMapping(value = "/search/{text}", method=RequestMethod.GET)
	@ResponseBody
	public String search(@PathVariable String text) throws JsonProcessingException {
		return om.writeValueAsString(is.search(text));
	}
	@RequestMapping(value="/top", method=RequestMethod.GET)
	@ResponseBody
	public String top() throws JsonProcessingException {
		return om.writeValueAsString(is.topSeller());
	}
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String get (@PathVariable int id, HttpSession httpSession) throws JsonProcessingException {
		return om.writeValueAsString(is.get(id));
	}
	
	@RequestMapping(value = "/inventory/{id}", method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	@ResponseBody
	public String get (@PathVariable int id, HttpSession httpSession) throws JsonProcessingException {
		return om.writeValueAsString(is.get(id));
	}
	
	/*@PostConstruct
	public void addInventoryTest() {
		Card test = new Card(0, "Banana", "gives monkeys +1/+1", "http://blah.com", 100, 9, null,null,
				new HashSet<CardType>(), new HashSet<CardColor>(), new HashSet<CardCreatureType>());
		Inventory test2 = new Inventory(0,null, 5, 2);
		is.save(test2);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getInventory () throws JsonProcessingException {
		return om.writeValueAsString(is.list());
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String employeeSaveCard(@RequestBody Inventory inv) throws JsonProcessingException {
		return om.writeValueAsString(is.save(inv));
	}
}
