// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: TexasEnigma.java

package com.cis2235.walkerp8;

public class TexasEnigma extends Enigma {
    // Strings to store the once encoded message and the fully encoded message
    private String tMessage;
    private String eMessage;
    // Encode method encodes a message that has already been encoded once in the normal way
    private void encode() {
        // Getting the once-coded message and splitting it into a character array
        char[] charArray = super.getCodedMessage().toCharArray();
        // Setting a starting temporary key value
        // Looping through each character - first pass
        for (int i = 0; i < charArray.length; i++) {
            // Setting temp key value - 1 + the iteration, and if it's even it is multiplied by -1
            int tempKey = i + 1;
            if (tempKey % 2 == 0) {
                tempKey *= -1;
            }
            // Converting character to its ascii value and addi147-126ng the temp key value, then wrapping if necessary
            int asciiValue = (int) charArray[i];
            asciiValue += tempKey;
            while (asciiValue > 126) {
                asciiValue = (asciiValue - 126) + 31;
            }
            while (asciiValue < 32) {
                asciiValue = 126 - (31 - asciiValue);
            }
            // Reassigning encoded value into the character array
            charArray[i] = (char) asciiValue;
        }
        // Initializing temp key value at one for next pass
        int tempKey = 1;
        // Looping through each character in reverse - second pass
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Converting the character to its ascii value, adding the temp key value, and wrapping if necessary
            int asciiValue = (int) charArray[i];
            asciiValue += tempKey;
            while (asciiValue > 126) {
                asciiValue = (asciiValue - 126) + 31;
            }
            // Incrementing temp key
            tempKey++;
            // Reassigning encoded value into the character array
            charArray[i] = (char) asciiValue;
        }
        // Setting the final encoded message into the tMessage variable
        tMessage = String.valueOf(charArray);
    }
    // Decode method reverses encoding
    private void decode() {
        // Converting the fully encoded message into a character array
        char[] charArray = tMessage.toCharArray();
        // Setting the initial temp key value
        int tempKey = 1;
        // First pass - looping through the array backwards
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Subtracting the tempkey value for each character, wrapping if necessary
            int asciiValue = (int) charArray[i];
            asciiValue -= tempKey;
            while (asciiValue < 32) {
                asciiValue = 126 - (31 - asciiValue);
            }
            // Incrementing temp key
            tempKey++;
            // Reassigning decoded character into the character array
            charArray[i] = (char) asciiValue;
        }
        // Second pass - looping through each character
        for (int i = 0; i < charArray.length; i++) {
            tempKey = i + 1;
            if (tempKey % 2 == 0) {
                tempKey *= -1;
            }
            // Subtracting temp key value from character ascii values, warpping if necessary
            int asciiValue = (int) charArray[i];
            asciiValue -= tempKey;
            while (asciiValue > 126) {
                asciiValue = (asciiValue - 126) + 31;
            }
            while (asciiValue < 32) {
                asciiValue = 126 - (31 - asciiValue);
            }
            // Incrementing temp key and multiplying by -1, resulting in a 1, -2, 3, -4 pattern
            tempKey++;
            tempKey *= -1;
            // Reassigning the decoded character value into the array
            charArray[i] = (char) asciiValue;
        }
        // Assigning the decoded message (back to one enigma pass) to the eMessage variable
        eMessage = String.valueOf(charArray);
    }
    // Overriding various interface methods
    @Override
    public void setMessage(String message, int key) {
        // Setting the message and the key, then encoding with Texas Enigma encoding
        super.setMessage(message, key);
        encode();
    }

    @Override
    public void setMessage(String message) {
        // Setting the message, then encoding with Texas Enigma encoding
        super.setMessage(message);
        encode();
    }

    @Override
    public void setCodedMessage(String message, int key) {
        // Assigning the fully coded message to the tMessage value
        tMessage = message;
        // Setting the key before decoding
        super.setKey(key);
        // Decoding the Texas encoded message back to normal enigma encoding
        decode();
        // using super.setCodedMessgae to set the normally encoded message and allow the class to decode it the rest of the way
        super.setCodedMessage(eMessage, key);
    }

    @Override
    public String getCodedMessage() {
        // returns the fully encoded message
        return tMessage;
    }
}
