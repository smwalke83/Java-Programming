/**************************
*Ivonne Nelson  inelson1@cnm.edu
* Enum Demo
* CIS2235
* File:  DailySpecials.java
***************************/

import java.util.Scanner;

public class DailySpecials{
	
	public enum Days {Sun, Mon, Tue, Wed, Thur, Fri, Sat};
	
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter a day\n"
		+ "(Sun, Mon, Tue, Wed, Thur, Fri, Sat)>>  ");
		
		String inputDay = scan.next();
		
		System.out.print("\nEnter another day\n >>  ");
		String inputDay2 = scan.next();
		
		//Converting Strings to  enum objects 
		Days d1 = Days.valueOf(inputDay);
		System.out.print("\nThe inputDay is " + d1);
		
		Days d2 = Days.valueOf(inputDay2);
		System.out.print("\nThe inputDay is " + d2);
		
		System.out.println("\nCompare objects using equals");
		if(d1.equals(d2))
			System.out.println("\n" + d1 +  " equals " + d2);
		else
			System.out.println("\n" + d1 +  " does not equal " + d2);
		
		System.out.println("\nCompare objects using compareTo");
		if(d1.compareTo(d2) > 0)
			System.out.println("\n" + d1 +  " is greater than " + d2);
		else if(d1.compareTo(d2) < 0)
			System.out.println("\n" + d1 +  " is less than than " + d2);
		else
			System.out.println("\n" + d1 +  " equals " + d2);
		

		
		//Get the number of inputDay
		int dayNum = d1.ordinal();
		System.out.print("\nThe number of inputDay is " + dayNum + "\n");
		
		//List all of the days:
		for(Days dy : Days.values()){
				System.out.print("\n" + dy + " ");
		}
		
		//List specials
		String msg = "\n\nThe special for " + d1;
		switch(d1){
			case Mon:
				msg += " is barbeque chicken.";
				break;
			case Tue:
				msg += " is tacos.";
				break;
			case Wed:
				msg += " is chef's salad.";
				break;
			case Thur:
				msg += " is a cheeseburger.";
				break;
			case Fri:
				msg += " is fish fillet.";
				break;
			default: //Sat or Sun
				msg += " is sorry, we are closed on weekends.";
		}
		System.out.println(msg);
	}
}
		
		
		
		
		
		