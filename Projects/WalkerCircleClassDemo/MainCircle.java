/* 
Programmer: Scott Walker 
Email: swalker62@student.cnm.edu
Program: Simple Circle Demo
File: MainCircle.java (main program file) 
*/

import javax.swing.JOptionPane;

public class MainCircle {
	
	// main method
	public static void main(String[] args) {
		
		// creating a circle (default values)
		Circle circle = new Circle();
		
		// initialize variables 
		int response;
		double radius;
		
		// do/while loop - the first run through sets the value of the response variable, and it will keep looping if the value remains "yes", other wise the loop will exit
		do {
			
			// ask user for radius of a circle
			String str = JOptionPane.showInputDialog(null, "Enter the radius of the circle:");
			radius = Double.parseDouble(str);
			
			// I have included two ways to set the new radius. The one that's commented out was in the assignment, the one I used was used in the class example.
			// circle = new Circle(radius);
			circle.setRadius(radius);
			
			// Uses variables and getters to construct a string showing the redius, area, and circumference. I formatted the results to two decimal points.
			JOptionPane.showMessageDialog(null, "For a circle of radius "
				+ radius 
				+ " units, the area is " 
				+ String.format("%.2f", circle.getArea())
				+ " units and the circumference is " 
				+ String.format("%.2f", circle.getCircumference())
				+ " units.");
			
			// ask user if they want to continue. yes = continue loop, no = exit loop
			response = JOptionPane.showConfirmDialog(null, "Do you want to do another circle?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
		} while(response == JOptionPane.YES_OPTION);
		
		// goodbye message once the loop is completed
		JOptionPane.showMessageDialog(null, "Thanks for making circles with us.");
	}
}