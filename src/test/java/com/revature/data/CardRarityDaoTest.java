package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.beans.CardRarity;

public class CardRarityDaoTest extends DaoTest {

	{ o = new CardRarityHibernate(); }
	@Test
	public void simpleDaoFunctions() {
		CardRarityHibernate o = (CardRarityHibernate) this.o;

		CardRarity test = new CardRarity(0, "TEST"); // transient
		CardRarity testResult = o.save(test);


		assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
		assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.

		assertEquals(testResult, o.get(testResult.getId()));

		testResult.setName("TEST2");
		CardRarity testResult2 = o.update(testResult);


		assertEquals(testResult2, o.get(testResult.getId()));
		assertEquals("TEST2", testResult2.getName());

		int size = o.list().size();
		assertNotEquals(0, size);

		o.delete(testResult);

		assertEquals(size-1, o.list().size());
	}

	@Test
	public void getNonExistantObjectIsNull () {
		CardRarityHibernate o = (CardRarityHibernate) this.o;
		assertNull(o.get(1000000));
	}
}