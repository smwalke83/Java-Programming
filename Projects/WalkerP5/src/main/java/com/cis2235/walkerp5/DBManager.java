// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File Name: DBManager
// This class was provided by the instructor, but I changed several methods to suit my table/database, as well as adding a method

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cis2235.walkerp5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

/**
 *
 * @author inelson1
 */
public class DBManager {

    private Connection connection = null;  // Private field to hold the database connection
    private Statement statement = null;    // Private field for executing SQL statements
    private final String TABLE_NAME = "WalkerP5";  // Constant for the table name used throughout the class; changed to WalkerP5 - smw
    private Result result = null;          // Private field to store results (note: this seems unused and might be a typo or leftover)

    // Constructor establishes the connection to the database
    public DBManager(){

        try{
            // Establish a connection to the SQLite database
            // Set the database name here. Default is sample, but using "nelsonp7.db"
            connection = DriverManager.getConnection("jdbc:sqlite:WalkerP5.db"); // Database name changed to WalkerP5 - smw

        } catch (SQLException ex) {
            // Log any SQL exceptions that occur during connection
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    // Method to insert a new record into the database
    // Changed parameters to reflect my table, and changed the method slightly to reflect my table - smw
    public void insert(int recordID, String firstName, String lastName, String phone, String email){
        try {
            // Prepare the SQL insert query using the table name
            String insertQuery =
                    "INSERT INTO "+TABLE_NAME +
                            " VALUES (?, ?, ? , ?, ?)";

            PreparedStatement  insertUpdate = null;  // PreparedStatement for secure insertion
            insertUpdate = connection.prepareStatement(insertQuery);  // Prepare the statement with placeholders

            // Set the values for the placeholders in the query
            insertUpdate.setInt(1, recordID);     // Set ID (primary key)
            insertUpdate.setString(2, firstName);     // Set first name
            insertUpdate.setString(3, lastName);    // Set last name
            insertUpdate.setString(4, phone);         // Set phone number
            insertUpdate.setString(5, email);    // Set email
            insertUpdate.executeUpdate();         // Execute the insert operation

        } catch (SQLException ex) {
            // Log any SQL exceptions during insertion
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to retrieve the last (maximum) ID from the table
    public int getLastID() {
        int ID = 0;              // Initialize ID to 0
        ResultSet results;       // To hold the query results
        try {
            statement = connection.createStatement();  // Create a statement object

            // SQL query to get the maximum ID from the table
            String newQuery = "SELECT MAX(ID)"
                    + "FROM " + TABLE_NAME;
            results = statement.executeQuery(newQuery);  // Execute the query

            if (results.next()) {
                // Parse the result as an integer
                ID = Integer.parseInt(results.getString(1));
            }

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;  // Return the maximum ID found
    }

    // I added this method to check if a user provided ID exists - smw
    public boolean checkID(int recordID) {
        try {
            PreparedStatement getRecordStmt = null;  // PreparedStatement for querying

            String getRecordQuery = "SELECT * "
                    +"FROM "+TABLE_NAME
                    +" WHERE ID = ?";  // Use placeholder for ID

            getRecordStmt = connection.prepareStatement(getRecordQuery);  // Prepare the statement
            getRecordStmt.setInt(1, recordID);    // Set the ID parameter

            ResultSet result = getRecordStmt.executeQuery();  // Execute the query
            return result.next(); // Return true if there is a result, false if it doesn't exist yet

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    // Method to retrieve a record by its ID and return it as a String array
    // I changed this method slightly to reflect my table - smw
    public String[] getRecordById(int recordID){

        String firstName = "";    // Initialize first name
        String lastName= "";    // Initialize last name
        String phone = "";  // Initialize phone number
        String email = "";   // Initialize color

        try {
            PreparedStatement getRecordStmt = null;  // PreparedStatement for querying


            // SQL query to select a record by ID
            String getRecordQuery = "SELECT * "
                    +"FROM "+TABLE_NAME
                    +" WHERE ID = ?";  // Use placeholder for ID
            getRecordStmt = connection.prepareStatement(getRecordQuery);  // Prepare the statement
            getRecordStmt.setInt(1, recordID);    // Set the ID parameter

            ResultSet result = getRecordStmt.executeQuery();  // Execute the query

            if(result.next())  // If a record is found
            {
                firstName = result.getString(2);   // Get first name (column 2)
                lastName = result.getString(3);  // Get last name (column 3)
                phone = result.getString(4); // Get phone (column 4)
                email = result.getString(5);  // Get email (column 5)
            }


        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Package the results into a String array
        String[] getRow = {firstName, lastName, phone, email};
        return getRow;  // Return the array
    }

    // Method to edit (update) an existing record by ID
    // I changed this method slightly to reflect my table - smw
    public void editRecord(int recordID, String firstName, String lastName, String phone, String email){
        try {
            PreparedStatement  editStatement = null;  // PreparedStatement for update
            // SQL update query
            String editQuery = "UPDATE " + TABLE_NAME
                    + " SET FIRSTNAME = ?, LASTNAME = ?, PHONE = ?, EMAIL = ? WHERE ID = ?";
            editStatement = connection.prepareStatement(editQuery);  // Prepare the statement

            // Set the new values for the placeholders
            editStatement.setString(1, firstName);     // Update first name
            editStatement.setString(2, lastName);    // Update last name
            editStatement.setString(3, phone);         // Update phone
            editStatement.setString(4, email);    // Update email
            editStatement.setInt(5, recordID);     // Where clause for ID
            editStatement.executeUpdate();         // Execute the update

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to delete a record by ID
    public void deleteRecord(int  recordID) {

        try {
            PreparedStatement deleteStmt = null;  // PreparedStatement for delete
            // SQL delete query
            String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";
            deleteStmt = connection.prepareStatement(deleteQuery);  // Prepare the statement
            deleteStmt.setInt(1, recordID);  // Set the ID parameter
            deleteStmt.executeUpdate();      // Execute the delete

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Methods for creating the table and populating it

    // Method to create the table if it doesn't exist
    // I changed this method to reflect my table - it is a table containing customer information - smw
    public void createTable(){

        // SQL statement to create the table
        String sql = "CREATE TABLE IF NOT EXISTS WalkerP5 ( \n"
                + "   id integer PRIMARY KEY, \n"
                + "   firstName text NOT NULL, \n"
                + "   lastName text NOT NULL, \n"
                + "   phone text, \n"
                + "   email text\n"
                + ");";
        // Note: The commented-out part below is an alternative SQL syntax, but SQLite uses the above
        //Using SQL:
//                    + "(ID NUMBER(3) NOT NULL PRIMARY KEY, "
//                        + "NAME Varchar2(30) NOT NULL, "
//                        + "BREED Varchar2(30) NOT NULL , "
//                        + "AGE NUMBER(2) NOT NULL , "
//                        + "COLOR Varchar2(30) NOT NULL )");
        try {
            statement = connection.createStatement();  // Create a statement
            statement.executeUpdate(sql);              // Execute the create table query
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to populate the database with sample data
    // I changed this method to reflect my table -smw
    public void populateDatabase(){

        // Insert sample records using the insert method
        insert(1, "John", "Smith", "111-222-3333", "jsmith1@website.com");
        insert(2, "Jane", "Doe", "222-333-4444", "jdoe2@website.com");
        insert (3, "Jacob", "Jingle", "333-444-5555", "jingleheimer@schmidt.com");
        insert (4, "Carmen", "San Diego", "555-666-7777", "whereinthe@world.com");
        insert (5, "Joe", "Plumber", "666-777-8888", "jplumber@whitehouse.gov");

    }

    // Method to drop (delete) the table
    public void dropTable(){

        try {
            statement = connection.createStatement();  // Create a statement

            // SQL to drop the table
            // Be sure to change the name of the table if needed
            String drop = "Drop Table " +TABLE_NAME+ " " ;
            statement.execute(drop);  // Execute the drop query
        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}