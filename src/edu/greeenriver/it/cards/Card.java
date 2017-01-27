/*Name:Patrick Callahan
 *Date:1/13/17
 *File Name:Card.java
 *Desc: A card class that instantiates a card object
 *       
 */
package edu.greeenriver.it.cards;

/**
 * A card class that allows you to instantiate a card object
 * @author Patrick Callahan
 * @version 1.0
 *
 */
public class Card {
	
	private SuitValue suitValue;
	private CardValue cardValue;
	
	/**
	 * This creates a card object that accepts suit and a value
	 * 
	 * @param suitValue the suit of the card
	 * @param cardValue the value of the card
	 */
	public Card(CardValue cardValue, SuitValue suitValue) {
		this.suitValue = suitValue;
		this.cardValue = cardValue;
	}
	
	public Card(){
		this.suitValue = SuitValue.SPADES;
		this.cardValue = CardValue.ACE;
	}
	
	/**
	 * A getter for the suit value
	 * 
	 * @return returns the suit value
	 */
	public SuitValue getSuitValue(){
	    return this.suitValue;
	  }
	 
	/**
	 * A setter for the suit value
	 * 
	 * @param suit sets the suit of the card
	 */
	  public void setSuitValue(SuitValue suit){
	    this.suitValue = suit;
	  }
	 
	  /**
	   * A getter for the card value
	   * 
	   * @return returns the value of the card
	   */
	  public CardValue getCardValue(){
	    return this.cardValue;
	  }
	 
	  /**
	   * A setter for the card value
	   * 
	   * @param setter for value of the card
	   */
	  public void setCardValue(CardValue cardValue){
	    this.cardValue = cardValue;
	  }
	  
	  /**
	   * toString() to return the car value and card suit
	   */
	public String toString() {
		return this.cardValue.toString() + " " + this.suitValue.toString();
	}


}
