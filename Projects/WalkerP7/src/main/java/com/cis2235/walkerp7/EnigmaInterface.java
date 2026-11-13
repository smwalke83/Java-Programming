package com.cis2235.walkerp7;

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
