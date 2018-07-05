package com.revature.beans;

import java.util.Set;

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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="card_rarity_id")
	private CardRarity rarity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="card_set_id")
	private CardSet set;
	
	@Column(name="card_color")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="card_color_card",
			joinColumns=@JoinColumn(name="card_id"),
			inverseJoinColumns=@JoinColumn(name="card_color_id"))
	private Set<CardColor> colors;
	
	@Column(name="creature_type")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="card_creature_type_card",
			joinColumns=@JoinColumn(name="card_id"),
			inverseJoinColumns=@JoinColumn(name="card_creature_type_id"))
	private Set<CardCreatureType> creatureTypes;
	
}
