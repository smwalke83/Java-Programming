// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: MainQ1.java

import javax.swing.JOptionPane;

public class MainQ1 {
	// Main method
	public static void main(String[] args) {
		// Creating a new RoomUI object
		RoomUI rooms = new RoomUI();
		// Showing the room description for each room in the RoomUI object
		JOptionPane.showMessageDialog(null, "Room 1: " + rooms.room1.getRoomDesc() + "\n" + 
											"Room 2: " + rooms.room2.getRoomDesc() + "\n" +
											"Room 3: " + rooms.room3.getRoomDesc());
	}
}