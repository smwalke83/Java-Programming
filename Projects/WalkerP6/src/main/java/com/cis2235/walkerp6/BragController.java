/**
 * Program Name: Martinez_Rasheed_Ridlon_Walker_Wells_P6
 * File Name: BragController.java
 */

package com.cis2235.walkerp6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class BragController {

    // Empty card arrays for each player hand
    private Card[] hand1 = new Card[3];
    private Card[] hand2 = new Card[3];

    // Card Deck and Three Card Brag objects
    private CardDeck deck;
    private ThreeCardBrag brag;

    // Strings to store player names; set to default values
    private String player1Name = "Player 1";
    private String player2Name = "Player 2";

    // Tracking the number of card deals
    private int dealCount = 0;

    // Tracking player scores
    private int player1Score = 0;
    private int player2Score = 0;

    // UI Buttons
    @FXML private Button dealButton;
    @FXML private Button winnerButton;

    // UI Text boxes and labels
    @FXML private TextArea rulesDisplay;
    @FXML private Label winnerDisplay;
    @FXML private Label statusText;

    // UI Player name input fields
    @FXML private TextField player1NameInput;
    @FXML private TextField player2NameInput;

    // UI Player 1's card images
    @FXML private ImageView player1Card1;
    @FXML private ImageView player1Card2;
    @FXML private ImageView player1Card3;

    // UI Player 2's card images
    @FXML private ImageView player2Card1;
    @FXML private ImageView player2Card2;
    @FXML private ImageView player2Card3;

    // Initializing JavaFX window
    @FXML
    public void initialize() {

        // Creating an image corresponding to the back of a blue card, then setting it for starting card images
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/b1fv.png")));
        player1Card1.setImage(image);
        player1Card2.setImage(image);
        player1Card3.setImage(image);

        // Creating an image corresponding to the back of a red card, then setting it for starting card images
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/b2fv.png")));
        player2Card1.setImage(image);
        player2Card2.setImage(image);
        player2Card3.setImage(image);

        // Initializing deck and brag objects
        deck = new CardDeck();
        brag = new ThreeCardBrag();

        // Setting the rules
        rulesDisplay.setText(brag.getRules());

        // Disabling the "determine winner" button; this is enabled after cards are dealt
        winnerButton.setDisable(true);
    }

    // Called when the deal button is clicked
    @FXML
    void handleDealButtonAction(ActionEvent event) {
        dealTheCards();
    }

    // Called when the determine winner button is clicked
    @FXML
    void handleWinnerButtonAction(ActionEvent event) {
        determineWinner();
    }

    // Called when the play again button is clicked
    @FXML
    void handlePlayAgainButtonAction(ActionEvent event) { playAgain(); }

    // Method called in "handleDealButtonAction" per instructions
    private void dealTheCards() {

        // Setting cards into the empty hands, starting with hand 1
        for (int i = 0; i < hand1.length; i++) {
            // Deals a card to the hand
            hand1[i] = deck.getNextCard();
            // Sets the path of the card image
            String path = "/images/" + hand1[i].getImageName();
            // Creates the card image
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
            // Sets the image to the correct position depending on position in the hand array
            if (i == 0) {
                player1Card1.setImage(image);
            }
            else if (i == 1) {
                player1Card2.setImage(image);
            }
            else {
                player1Card3.setImage(image);
            }
        }
        // Setting cards into the empty hand 2
        for (int i = 0; i < hand2.length; i++) {
            // Deals a card to the hand
            hand2[i] = deck.getNextCard();
            // Sets the path of the card image
            String path = "/images/" + hand2[i].getImageName();
            // Creates the card image
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
            // Sets the image to the correct position depending on position in the hand array
            if (i == 0) {
                player2Card1.setImage(image);
            }
            else if (i == 1) {
                player2Card2.setImage(image);
            }
            else {
                player2Card3.setImage(image);
            }
        }

        // Increments the deal count, enables the "determine winner" button, resets the winner display text
        dealCount++;
        winnerButton.setDisable(false);
        winnerDisplay.setText("");

        // If it is the eighth deal, the deal button is disabled
        if (dealCount == 8) {
            dealButton.setDisable(true);
        }

        // If it is the first deal, player names are set
        if (dealCount == 1) {
            // If the player name fields aren't empty, the values are assigned to the player names (otherwise defaults or previous names are used)
            if (!player1NameInput.getText().isEmpty()) {
                player1Name = player1NameInput.getText();
                player1NameInput.setText("");
            }
            if (!player2NameInput.getText().isEmpty()) {
                player2Name = player2NameInput.getText();
                player2NameInput.setText("");
            }
            // Displays player scores
            statusText.setText(player1Name + ": " + player1Score + " --- " + player2Name + ": " + player2Score);

            // Disables the player Name text boxes until the game is restarted
            player1NameInput.setDisable(true);
            player2NameInput.setDisable(true);
        }
    }

    // Method called in "handleWinnerButtonAction" per instructions
    private void determineWinner() {

        // Sets the player hands into the brag object (which also calculates outcome of the hand)
        brag.setPlayerHands(hand1, hand2);
        // Initializes result string and assigns a number to the winner variable
        String result = "";
        int winner = brag.getWinningHand();
        // Updates the result depending on the value returned by getWinningHand()
        switch (winner) {
            // 0 means nobody won
            case 0:
                result = "Nobody won...";
                break;
            // 1 means player 1 won
            case 1:
                result = player1Name + " is the winner!";
                player1Score++;
                break;
            // 2 means player 2 won
            case 2:
                result = player2Name + " is the winner!";
                player2Score++;
                break;
            // 3 means it was a draw
            case 3:
                result = "It's a draw!";
                break;
        }
        // Displays the result of the hand, updates the score, and disables the "determine winner" button until the next deal
        winnerDisplay.setText(result);
        statusText.setText(player1Name + ": " + player1Score + " --- " + player2Name + ": " + player2Score);
        winnerButton.setDisable(true);
    }

    // Method called in "handlePlayAgainButtonAction", I did it this way for formatting consistency
    private void playAgain() {
        // Creates a fresh deck
        deck = new CardDeck();

        // Resets deal count and score values
        dealCount = 0;
        player1Score = 0;
        player2Score = 0;

        // Enables the deal button if it was disabled
        dealButton.setDisable(false);

        // Resets card images to default
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/b1fv.png")));
        player1Card1.setImage(image);
        player1Card2.setImage(image);
        player1Card3.setImage(image);
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/b2fv.png")));
        player2Card1.setImage(image);
        player2Card2.setImage(image);
        player2Card3.setImage(image);

        // Resets starting text to default
        statusText.setText("Enter names and press Deal to begin!");
        winnerDisplay.setText("");

        // Disables the determine winner button if it was enabled
        winnerButton.setDisable(true);

        // Enables the player name text fields
        player1NameInput.setDisable(false);
        player2NameInput.setDisable(false);
    }
}

