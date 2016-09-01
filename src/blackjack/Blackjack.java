package blackjack;
import java.util.*;

public class Blackjack implements BlackjackEngine {
	
	private final int standardDeckSize = 52;
	private int numberOfDecks;
	
	
	/**
	 * Constructor you must provide.  Initializes the player's account 
	 * to 200 and the initial bet to 5.  Feel free to initialize any other
	 * fields. Keep in mind that the constructor does not define the 
	 * deck(s) of cards.
	 * @param randomGenerator
	 * @param numberOfDecks
	 */
	public Blackjack(Random randomGenerator, int numberOfDecks) {
	    throw new UnsupportedOperationException("You must implement this method.");
	    
	}
	
	/**
	 * Returns the number of decks being used. 
	 * @return number of decks
	 */
	public int getNumberOfDecks() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Creates and shuffles the card deck(s) using a random number generator.
	 */
	public void createAndShuffleGameDeck() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns the current deck of cards.
	 * @return Card array representing deck of cards.
	 */
	public Card[] getGameDeck() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Creates a new deck of cards, and assigns cards to the dealer and player.
	 * A total of four cards are dealt in the following order:
	 * Player (face up), Dealer (face down), Player (face up), Dealer (face  up).
	 * Once the cards have been dealt, the game's status will be GAME_IN_PROGRESS.
	 * Delete the bet amount from the account.
	 */
	public void deal() {	
		throw new UnsupportedOperationException("You must implement this method.");
	}
		
	/**
	 * Returns dealer's cards.
	 * @return Card array representing the dealer's cards.
	 */
	public Card[] getDealerCards() {
		throw new UnsupportedOperationException("You must implement this method.");
	}

	/**
	 * Returns an array representing the possible value(s) associated with the 
	 * dealer's cards if the cards represent a value less than or equal to 21.
	 * @return Integer array representing the possible value(s) or null if cards
	 * represent a value higher than 21.  The array will have a size of 1 if only
	 * one value is associated with the set of cards, and a size of two if two
	 * values are possible.  For the case of an array of size two, the smaller value
	 * must appear in the first array entry.
	 */
	public int[] getDealerCardsTotal() {
		throw new UnsupportedOperationException("You must implement this method.");
	}

	/**
	 * Returns an integer value that can assume the values
	 * LESS_THAN_21 if the dealer's cards have a value less than 21,
	 * BUST if the dealer's cards have a value greater than 21, and
	 * BLACKJACK if the dealer has an Ace along with a "10", Jack, Queen, or King.
	 * If the dealer's cards have a value equivalent to 21 and the hand does
	 * not correspond to a blackjack, HAS_21 will be returned.
	 * @return Integer value that corresponds to one of the following: 
	 * LESS_THAN_21, BUST, BLACKJACK, HAS_21
	 */
	public int getDealerCardsEvaluation() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns player's cards.
	 * @return Card array representing the player's cards.
	 */
	public Card[] getPlayerCards() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns an array representing the possible value(s) associated with the 
	 * player's cards if the cards represent a value less than or equal to 21.
	 * @return integer array representing the possible value(s) or null if cards
	 * represent a value higher than 21.  The array will have a size of 1 if only
	 * one value is associated with the set of cards, and a size of two if two
	 * values are possible.  For the case of an array of size two, the smaller value
	 * must appear in the first array entry.
	 */
	public int[] getPlayerCardsTotal() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
		
	/**
	 * Returns an integer value that can assume the values
	 * LESS_THAN_21 if the player's cards have a value less than 21,
	 * BUST if the players's cards have a value greater than 21, and
	 * BLACKJACK if the player has an Ace along with a "10", Jack, Queen, or King.
	 * If the players' cards have a value equivalent to 21 and the hand does
	 * not correspond to a blackjack, HAS_21 will be returned.
	 * @return Integer value that corresponds to one of the following: 
	 * LESS_THAN_21, BUST, BLACKJACK, HAS_21
	 */
	public int getPlayerCardsEvaluation() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Retrieves a card from the deck and assigns the card to the player.
	 * The new sets of cards will be evaluated.  If the player busts, the game
	 * is over and the games's status will be updated to DEALER_WON.  Otherwise
	 * the game's status is GAME_IN_PROGRESS.
	 */
	public void playerHit() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Flips the dealer's card that is currently face down 
	 * and assigns cards to the dealer as long as the dealer 
	 * doesn't bust and the cards have a value less than 16.  Once the dealer
	 * has a hand with a value greater than or equal to 16, and less than or equal to 21, 
	 * the hand will be compared against the player's hand and whoever has the
	 * hand with a highest value will win the game. If both have the same value 
	 * we have a draw.  The game's status will be updated to one of
	 * the following values: DEALER_WON, PLAYER_WON, or DRAW.  The player's
	 * account will be updated with a value corresponding to twice the bet amount if 
	 * the player wins.  If there is a draw the player's account will be updated
	 * with the only the bet amount. 
	 *
	 */
	public void playerStand() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/** 
	 * Updates the bet amount to the provided value 
	 */
	public int getGameStatus() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns an integer representing the bet amount.
	 * @return bet amount.
	 */
	public void setBetAmount(int amount) {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Updates the player's account with the parameter value.
	 * @param amount 
	 */
	public int getBetAmount() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns the player's account amount
	 * @return account amount
	 */
	public void setAccountAmount(int amount) {	
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns an integer representing the game status.   
	 * @return DRAW, PLAYER_WON, DEALER_WON OR GAME_IN_PROGRESS
	 */
	public int getAccountAmount() {
		throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/* Feel Free to add any private methods you might need */
}