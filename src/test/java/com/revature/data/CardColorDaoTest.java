package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.beans.CardColor;

public class CardColorDaoTest extends DaoTest {
	{ o = new CardColorHibernate(); }
	@Test
	public void simpleDaoFunctions() {
		CardColorHibernate o = (CardColorHibernate) this.o;

		CardColor test = new CardColor(0, "TEST"); // transient
		CardColor testResult = o.save(test);


		assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
		assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.

		assertEquals(testResult, o.get(testResult.getId()));

		testResult.setName("TEST2");
		CardColor testResult2 = o.update(testResult);


		assertEquals(testResult2, o.get(testResult.getId()));
		assertEquals("TEST2", testResult2.getName());

		int size = o.list().size();
		assertNotEquals(0, size);

		o.delete(testResult);

		assertEquals(size-1, o.list().size());
	}

	@Test
	public void getNonExistantObjectIsNull () {
		CardColorHibernate o = (CardColorHibernate) this.o;
		assertNull(o.get(1000000));
	}
}