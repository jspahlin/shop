package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Card;

@Component
public class CardHibernate implements HibernateSession, CardDao {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public Card get(int id) {
		return session.get(Card.class, id);
	}

	@Override
	public Card save(Card card) {
		session.save(card);
		return card;
	}

	@Override
	public void delete(Card card) {
		session.delete(card);
	}

	@Override
	public Card update(Card card) {
		session.update(card);
		return card;
	}

	@Override
	public List<Card> list() {
		return session.createQuery("From com.revature.beans.Card", Card.class).list();
	}
}