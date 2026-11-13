// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: ColorBuilderFrame.java
// Since I did not write most of this code, I did not comment it. My only comments are prefixed with SW, and they show the debugging steps I took.
// This file has 13 corrections -
	// Removed unnecessary button (1 correction)
	// Initialized cbobj in constructor (1 correction)
	// Red and blue color values were being set using the wrong methods in init() (2 corrections)
	// Added a ; in init() (1 correction)
	// Two initial slider values were hard coded to zero in init(), the third wasn't set at all, now they are all assigned based on the ColorBuilder object's color values (3 corrections)
	// Made sure lblColor field was initialized properly in init() (1 correction)
	// Set lblColor background to opaque in init() so the background color would be displayed (1 correction)
	// Each sliderChanged event listener was coded for the wrong color, those have all been corrected (3 corrections)

package colors;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorBuilderFrame extends JFrame
{
	// SW There is a button defined here but never used. I commented it out.
	// private JButton jbtButton;
	private ColorBuilder cbobj;
	private  JLabel lblRed;
	private JSlider slRed;
	private JLabel lblGreen;
	private JSlider slGreen;
	private JLabel lblBlue;
	private JSlider slBlue;
	private JLabel lblColor;
	String cbDesc;
	
	public ColorBuilderFrame(ColorBuilder builder)
	{
		// SW the color builder parameter wasn't being assigned to the cbobj field
		cbobj = builder;
		init();
	}

	private void init()
	{

		Color mc = cbobj.getTheColor();
		Color cc = cbobj.getTheComplementColor();
		// SW Red called the function for get Blue
		int cbRed = mc.getRed();
		int cbGreen = mc.getGreen();
		// SW Blue called the function for get Red
		int cbBlue = mc.getBlue();
		cbDesc = cbobj.toString();

		//make the container
		GridLayout wcgrid = new GridLayout(7, 1);
		setLayout(wcgrid);
		//create the components
		// SW line needed a ';'
		lblRed = new JLabel("Red: " + cbRed, JLabel.CENTER);
		slRed = new JSlider(0, 255, cbRed);
		slRed.setPaintTicks(true);
		slRed.setPaintLabels(true);
		slRed.setMajorTickSpacing(15);
		slRed.setMinorTickSpacing(5);
		// SW initializing value to the red component of the ColorBuilder, not necessarily zero
		slRed.setValue(mc.getRed());
		
		lblGreen = new JLabel("Green: " + cbGreen, JLabel.CENTER);
		slGreen = new JSlider(0, 255, cbGreen);
		slGreen.setPaintTicks(true);
		slGreen.setPaintLabels(true);
		slGreen.setMajorTickSpacing(15);
		slGreen.setMinorTickSpacing(5);
		// SW initializing value to the green component of the ColorBuilder, not necessarily zero
		slGreen.setValue(mc.getGreen());
		
		lblBlue = new JLabel("Blue: " + cbBlue, JLabel.CENTER);
		slBlue = new JSlider(0, 255, cbBlue);
		slBlue.setPaintTicks(true);
		slBlue.setPaintLabels(true);
		slBlue.setMajorTickSpacing(15);
		slBlue.setMinorTickSpacing(5);
		// SW This line was missing entirely; it sets the starting blue value
		slBlue.setValue(mc.getBlue());

		// SW Instead of initializing a new label to the lblColor field, a new local variable was being created. That has been corrected
		lblColor = new JLabel(cbDesc, JLabel.CENTER);
		lblColor.setForeground(cc);
		lblColor.setBackground(mc);
		// SW This value needs to be set to true to show the background color; it was initially set to false
		lblColor.setOpaque(true);

		//adding the components to the frame.
		add(lblRed);
		add(slRed);
		add(lblGreen);
		add(slGreen);
		add(lblBlue);
		add(slBlue);
		add(lblColor);
		
		//listeners!
		slBlue.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				// SW This is the listener for blue, but the code below was for red. Changed all of that to blue
				int blueVal = slBlue.getValue();
				cbobj.setBlue(blueVal);
				Color bc = cbobj.getTheColor(); //background color is The Color
				Color fc = cbobj.getTheComplementColor(); //font color complements
				cbDesc = cbobj.toString();
				lblBlue.setText("Blue: " + blueVal);
				lblColor.setText(cbDesc);
				lblColor.setForeground(fc);
				lblColor.setBackground(bc);
			}
		});
		slRed.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent f)
			{
				// SW This is the listener for red, but the code below was for green. Changed all of that to red
				int redVal = slRed.getValue();
				cbobj.setRed(redVal);
				Color bc = cbobj.getTheColor(); //background color is The Color
				Color fc = cbobj.getTheComplementColor(); //font color complements
				cbDesc = cbobj.toString();
				lblRed.setText("Red: " + redVal);
				lblColor.setText(cbDesc);
				lblColor.setForeground(fc);
				lblColor.setBackground(bc);
			}
		});
		slGreen.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent g)
			{
				// SW This is the listener for green, but the code below was for blue. Changed all of that to green
				int greenVal = slGreen.getValue();
				cbobj.setGreen(greenVal);
				Color bc = cbobj.getTheColor(); //background color is The Color
				Color fc = cbobj.getTheComplementColor(); //font color complements
				cbDesc = cbobj.toString();
				lblGreen.setText("Green: " + greenVal);
				lblColor.setText(cbDesc);
				lblColor.setForeground(fc);
				lblColor.setBackground(bc);
			}
		});

	}

		
}		
		
		
		
		
	