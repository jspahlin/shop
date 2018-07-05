package com.revature.data;

import java.util.List;

import com.revature.beans.Card;

public interface CardDao {
	public Card get(int id);
	public Card save(Card card);
	public void delete(Card card);
	public Card update(Card card);
	public List<Card> list();
}
