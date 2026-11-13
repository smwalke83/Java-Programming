// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Combo Box Demo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo extends JFrame {
	private DescriptionPanel panel = new DescriptionPanel();
	String[] petStrings = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};
	private ImageIcon[] pet = {
		new ImageIcon("image/bird.gif"),
		new ImageIcon("image/cat.gif"),
		new ImageIcon("image/dog.gif"),
		new ImageIcon("image/pig.gif"),
		new ImageIcon("image/rabbit.gif")
	};
	JComboBox<String> petList = new JComboBox<>(petStrings);
	
	public ComboBoxDemo() {
		panel.setTitle("My Pet");
		panel.setDescription("My Pet: Bird");
		panel.setImageIcon(pet[0]);
		add(petList, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		petList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setDisplay(petList.getSelectedIndex());
				System.out.println("index " + petList.getSelectedIndex());
			}
		});
	}
	
	public void setDisplay(int index) {
		panel.setTitle(petStrings[index]);
		panel.setImageIcon(pet[index]);
		panel.setDescription("My Pet: " + petStrings[index]);
	}
	
	public static void main(String[] args) {
		ComboBoxDemo frame = new ComboBoxDemo();
		frame.setSize(500, 225);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ComboBox Demo");
		frame.setVisible(true);
	}
}