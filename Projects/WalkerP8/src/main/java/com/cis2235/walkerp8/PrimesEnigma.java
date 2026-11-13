// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: PrimesEnigma.java

package com.cis2235.walkerp8;

import java.util.Arrays;

public class PrimesEnigma extends Enigma {
    // Fields containing the list of prime numbers and messages pre/post encoding
    private final int[] primes = {11, 13, 17, 19, 23};
    private String pMessage;
    private String eMessage;
    // Encode method using Primes Enigma encoding
    private void encode() {
        // Getting the coded message and assigning the letters to a character array
        char[] charArray = super.getCodedMessage().toCharArray();
        // Looping through each character
        for (int i = 0; i < charArray.length; i++) {
            // Getting the character's ascii value, adding the primes from the primes array one at a time, in order, looping
            int asciiValue = (int) charArray[i];
            asciiValue += primes[i % 5];
            // Wrapping if the result exceeds 126
            if (asciiValue > 126) {
                asciiValue = (asciiValue - 126) + 31;
            }
            // Second pass - adding the key value again
            asciiValue += super.getKey();
            // Wrapping if the result exceeds 126
            if (asciiValue > 126) {
                asciiValue = (asciiValue - 126) + 31;
            }
            // Assigning encoded value back into the array
            charArray[i] = (char) asciiValue;
        }
        // Splitting the string into substrings and reversing using the splitAndReverse method
        char[] newCharArray = splitAndReverse(charArray);
        // Setting the final encoded message into the pMessage variable
        pMessage = String.valueOf(newCharArray);
    }
    // Decode method reverses encode
    private void decode() {
        // Creating character array from fully encoded message
        char[] charArray = pMessage.toCharArray();
        // Splitting the string into substrings and reversing using the splitAndReverse method
        char[] newCharArray = splitAndReverse(charArray);
        // Looping through each character
        for (int i = 0; i < newCharArray.length; i++) {
            // Converting character to ascii value
            int asciiValue = (int) newCharArray[i];
            // Subtracting the key for the first pass
            asciiValue -= super.getKey();
            // Wrapping if necessary
            if (asciiValue < 32) {
                asciiValue = 126 - (31 - asciiValue);
            }
            // Subtracting the primes from the primes array one at a time, in order, looping
            asciiValue -= primes[i % 5];
            // Wrapping if necessary
            if (asciiValue < 32) {
                asciiValue = 126 - (31 - asciiValue);
            }
            // Assigning decoded value back into the array
            newCharArray[i] = (char) asciiValue;
        }
        // Setting the decoded (back to one enigma level) value into the eMessage variable
        eMessage = String.valueOf(newCharArray);
    }
    // splitAndReverse method breaks the array into multiple arrays based on the key value, reverses each array, and puts it back together
    private char[] splitAndReverse(char[] charArray) {
        // num is the number of characters in each substring; calculated as key % 4 + 2. numStrings is how many substrings the string needs to be split into
        int num = super.getKey() % 4 + 2;
        int numStrings = (int) Math.ceil((double) charArray.length / num);
        // Loops from 1 to the total number of substrings, incrementing one at a time
        for (int i = 1; i < numStrings + 1; i++) {
            // if it's the end of the array and the length of the substring is longer than the length of the rest of the array...
            if (charArray.length < num * i) {
                // Only copy the remainder of the array
                char[] temp = Arrays.copyOfRange(charArray, (num * (i - 1)), charArray.length);
                // the reversed copy is stored in another array and reversed in the next loop
                char[] reversedTemp = new char[temp.length];
                for (int j = 0; j < temp.length; j++) {
                    reversedTemp[j] = temp[temp.length - 1 - j];
                }
                // reassigning the reversed sub-array into the appropriate place in the original array
                for (int j = 0; j < reversedTemp.length; j++) {
                    charArray[num * (i-1) + j] = reversedTemp[j];
                }
            }
            else {
                // Copy the appropriate section of the array
                char[] temp = Arrays.copyOfRange(charArray, (num * (i - 1)), (num * i));
                // the reversed copy is stored in another array and reversed in the next loop
                char[] reversedTemp = new char[temp.length];
                for (int j = 0; j < temp.length; j++) {
                    reversedTemp[j] = temp[temp.length - 1 - j];
                }
                // reassigning the reversed sub-array into the appropriate place in the original array
                for (int j = 0; j < num; j++) {
                    charArray[num * (i-1) + j] = reversedTemp[j];
                }
            }
        }
        // returning the split and reversed array
        return charArray;
    }
    // Overriding various interface methods
    @Override
    public void setMessage(String message, int key) {
        // Sets the message/key and then encodes again with Primes Enigma encoding
        super.setMessage(message, key);
        encode();
    }

    @Override
    public void setMessage(String message) {
        // Sets the message and then encodes again with Primes Enigma encoding
        super.setMessage(message);
        encode();
    }

    @Override
    public void setCodedMessage(String message, int key) {
        // Assigns the fully coded message to the pMessage variable
        pMessage = message;
        // Sets the key before decoding, as it is needed for decoding
        super.setKey(key);
        // Decodes the fully coded message to a message encoded once by the enigma parent class
        decode();
        // Sets the once coded message so it can be decoded the rest of the way by super.setCodedMessage()
        super.setCodedMessage(eMessage, key);
    }

    @Override
    public String getCodedMessage() {
        // Returns the fully coded message
        return pMessage;
    }
}

