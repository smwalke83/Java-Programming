// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: Enigma.java

package com.cis2235.walkerp8;

import java.util.Random;

// Enigma class implements the methods in Enigma Interface
// I tried to keep this as unchanged as possible from program 7; I ended up adding a setKey method that can be called by its children
public class Enigma implements EnigmaInterface {

    // Data fields for storing key, message, and coded message
    private int key;
    private String message;
    private String codedMessage;

    // Encode method
    private void encode() {
        // Converts the message to an array of characters
        char[] charArray = message.toCharArray();
        // For each character in the message, the ascii value is adjusted based on the key and reassigned to that position in the array
        for (int i = 0; i < message.length(); i++) {
            int asciiValue = (int) charArray[i];
            int newAscii = asciiValue + key;
            // If the new ascii value is out of range, it is converted to an appropriate wrapped value
            if (newAscii > 126) {
                newAscii = (newAscii - 126) + 31;
            }
            charArray[i] = (char) newAscii;
        }
        // Converts the character array back to a string
        codedMessage = String.valueOf(charArray);
    }

    // Decode method
    private void decode() {
        // Converts the message to an array of characters
        char[] charArray = codedMessage.toCharArray();
        // For each character in the message, the ascii value is adjusted based on the key and reassigned to that position in the array
        for (int i = 0; i < codedMessage.length(); i++) {
            int asciiValue = (int) charArray[i];
            int newAscii = asciiValue - key;
            // If the new ascii value is out of range, it is converted to an appropriate wrapped value
            if (newAscii < 32) {
                newAscii = 126 - (31 - newAscii);
            }
            charArray[i] = (char) newAscii;
        }
        message = String.valueOf(charArray);
    }

    // Method to set the key, called by the other enigma types when setting the coded message
    public void setKey(int key) {
        this.key = key;
    }

    // The following are contracted methods from the interface
    // Set message sets the non-encoded message and either selects a random key, or sets the supplied key
    @Override
    public void setMessage(String message) {
        this.message = message;
        // Used to generate a random number
        Random randomNum = new Random();
        // Sets the key to a random number between 1 and 50 (inclusive)
        this.key = randomNum.nextInt(1, 51);
        // Calls the encode method after setting the message and the key
        encode();
    }

    @Override
    public void setMessage(String message, int key) {
        this.message = message;
        // If the key is not in the bounds, sets the key to 1
        if (key >= 1 && key <=50) {
            this.key = key;
        } else {
            this.key = 1;
        }
        // Calls the encode method after setting the message and the key
        encode();
    }

    // Sets the coded message and a key to decode it with
    @Override
    public void setCodedMessage(String message, int key) {
        codedMessage = message;
        this.key = key;
        // Calls the decode method after setting the key and the coded message
        decode();
    }

    // Returns the coded message
    @Override
    public String getCodedMessage() {
        return codedMessage;
    }

    // Returns the non-coded message
    @Override
    public String getMessage() {
        return message;
    }

    // Returns the key
    @Override
    public int getKey() {
        return key;
    }
}
