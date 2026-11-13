/* 
Programmer: Scott Walker 
Email: swalker62@student.cnm.edu
Program: JOptionPane Demo
File: WalkerJOPDemo.java 
*/

import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class WalkerJOPDemo 
{

	// Program begins with a call to main()
	public static void main(String[] args) 
	{
	
		// Commented out per instructions
		// System.out.println("Welcome to the JOptionPane Demo.");
		
		// Simple Message Dialog
		JOptionPane.showMessageDialog(null, "Scott Walker");
		
		// Add custom message dialog. I hope it's okay that I changed the string from the assignment.
		JOptionPane.showMessageDialog(null, "Hello, World! This is the Demo of JOptionPane.", "Scott Walker", JOptionPane.INFORMATION_MESSAGE);
		
		// Add input dialog
		String input = JOptionPane.showInputDialog("Enter your name:");
		String sAge = JOptionPane.showInputDialog("Hello " + input + ", enter your age:");
		
		// Convert age to int
		int age = Integer.parseInt(sAge);
		
		// Show user name and age:
		JOptionPane.showMessageDialog(null, "Hello " + input + ", your age is " + age);
		
		// In the assignment, this is where you ask the user if they want to continue. I've moved that to the end. Please let me know if I'm straying from instructions too much.
		// Create a ComboBox for RPS
		String[] options = {"Rock", "Paper", "Scissors"};
		JComboBox<String> jcb = new JComboBox<>(options);
		input = (String)JOptionPane.showInputDialog(null, "Select Rock, Paper, or Scissors:", "Choices", JOptionPane.QUESTION_MESSAGE, null, options, "RPS");
		
		// Display user choice
		JOptionPane.showMessageDialog(null, "You chose " + input);
		
		// Option dialog - Note that the instructions suggested using the "options" array defined above instead of the "moreOptions" array defined here
		Object[] moreOptions = {"Rock", "Paper", "Scissors", "Lizard"};
		
		// The below two lines use "moreOptions" instead of reusing "options" as instructed in the Word document.
		int choice = JOptionPane.showOptionDialog(null, "Pick one.", "RPS", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, moreOptions, moreOptions[0]);
		JOptionPane.showMessageDialog(null, "You chose " + moreOptions[choice]);
		
		// Below I included the code suggested in the instructions for completeness, but I commented it out.
		// int choice = JOptionPane.showOptionDialog(null, "Pick one.", "RPS", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		// JOptionPane.showMessageDialog(null, "You chose " + options[choice]);
		
		// Confirmation dialog - Moved to the bottom after Rock Paper Scissors
		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) 
		{
			JOptionPane.showMessageDialog(null, "Ok, goodbye.");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "I guess you have not finished this demo...");
		}
	}
}