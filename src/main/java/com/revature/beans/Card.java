package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
public class Card {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_gen")
    @SequenceGenerator(name="card_gen", sequenceName="card_seq", allocationSize=1)
	private int id;
	private String name;
	private String text;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="converted_mana_cost")
	private int convertedManaCost;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="card_rarity_id")
	private CardRarity rarity;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="card_set_id")
	private CardSet set;
	
	@Column(name="card_color")
	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name="card_color_card",
			joinColumns=@JoinColumn(name="card_id"),
			inverseJoinColumns=@JoinColumn(name="card_color_id"))
	private Set<CardColor> colors;
	
	@Column(name="creature_type")
	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name="card_creature_type_card",
			joinColumns=@JoinColumn(name="card_id"),
			inverseJoinColumns=@JoinColumn(name="card_creature_type_id"))
	private Set<CardCreatureType> creatureTypes;

	public Card() {
		super();
	}

	public Card(int id, String name, String text, String imageUrl, int convertedManaCost, CardRarity rarity,
			CardSet set, Set<CardColor> colors, Set<CardCreatureType> creatureTypes) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.imageUrl = imageUrl;
		this.convertedManaCost = convertedManaCost;
		this.rarity = rarity;
		this.set = set;
		this.colors = colors;
		this.creatureTypes = creatureTypes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getConvertedManaCost() {
		return convertedManaCost;
	}

	public void setConvertedManaCost(int convertedManaCost) {
		this.convertedManaCost = convertedManaCost;
	}

	public CardRarity getRarity() {
		return rarity;
	}

	public void setRarity(CardRarity rarity) {
		this.rarity = rarity;
	}

	public CardSet getSet() {
		return set;
	}

	public void setSet(CardSet set) {
		this.set = set;
	}

	public Set<CardColor> getColors() {
		return colors;
	}

	public void setColors(Set<CardColor> colors) {
		this.colors = colors;
	}

	public Set<CardCreatureType> getCreatureTypes() {
		return creatureTypes;
	}

	public void setCreatureTypes(Set<CardCreatureType> creatureTypes) {
		this.creatureTypes = creatureTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", text=" + text + ", imageUrl=" + imageUrl
				+ ", convertedManaCost=" + convertedManaCost + ", rarity=" + rarity + ", set=" + set + ", colors="
				+ colors + ", creatureTypes=" + creatureTypes + "]";
	}
}
