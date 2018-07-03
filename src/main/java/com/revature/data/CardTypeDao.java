package com.revature.data;

import java.util.Set;

import com.revature.beans.CardType;

public interface CardTypeDao {
	public CardType get(int id);
	public CardType save(CardType type);
	public CardType update(CardType type);
	public void delete(CardType type);
	public Set<CardType> list();
}
