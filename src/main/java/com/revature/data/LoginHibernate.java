package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Login;

@Component
public class LoginHibernate implements LoginDao, HibernateSession {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Login get(int id) {
		return (Login) session.get(Login.class, id);
	}

	@Override
	public Login getByPass(String username, String password) {
		Query<Login> q = session.createQuery("From com.revature.beans.Login l where l.username=:username and l.password=:password", Login.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		return q.uniqueResult();
	}

	@Override
	public Login save(Login user) { // TODO: FIGURE OUT WHY HIBERNATE WILL NOT RESPECT CONSTRAINTS!!!!!!!
		session.save(user);
		return user;
	}

	@Override
	public Login update(Login user) {
		session.update(user);
		return user;
	}

	@Override
	public void delete(Login user) {
		session.delete(user);
	}
	@Override
	public List<Login> list() {
		return (List<Login>) session.createQuery("From com.revature.beans.Login", Login.class).list();
	}
}
