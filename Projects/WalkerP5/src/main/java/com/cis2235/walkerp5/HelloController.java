// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File Name: HelloController

package com.cis2235.walkerp5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

// Controller class
public class HelloController {

    // Final class member for the database, per instructions. This connects to the database. It is used to call Create Table and other methods.
    // THe table is not created until create table is clicked on the form. It is then populated by clicking populate table.
    private final DBManager db = new DBManager();

    // Buttons to be clicked in the main window
    @FXML
    private Button btnClearFields;

    @FXML
    private Button btnCreateTable;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnEnterID;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnPopulate;

    // Labels for various controls
    @FXML
    private Label lblEdit;

    @FXML
    private Label lblID;

    @FXML
    private Label lblInsert;

    @FXML
    private Label lblPopulate;

    @FXML
    private Label lblTableCreated;

    @FXML
    private Label lblTitle;

    // Text field/area controls for various purposes
    @FXML
    private TextArea taError;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    // Handling clicking the clear fields button; this clears all the input fields
    @FXML
    void onClearClicked(MouseEvent event) {
        tfID.clear();
        tfFirstName.clear();
        tfLastName.clear();
        tfPhone.clear();
        tfEmail.clear();
    }

    // Handling clicking the create table function
    @FXML
    void onCreateClicked(MouseEvent event) {
        try {
            // Creates the table and alerts the user
            db.createTable();
            lblTableCreated.setVisible(true);
            taError.clear();
        }
        catch (Exception ex) {
            // Reports any errors in the Error text area
            taError.setText("Error: " + ex.getMessage());
        }
    }

    // Handling clicking the delete record function
    @FXML
    void onDeleteClicked(MouseEvent event) {
        try {
            // ID variable to store the id to delete
            int id;
            // If the id field is not empty and successfully parses to an integer, the record is deleted
            if (!tfID.getText().isEmpty()) {
                id = Integer.parseInt(tfID.getText());
                db.deleteRecord(id);
                taError.setText("Successfully deleted record " + id + ".");
            }
            // If the id field is empty, user is prompted to enter a valid id
            else {
                taError.setText("Please input a valid ID.");
            }
        }
        // If a number format exception is thrown, it is displayed and user is asked to enter a valid ID
        catch (NumberFormatException ex) {
            taError.setText("Error: " + ex.getMessage() + "\nPlease input a valid ID.");
        }
        // If another Exception is thrown, it is displayed to the user
        catch (Exception ex) {
            taError.setText("Error: " + ex.getMessage());
        }
    }

    // Handling clicking the display record button
    @FXML
    void onDisplayClicked(MouseEvent event) {
        try {
            // ID variable
            int id;
            // If the id field is not empty and successfully parses to an integer...
            if (!tfID.getText().isEmpty()) {
                id = Integer.parseInt(tfID.getText());
                // If the ID is greater than the highest existing ID or less than 1, fields are cleared and user is alerted the record doesn't exist
                if (id > db.getLastID() || id < 1) {
                    tfFirstName.clear();
                    tfLastName.clear();
                    tfPhone.clear();
                    tfEmail.clear();
                    taError.setText("Record ID " + id + " does not exist. Make sure it is a positive whole number associated with an existing record.");
                }
                // Otherwise, the associated record is displayed
                else {
                    String[] results = db.getRecordById(id);
                    tfFirstName.setText(results[0]);
                    tfLastName.setText(results[1]);
                    tfPhone.setText(results[2]);
                    tfEmail.setText(results[3]);
                    taError.clear();
                }
            }
            // If the ID field is empty, the user is alerted and prompted for a valid ID
            else {
                taError.setText("Please input a valid ID.");
            }
        }
        // A number format exception prompts the user for a valid id
        catch (NumberFormatException ex) {
            taError.setText("Error: " + ex.getMessage() + "\nPleas input a valid ID.");
        }
        // Other exceptions are reported to the user
        catch (Exception ex) {
            taError.setText("Error: " + ex.getMessage());
        }
    }

    // Handling clicking the edit record button
    @FXML
    void onEditClicked(MouseEvent event) {
        try {
            // Since first and last name must not be null, this verifies that values were provided
            if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty()) {
                taError.setText("Record must have a First and Last name.");
            }
            // if first and last names are provided, updates the record
            else {
                int recordID = Integer.parseInt(tfID.getText());
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                String phone = tfPhone.getText();
                String email = tfEmail.getText();
                db.editRecord(recordID, firstName, lastName, phone, email);
                taError.setText("Record " + recordID + " successfully edited.");
            }
        }
        // Prompts the user for a valid ID if the number format exception is thrown.
        catch (NumberFormatException ex) {
            taError.setText("Error: " + ex.getMessage() + "\nPlease enter a valid Record ID to edit.");
        }
        // Other exceptions are reported to the user
        catch (Exception ex) {
            taError.setText("Error: " + ex.getMessage());
        }
    }

    // Handling the user clicking INSERT RECORD
    @FXML
    void onInsertClicked(MouseEvent event) {
        try {
            // Variable to store ID
            int recordID;
            // If the ID text field isn't empty, that value is used for ID
            if (!tfID.getText().isEmpty()) {
                recordID = Integer.parseInt(tfID.getText());
            }
            // If the ID text field is empty, an ID of 1 greater than the highest ID is used
            else {
                recordID = db.getLastID() + 1;
            }
            // If the chosen ID isn't already in use, proceeds with insert
            if (!db.checkID(recordID)) {
                // Since first and last name cannot be null, this verifies that values are provided. If not, the user is alerted
                if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty()) {
                    taError.setText("Record must have a First and Last name.");
                }
                // If first and last name are provided, data is collected from input fields and inserted into the table
                else {
                    String firstName = tfFirstName.getText();
                    String lastName = tfLastName.getText();
                    String phone = tfPhone.getText();
                    String email = tfEmail.getText();
                    db.insert(recordID, firstName, lastName, phone, email);
                    taError.setText("Record " + recordID + " successfully inserted.");
                }
            }
            // If the chosen ID is already in use, alerts the user.
            else {
                taError.setText("Record " + recordID + " already exists, please select another ID.");
            }
        }
        // If a number format exception is thrown, alerts the user and prompts for a valid ID
        catch (NumberFormatException ex) {
            taError.setText("Error: " + ex.getMessage() + "\nRecord ID must be a whole number.");
        }
        // Other exceptions are reported to the user
        catch (Exception ex) {
            taError.setText("Error: " + ex.getMessage());
        }
    }

    // Handling clicking the Populate Table button. Alerts user on success or failure.
    // If this is clicked after the table is already populated, a sql error is logged.
    @FXML
    void onPopulateClicked(MouseEvent event) {
        try {
            db.populateDatabase();
            lblPopulate.setVisible(true);
            taError.clear();
        }
        catch (Exception ex) {
            taError.setText("Error: " + ex.getMessage());
        }
    }

}

