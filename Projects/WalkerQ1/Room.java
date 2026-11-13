// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: Room.java

public class Room {
    // Class variables
    private double height;
    private double length;
    private double width;
    // Getter/setter for height
    private double getHeight() {
        return height;
    }
    private void setHeight(double newHeight) {
        height = newHeight;
    }
    // Getter/setter for length
    private double getLength() {
        return length;
    }
    private void setLength(double newLength) {
        length = newLength;
    }
    // Getter/setter for width
    private double getWidth() {
        return width;
    }
    private void setWidth(double newWidth) {
        width = newWidth;
    }
    // Constructor with parameters for each variable
    public Room(double height, double length, double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }
    // Constructor that sets default values
    public Room() {
        this(8.0, 12.5, 10.0);
    }
    // Method to set all room variables
    public void setRoomData(double newHeight, double newLength, double newWidth) {
        height = newHeight;
        length = newLength;
        width = newWidth;
    }
    // Method to get a string with a room description
    public String getRoomDesc() {
        return "The room is " + height + " feet tall, " + length + " feet long, and " + width + " feet wide.";
    }
}
