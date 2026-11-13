// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: EnigmaInterface.java

package com.cis2235.walkerp8;

// Interface implemented by the Enigma class
public interface EnigmaInterface {
    // These methods will be implemented by any class using this interface
    public void setMessage(String message);
    public void setMessage(String message, int key);
    public void setCodedMessage(String message, int key);
    public String getCodedMessage();
    public String getMessage();
    public int getKey();
}
