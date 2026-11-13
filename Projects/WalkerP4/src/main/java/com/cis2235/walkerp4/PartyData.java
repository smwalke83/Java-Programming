package com.cis2235.walkerp4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

// Class to contain data for party planning
public class PartyData {
    // A static array of strings containing party themes, used for the combo box
    static final String[] themes = {"70s", "80s", "90s", "00s"};

    // Private class members (containing party information) with public getters and setters
    private String theme;
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getTheme() { return theme; }

    private int numGuests;
    public void setNumGuests(int guests) {
        numGuests = guests;
    }
    public int getNumGuests() {
        return numGuests;
    }

    private String address;
    public void setAddress(String add) {
        address = add;
    }
    public String getAddress() {
        return address;
    }

    private int numHours;
    public void setNumHours(int hours) {
        numHours = hours;
    }
    public int getNumHours() {
        return numHours;
    }

    private String snackBrand;
    public void setSnackBrand(String snack) {
        snackBrand = snack;
    }
    public String getSnackBrand() {
        return snackBrand;
    }

    private String drinkBrand;
    public void setDrinkBrand(String drink) {
        drinkBrand = drink;
    }
    public String getDrinkBrand() {
        return drinkBrand;
    }

    private boolean DJ;
    public void setDJ(boolean dj) { DJ = dj; }
    public boolean getDJ() {
        return DJ;
    }

    private boolean bouncer;
    public void setBouncer(boolean bouncer) {
        this.bouncer = bouncer;
    }
    public boolean getBouncer() {
        return bouncer;
    }

    private boolean alcohol;
    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }
    public boolean getAlcohol() {
        return alcohol;
    }

    private boolean kids;
    public void setKids(boolean kids) {
        this.kids = kids;
    }
    public boolean getKids() {
        return kids;
    }

    private boolean pets;
    public void setPets(boolean pets) {
        this.pets = pets;
    }
    public boolean getPets() {
        return pets;
    }

    private boolean plusOne;
    public void setPlusOne(boolean plusone) {
        plusOne = plusone;
    }
    public boolean getPlusOne() {
        return plusOne;
    }

    // Constructor with default values
    public PartyData() {
        this("", 0, "", 0, "",
                "", false, false, false,
                false, false, false);
    }

    // Constructor with parameters for each field
    public PartyData(String theme, int guests, String add, int hours, String snack,
                     String drink, boolean dj, boolean bouncer, boolean alcohol,
                     boolean kids, boolean pets, boolean plusOne) {
        this.theme = theme;
        numGuests = guests;
        address = add;
        numHours = hours;
        snackBrand = snack;
        drinkBrand = drink;
        DJ = dj;
        this.bouncer = bouncer;
        this.alcohol = alcohol;
        this.kids = kids;
        this.pets = pets;
        this.plusOne = plusOne;
    }

    // toString override - Writes out the party details
    @Override
    public String toString() {
        return "You are planning a party! Here are some details:\nTheme: " + theme +
               "\nNumber of Guests: " + numGuests +
               "\nParty Address: " + address +
               "\nLength of Party: " + numHours + " Hours" +
               "\nBrand of Snacks: " + snackBrand +
               "\nBrand of Drinks: " + drinkBrand +
               "\nDJ: " + DJ +
               "\nBouncer: " + bouncer +
               "\nKids Welcome: " + kids +
               "\nPets Welcome: " + pets +
               "\nPlus One Allowed: " + plusOne;
    }

    // Writes the party data to a file
    public void WriteFile(File file) {
        try {
            // Using filewriter and bufferedwriter to write a file with the toString results
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this.toString());
            out.close();
        }

        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
