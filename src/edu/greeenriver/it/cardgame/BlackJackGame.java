/*Name:Patrick Callahan
 *Date:1/13/17
 *File Name:BlackJackGame.java
 *Desc: A blackjack game class that instantiates a game of blackjack
 *       
 */
package edu.greeenriver.it.cardgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.greeenriver.it.cards.Card;
import edu.greeenriver.it.cards.CardValue;
import edu.greeenriver.it.cards.SuitValue;

/**
 * This creates a Blackjack game object that will allow a user to 
 * play a game of blackjack
 * 
 * @author Patricks Callahan
 * @version 1.0
 *
 */
public class BlackJackGame extends CardGame {
	//Global variables
	Scanner userInput = new Scanner(System.in);
	BlackJackGame playerDeck;
	BlackJackGame dealerDeck;
	BlackJackGame newGame;
	ArrayList<Card> playerCards = new ArrayList<>();
	ArrayList<Card> dealerCards = new ArrayList<>();
	boolean endRound = false;
	static int MAX_BUST = 21;
	static int DEALER_STAND =17;
	
	//Instance variables
	private ArrayList<Card> cards;
	private String welcomeMessage;
	private static String gameName = "Blackjack";
	
	/**
	 * A BlackJackGame constructor that accepts an array of cards
	 * @param cards
	 */
	public BlackJackGame(ArrayList<Card> cards){
		super(gameName);
		this.welcomeMessage = "Play a Blackjack game!\nWelcome to my BlackJack Game!";
		this.cards = cards;
		
	}
	
	/**
	 * Creating a deck of cards and populating the deck with a 
	 * suit and a value
	 */
	public void createADeck(){
		//Generate a deck of cards
		for(SuitValue cardSuit: SuitValue.values()){
			for(CardValue cardValue: CardValue.values()){
				//Add a new card to deck
				this.cards.add(new Card(cardValue,cardSuit));
			}
		}
	}

	/**
	 * Shuffling the deck of cards
	 */
	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<>();
		Random randCard = new Random();
		//Represents a random card were pulling out
		int randCardIndex = 0;
		//Getting size of the deck[52]
		int originalSize = this.cards.size();
		for(int i = 0;i < originalSize;i++){
			//Generate random index randCard.nextInt(max-min)-1)+min;
			randCardIndex = randCard.nextInt((this.cards.size()- 1 -0)+1 ) + 0;
			tempDeck.add(this.cards.get(randCardIndex));
			//Remove from original deck
			this.cards.remove(randCardIndex);
		}
		
