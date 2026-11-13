// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Text Area Demo

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

// Main class inheriting JFrame
public class TextAreaDemo extends JFrame {
	// DescriptionPanel member, to be contained in the frame
	private DescriptionPanel panel = new DescriptionPanel();
	
	// Constructor. Sets title, Image, and description, then creates a JFrame layout and centers the panel in that layout
	public TextAreaDemo () {
		panel.setTitle("Canada");
		String desc = "The Canadian national flag...";
		ImageIcon userIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/flag.png")));
		//ImageIcon userIcon = new ImageIcon("flag.png");
		panel.setImageIcon(userIcon);
		panel.setDescription(desc);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
	}
	
	// Main function, creates the TextAreaDemo frame, sets size, centering, exit behavior, title, and visibility
	public static void main(String[] args) {
		TextAreaDemo frame = new TextAreaDemo();
		frame.setSize(500, 225);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Text Area Demo");
		frame.setVisible(true);
	}
}