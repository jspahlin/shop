package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.CardColor;

@Component
public class CardColorHibernate implements CardColorDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;

	}

	@Override
	public CardColor get(int id) {
		return (CardColor) session.get(CardColor.class, id);
	}

	@Override
	public CardColor save(CardColor color) {
		session.save(color);
		return color;
	}

	@Override
	public CardColor update(CardColor color) {
		session.update(color);
		return color;
	}
	
	@Override
	public void delete(CardColor color) {
		session.delete(color);
	}
	@Override
	public CardColor findByName(String name) {
		Query<CardColor> q = session.createQuery("From com.revature.beans.CardColor l where l.name=:name", CardColor.class);
		q.setParameter("name", name);
		return q.uniqueResult();
	}

	@Override
	public List<CardColor> list() {
		return (List<CardColor>) session.createQuery("From com.revature.beans.CardColor", CardColor.class).list();
	}

}
