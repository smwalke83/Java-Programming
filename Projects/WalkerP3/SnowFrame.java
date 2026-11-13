// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Project 3
// File: SnowFrame.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// SnowFrame class inherits from JFrame
public class SnowFrame extends JFrame {
	
	// Class variables - a snowman object to contain game data, a SnowmanPanel to draw on, UI labels, text fields, and buttons
	private Snowman snow;
	private SnowmanPanel canvas;
	private JLabel instructionsLabel;
	private JLabel nameLabel;
	private JLabel guessingMessage;
	private JLabel incorrectMessage;
	private JLabel userGuessLabel;
	private JTextArea instructions;
	private JTextField nameField;
	private JTextField userGuessField;
	private JButton nameButton;
	private JButton guessButton;
	private JButton playAgainButton;
	private JButton seeSummaryButton;
	
	// Constructor, snowman object passed in by Main. Sets the window layout, the snowman, and calls initcomponents for the rest of setup
	public SnowFrame (Snowman snow) {
		setLayout(new GridLayout(3, 1));
		this.snow = snow;
		initComponents();
	}
	
	// Called in constructor, creates panels and initializes labels, text fields, and buttons
	private void initComponents() {
		
		// Creating the canvas panel to draw on
		canvas = new SnowmanPanel();
		canvas.setBackground(Color.CYAN);
		
		/* Creating a panel to store user name data with a button
		When the button is pressed, it is hidden along with the input field and a "Hello, user" message is displayed
		Adding the field, label and button to the panel
		*/
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		nameField = new JTextField(10);
		nameLabel = new JLabel();
		nameLabel.setText("Please enter your name: ");
		nameButton = new JButton("Submit");
		nameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				snow.setName(nameField.getText());
				nameLabel.setText("Hello, " + snow.getName() + "!");
				nameField.setVisible(false);
				nameButton.setVisible(false);
			}
		});
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.add(nameButton);
		
		/* Creating a panel to contain the word guessing portion
		A word is selected to be guessed, labels are created to display how much has been guessed/missed
		Labels are added to the panel
		*/
		JPanel wordPanel = new JPanel();
		wordPanel.setLayout(new FlowLayout());
		snow.selectWord();
		guessingMessage = new JLabel();
		incorrectMessage = new JLabel();
		guessingMessage.setText("Word: " + snow.getGuessedWord());
		incorrectMessage.setText("Incorrect Guesses: " + snow.getMissedString());
		wordPanel.add(guessingMessage);
		wordPanel.add(incorrectMessage);
		
		/* Creating a panel to contain a field/label for the user guess and a button to submit the guess
		Two more buttons are created (play again, see summary) but they are not visible until a game ends
		Play again button creates a new snowman, selects a new word, and resets the labels and buttons to starting state, then repaints the picture
		See summary button shows a summary of games won/lost and says goodbye. To exit the program the user can just click the "x" in the corner
		All the controls are added to the panel.
		*/
		JPanel guessPanel = new JPanel();
		guessPanel.setLayout(new FlowLayout());
		userGuessField = new JTextField(5);
		userGuessLabel = new JLabel();
		userGuessLabel.setText("Guess a Letter:");
		guessButton = new JButton("Submit");
		guessButton.addActionListener(new ButtonListener());
		playAgainButton = new JButton("Play Again");
		playAgainButton.setVisible(false);
		playAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				snow = new Snowman();
				snow.selectWord();
				guessingMessage.setText("Word: " + snow.getGuessedWord());
				incorrectMessage.setText("Incorrect Guesses: " + snow.getMissedString());
				playAgainButton.setVisible(false);
				seeSummaryButton.setVisible(false);
				userGuessLabel.setVisible(true);
				userGuessField.setVisible(true);
				guessButton.setVisible(true);
				canvas.repaint();
			}
		});
		seeSummaryButton = new JButton("See Summary");
		seeSummaryButton.setVisible(false);
		seeSummaryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String goodbye = snow.getGoodByeString();
				instructions.setText(goodbye + "\nClick 'X' to exit or click Play Again to continue playing.");
			}
		});
		guessPanel.add(userGuessLabel);
		guessPanel.add(userGuessField);
		guessPanel.add(guessButton);
		guessPanel.add(playAgainButton);
		guessPanel.add(seeSummaryButton);
		
		// Creating a panel to contain a label and text area for instructions (also displays messages to the user during gameplay)
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(2, 1));
		instructionsLabel = new JLabel();
		instructionsLabel.setText("Snowman Instructions & Game Messages:");
		instructions = new JTextArea();
		instructions.setText("You will be guessing a word from a list of fruits! You guess one letter at a time." +
			"If it is in the word, that will be revealed to you. If not, you will be charged with an incorrect guess and part of the snowman will appear." +
			"A number of incorrect guesses equal to the length of the word results in a loss - and a complete snowman." +
			"Try to guess the word before the snowman appears!" + 
			"All letters are lowercase, so make sure not to guess uppercase or any special characters. Good luck!");
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		instructions.setEditable(false);
		instructionsPanel.add(instructionsLabel);
		instructionsPanel.add(instructions);
		
		// One final panel to contain several other panels in a verticle grid layout. This makes the spacing feel better.
		JPanel userPanel = new JPanel(new GridLayout(3, 1));
		userPanel.add(namePanel);
		userPanel.add(wordPanel);
		userPanel.add(guessPanel);
		
		// Adding the three top level panels to the frame, they will be displayed in a verticle grid layout as well
		add(instructionsPanel);
		add(canvas);
		add(userPanel);
	}
	
	// ButtonListener class to override actionPerformed. In two of the above buttons this was done in the constructor, but the submit button required a bit more code, so this seemed cleaner
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			// Checking the guess and assigning the result to a variable
			int guessResult = snow.checkGuess(userGuessField.getText());
			
			switch (guessResult) {
				case 1:
					// letter has been guessed - alert user
					instructions.setText("You already guessed that letter!");
					break;
				case 2:
					// incorrect guess - alert user
					instructions.setText("Sorry, " + userGuessField.getText() + " is not in the word...");
					break;
				case 3:
					// correct guess - alert user
					instructions.setText("Nice guess! " + userGuessField.getText() + " is in the word!");
					break;
				case 4:
					// game over - alert user, make end game buttons visible to ask user if they want to play again or see their results
					instructions.setText(snow.getGameOverString() + ".\nPlay again or view summary.");
					userGuessLabel.setVisible(false);
					userGuessField.setVisible(false);
					guessButton.setVisible(false);
					playAgainButton.setVisible(true);
					seeSummaryButton.setVisible(true);
					break;
				case 5:
					// user input too many characters - alert user
					instructions.setText("Please just guess one letter.");
					break;
			}
			
			// resetting value of user guess field so they don't have to delete it, refreshing labels to reflect state of guessed word, repainting canvas
			userGuessField.setText("");
			guessingMessage.setText("Word: " + snow.getGuessedWord());
			incorrectMessage.setText("Incorrect Guesses: " + snow.getMissedString());
			canvas.repaint();
		}
	}
	
	// Snow Panel inherits from JPanel
	private class SnowmanPanel extends JPanel {
		
		// Overriding paintComponent to paint the snowman
		@Override
		protected void paintComponent(Graphics page) {
			
			// painting the background, setting values to work from when drawing the snowman
			super.paintComponent(page);
			final int MID = (getWidth()) / 2;  // always draws the snowman in the middle of the canvas
			final int TOP = 50;
			// drawing the ground
			page.setColor(Color.blue);
			page.fillRect(0, 175, getWidth(), 50);
			// drawing the sun
			page.setColor(Color.yellow);
			page.fillOval(50, -20, 80, 80);
			
			// Switch statement: max guesses are still the number of letters in the word, so it's drawn slightly differently based on word length
			switch (snow.getHiddenWord().length()) {
				// 5 letter word
				case 5:
					// draw bottom, then torso, then head, arms, face+tophat, depending on number of missed guesses (1-5)
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arms
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// face/tophat
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
						page.fillRect(MID - 15, TOP - 20, 30, 25);
						page.fillOval(MID - 10, TOP + 10, 5, 5);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					break;
				// six letter word
				case 6:
					// same as 5 letter word but with snowman broken into six components
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arms
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// face
						page.setColor(Color.black);
						page.fillOval(MID - 10, TOP + 10, 5, 5);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					if (snow.getMissedString().length() >= 6) {
						// tophat
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
						page.fillRect(MID - 15, TOP - 20, 30, 25);	
					}
					break;
				// seven letter word
				case 7:
					// snowman broken into seven components
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arm1
						page.setColor(Color.black);
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// arm2
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
					}
					if (snow.getMissedString().length() >= 6) {
						// face
						page.setColor(Color.black);
						page.fillOval(MID - 10, TOP + 10, 5, 5);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					if (snow.getMissedString().length() >= 7) {
						// tophat
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
						page.fillRect(MID - 15, TOP - 20, 30, 25);	
					}
					break;
				// eight letter word
				case 8:
					// snowman broken into 8 components
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arm1
						page.setColor(Color.black);
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// arm2
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
					}
					if (snow.getMissedString().length() >= 6) {
						// eyes
						page.setColor(Color.black);
						page.fillOval(MID - 10, TOP + 10, 5, 5);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
					}
					if (snow.getMissedString().length() >= 7) {
						// mouth
						page.setColor(Color.black);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					if (snow.getMissedString().length() >= 8) {
						// tophat
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
						page.fillRect(MID - 15, TOP - 20, 30, 25);
					}
					break;
				// nine letter word
				case 9:
					// snowman broken into 9 components
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arm1
						page.setColor(Color.black);	
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// arm2
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
					}
					if (snow.getMissedString().length() >= 6) {
						// eye1
						page.setColor(Color.black);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
					}
					if (snow.getMissedString().length() >= 7) {
						// eye2
						page.setColor(Color.black);
						page.fillOval(MID - 10, TOP + 10, 5, 5);
					}
					if (snow.getMissedString().length() >= 8) {
						// mouth
						page.setColor(Color.black);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					if (snow.getMissedString().length() >= 9) {
						// tophat
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
						page.fillRect(MID - 15, TOP - 20, 30, 25);
					}
					break;
				// ten letter word
				case 10:
					// snowman broken into ten components
					if (snow.getMissedString().length() >= 1) {
						// bottom
						page.setColor(Color.white);
						page.fillOval(MID - 50, TOP + 80, 100, 60);
					}
					if (snow.getMissedString().length() >= 2) {
						// torso
						page.setColor(Color.white);
						page.fillOval(MID - 35, TOP + 35, 70, 50);
					}
					if (snow.getMissedString().length() >= 3) {
						// head
						page.setColor(Color.white);
						page.fillOval(MID-20, TOP, 40, 40);
					}
					if (snow.getMissedString().length() >= 4) {
						// arm1
						page.setColor(Color.black);
						page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
					}
					if (snow.getMissedString().length() >= 5) {
						// arm2
						page.setColor(Color.black);
						page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
					}
					if (snow.getMissedString().length() >= 6) {
						// eye1
						page.setColor(Color.black);
						page.fillOval(MID + 5, TOP + 10, 5, 5);
					}
					if (snow.getMissedString().length() >= 7) {
						// eye2
						page.setColor(Color.black);	
						page.fillOval(MID - 10, TOP + 10, 5, 5);
					}
					if (snow.getMissedString().length() >= 8) {
						// mouth
						page.setColor(Color.black);
						page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
					}
					if (snow.getMissedString().length() >= 9) {
						// tophat1
						page.setColor(Color.black);
						page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
					}
					if (snow.getMissedString().length() >= 10) {
						// tophat2
						page.setColor(Color.black);
						page.fillRect(MID - 15, TOP - 20, 30, 25);
					}
					break;
			}
		}
	}
}