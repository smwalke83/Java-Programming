// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Project 3
// File: MainP3.java

import javax.swing.*;

// Main program class
public class MainP3 {
	
	// Main function - create a snowman, create a snowframe with that snowman instance, set up the window
	public static void main(String[] args) {
		Snowman man = new Snowman();
		SnowFrame frame = new SnowFrame(man);
		
		frame.setTitle("Name: Scott Walker - Program Title: P3 - Snowman - Objective: A game of Snowman with graphics.");
		frame.setSize(600, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}