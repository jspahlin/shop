package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Card;
import com.revature.data.CardDao;

@Component
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	CardDao ld;
	
	@Override
	public List<Card> list() {
		return ld.list();
	}
}
