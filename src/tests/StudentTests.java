package tests;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import blackjack.Blackjack;
import blackjack.Card;


/**
 * Please put your own test cases into this file, so they can be tested
 * on the server.
*/

public class StudentTests {
	
	// Tests if decks generate properly
	@Test
	public void test1DeckGeneration(){
		List<Card> deck = Blackjack.generateDeck();
		int size = deck.size();
		System.out.println("Deck size: " + size);
		assertTrue(size == 52);
	}

	// Tests that cards will never run out
	@Test
	public void test2HitTilYouDrop(){
		Blackjack blackjack = setBlackJack();
		int repetitions = 1000;
		boolean fail = false;
		
		try{
		for(int i = 0; i < repetitions; i++){
			blackjack.deal();
			while(blackjack.getGameStatus() != Blackjack.DEALER_WON){
				blackjack.playerHit();
			}
		}
		} catch(Exception e){
			fail = true;
		}
		
		assertTrue(!fail);
	}
	
	// Tests that aces calculations never return a second value over 21
	@Test
	public void test3AcesUnder22(){
		Blackjack blackjack = setBlackJack();
		int repetitions = 100;
		boolean fail = false;
		for(int i = 0; i < repetitions; i++){
			blackjack.deal();
			while(blackjack.getGameStatus() != Blackjack.DEALER_WON){
				blackjack.playerHit();
				
				int[] values = blackjack.getPlayerCardsTotal();
				
				if(values != null && values.length == 2 && values[1] > 21){
					fail = true;
				}
			}
		}
		
		assertTrue(!fail);
	}
	
	private static Blackjack setBlackJack() {
		Random randomGenerator = new Random(System.currentTimeMillis());
		int numberOfDecks = 1;
		Blackjack blackjack = new Blackjack(randomGenerator, numberOfDecks);
	    return blackjack;
	}
}