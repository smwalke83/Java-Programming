package com.cis2235.walkerp6;

/**
 * Program: P8 Three Card Brag Game
 * File Name: CardDeck.java
 * Description: Represents a deck of 52 playing cards and handles randomized dealing mechanics.
 */

import java.util.Random;

public class CardDeck{

    private Card[] cardArray;		// Array to hold the 52 Card objects
    private boolean[] cardDealt;	// Parallel array tracking if a card has been used (true = played)
    private int cardsDealtCount;	// Counter to track how many cards have been dealt
    private Card lastCardReturned;	// Keeps track of the last card returned by the deck
    private Random random;			// Random object for selecting randomized cards

    /**
     * Constructor
     * Fills the card array sequentially to match the provided .png image files.
     */
    public CardDeck(){
        cardArray = new Card[52];
        cardDealt = new boolean[52];
        cardsDealtCount = 0;
        random = new Random();
        lastCardReturned = null;

        String[] suits = {"spade", "heart", "diamond", "club"};
        int imageCounter = 1; // Maps to image file names from 1.png through 52.png

        // Populate the card array in the strict sequential order required
        for (int s = 0; s < suits.length; s++) {
            // First card of each suit is the Ace (Rank 14)
            cardArray[s * 13] = new Card();
            cardArray[s * 13].setRank(14);
            cardArray[s * 13].setSuit(suits[s]);
            cardArray[s * 13].setImageName(imageCounter + ".png");
            imageCounter++;

            // Remaining cards of the suit range from 2 up to 13 (King)
            for (int r = 2; r <= 13; r++){
                int index = (s * 13) + (r - 1);
                cardArray[index] = new Card();
                cardArray[index].setRank(r);
                cardArray[index].setSuit(suits[s]);
                cardArray[index].setImageName(imageCounter + ".png");
                imageCounter++;
            }
        }

        // Initialize the tracking array (all cards initially set to false/not played)
        for (int i = 0; i < cardDealt.length; i++){
            cardDealt[i] = false;
        }
    }

    /**
     * Generates a random number between 0 and 51, checks if that card has been played,
     * and returns the card object while updating tracking flags.
     */
    public Card getNextCard(){
        // Safety guard: If no cards are left to play, return the last card played
        if (cardsDealtCount >= 52){
            return lastCardReturned;
        }

        int randomIndex;

        // Loop generates another random index if the selected card has already been dealt
        do {
            randomIndex = random.nextInt(52); // Generates a random number between 0 and 51
        }while (cardDealt[randomIndex]);

        // Mark the card as dealt and increment counters
        cardDealt[randomIndex] = true;
        cardsDealtCount++;
        lastCardReturned = cardArray[randomIndex]; // Update the last card returned

        return lastCardReturned;
    }

    /**
     * Getter method for the dealt cards count (helpful for managing Controller logic)
     */
    public int getCardsDealtCount(){ return cardsDealtCount; }
}
