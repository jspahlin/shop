package com.revature.data;

import java.util.Set;

import com.revature.beans.CardSet;

public interface CardSetDao {
	public CardSet get(int id);
	public CardSet save(CardSet set);
	public CardSet update(CardSet set);
	public void delete(CardSet set);
	public Set<CardSet> list();
}
