package com.revature.data;

import java.util.Set;

import com.revature.beans.CardColor;

public interface CardColorDao {
	public CardColor get(int id);
	public CardColor insert(CardColor color);
	public boolean update(CardColor color);
	public Set<CardColor> list();
}
