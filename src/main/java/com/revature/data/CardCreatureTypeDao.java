package com.revature.data;

import java.util.List;

import com.revature.beans.CardCreatureType;

public interface CardCreatureTypeDao {
	public CardCreatureType get(int id);
	public CardCreatureType save(CardCreatureType creature);
	public CardCreatureType update(CardCreatureType creature);
	public void delete(CardCreatureType creature);
	public List<CardCreatureType> list();
}
