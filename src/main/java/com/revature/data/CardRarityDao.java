package com.revature.data;

import java.util.List;

import com.revature.beans.CardRarity;

public interface CardRarityDao {
	public CardRarity get(int id);
	public CardRarity save(CardRarity rarity);
	public CardRarity update(CardRarity rarity);
	public void delete(CardRarity rarity);
	public List<CardRarity> list();
}
