// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Snowman
// File: Snowman.java

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Snowman
{
	// main method
	public static void main(String[] args)
	{
		// initialize word list
		String[] words = new String[] 
		{
			"banana",
			"apple",
			"grape",
			"orange",
			"lemon",
			"strawberry",
			"blueberry",
			"pineapple",
			"watermelon",
			"honeydew"
		};
		
		// intializing variables needed globally
		int gamesPlayed = 0;
		int gamesWon = 0;
		int response;
		
		// creating an object to format a decimal number
		DecimalFormat percentage = new DecimalFormat("0.00%");
		
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
		
		// obtaining the user's name
		String name = JOptionPane.showInputDialog("Please enter your name: ");
		
		// starting the "play game again" loop
		do
		{	
			// randomizing an index to select a word from the list
			int wordIndex = (int) (Math.random() * 10);
			String hiddenWord = words[wordIndex];
			
			// building mutable strings with string builder. One for the letters guessed so far, and one to store incorrect guesses
			StringBuilder guessedWord = new StringBuilder(hiddenWord.length());
			for (int i = 0; i < hiddenWord.length(); i++)
			{
				guessedWord.append('*');
			}
			StringBuilder incorrectGuesses = new StringBuilder(hiddenWord.length());
			
			// initializing variables to be manipulated in the next while loop. The numCorrect and numIncorrect are floats as they will be used later to calculate a percentage.
			float numCorrect = 0;
			float numIncorrect = 0;
			boolean alreadyGuessed = false;
			
			// starting the word guessing loop, to be exited if the word is guessed or the number of incorrect guesses reaches the length of the word.
			while (numCorrect < hiddenWord.length() && numIncorrect < hiddenWord.length())
			{
				// storing the user's input. 
				String input = JOptionPane.showInputDialog(null, "Word: " + guessedWord.toString() + ". Please guess a letter: ", "Incorrect Guesses: " + incorrectGuesses.toString(), JOptionPane.QUESTION_MESSAGE);
				
				// if the user input multiple characters or zero characters, display an error and restart the loop.
				if (input.length() != 1)
				{
					JOptionPane.showMessageDialog(null, "Please just guess one letter.", "Guess a letter!", JOptionPane.INFORMATION_MESSAGE);
					continue;
				}
				
				// if the letter has been guessed before, alerts the user and restarts the loop.
				if (guessedWord.toString().contains(input) || incorrectGuesses.toString().contains(input))
				{
					JOptionPane.showMessageDialog(null, "You already guessed that letter!", "Already guessed", JOptionPane.INFORMATION_MESSAGE);
					continue;
				}
				
				// if the letter is not in the word, adds it to the incorrect guesses, increments the number incorrect, and tells the user
				if (!hiddenWord.contains(input))
				{
					incorrectGuesses.append(input);
					numIncorrect++;
					JOptionPane.showMessageDialog(null, "Sorry, " + input + " is not in the word...", "No luck...", JOptionPane.INFORMATION_MESSAGE);
				}
				
				// if the letter is in the word, finds the position of each occurance and puts that into the guessed word.
				else
				{
					// converting the input and the word to char and char array in order to iterate through the word.
					char letter = input.charAt(0);
					char[] strArray = hiddenWord.toCharArray();
					for (int i = 0; i < strArray.length; i++)
					{
						if (letter == strArray[i])
						{
							guessedWord.setCharAt(i, letter);
							numCorrect++;
						}
					}
				}
			} 
			
			// after the gameplay loop exits, if the number correct is the same as the length of the word, displays a winning message and increments the games won counter
			if (numCorrect == hiddenWord.length())
			{
				JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word! The word was " + hiddenWord + ".", "You won!", JOptionPane.INFORMATION_MESSAGE);
				gamesWon++;
			}
			
			// if the user didn't solve the word, displays a losing message
			else
			{
				JOptionPane.showMessageDialog(null, "Oh no! You've run out of guesses! The word was " + hiddenWord + ".", "You lose...", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// creating variables for total guesses and the percent correct, making the calculations, and displaying the results.
			float totalGuesses = numCorrect + numIncorrect;
			float percentCorrect = numCorrect/totalGuesses;
			JOptionPane.showMessageDialog(null, 
				"Total guesses: " + (int) totalGuesses + 
				"\nCorrect Guesses: " + (int) numCorrect +
				"\nPercent of Correct Guesses: " + percentage.format(percentCorrect),
				"Snowman Results",
				JOptionPane.INFORMATION_MESSAGE);
			
			// asks the user if they want to continue. if yes, the loop restarts, otherwise a goodbye message is displayed and the program ends
			response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			gamesPlayed++;
		} while (response == JOptionPane.YES_OPTION);
		JOptionPane.showMessageDialog(null, "Thank you for playing, " + name + ". You played " + gamesPlayed + " games. You won " + gamesWon + " of them. Goodbye!", "Goodbye!", JOptionPane.INFORMATION_MESSAGE);
	}
}