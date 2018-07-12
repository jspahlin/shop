package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Card;
import com.revature.data.CardColorDao;
import com.revature.data.CardCreatureTypeDao;
import com.revature.data.CardDao;
import com.revature.data.CardRarityDao;
import com.revature.data.CardSetDao;
import com.revature.data.CardTypeDao;

@Component
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardDao ld;
	@Autowired
	private CardColorDao ccd;
	@Autowired
	private CardCreatureTypeDao cctd;
	@Autowired
	private CardRarityDao crd;
	@Autowired
	private CardSetDao csd;
	@Autowired
	private CardTypeDao ctd;
	
	
	@Override
	public List<Card> list() {
		return ld.list();
	}
	
	@Override
	public Card getCardByID(int id) {
		return ld.get(id);
	}
	
	@Override
	public Card save(Card card) { // Cards can have stuff in them that is already in the db...
		if(crd.findByName(card.getRarity().getName()) != null) {
			card.setRarity(crd.findByName(card.getRarity().getName()));
			System.out.println("updating rarity....");
		}
		if(csd.findByName(card.getSet().getName()) != null) {
			card.setSet(csd.findByName(card.getSet().getName()));
		}
		
		
		
		
		return ld.save(card);
	}
}
