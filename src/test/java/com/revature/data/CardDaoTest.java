package com.revature.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.*;
import org.junit.Test;

public class CardDaoTest extends DaoTest {
	{ o = new CardHibernate(); }
	@Test
	public void simpleDaoFunctions() {
		CardHibernate o = (CardHibernate) this.o;
		Set<CardColor> colors = new HashSet<CardColor>();
		colors.add(new CardColor(0, "Blue"));
		Card test = new Card(0, "TEST", "Card text", "http://blah.com", 9,
				new CardRarity(0, "Rare"), new CardSet(0, "Alpha"), new CardType(0, "Instant"),
				colors, new HashSet<CardCreatureType>());
		Card testResult = o.save(test);


		assertNotNull(testResult); // making sure that saving an object actually creates an object in the db.
		assertNotEquals(0, testResult.getId()); // Id needs to be non-zero for it to be persistant.

		assertEquals(testResult, o.get(testResult.getId()));

		testResult.setName("TEST2");
		Card testResult2 = o.update(testResult);


		assertEquals(testResult2, o.get(testResult.getId()));
		assertEquals("TEST2", testResult2.getName());
/*
		int size = o.list().size();
		assertNotEquals(0, size);
*/
		o.delete(testResult);

	//	assertEquals(size-1, o.list().size());
		
	}

	@Test
	public void getNonExistantObjectIsNull () {
		CardHibernate o = (CardHibernate) this.o;
		assertNull(o.get(1000000));
	}
}

