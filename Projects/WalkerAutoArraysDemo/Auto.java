/**************************
*Ivonne Nelson  inelson1@cnm.edu
* Class AutoClass1
* CIS2235
* File:  Auto.java
***************************/

import java.text.DecimalFormat;

public class Auto{
	//instance variables
	private String model;
	private int milesDriven;
	private double gallonsOfGas;
	
	/*************** Constructors *****************************/
	//default constructor
	public Auto(){
		model  = "unknown";	
	//milesdriven and gallonsOfGas automatically initialized to 0		
	}
	//Overloaded Constructor	
	public Auto(String newModel, int newMilesDriven, double newGallonsOfGas){
		model = newModel;
		setMilesDriven(newMilesDriven);
		setGallonsOfGas(newGallonsOfGas);
	}
		
	/*****************Accessor Methods****************/
	
	public String getModel(){
		return model;
	}
	
	public int getMilesDriven(){
		return milesDriven;
	}
	
	public double getGallonsOfGas(){
		return gallonsOfGas;
	}

	
	
	/****************Mutator Methods*****************/
	//Mutator methods:
	public void setModel(String newModel){
		model = newModel;
	}
	
	public void setMilesDriven(int newMilesDriven){
		//validate newMilesDriven parameter
		if(newMilesDriven >=0){
			milesDriven = newMilesDriven;
		}else {
			System.err.println("\nMiles driven is negative.");
			System.err.println("Value is set to 0");
			milesDriven = 0;
		}
	}
	
	public void setGallonsOfGas(double newGallonsOfGas){
		//validate newGallonsOfGas parameter
		if(newGallonsOfGas >=0){
			gallonsOfGas = newGallonsOfGas;
		}else {
			System.err.println("\nGallons of gas is negative.");
			System.err.println("Value is set to 0");
			gallonsOfGas = 0.0;
		}
	}
	

}


	
	
	
	