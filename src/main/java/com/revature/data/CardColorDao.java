package com.revature.data;

import java.util.List;

import com.revature.beans.CardColor;

public interface CardColorDao {
	public CardColor get(int id);
	public CardColor save(CardColor color);
	public CardColor update(CardColor color);
	public void delete(CardColor color);
	public List<CardColor> list();
	public CardColor findByName(String name);
}
