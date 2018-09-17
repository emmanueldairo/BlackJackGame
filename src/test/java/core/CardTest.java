package core;

import junit.framework.TestCase;

public class CardTest extends TestCase{
		Card aCard =new Card("DIAMOND",1);
		
	public void testgetRankName() {
		assertTrue(aCard.getRankName().equals("A"));
	}
	public void testgetValue() {
		assertEquals(11, aCard.getValue());
	}
	public void testgetSuit() {
		assertTrue(aCard.getSuit().equals("DIAMOND"));

	}
	public void testgetRank() {
		assertEquals(1, aCard.getRank());
	}
	public void testToString() {
		assertTrue(aCard.toString().equals("A_DIAMOND"));
	}
	
}
