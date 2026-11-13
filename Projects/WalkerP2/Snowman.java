/*
* Name: Scott Walker
* Email: swalker62@student.cnm.edu
* Program Name: Snowman with Classes
* File Name: Snowman.Java
*/

import java.text.DecimalFormat;

public class Snowman {
	
	// initiallize the words to pick from
	private String[] words = new String[] 
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
		
	// class members
	private String hiddenWord;
	private StringBuilder guessedWord;
	private StringBuilder incorrectGuesses;
	private String userName;
	private String gameOver;
	private String goodBye;
	private DecimalFormat percentage;
	
	// these are floats so they can be used for percentage calculations later
	private float numCorrect;
	private float numIncorrect;
	private float totalGuesses;
	
	// static variables to track globally (between games with distinct snowman objects)
	private static int gamesPlayed = 0;
	private static int gamesWon = 0;
	
	// constructor - initiallizes values that need initialization
	public Snowman() {
		percentage  = new DecimalFormat("0.00%");
		numCorrect = 0;
		numIncorrect = 0;
		totalGuesses = 0;
	}
	
	// variable getters/setters
	// read only
	public String[] getWords() {
		return words;
	}
	
	public String getGameOverString() {
		return gameOver;
	}
	
	public String getGoodByeString() {
		goodBye = "Thank you for playing, " + userName + "! You played " + gamesPlayed + " game(s) and won " + gamesWon + ". Goodbye.";
		return goodBye;
	}
	
	public String getGuessedWord() {
		return guessedWord.toString();
	}
	
	public String getMissedString() {
		return incorrectGuesses.toString();
	}
	
	public String getHiddenWord() {
		return hiddenWord;
	}
	
	// read/write
	public String getName() {
		return userName;
	}
	
	public void setName(String newName) {
		userName = newName;
	}
	
	// method to select a word to be guessed
	public void selectWord() {
		int wordIndex = (int) (Math.random() * 10);
		String word = words[wordIndex];
		hiddenWord = word;
		guessedWord = new StringBuilder(hiddenWord.length());
		for (int i = 0; i < hiddenWord.length(); i++) {
			guessedWord.append('*');
		}
		incorrectGuesses = new StringBuilder(hiddenWord.length());
	}
	
	// method to check the user's guess
	public int checkGuess(String guess) {
		
		// returns 5 if the guess isn't one letter long
		if (guess.length() != 1) {
			return 5;
		}
		if (!(guessedWord.toString().contains(guess) || incorrectGuesses.toString().contains(guess))) {
			// if letter hasn't been guessed before
			if (!hiddenWord.contains(guess)) {
				// if letter isn't in hidden word - returns 4 (game over, incorrect) if the game ends, 2 (incorrect guess) if the game continues
				incorrectGuesses.append(guess);
				numIncorrect++;
				totalGuesses++;
				if (numIncorrect == hiddenWord.length()) {
					gameOver = "Oh no! You've run out of guesses! The word was "
					+ hiddenWord + ". You lose...\nTotal guesses: "
					+ (int) totalGuesses + "\nCorrect Guesses: "
					+ (int) numCorrect +	"\nPercent of Correct Guesses: "
					+ percentage.format(numCorrect/totalGuesses);
					gamesPlayed++;
					return 4;
				} else {
					return 2;
				}
			} else {
				// if letter is in hidden word - returns 4 (game over, correct) if the game ends, 3 (correct guess) if the game continues
				char letter = guess.charAt(0);
				char[] strArray = hiddenWord.toCharArray();
				for (int i = 0; i < strArray.length; i++)
				{
					if (letter == strArray[i])
					{
						guessedWord.setCharAt(i, letter);
						numCorrect++;
						totalGuesses++;
					}
				}
				if (numCorrect == hiddenWord.length()) {
					gameOver = "Congratulations! You guessed the word! The word was "
					+ hiddenWord + ".\nTotal guesses: "
					+ (int) totalGuesses + "\nCorrect Guesses: "
					+ (int) numCorrect +	"\nPercent of Correct Guesses: "
					+ percentage.format(numCorrect/totalGuesses);
					gamesWon++;
					gamesPlayed++;
					return 4;
				} else {
					return 3;
				}
			}
			
		// if the letter has been guessed before, returns 1 (already guessed letter)
		} else {
			return 1;
		}
	}



}