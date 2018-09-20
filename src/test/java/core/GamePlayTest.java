package core;

import org.junit.Test;

import junit.framework.TestCase;

public class GamePlayTest extends TestCase{
		Card aCard=new Card("DIAMOND",1);
		Deck aDeck=new Deck();
		Hand player= new Hand("Player");
		Hand split=new Hand("Split");
		Hand dealer=new Hand("Dealer");
	@Test
	public void testInitDeck() {
		GamePlay.initDeck("SKHQSQC5DJ", aDeck);	
		assertNotNull(aDeck);
	}

	@Test
	public void testSplit() {
	player.insert(aCard);
	player.insert(aCard);
	dealer.insert(aCard);
	split=GamePlay.split(player, split, dealer);
	assertNotNull(split);
	}

	@Test
	public void testStand() {
		player.insert(aCard);
		GamePlay.stand(aDeck, player, split, dealer);
		
		assertEquals(aCard.getValue(), player.peekValue());
	}

	@Test
	public void testHit() {
		player.insert(aCard);
		dealer.insert(aCard);
		aDeck.push(aCard);
		aDeck=GamePlay.hit(aDeck, player, split, dealer);
		assertNotNull(aDeck);
	}

	@Test
	public void testDealerDraw() {
		aDeck.push(aCard);
		aDeck=GamePlay.dealerDraw(aDeck, player, split, dealer);
		assertNotNull(aDeck);
	}

	@Test
	public void testDrawFromDeck() {
		aDeck.push(aCard);
		aDeck=GamePlay.drawFromDeck(aDeck, player);
		assertNotNull(aDeck);	
	}


	@Test
	public void testCheckDeck() {
		aDeck=GamePlay.checkDeck(aDeck);
		assertNotNull(aDeck);	
		}

	@Test
	public void testCreateDeck() {
		aDeck=GamePlay.createDeck();
		assertNotNull(aDeck);	}

	@Test
	public void testInitialDraw() {
		
		aDeck=GamePlay.initialDraw(aDeck, player, split, dealer);
		assertNotNull(aDeck);
		assertNotNull(player);
		assertNotNull(dealer);

		}

	

}
