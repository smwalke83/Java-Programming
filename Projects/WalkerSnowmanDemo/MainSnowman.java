// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Paint Component Demo

import javax.swing.JFrame;

public class MainSnowman {
	// SnowFrame on which to draw
	private SnowFrame snow;
	
	// Main function calls constructor
	public static void main(String[] args) {
		MainSnowman app = new MainSnowman();
	}
	
	// Constructor initializes SnowFrame, sets values for the main window
	public MainSnowman() {
		snow = new SnowFrame();
		snow.setTitle("Snowman");
		snow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snow.setLocationRelativeTo(null);
		snow.setSize(300, 260);
		snow.setVisible(true);
	}
}