// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Simple Window Demo

import javax.swing.*;
import java.awt.Color;

public class WalkerSimpleWindow {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello, Java Again!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JLabel label = new JLabel("Hello, Java Again!", JLabel.CENTER);
		frame.add(label);
		frame.getContentPane().setBackground(Color.PINK);
		frame.setVisible(true);
	}
}