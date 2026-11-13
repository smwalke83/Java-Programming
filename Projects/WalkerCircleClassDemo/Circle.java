/* 
Programmer: Scott Walker 
Email: swalker62@student.cnm.edu
Program: Simple Circle Class Demo
File: Circle.java
*/

public class Circle {
		
	// Adding class variables
	private double radius = 1;
	private double area = 1;
	private double circumference = 1;
	
	// Circle constructor function
	public Circle() {
		calcAreaAndCircumference();
	}
	
	// Function to set radius
	public void setRadius(double rad) {
		radius = rad;
		calcAreaAndCircumference();
	}
	
	// Circle constructor function w/ radius parameter
	public Circle(double rad) {
		setRadius(rad);
	}
	
	// Getter functions for radius, area, circumference
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return area;
	}
	public double getCircumference() {
		return circumference;
	}
	
	// Function to calculate area and curcumference
	private void calcAreaAndCircumference() {
		area = Math.PI * Math.pow(radius, 2);
		circumference = 2.0 * Math.PI * radius;
	}

}