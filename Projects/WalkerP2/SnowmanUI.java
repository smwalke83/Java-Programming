/*
* Name: Scott Walker
* Email: swalker62@student.cnm.edu
* Program Name: Snowman with Classes
* File Name: SnowmanUI.Java
*/

import javax.swing.JOptionPane;

public class SnowmanUI {
	// class member, represents a game of snowman
	private Snowman snowman;
	
	// constructor with object reference passed in
	public SnowmanUI(Snowman snowman) {
		this.snowman = snowman;
	}
	
	// the main game play method
	public void play() {
		
		// initializing variables
		int response = JOptionPane.YES_OPTION;
		int guessResult = 0;
		// dispalying course header
		JOptionPane.showMessageDialog(null, "Name: Scott Walker\nProgram: Snowman\nObjective: This is a 'Snowman' word guessing game.", "Snowman", JOptionPane.INFORMATION_MESSAGE);
		
		// displaying welcome message with rules
		JOptionPane.showMessageDialog(null, 
			"You will be guessing a word from a list of fruits! You guess one letter at a time." +
			"\nIf it is in the word, that will be revealed to you. If not, you will be charged with an incorrect guess." +
			"\nA number of incorrect guesses equal to the length of the word results in a loss." +
			"\nAll letters are lowercase, so make sure not to guess uppercase or any special characters. Good luck!",
			"Welcome to Snowman!",
			JOptionPane.INFORMATION_MESSAGE);
		
		// getting the user's name
		String name = JOptionPane.showInputDialog("Please enter your name: ");
			
		do {
			
			// if the game just started, picks a word and sets the user's name
			if (guessResult == 0) {
				snowman.selectWord();
				snowman.setName(name);
			}
			
			// getting the user's first guess and checking the result 
			String input = JOptionPane.showInputDialog(null, "Word: " + snowman.getGuessedWord() + ". Please guess a letter: ", "Incorrect Guesses: " + snowman.getMissedString(), JOptionPane.QUESTION_MESSAGE);
			guessResult = snowman.checkGuess(input);
			switch (guessResult) {
				case 1:
					// letter has been guessed - alert user
					JOptionPane.showMessageDialog(null, "You already guessed that letter!", "Already guessed", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					// incorrect guess - alert user
					JOptionPane.showMessageDialog(null, "Sorry, " + input + " is not in the word...", "No luck...", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3:
					// correct guess - no message to user, variables will update on their own
					break;
				case 4:
					// game over - alert user
					JOptionPane.showMessageDialog(null, snowman.getGameOverString(), "Game over!", JOptionPane.INFORMATION_MESSAGE);
					
					// ask user if they want to play again, if so, reset variables for a new game state. if not, say goodbye and the loop will terminate
					response = JOptionPane.showConfirmDialog(null, "Do you want to keep playing?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
						guessResult = 0;
						snowman = new Snowman();
					} else {
						this.sayGoodbye();
					}
					break;
				case 5:
					// user input too many characters
					JOptionPane.showMessageDialog(null, "Please just guess one letter.", "Guess a letter!", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		} while (response == JOptionPane.YES_OPTION);
	}
	
	// get goodbye message and display it to the user
	private void sayGoodbye() {
		String string = snowman.getGoodByeString();
		JOptionPane.showMessageDialog(null, string, "Goodbye!", JOptionPane.INFORMATION_MESSAGE);
	}
}