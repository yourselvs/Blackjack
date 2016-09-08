package blackjack;
import java.util.*;

public class Blackjack implements BlackjackEngine {
	private Random rand;
	private final int standardDeckSize = 52;
	private int numberOfDecks;
	
	private List<Card> gameDeck;
	private List<Card> playerDeck;
	private List<Card> dealerDeck;
	
	private int gameStatus;
	
	private int betAmount;
	private int accountAmount;
	
	/**
	 * Constructor you must provide.  Initializes the player's account 
	 * to 200 and the initial bet to 5.  Feel free to initialize any other
	 * fields. Keep in mind that the constructor does not define the 
	 * deck(s) of cards.
	 * @param randomGenerator
	 * @param numberOfDecks
	 */
	public Blackjack(Random randomGenerator, int numberOfDecks) {
	    this.rand = randomGenerator;
	    this.numberOfDecks = numberOfDecks;
	    
	    gameDeck = new ArrayList<Card>();
	    playerDeck = new ArrayList<Card>();
	    dealerDeck = new ArrayList<Card>();
	    
	    gameStatus = 0;
	}
	
	/**
	 * Returns the number of decks being used. 
	 * @return number of decks
	 */
	public int getNumberOfDecks() {
		return numberOfDecks;
	}
	
	/**
	 * Creates and shuffles the card deck(s) using a random number generator.
	 */
	public void createAndShuffleGameDeck() {
		gameDeck.clear();
		for(int i = 0; i < numberOfDecks; i++){
			gameDeck.addAll(generateDeck());
		}
		Collections.shuffle(gameDeck, rand);
	}
	
	/**
	 * Returns the current deck of cards.
	 * @return Card array representing deck of cards.
	 */
	public Card[] getGameDeck() {
		return gameDeck.toArray(new Card[gameDeck.size()]);
	}
	
	/**
	 * Creates a new deck of cards, and assigns cards to the dealer and player.
	 * A total of four cards are dealt in the following order:
	 * Player (face up), Dealer (face down), Player (face up), Dealer (face  up).
	 * Once the cards have been dealt, the game's status will be GAME_IN_PROGRESS.
	 * Delete the bet amount from the account.
	 */
	public void deal() {	
		Card card;
		
		card = gameDeck.remove(0);
		card.setFaceUp();
		playerDeck.add(card);
		
		card = gameDeck.remove(0);
		card.setFaceDown();
		dealerDeck.add(card);

		card = gameDeck.remove(0);
		card.setFaceUp();
		playerDeck.add(card);
		
		card = gameDeck.remove(0);
		card.setFaceUp();
		dealerDeck.add(card);
		
		accountAmount -= betAmount;
	}
		
	/**
	 * Returns dealer's cards.
	 * @return Card array representing the dealer's cards.
	 */
	public Card[] getDealerCards() {
		return dealerDeck.toArray(new Card[gameDeck.size()]);
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
		int[] totals;
		boolean hasAce = false;
		
		int total = 0;
		
		for(Card card : dealerDeck){
			if(card.getValue().getIntValue() == CardValue.Ace.getIntValue()){
				hasAce = true;
			}
			total += card.getValue().getIntValue();
		}
		
		if(total > 21)
			return null;
		
		if(hasAce && total < 12){
			totals = new int[2];
			totals[0] = total;
			totals[1] = total + 10;
			return totals;
		}
		
		totals = new int[1];
		totals[0] = total;
		return totals;
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
		int[] cards = getDealerCardsTotal();
		
		if(cards == null){ // Decks with a total over 21
			return Blackjack.BUST;
		}
		
		if(cards[0] == 21){ // Decks without aces that equal 21
			return Blackjack.HAS_21;
		}
		if(cards.length == 1){ // Decks without aces that are less than 21
			return Blackjack.LESS_THAN_21;
		}
		
		if(cards[1] < 21){ // Decks with aces are less than 21 with either value
			return Blackjack.LESS_THAN_21;
		}
		
		if(dealerDeck.size() == 2){ // Only two cards
			return Blackjack.BLACKJACK;
		}
		else { // More than two cards
			return Blackjack.HAS_21;
		}
	}
	
	/**
	 * Returns player's cards.
	 * @return Card array representing the player's cards.
	 */
	public Card[] getPlayerCards() {
		return playerDeck.toArray(new Card[gameDeck.size()]);
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
		int[] totals;
		boolean hasAce = false;
		
		int total = 0;
		
		for(Card card : playerDeck){
			if(card.getValue().getIntValue() == CardValue.Ace.getIntValue()){
				hasAce = true;
			}
			total += card.getValue().getIntValue();
		}
		
		if(total > 21)
			return null;
		
		if(hasAce && total < 12){
			totals = new int[2];
			totals[0] = total;
			totals[1] = total + 10;
			return totals;
		}
		
		totals = new int[1];
		totals[0] = total;
		return totals;
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
		int[] cards = getPlayerCardsTotal();
		
		if(cards == null){ // Decks with a total over 21
			return Blackjack.BUST;
		}
		
		if(cards[0] == 21){ // Decks without aces that equal 21
			return Blackjack.HAS_21;
		}
		if(cards.length == 1){ // Decks without aces that are less than 21
			return Blackjack.LESS_THAN_21;
		}
		
		if(cards[1] < 21){ // Decks with aces are less than 21 with either value
			return Blackjack.LESS_THAN_21;
		}
		
		if(playerDeck.size() == 2){ // Only two cards
			return Blackjack.BLACKJACK;
		}
		else { // More than two cards
			return Blackjack.HAS_21;
		}
	}
	
	/**
	 * Retrieves a card from the deck and assigns the card to the player.
	 * The new sets of cards will be evaluated.  If the player busts, the game
	 * is over and the games's status will be updated to DEALER_WON.  Otherwise
	 * the game's status is GAME_IN_PROGRESS.
	 */
	public void playerHit() {
		playerDeck.add(gameDeck.remove(0));
		
		if(getPlayerCardsEvaluation() == Blackjack.BUST){
			gameStatus = Blackjack.DEALER_WON;
			return;
		}
		
		gameStatus = Blackjack.GAME_IN_PROGRESS;
		
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
		dealerDeck.get(0).setFaceUp();
	}
	
	/**
	 * Returns an integer representing the game status.   
	 * @return DRAW, PLAYER_WON, DEALER_WON OR GAME_IN_PROGRESS
	 */public int getGameStatus() {
		return gameStatus;
	}

	/** 
	 * Updates the bet amount to the provided value 
	 */
	public void setBetAmount(int amount) {
		betAmount = amount;
	}
	
	/**
	 * Returns an integer representing the bet amount.
	 * @return bet amount.
	 */
	public int getBetAmount() {
		return betAmount;
	}
	
	/**
	 * Updates the player's account with the parameter value.
	 * @param amount 
	 */
	public void setAccountAmount(int amount) {	
		accountAmount = amount;
	}
	
	/**
	 * Returns the player's account amount
	 * @return account amount
	 */
	public int getAccountAmount() {
		return accountAmount;
	}
	
	/* Feel Free to add any private methods you might need */
	private List<Card> generateDeck(){
		// TODO finish method
		return null;
	}
}