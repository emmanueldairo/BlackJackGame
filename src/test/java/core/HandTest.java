package core;

import junit.framework.TestCase;

public class HandTest extends TestCase{
	Card aCard =new Card("DIAMOND",1);
	Hand P1= new Hand("Bamise");
	
	public void testInsert() {
		P1.insert(aCard);
		Card temp=P1.deleteFirst();
		assertEquals(aCard.toString(),temp.toString());
	}
	public void testDeleteFirst() {
		P1.insert(aCard);
		Card temp=P1.deleteFirst();
		assertEquals(aCard.toString(),temp.toString());
	}
	public void testIsEmpty() {
		assertTrue(P1.isEmpty());
	}
	public void testBothEqual() {
		P1.insert(aCard);
		P1.insert(aCard);
		assertTrue(P1.bothEqual());
		Card temp=new Card("SPADE",13);
		P1.deleteFirst();
		P1.insert(temp);
		assertFalse(P1.bothEqual());
	}
	public void testPeekValue() {
		P1.insert(aCard);
		assertEquals(11, P1.peekValue());
	}
	public void testGetHandSize() {
		P1.insert(aCard);
		assertEquals(1, P1.getHandSize());
	}
	public void testGetName() {
		P1.insert(aCard);
		assertEquals("Bamise", P1.getName());
	}
	public void testGetHandTotal() {
		P1.insert(aCard);
		assertEquals(11, P1.getHandTotal());
	}
}
