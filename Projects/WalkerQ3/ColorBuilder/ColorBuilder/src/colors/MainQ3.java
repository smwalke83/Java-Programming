// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: MainQ3.java
// Since I did not write most of this code, I did not comment it. My only comments are prefixed with SW, and they show the debugging steps I took.
// I did, however, change the JFrame window title to show my name and quiz 3.
// This file has 2 corrections - Initializing the ColorBuilder and making the frame visible

package colors;

import javax.swing.JFrame;

public class MainQ3
{
	
	public static void main(String[] args)
	{
		// SW ColorBuilder was not initialized before being passed into the frame constructor
		ColorBuilder builder = new ColorBuilder();
		// SW You can now use the overloaded constructor when initializing ColorBuilder and the sliders will be preset to their appropriate values
		// ColorBuilder builder = new ColorBuilder(100, 150, 200);
		ColorBuilderFrame frame = new ColorBuilderFrame(builder);
		frame.setTitle("Scott Walker - Quiz 3");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		// SW The frame needed to be made visible
		frame.setVisible(true);

	}
}

		