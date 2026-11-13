import javax.swing.*;
import java.awt.*;

public class Swings {
	public static void main(String[] args) {
		// Create jframe
		JFrame frame = new JFrame("Title");
		
		// Set default close operation to exit when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set layout manager
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// Set the size in pixels
		frame.setSize(600, 400);
		
		// Cetner the frame
		frame.setLocationRelativeTo(null);
		
		// Create a label with text
		JLabel label1 = new JLabel("I am the first label", JLabel.CENTER);
		
		// Set size for the label
		label1.setPreferredSize(new Dimension(150, 52));
		label1.setOpaque(true);
		label1.setBackground(Color.YELLOW);
		// Add label to the frame
		frame.add(label1);
		
		JLabel label2 = new JLabel("I am the second label");
		label2.setOpaque(true);
		label2.setBackground(Color.CYAN);
		label2.setFont(new Font("TimesRoman", Font.BOLD, 24));
		
		frame.add(label2);
		
		JLabel label3 = new JLabel("<html>Styled <b><i>Label</i></b></html>");
		label3.setBackground(Color.RED);
		label3.setForeground(Color.BLUE);
		
		frame.add(label3);
		
		// Make the frame visible after adding all components
		frame.setVisible(true);
	}
}


