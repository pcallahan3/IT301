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
	 * @param args takes an array of string	 */
	public static void main(String[] args) {
		/*
		//Create a new blackjack game object
		ArrayList<Card> newCard = new ArrayList<>();
		BlackJackGame newGame = new BlackJackGame(newCard);
		
		//Deal cards and play game
		newGame.deal();
		System.out.println(newGame);*/
		
		int[] values = new int[] {9,32,54,6,267,53,43,3232,78};
		
		/*Sum numbers in an array
		int temp = 0;
		for(int i = 0;i < values.length;i++){
			temp *= values[i];
			
		}
		System.out.println(temp);*/
		
		/*Find smallest element
		int minIndex = 0;
		for(int i = 0;i < values.length;i++){
			if(values[i] < values[minIndex]){
				minIndex = i;
			}
		}
		System.out.println(minIndex);*/
		
		/*Search for a target
		int target = 32;
		for(int i = 0;i < values.length;i++){
			if(values[i] == target){
				System.out.println(target);
			}
		}*/
		
		/*
		int maxNum = ;
		for(int i = 0;i < values.length;i++){
			if(maxNum == values[i]){
				System.out.println(maxNum);
			}
			else{
				System.out.println("Wrong");
				break;
			}
		}*/
		
		/*
		int maxNum = values[0];//find the element not the index
		for(int i = 0;i < values.length;i++){
			if(values[i] > maxNum){
				maxNum = values[i];
			}
		}
		System.out.println(maxNum);
		*/
	
		int minNum = values[0];
		for(int i = 0;i < values.length;i++){
			if(values[i] < minNum){
				System.out.println(minNum);
			}
			else{
				System.out.println("Wrong");
			}
			
			
		}
	}
}



		
		
