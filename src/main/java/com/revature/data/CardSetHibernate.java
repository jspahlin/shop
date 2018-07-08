package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.CardRarity;
import com.revature.beans.CardSet;

@Component
public class CardSetHibernate implements CardSetDao, HibernateSession {
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public CardSet get(int id) {
		return session.get(CardSet.class, id);

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
		session.delete(set);

	}
	@Override
	public CardSet findByName(String name) {
		Query<CardSet> q = session.createQuery("From com.revature.beans.CardSet l where l.name=:name", CardSet.class);
		q.setParameter("name", name);
		return q.uniqueResult();
	}

	@Override
	public List<CardSet> list() {
		return (List<CardSet>) session.createQuery("From com.revature.beans.CardSet", CardSet.class).list();
	}

}
