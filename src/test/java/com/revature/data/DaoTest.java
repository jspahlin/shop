package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import com.revature.utils.HibernateUtil;

public class DaoTest {
	protected HibernateUtil hu;
	protected Session session;
    protected Transaction tx;
	protected HibernateSession o;
	@Before
	public void setup() {
		hu = new HibernateUtil();
		session = hu.getSession();
		tx = session.beginTransaction();
		o.setSession(session);
		
	}
	@After
	public void tearDown() {
		tx.rollback();
		session.close();		
		
		hu = null;
		session = null;
		tx = null;
		o = null;
	}
}
