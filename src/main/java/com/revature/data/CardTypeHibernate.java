package com.revature.data;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.CardType;

@Component
public class CardTypeHibernate implements CardTypeDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public CardType get(int id) {
		return (CardType) session.get(CardType.class, id);
	}

	@Override
	public CardType save(CardType type) {
		session.save(type);
		return type;
	}

	@Override
	public CardType update(CardType type) {
		session.update(type);
		return type;
	}

	@Override
	public void delete(CardType type) {
		session.update(type);
	}

	@Override
	public List<CardType> list() { 
		return (List<CardType>) session.createQuery("From com.revature.beans.CardType", CardType.class).list();
	}

}



