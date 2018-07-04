package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.revature.beans.CardSet;
import com.revature.utils.HibernateUtil;



public class CardSetDaoTest {
	
	@Test
	public void simpleDaoFunctions() {
		HibernateUtil hu = new HibernateUtil();
		Session session = hu.getSession();
        Transaction tx = session.beginTransaction();
        
        
		CardSetHibernate o = new CardSetHibernate();
		o.setSession(session);
		
		assertNull(o.get(1000000));
		
		CardSet test = new CardSet(0, "TEST"); // transient
		CardSet testResult = o.save(test);
		

		assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
		assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.
		
		assertEquals(testResult, o.get(testResult.getId()));
		
		testResult.setName("TEST2");
		CardSet testResult2 = o.update(testResult);
		

		assertEquals(testResult2, o.get(testResult.getId()));
		assertEquals("TEST2", testResult2.getName());

		int size = o.list().size();
		assertNotEquals(0, size);
		
		o.delete(testResult);
		
		tx.rollback();
		assertEquals(size-1, o.list().size());
		session.close();		
	}
}
