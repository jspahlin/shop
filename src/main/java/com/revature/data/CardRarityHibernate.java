package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.CardRarity;

@Component
public class CardRarityHibernate implements CardRarityDao, HibernateSession {
	private Session session;
	@Override
    public void setSession(Session session) {
            this.session = session;
    }

	@Override
	public CardRarity get(int id) {
		return (CardRarity) session.get(CardRarity.class, id);
	}
	@Override
	public CardRarity findByName(String name) {
		Query<CardRarity> q = session.createQuery("From com.revature.beans.CardRarity l where l.name=:name", CardRarity.class);
		q.setParameter("name", name);
		return q.uniqueResult();
	}
	@Override
	public CardRarity save(CardRarity rarity) {
		session.save(rarity);
		return rarity;
	}

	@Override
	public CardRarity update(CardRarity rarity) {
		session.update(rarity);
		return rarity;
	}
	@Override
	public void delete(CardRarity rarity) {
		session.delete(rarity);
	}

	@Override
	public List<CardRarity> list() {
		return (List<CardRarity>) session.createQuery("From com.revature.beans.CardRarity", CardRarity.class).list();
	}

}
