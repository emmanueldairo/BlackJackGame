package core;

import junit.framework.TestCase;

public class HandTest extends TestCase{
	Card aCard =new Card("DIAMOND",1);
	Hand P1= new Hand("Bamise");
	P1.insert(aCard);

	public void testInsert() {
		assertEquals(aCard.toString(),temp.toString());
	}
	public void testDeleteFirst() {
		Card temp=P1.deleteFirst();
		assertEquals(aCard.toString(),temp.toString());
	}
	public void testIsEmpty() {
		P1.deleteFirst();
		assertNull(P1.isEmpty());
	}
	public void testBothEqual() {
		P1.insert(aCard);
		assertTrue(P1.bothEqual());
		Card temp=new Card("SPADE",13)
		P1.deleteFirst();
		P1.insert(temp);
		assertFalse(P1.bothEqual(););
	}
	public void testPeekValue() {
		assertEquals(11, P1.peekValue());
	}
	public void testGetHandSize() {
		assertEquals(1, P1.getHandSize());
	}
	public void testGetName() {
		assertEquals("Bamise", P1.getName());
	}
	public void testGetHandTotal() {
		assertEquals(11, P1.getCardTotal());
	}
}
