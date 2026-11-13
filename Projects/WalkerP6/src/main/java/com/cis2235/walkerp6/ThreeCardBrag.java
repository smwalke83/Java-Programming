package com.cis2235.walkerp6;

// logic for the game
// File Name: ThreeCardBrag.java
// omartinez54@student.cnm.edu
// Oscar Martinez

public class ThreeCardBrag {

    private Card[] p1Cards;
    private Card[] p2Cards;
    private int outcome = 0; // 0: No winner/Tie, 1: P1 wins, 2: P2 wins, 3: Equal tier tie

    // Default constructor per program criteria
    public ThreeCardBrag() {}

    /**
     * Maps incoming hands from controller and runs determination engine.
     */
    public void setPlayerHands(Card[] hand1, Card[] hand2) {
        p1Cards = hand1;
        p2Cards = hand2;
        determineOutcome();
    }

    /**
     * Fetches calculation results for the Controller.
     */
    public int getWinningHand() {
        return (p1Cards == null || p2Cards == null) ? 0 : outcome;
    }

    /**
     * Formats ruleset payload for UI text blocks.
     */
    public String getRules() {
        return "Three Card Brag Rules:\n" +
                "• Tier 3 (Max): Three 3's or any Ace\n" +
                "• Tier 2 (Mid): 2 or 3 cards of identical suit or rank\n" +
                "• Tier 1 (Low): Presence of King, Queen, or Jack\n\n" +
                "Higher tier claims victory. Matching tiers end in a tie.";
    }

    /**
     * Executes tier comparison algorithm.
     */
    private void determineOutcome() {
        int tierP1 = calculateTier(p1Cards);
        int tierP2 = calculateTier(p2Cards);

        if (tierP1 > tierP2) {
            outcome = 1;
        } else if (tierP2 > tierP1) {
            outcome = 2;
        } else if (tierP1 == tierP2 && tierP1 > 0) {
            outcome = 3;
        } else {
            outcome = 0;
        }
    }

    /**
     * Evaluates rank and suit configurations to determine hand strength.
     */
    private int calculateTier(Card[] currentHand) {
        boolean aceFound = false;
        boolean faceCardFound = false;
        int totalThrees = 0;

        // Process cards using an enhanced for-each loop structure
        for (Card currentCard : currentHand) {
            int currentRank = currentCard.getRank(); // Interacts with Card.java[cite: 2]

            if (currentRank == 14) aceFound = true;
            if (currentRank == 3) totalThrees++;
            if (currentRank >= 11 && currentRank <= 13) faceCardFound = true;
        }

        // Logical evaluation flags for pairs/suits
        boolean matchingRanks = (currentHand[0].getRank() == currentHand[1].getRank()) ||
                (currentHand[1].getRank() == currentHand[2].getRank()) ||
                (currentHand[0].getRank() == currentHand[2].getRank());

        boolean matchingSuits = currentHand[0].getSuit().equals(currentHand[1].getSuit()) ||
                currentHand[1].getSuit().equals(currentHand[2].getSuit()) ||
                currentHand[0].getSuit().equals(currentHand[2].getSuit());

        // Tier Assignment
        if (totalThrees == 3 || aceFound) {
            return 3;
        }
        if (matchingRanks || matchingSuits) {
            return 2;
        }
        if (faceCardFound) {
            return 1;
        }

        return 0;
    }
}
