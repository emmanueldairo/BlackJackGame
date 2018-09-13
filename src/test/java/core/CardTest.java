package core;

import junit.framework.TestCase;

public class CardTest extends TestCase{
	public void testgetRankName() {
		Card aCard =new Card();
		assertEquals("A", aCard.getRankName());
	}
	public void testgetValue() {
		Card aCard =new Card();
		assertEquals(1, aCard.getValue());
	}
	public void testgetSuit() {
		Card aCard =new Card();
		assertEquals("Ace", aCard.getSuit());
	}
	public void testgetRank() {
		Card aCard =new Card();
		assertEquals(1, aCard.getRank());
	}
	public void testshowCard() {
		Card aCard =new Card();
		assertEquals("A_1", aCard.showCard());
	}	
	
}
