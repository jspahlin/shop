package com.revature.data;

import java.util.List;
import com.revature.beans.CardType;

public interface CardTypeDao {
	public CardType get(int id);
	public CardType save(CardType type);
	public CardType update(CardType type);
	public void delete(CardType type);
	
	public List<CardType> list();
	CardType findByName(String name);
}
