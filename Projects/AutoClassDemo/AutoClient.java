/***************************************
* Scott Walker swalker62@student.cnm.edu
* Class AutoClient
* CIS2235
* File: AutoClient.java
***************************************/

public class AutoClient 
{
	public static void main(String[] args) 
	{
		System.out.println("\nInstantiate sedan");
		Auto sedan = new Auto();
		String sedanModel = sedan.getModel();
		int sedanMiles = sedan.getMilesDriven();
		double sedanGallons = sedan.getGallonsOfGas();
		System.out.println("\nSedan model is " + sedanModel + "\nMiles driven is " + sedanMiles + "\nGallons of gas is " + sedanGallons);
		
		System.out.println("\nInstantiate SUV");
		Auto suv = new Auto("Trailblazer", 7000, 437.5);
		String suvModel = suv.getModel();
		int suvMiles = suv.getMilesDriven();
		double suvGallons = suv.getGallonsOfGas();
		System.out.println("\nSUV model is " + suvModel + "\nMiles driven is " + suvMiles + "\nGallons of gas is " + suvGallons);
		
		// Commented out mini per instructions
		//System.out.println("\nInstantiate mini");
		//Auto mini = new Auto("Mini Cooper", 200, -1.0);
		
		suv.setModel("Sportage");
		suv.setMilesDriven(200);
		suv.setGallonsOfGas(10.5);
		System.out.println("\nSUV model is " + suv.getModel() + "\nMiles driven is " + suv.getMilesDriven() + "\nGallons of gas is " + suv.getGallonsOfGas());
		
		// Commented out per instructions
		//suv.setMilesDriven(-1);
		//System.out.println("\nSUV model is " + suv.getModel() + "\nMiles driven is " + suv.getMilesDriven() + "\nGallons of gas is " + suv.getGallonsOfGas());
		
		System.out.println(suv.toString());
		
		if (sedan.equals(suv)) 
		{
			System.out.println("The sedan is an suv!");
		} else 
		{
			System.out.println("The sedan is NOT an suv!");
		}
	}
}