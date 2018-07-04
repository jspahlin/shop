package com.revature.data;

import java.util.List;
import org.hibernate.Session;

import com.revature.beans.CardSet;

public class CardSetHibernate implements CardSetDao, HibernateSession {
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public CardSet get(int id) {
		return (CardSet) session.get(CardSet.class, id);

	}

	@Override
	public CardSet save(CardSet set) {
		session.save(set);
		return set;
	}

	@Override
	public CardSet update(CardSet set) {
		session.update(set);
		return set;
	}

	@Override
	public void delete(CardSet set) {
		session.update(set);

	}

	@Override
	public List<CardSet> list() {
		return (List<CardSet>) session.createQuery("From com.revature.beans.CardType", CardSet.class).list();
	}

}
