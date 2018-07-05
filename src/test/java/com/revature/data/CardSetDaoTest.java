package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.beans.CardSet;

public class CardSetDaoTest extends DaoTest {
	{ o = new CardSetHibernate(); }
	@Test
	public void simpleDaoFunctions() {
		CardSetHibernate o = (CardSetHibernate) this.o;
		
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
		
		assertEquals(size-1, o.list().size());
	}
	
	@Test
	public void getNonExistantObjectIsNull () {
		CardSetHibernate o = (CardSetHibernate) this.o;
		assertNull(o.get(1000000));
	}
}
