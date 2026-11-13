// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Paint Component Demo

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

// SnowFrame class inherits from JFrame
public class SnowFrame extends JFrame {
	// Constants to help with drawing and a SnowPanel for the actual painting
	private final int MID = 150;
	private final int TOP = 50;
	private SnowPanel snowPanel;
	
	// Constructor creates a snowpanel, sets a background color, and sdds it to the frame
	public SnowFrame() {
		snowPanel = new SnowPanel();
		snowPanel.setBackground(Color.cyan);
		add(snowPanel);
	}
	
	// inner class to paint in, inherits from JPanel
	class SnowPanel extends JPanel {
		// overriding JPanel's paintComponent to paint a snowman 
		@Override
		public void paintComponent(Graphics page) {
			super.paintComponent(page);
			
			// drawing the ground
			page.setColor(Color.blue);
			page.fillRect(0, 175, 300, 50);
			
			// drawing the sun
			page.setColor(Color.yellow);
			page.fillOval(-20, -20, 80, 80);
			
			// drawing the head
			page.setColor(Color.white);
			page.fillOval(MID-20, TOP, 40, 40);
			
			// drawing the torso
			page.fillOval(MID - 35, TOP + 35, 70, 50);
			page.fillOval(MID - 50, TOP + 80, 100, 60);
			
			// drawing the eyes
			page.setColor(Color.black);
			page.fillOval(MID - 10, TOP + 10, 5, 5);
			page.fillOval(MID + 5, TOP + 10, 5, 5);
			
			// drawing the smile
			page.drawArc(MID - 10, TOP + 20, 20, 10, 170, -160);
			
			// drawing the arms
			page.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);
			page.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
			
			// drawing the hat
			page.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);
			page.fillRect(MID - 15, TOP - 20, 30, 25);
		}
	}
}