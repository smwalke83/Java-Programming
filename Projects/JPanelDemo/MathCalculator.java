// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: JPanel Demo

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// creating child class of JFrame
public class MathCalculator extends JFrame {
	// class fields for width/height of frame, text fields for the calcualtions
	private static final int WIDTH = 380;
	private static final int HEIGHT = 110;
	private JTextField xBox;
	private JTextField xSqrtBox;
	private JTextField xLogBox;
	
	// constructor sets title, size, close behavior, calls a method to create window contents, centers the window and makes it visible
	public MathCalculator() {
		setTitle("Math Calculator");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	// method to create window contents
	private void createContents() {
		
		// creating panels to put the text boxes, buttons, and labels in
		JPanel xPanel;
		JPanel xSqrtPanel;
		JPanel xLogPanel;
		
		// creating label for user input field, buttons for calculating square root and log base 10, and a listener object (see below class)
		JLabel xLabel;
		JButton xSqrtButton;
		JButton xLogButton;
		Listener listener;
		
		// creating a 2 x 2 grid layout
		setLayout(new GridLayout(2, 2));
		
		// instantiating the label and text field for the user input and the panel for those values, then adding label and textbox to the panel
		xLabel = new JLabel("x:");
		xBox = new JTextField(8);
		xPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		xPanel.add(xLabel);
		xPanel.add(xBox);
		
		// instantiating button and result text field for square root, then creating and adding them to their panel
		xSqrtButton = new JButton("sqrt x");
		xSqrtBox = new JTextField(8);
		xSqrtBox.setEditable(false);
		xSqrtPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		xSqrtPanel.add(xSqrtButton);
		xSqrtPanel.add(xSqrtBox);
		
		// same as above, but for log instead of square root
		xLogButton = new JButton("log10 x");
		xLogBox = new JTextField(8);
		xLogBox.setEditable(false);
		xLogPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		xLogPanel.add(xLogButton);
		xLogPanel.add(xLogBox);
		
		// adding each panel, with a dummy panel between square root and log to leave an empty space in the grid
		add(xPanel);
		add(xSqrtPanel);
		add(new JLabel());
		add(xLogPanel);
		
		// instantiating the listener, which will wait for a button to be pressed
		listener = new Listener();
		xSqrtButton.addActionListener(listener);
		xLogButton.addActionListener(listener);
	}
	
	// inner class for the listener, which uses action listener
	private class Listener implements ActionListener {
		
		// when an action is performed, this method is called
		public void actionPerformed(ActionEvent e) {
			
			// x will be the user input, result will be the result of the math operation on the input
			double x;
			double result;
			
			// if the text box cannot be parsed into a double, x is set to -1
			try {
				x = Double.parseDouble(xBox.getText());
			}
			catch (NumberFormatException nfe) {
				x = -1;
			}
			
			// if the button clicked was the square root button, perform the calculation (if x is negative, the result is undefined)
			if (e.getActionCommand().equals("sqrt x")) {
				if (x < 0) {
					xSqrtBox.setText("undefined");
				}
				else {
					result = Math.sqrt(x);
					xSqrtBox.setText(String.format("%7.5f", result));
				}
			}
			// same as above, but the button clicked must be the log button
			else {
				if (x < 0) {
					xLogBox.setText("undefined");
				}
				else {
					result = Math.log10(x);
					xLogBox.setText(String.format("%7.5f", result));
				}
			}
		}
	}
	
	// main function just instantiates the calculator object
	public static void main(String[] args) {
		new MathCalculator();
	}
}