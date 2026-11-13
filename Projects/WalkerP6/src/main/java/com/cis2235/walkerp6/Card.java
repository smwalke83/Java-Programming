package com.cis2235.walkerp6;

/**
 * Program: P8 Three Card Brag Game
 * File Name: Card.java
 * Description: Represents the data for a single playing card.
 */

public class Card {
    // Class members
    private int rank;			// Rank ranges from 2 through 14 (where 14 represents an Ace)
    private String suit;		// Suit can be "spade", "heart", "diamond", or "club"
    private String imageName;	// The filename of the card image (e.g., "1.png", "2.png")

    /**
     * Default constructor
     * Left empty per project specifications.
     */
    public Card(){
    }

    // --- Getters and Setters ---

    public int getRank(){ return rank; }
    public void setRank(int rank){ this.rank = rank; }

    public String getSuit(){ return suit; }
    public void setSuit(String suit){ this.suit = suit; }

    public String getImageName(){ return imageName; }
    public void setImageName(String imageName){this.imageName = imageName; }
}
