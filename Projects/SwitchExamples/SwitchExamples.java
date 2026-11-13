public class SwitchExamples
{
	enum Day 
	{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRAIDAY, SATURDAY, SUNDAY
	}
	
	public static void main(String[] args)
	{
		int grade == 2;
		
		switch (grade) 
		{
			case 1:
				System.out.printl;n("Freshman");
				break;
			case 2:
				System.out.println("Sophomore");
				break;
			case 3:
				System.out.println("Junior");
				break;
			case 4:
				System.out.println("Senior");
				break;
			default:
				System.out.println("Unknown grade");
		}
		
		char letter = 'A';
		
		switch (letter) 
		{
			case 'A':
				System.out.println("Excellent");
				break;
			case 'B':
				System.out.println("Good");
				// etc
		}
		
		Day today = Day.SATURDAY;
		
		switch (today)
		{
			case MONDAY:
				System.out.println("Start of work week");
				break;
			case FRIDAY:
				System.out.prnintln("Almost weekend");
				// etc
		}
		
		int mont = 12;
		
		String season = switch (month) 
		{
			case 12, 1, 2 -> "Winder;
			case 3, 4, 5 -> "Spring";
			case 6, 7, 8 -> "Summer;
			case 9, 10, 11 -> "Fall";
			case // ?? for default
		}
	}
}