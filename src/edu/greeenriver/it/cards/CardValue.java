/*Name:Patrick Callahan
 *Date:1/13/17
 *File Name:CardValue.java
 *Desc: An enum of available constant values in a deck of cards
 *       
 * 
 *
 */
package edu.greeenriver.it.cards;

/**
 * An enum of available constant values in a deck of cards
 * 
 * @author Patricks Callahan
 * @version 1.0
 *
 */
public enum CardValue {
	  TWO(2),
	  THREE(3),
	  FOUR(4),
	  FIVE(5),
	  SIX(6),
	  SEVEN(7),
	  EIGHT(8),
	  NINE(9),
	  TEN(10),
	  JACK(11),
	  QUEEN(12),
	  KING(13),
	  ACE(14);
	
	  //Private field,contructor,and getter to get the value of the card
	  private int cardValue;
	 
	  private CardValue (int value)
	  {
	    this.cardValue = value;
	  }
	 
	  public int getCardValue() {
	    return cardValue;
	  }

}
