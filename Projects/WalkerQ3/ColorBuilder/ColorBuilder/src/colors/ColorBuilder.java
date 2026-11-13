// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: ColorBuilder.java
// Since I did not write most of this code, I did not comment it. My only comments are prefixed with SW, and they show the debugging steps I took.
// This file contains 3 corrections -
	// The overloaded constructor was incorrectly setting parameter values into field values
	// The getTheColor() function was returning the wrong color
	// The complementary colors were being calculated incorrectly

package colors;

import java.awt.Color;

public class ColorBuilder
{
	private int red;
	private int green;
	private int blue;
	private int cRed, cGreen, cBlue;

	
	public ColorBuilder()
	{
		red = 0;
		green = 0;
		blue = 0;

	}
	
	public ColorBuilder(int red, int green, int blue)
	{
		// SW While this constructor is never actually called in this code, the parameter assignments were backwards here. I commented the old code out so you can see what I mean
		// red = this.red;
		// green = this.green;
		// blue = this.blue;
		// SW Below is the correct assignment of the parameter values to the color fields
		this.red = red;
		this.green = green;
		this.blue = blue;

	}
	
	//Set red value
	public void setRed(int r){
		red = r;

	}
	
	//Set green value
	public void setGreen(int g){
		green = g;

	}
	
	//Set blue value
	public void setBlue(int b){
		blue = b;

	}

	//Returns the color
	public Color getTheColor()
	{
		// SW This was providing the color parameters in the wrong order (red, blue, green)
		Color temp = new Color(red, green, blue);
		return temp;
	}

	public Color getTheComplementColor()
	{
		//if it's mid-grey, make the complementary color black.
		if (red < 170 && red > 100 && green < 170 && green > 100 && 
			blue < 170 && blue > 100)
		{
			cRed = 255;
			cGreen = 255;
			cBlue = 255;
		}
		else		//otherwise, find the actual complement
		{
			// SW In order to find the complementary color, you subtract the color from 255. It was originally being added
			cRed = 255 - red;
			cGreen = 255 - green;
			cBlue = 255 - blue;
		}
		Color compColor = new Color(cRed, cGreen, cBlue);
	return compColor;
	}
	@Override

	public String toString()
	{
		return "Red: " + red + " Green: " + green + " Blue: " + blue;
	}

}

	
	
	
	
	
	
	
	
	

	