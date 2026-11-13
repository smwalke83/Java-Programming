import java.util.Arrays;

public class ArrayExamples
{
	public static void main(String[] args)
	{
		// Integer Array - created w/ size (new int[5])
		int[] numbers = new int[5];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;
		
		System.out.println("Integer Array:");
		System.out.println(Arrays.toString(numbers));
		
		// String Array - Direct initialization
		String[] colors = {"Red", "Green", "Blue", "Yellow"};
		
		System.out.println("\nString Array:");
		System.out.println(Arrays.toString(colors));
		
		// Double and Char Arrays
		double[] prices = {19.99, 5.49, 12.75};
		
		System.out.println("\nDouble Array:");
		System.out.println(Arrays.toString(prices));
		
		char[] letters = {'A', 'B', 'C', 'D'};
		
		System.out.println("\nChar Array:");
		System.out.println(Arrays.toString(letters));
		
		// Boolean Array
		boolean[] answers = {true, false, true};
		
		System.out.println("\nBoolean Array:");
		System.out.println(Arrays.toString(answers));
		
		// Array using new keyword
		String[] animals = new String[] 
		{
			"Dog",
			"Cat",
			"Bird"
		};
		
		System.out.println("\nArray:");
		System.out.println(Arrays.toString(animals));
		
		// Looping Through Arrays
		
		System.out.println("\nLooping Through Colors:");
		
		for (String color : colors) 
		{
			System.out.println(color);
		}
	}
}