package core;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class DeckTest extends TestCase{
	Card aCard =new Card("ACE",1);
	Deck aDeck =new Deck(52);
	Card temp;
	public void testPushPop() {
		aDeck.push(aCard);	
		assertEquals(false, aDeck.isEmpty());
		temp=aDeck.pop();
		assertEquals(aCard.getRank(), temp.getRank());
		assertEquals(aCard.getSuit(), temp.getSuit());
		
	}
	public void testIsEmpty() {
		assertEquals(true, aDeck.isEmpty());
	}
	public void testShuffleDeck() {
		aDeck.createDeck();
		aDeck.pop();
		aDeck.push(aCard);
		aDeck.shuffleDeck();
		temp=aDeck.pop();
		assertNotEquals(aCard.getRank(), temp.getRank());
		assertNotEquals(aCard.getSuit(), temp.getSuit());
	}
	public void testCreateDeck() {
		aDeck.createDeck();
		assertNotNull(aDeck.pop());
	}


}
