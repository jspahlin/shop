package com.revature.services;

import java.util.List;

import com.revature.beans.Card;

public interface CardService {
	public List<Card> list();
	public Card getCardByID(int id);
	public Card save(Card card);
}
