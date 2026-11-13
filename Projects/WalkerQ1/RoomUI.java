// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: RoomUI.java

public class RoomUI {
	// 3 Room objects as class members
	public Room room1;
	public Room room2;
	public Room room3;
	// Constructor setting up the rooms as per instructions
	public RoomUI() {
		// Room 1 has default dimensions
		room1 = new Room();
		// Room 2 uses the overloaded constructor to provide dimensions
		room2 = new Room(15.0, 15.0, 15.0);
		// Room 3 uses the default constructor again, then uses the setRoomData method to set the dimensions
		room3 = new Room();
		room3.setRoomData(10, 20, 30);
	}
	

}