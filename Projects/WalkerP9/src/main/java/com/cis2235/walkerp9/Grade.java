// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: Grade.java

package com.cis2235.walkerp9;

// Grade class stores information about each sustainability quiz
public class Grade {
    // Stores user score
    protected int score = 0;
    // This is the max score
    protected final int maxScore = 10;
    // This stores each question prompt
    private String[] prompts = new String[10];

    // Method to increment the user score
    public void addToScore(int value) {
        score += value;
    }

    // Method to set the score
    public void setScore(int value) {
        score = value;
    }

    // Method to set the prompts
    public void setPrompts(String[] prompts) {
        this.prompts = prompts;
    }

    // Method to get the prompts
    public String[] getPrompts() {
        return prompts;
    }

    // To String override
    @Override
    public String toString() {
        double grade = (double) score / maxScore * 100;
        return "You scored " + score + " out of " + maxScore + ", or " + grade + "%";
    }
}
