
/*Name:Patrick Callahan
 *Date:1/13/17
 *File Name:CardGame.java
 *Desc: An abstract class of a card game that accepts a gameName string
 *		and a welcomeMessage string. It also includes 3 abstract methods 
 *		deal(),shuffle(), and playround()
 *
 */
package edu.greeenriver.it.cardgame;

import java.util.ArrayList;

import edu.greeenriver.it.cards.Card;


/**
 * An abstract card game that will be used for other card games
 * @author Patrick Callahan	
 * @version 1.0
 *
 */
public abstract class CardGame {
	
	private String gameName;

	/**
	 * A card game object that accetps a string for a game name
	 * @param gameName
	 */
	public CardGame(String gameName){
		this.gameName = gameName;
		
	}
	
	/**
	 * This method will deal and return a Card object
	 * 
	 * @return returns a Card object
	 */
	public abstract ArrayList<Card> deal();
	
	/**
	 * This method will shuffle the Card object
	 */
	public abstract void shuffle();
	
	/**
	 * This method will allow the user to play a round of blackjack
	 */
	public abstract void playRound();

	@Override
	public String toString() {
		return  this.gameName  ;
	}

}
