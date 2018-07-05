package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.CardType;
import com.revature.utils.HibernateUtil;

public class CardTypeDaoTest {
	
		HibernateUtil hu;
		Session session;
	    Transaction tx;
		CardTypeHibernate o;
		@Before
		public void setup() {
			hu = new HibernateUtil();
			session = hu.getSession();
			tx = session.beginTransaction();
			o = new CardTypeHibernate();
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
		@Test
		public void simpleDaoFunctions() {
			
			
			CardType test = new CardType(0, "TEST"); // transient
			CardType testResult = o.save(test);
			

			assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
			assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.
			
			assertEquals(testResult, o.get(testResult.getId()));
			
			testResult.setName("TEST2");
			CardType testResult2 = o.update(testResult);
			

			assertEquals(testResult2, o.get(testResult.getId()));
			assertEquals("TEST2", testResult2.getName());

			int size = o.list().size();
			assertNotEquals(0, size);
			
			o.delete(testResult);
			
			assertEquals(size-1, o.list().size());
		}
		
		@Test
		public void getNonExistantObjectIsNull () {
			assertNull(o.get(1000000));
		}
	}

