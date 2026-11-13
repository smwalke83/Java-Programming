/**************************
*Scott Walker  swalker62@student.cnm.edu
* Class AutoClient
* JAVA Programming
* File:  AutoClient.java
***************************/

import java.util.Arrays;

// Main class
public class AutoClient {
	// psvm
	public static void main(String[] args) {
		// Instantiate auto array
		System.out.println("\nInstantiate auto array");
		Auto[] cars = new Auto[3];
		
		// Instantiate auto objects
		Auto sportscar = new Auto("Ferrari", 100, 15.0);
		cars[0] = sportscar;
		cars[1] = new Auto();
		
		// Use Auto methods
		System.out.println("\ncars[0] is a " + cars[0].getModel());
		Auto myCar = cars[1];
		System.out.println("myCar used " + myCar.getGallonsOfGas() + " gallons of gas.");
		
		// Attemt to call method on null Auto objects - Doesn't work, initialize object and try again
		// System.out.println("\ncars[2] is a " + cars[2].getModel());
		cars[2] = new Auto("Lamborghini", 250, 25.0);
		System.out.println("\ncars[2] is a " + cars[2].getModel());
		
		// Printing array elements
		for (Auto car: cars) {
			System.out.println("\nThis auto model is: " + car.getModel() + "\nThe miles driven are: " + car.getMilesDriven() + "\nThe car used " + car.getGallonsOfGas() + " gallons of gas.");
		}
		
		// Create a new array from cars array
		Auto[] moreCars = Arrays.copyOf(cars, cars.length);
		
		// Fill array with sportscars
		Arrays.fill(moreCars, sportscar);
		
		// Display moreCars
		for (Auto more : moreCars) {
			System.out.println("\nThis auto model is " + more.getModel() + "\nThe miles driven are: " + more.getMilesDriven() + "\nThe car used " + more.getGallonsOfGas() + " gallons of gas.");
		}
	}
}