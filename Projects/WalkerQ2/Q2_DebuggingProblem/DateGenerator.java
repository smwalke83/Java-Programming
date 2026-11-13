
//CIS2235 Java Debugging problem


public class DateGenerator
{

	private int month, day;
	private String newDate;
	private String [] monthNames;
	private String [] dayNames;

	public DateGenerator()
	{
		// SW This originally created a new local monthNames array instead of assigning the array to the class member
		monthNames = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		
		// SW This originally created a new local dayNames array instead of assigning the array to the class member
		dayNames = new String[] {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};

		month = 1;
	}


	public void setMonth(int m)
	{
		month = m;
		calculate();
	}
	
	public String getRandomDate()
	{
		return newDate;
	}

	private void calculate()
	{
		switch(month)
		{
			case 2: //Feb 1-28 
			// SW Math.random()*28 will return a value 0-27. If we add 1 to the result, we get a result from 1-28
			day = (int)(Math.random()*28) + 1;
			break;

			case 4: case 6: case 9: case 11:
			// SW Math.random()*30 will return a value 0-29. If we add 1 to the result, we get a result from 1-30
			day = (int)(Math.random()*30) + 1;
			break;

			default:
			// SW Math.random()*31 will return a value 0-30. If we add 1 to the result, we get a result from 1-31
			day = (int)(Math.random()*31) + 1;
			break;
		}
		// SW Commented out the below line; day will no longer be zero, it will be 1-28, 1-30, or 1-31
		// if(day == 0) day = 1;
		int dayn = (int)(Math.random()*7);
		
		// SW The monthNames array starts at 0, but our month numbers start at 1, so the index has to have one subtracted
		// SW I also deleted an extra space between the monthNames[month - 1] and day for visual appeal
		newDate = dayNames[dayn] + ", " + monthNames[month - 1]+ " " + day;

	}

}