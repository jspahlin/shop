package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.beans.CardCreatureType;

public class CardCreatureTypeDaoTest extends DaoTest {
	{ o = new CardCreatureTypeHibernate(); }
	@Test
	public void simpleDaoFunctions() {
		CardCreatureTypeHibernate o = (CardCreatureTypeHibernate) this.o;

		CardCreatureType test = new CardCreatureType(0, "TEST"); // transient
		CardCreatureType testResult = o.save(test);


		assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
		assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.

		assertEquals(testResult, o.get(testResult.getId()));

		testResult.setName("TEST2");
		CardCreatureType testResult2 = o.update(testResult);


		assertEquals(testResult2, o.get(testResult.getId()));
		assertEquals("TEST2", testResult2.getName());

		int size = o.list().size();
		assertNotEquals(0, size);

		o.delete(testResult);

		assertEquals(size-1, o.list().size());
	}

	@Test
	public void getNonExistantObjectIsNull () {
		CardCreatureTypeHibernate o = (CardCreatureTypeHibernate) this.o;
		assertNull(o.get(1000000));
	}
}