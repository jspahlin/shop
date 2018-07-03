package com.revature.data;

import java.util.List;

import org.hibernate.Session;

import com.revature.beans.CardCreatureType;

public class CardCreatureTypeHibernate implements CardCreatureTypeDao, HibernateSession {
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public CardCreatureType get(int id) {
		return (CardCreatureType) session.get(CardCreatureType.class, id);
	}

	@Override
	public CardCreatureType save(CardCreatureType creature) {
		session.save(creature);
		return creature;
	}

	@Override
	public CardCreatureType update(CardCreatureType creature) {
		session.update(creature);
		return creature;
	}
	@Override
	public void delete(CardCreatureType creature) {
		session.delete(creature);
	}
	@Override
	public List<CardCreatureType> list() {
		return (List<CardCreatureType>) session.createQuery("From com.revature.beans.CardCreatureType", CardCreatureType.class).list();
	}

}
