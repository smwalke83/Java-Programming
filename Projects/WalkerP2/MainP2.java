/*
* Name: Scott Walker
* Email: swalker62@student.cnm.edu
* Program Name: Snowman with Classes
* File Name: MainP2.Java
*/

public class MainP2 {
	
	// main method
	public static void main(String[] args) {
		
		// create snowman object and pass it to the UI in a constructor
		Snowman snowman = new Snowman();
		SnowmanUI newGame = new SnowmanUI(snowman);
		
		// run the SnowmanUI play method to play the game
		newGame.play();
		
		// end the program when the play method finishes
		System.exit(0);
	}
}