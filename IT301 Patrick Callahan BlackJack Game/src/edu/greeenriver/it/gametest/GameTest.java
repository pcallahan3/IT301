/*Name:Patrick Callahan
 *Date:1/13/17
 *File Name:GameTest.java
 *Desc: A game test class that to objects in certain packages
 *       
 */
package edu.greeenriver.it.gametest;

import java.util.ArrayList;

import edu.greeenriver.it.cardgame.BlackJackGame;
import edu.greeenriver.it.cards.Card;

/**
 * Entry point into the application
 * @author Patricks Callahan
 * @version 1.0
 *
 */
public class GameTest {

	/**
	 * Entry point into the application
	 * @param args takes an array of strings
	 */
	public static void main(String[] args) {
		
		//Create a new blackjack game object
		ArrayList<Card> newCard = new ArrayList<>();
		BlackJackGame newGame = new BlackJackGame(newCard);
		
		//Deal cards and play game
		newGame.deal();
		System.out.println(newGame);
	}

}
