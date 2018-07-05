package com.revature.data;

import java.util.List;

import com.revature.beans.CardColor;
import com.revature.beans.CardSet;

public interface CardColorDao {
	public CardColor get(int id);
	public CardColor save(CardColor color);
	public CardColor update(CardColor color);
	public void delete(CardColor color);
	public List<CardColor> list();
}
