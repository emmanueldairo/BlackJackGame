package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
	Card aCard =new Card("ace",1);
	Deck aDeck =new Deck(52);
	
	
	public void testPushAndPop() {
		aDeck.push(aCard);
		assertEquals(aCard, aDeck.pop());
	}
	public void testIsEmpty() {
		assertEquals(-1, aDeck.isEmpty());
	}
	public void testShuffleDeck() {
		aDeck.createDeck();
		aDeck.pop();
		aDeck.push(aCard);
		assertNotEquals(aCard, aDeck.shuffleDeck());
	}
	public void testCreateDeck() {
		aDeck.createDeck();
		assertNotNull(aDeck.pop());
		assertEquals(aCard, aDeck.pop());
	}


}
