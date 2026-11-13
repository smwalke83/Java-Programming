/***************************************
* Scott Walker swalker62@student.cnm.edu
* Class Auto
* CIS2235
* File: Auto.java
***************************************/

import java.text.DecimalFormat;

public class Auto 
{
	// instance variables
	private String model;
	private int milesDriven;
	private double gallonsOfGas;
	private double mpg;
	private double gasCost;
	private DecimalFormat formatter = new DecimalFormat("#0.00");
	
	// default constructor
	public Auto() 
	{
		model = "unknown";
	}
	
	// overloaded constructor
	public Auto(String newModel, int newMilesDriven, double newGallonsOfGas) 
	{
		model = newModel;
		setMilesDriven(newMilesDriven);
		setGallonsOfGas(newGallonsOfGas);
		moneySpentOnGas();
		calculateMileage();
	}
	
	// accessor methods (getters)
	public String getModel() 
	{
		return model;
	}
	
	public int getMilesDriven() 
	{
		return milesDriven;
	}
	
	public double getGallonsOfGas() 
	{
		return gallonsOfGas;
	}
	
	public double getMpg() 
	{
		return mpg;
	}
	
	public double getGasCost() 
	{
		return gasCost;
	}
	
	// mutator methods (setters)
	public void setModel(String newModel) 
	{
		model = newModel;
	}
	
	public void setMilesDriven(int newMilesDriven) 
	{
		if (newMilesDriven >= 0) 
		{
			milesDriven = newMilesDriven;
			moneySpentOnGas();
			calculateMileage();
		} else 
		{
			System.err.println("Miles driven is negative.");
			System.err.println("Value is set to 0");
			milesDriven = 0;
		}
	}
	
	public void setGallonsOfGas(double newGallonsOfGas) 
	{
		if (newGallonsOfGas >= 0) 
		{
			gallonsOfGas = newGallonsOfGas;
			moneySpentOnGas();
			calculateMileage();
		} else 
		{
			System.err.println("Gallons of gas is negative.");
			System.err.println("Value is set to 0");
			gallonsOfGas = 0;
		}
	}
	
	// private methods
	private void calculateMileage() 
	{
		if (gallonsOfGas != 0) 
		{
			mpg = milesDriven/gallonsOfGas;
		} else 
		{
			mpg = 0.0;
		}
	}
	
	private void moneySpentOnGas() 
	{
		final double PRICE_OF_GAS = 2.79; // if only this was the price of gas
		gasCost = PRICE_OF_GAS * gallonsOfGas;
	}
	
	// public methods
	@Override
	public String toString() 
	{
		return "\n Model: " + model + 
			"; \n Miles Driven: " + milesDriven +
			"; \n Gallons of gas: " + formatter.format(gallonsOfGas) +
			"; \n Miles per gallon: " + formatter.format(mpg) +
			"; \n Cost of gas: " + formatter.format(gasCost);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (!(obj instanceof Auto)) 
		{
			return false;
		} else 
		{
			Auto newObj = (Auto)obj;
			if (model == newObj.model) 
			{
				return true;
			} else 
			{
				return false;
			}
		}
	}
}