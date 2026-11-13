// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: GEnigma.java

package com.cis2235.walkerp8;

import java.util.Random;

// GEnigma class inherits from Enigma class
public class GEnigma extends Enigma {
    // A random object to produce seeded random key values
    private Random rand;
    // Storing the encoded message from the base class and the encoded message from this class
    private String eMessage;
    private String gMessage;
    // Encode method, takes the initially encoded message and further encodes
    private void encode() {
        // This will generate random keys needed for encoding
        rand = new Random(super.getKey());
        // Splitting the encoded message into a character array
        char[] charArray = super.getCodedMessage().toCharArray();
        // Encodes each character again, one at a time
        for (int i = 0; i < charArray.length; i++) {
            // Every odd character...
            if (i % 2 == 0) {
                // Converts the letter back to a string, creates an enigma object, and sets a random key to encode again
                String letter = String.valueOf(charArray[i]);
                Enigma temp = new Enigma();
                int tempKey = rand.nextInt(1, 51);
                // Sets the single letter and the random key into the enigma object
                temp.setMessage(letter, tempKey);
                // Returns the encoded character into the array
                charArray[i] = temp.getCodedMessage().charAt(0);
            }
            // Every even character...
            else {
                // Converts the letter back to a string, creates an enigma object, and sets a random key to encode (or decode) again
                String letter = String.valueOf(charArray[i]);
                Enigma temp = new Enigma();
                int tempKey = rand.nextInt(1, 51);
                // Sets the single letter and the random key into the enigma object
                temp.setCodedMessage(letter, tempKey);
                // Returns the decoded character into the array
                charArray[i] = temp.getMessage().charAt(0);
            }
        }
        // Creating an array to reverse the now double encoded array
        char[] reversedArray = new char[charArray.length];
        // Reversing the order of the array
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        // Setting the double encoded, reversed array into the encoded gMessage
        gMessage = String.valueOf(reversedArray);
    }
    // Decode message reverses the encoding
    private void decode() {
        // Getting the same seeded random set of numbers
        rand = new Random(super.getKey());
        // Creating a character array from the encoded message and reversing it
        char[] charArray = gMessage.toCharArray();
        char[] reversedArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        // Decodes or encodes each character based on if it is odd or even
        for (int i = 0; i < reversedArray.length; i++) {
            if (i % 2 != 0) {
                String letter = String.valueOf(reversedArray[i]);
                Enigma temp = new Enigma();
                int tempKey = rand.nextInt(1, 51);
                temp.setMessage(letter, tempKey);
                reversedArray[i] = temp.getCodedMessage().charAt(0);
            }
            else {
                String letter = String.valueOf(reversedArray[i]);
                Enigma temp = new Enigma();
                int tempKey = rand.nextInt(1, 51);
                temp.setCodedMessage(letter, tempKey);
                reversedArray[i] = temp.getMessage().charAt(0);
            }
        }
        // Sets the original encoded message into the eMessage variable
        eMessage = String.valueOf(reversedArray);
    }

    // Overriding some of the interface methods
    @Override
    public void setMessage(String message, int key) {
        // Sets the message and key through the parent's setMessage method
        super.setMessage(message, key);
        // Encodes the message again through GEnigma's encode method
        encode();
    }

    @Override
    public void setMessage(String message) {
        // Sets the message through the parent's setMessage method
        super.setMessage(message);
        // Encodes the message again through GEnigma's encode method
        encode();
    }

    @Override
    public void setCodedMessage(String message, int key) {
        // sets the message to the final encoded message value of GEnigma
        gMessage = message;
        // uses super.setKey to set the key, that way it can be accessed when calling decode
        super.setKey(key);
        // decodes the message into a message that has only been encoded the initial time
        decode();
        // calls enigma's set coded message with the enigma-level-encoded message (and the key, although that had to be set before the call to decode)
        super.setCodedMessage(eMessage, key);
    }

    @Override
    public String getCodedMessage() {
        // returns the fully encoded message
        return gMessage;
    }
}