		this.cards = tempDeck;
	}
	
	/**
	 * Returns an Arraylist of dealt card objects
	 */
	public ArrayList<Card> deal() {
		
		BlackJackGame newGame = new BlackJackGame(cards);
		newGame.createADeck();
		newGame.shuffle();
		
		//Create a deck for player and dealer
		BlackJackGame playerDeck = new BlackJackGame(playerCards);
		BlackJackGame dealerDeck = new BlackJackGame(dealerCards);
		
		//Player get 2 cards
		playerDeck.draw(newGame);
		playerDeck.draw(newGame);
		
		//Dealer get 2 cards
		dealerDeck.draw(newGame);
		dealerDeck.draw(newGame);
	
		//Game loop
		while(true){
			System.out.println("Play a Blackjack game!\nWelcome to my BlackJack Game!");
			System.out.println("Your hand:" + playerDeck);
			System.out.println("Your hand total is:" + playerDeck.cardsValue());
			if(playerDeck.cardsValue() == MAX_BUST){
				System.out.println("You got 21, you win!");
				endRound = true;
			}
			System.out.println("");
			
			//Display dealer hand
			System.out.println("Dealer hand:\n" + dealerDeck.getCard(0).toString() + " and [concealed]");
			
			//What does player want to do
			System.out.println("Would you like to hit(y) or stand(n):");
			String response = userInput.nextLine();
			
			if(response.equalsIgnoreCase("y")){
				playerDeck.draw(newGame);
				System.out.println("You drew a:" + playerDeck.getCard(playerDeck.deckSize()- 1));
				
					//Bust if over 21
					if(playerDeck.cardsValue() > MAX_BUST){
						System.out.println("");
						System.out.println("Sorry you busted! Your busted value is:" + playerDeck.cardsValue());
						endRound = true;
						break;
					}
			}
			//Break out of loop is player stands
			if(response.equalsIgnoreCase("n")){
				break;
			}
		}
		//Reveal dealer cards
		System.out.println("Dealer Cards:" + dealerDeck.toString());
		//See if dealer has more points than the player
		if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false){
			System.out.println("Dealer wins!");
			endRound = true;
		}
		//Dealer draws at 16 and stands at 17
		while(dealerDeck.cardsValue() < DEALER_STAND && endRound == false){
			//Dealer draws a card
			dealerDeck.draw(newGame);
			System.out.println("Dealer drew a:" + dealerDeck.getCard(dealerDeck.deckSize()- 1).toString());
		}
		//Display total value for dealer
		System.out.println("Dealers hand total is:" + dealerDeck.cardsValue());
		//Determine if dealer busted
		if(dealerDeck.cardsValue() > MAX_BUST && endRound == false){
			System.out.println("Dealer busts, you win!");
			endRound = true;
		}
		if(dealerDeck.cardsValue() == MAX_BUST){
			System.out.println("Dealer wins, you lose!");
			endRound = true;
		}
		//Determine if theres a push/tie
		if(playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound == false){
			System.out.println("There is a tie");
			endRound = true;
		}
		if(playerDeck.cardsValue() > dealerDeck.cardsValue() && endRound == false){
			System.out.println("You win!");
			endRound = true;
		}
		else if(endRound == false){
			System.out.println("");
			System.out.println("Sorry, you lose!");
		}
		
		//Return to top of deck
		playerDeck.returnCardsToDeck(newGame);
		dealerDeck.returnCardsToDeck(newGame);
		System.out.println("End of hand");
		System.out.println("");
		playRound();
		return this.cards;
	}
			
	/**
	 * Play a round of blackjack
	 */
	public void playRound() {
		//Play another round
		System.out.println("Would you like to play again:Y/N");
		String playAgain = userInput.nextLine();
		if(playAgain.equals("y")){
			deal();
		}
		else{
			System.out.println("Good bye");
		}
	
	}
	
	/**
	 * Will remove an index from our arraylist of cards
	 * @param removes an index from the arraylist
	 */
	public void removeCard(int i){
		this.cards.remove(i);
	}
	
	/**
	 * Gets a card at specified index
	 * @param accepts an int as a param
	 * @return return the index of the card
	 */
	public Card getCard(int i){
		return this.cards.get(i);
	}
	
	/**
	 * Adds a card to the deck
	 * @param accepts a Card as a param
	 */
	public void addCard(Card addCard){
		this.cards.add(addCard);
	}
	
	/**
	 * Return the size of the deck
	 * @return return the size of the deck
	 */
	public int deckSize(){
		return this.cards.size();
	}
	
	/**
	 * Returns dealt cards to the deck for reshuffling
	 * @param returnTo return dealt cards to the deck
	 */
	public void returnCardsToDeck(BlackJackGame returnTo){
		int thisDeckSize = this.cards.size();
		
		//Return cards back into deck
		for(int i= 0;i < thisDeckSize;i++){
			returnTo.addCard(this.getCard(i));
		}
		//Empty out deck
		for(int i = 0;i < thisDeckSize;i++){
			this.removeCard(0);
		}
	}
	/**
	 * Draws a card from the deck
	 * @param accepts a BlackjackGame as a param
	 */
	public void draw(BlackJackGame comingFrom){
		//Beginning of ArrayList is top of the deck
		this.cards.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
	}
	
	/**
	 * Returns the total value of the deck
	 * @return returns the total value of the deck
	 */
	public int cardsValue(){
		int totalValue = 0;
		
		for(Card aCard: this.cards){
			//switch statement to get an associated value
			switch(aCard.getCardValue()){
			case TWO: totalValue += 2; 
			break;
			case THREE: totalValue += 3; 
			break;
			case FOUR: totalValue += 4; 
			break;
			case FIVE: totalValue += 5; 
			break;
			case SIX: totalValue += 6; 
			break;
			case SEVEN: totalValue += 7; 
			break;
			case EIGHT: totalValue += 8; 
			break;
			case NINE: totalValue += 9; 
			break;
			case TEN: totalValue += 10; 
			break;
			case JACK: totalValue += 10; 
			break;
			case QUEEN: totalValue += 10; 
			break;
			case KING: totalValue += 10; 
			break;
			case ACE: totalValue += 1; 
			break;
			}
			
		}
		return totalValue;
	}
	
	/**
	 * Returns a string representation of a hand of cards
	 */
	public String toString(){
		String cardOutput = "";
		
		for(Card aCard: this.cards){
			cardOutput += "\n" + aCard.toString();
		}
		return cardOutput  ;
	}
}
