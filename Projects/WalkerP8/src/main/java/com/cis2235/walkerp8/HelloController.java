// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Program: Program 8
// File: HelloController.java

package com.cis2235.walkerp8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// Controller class to connect enigma logic to user interface
public class HelloController {

    // Member variables per instructions; an enigma array, three enigma child objects, as well as variables to hold the key and message values
    private Enigma[] enigmas = new Enigma[3];
    private GEnigma gEnigma;
    private PrimesEnigma pEnigma;
    private TexasEnigma tEnigma;
    private int index = 0;
    private int key;
    private String enigmaType;
    private String message;
    private String codedMessage;

    // Initialize method to instantiate enigma objects. Also makes the Key Input field invisible/uneditable unless the Fixed Key radio button is selected
    @FXML
    public void initialize() {
        gEnigma = new GEnigma();
        pEnigma = new PrimesEnigma();
        tEnigma = new TexasEnigma();
        enigmas[0] = gEnigma;
        enigmas[1] = pEnigma;
        enigmas[2] = tEnigma;
        tfKeyInput.editableProperty().bind(rbFixedKey.selectedProperty());
        tfKeyInput.visibleProperty().bind(rbFixedKey.selectedProperty());
    }

    // Label that displays error messages
    @FXML
    private Label lblError;

    // Clear, decode, encode buttons
    @FXML
    private Button btnClear;

    @FXML
    private Button btnDecode;

    @FXML
    private Button btnEncode;

    // Radio button groups
    @FXML
    private ToggleGroup radioGroup1;

    @FXML
    private ToggleGroup radioGroup2;

    // Radio buttons for key generation
    @FXML
    private RadioButton rbFixedKey;

    @FXML
    private RadioButton rbGeneratedKey;

    // Radio buttons to choose enigma type
    @FXML
    private RadioButton rbGEnigma;

    @FXML
    private RadioButton rbPrimesEnigma;

    @FXML
    private RadioButton rbTexasEnigma;

    // Text fields for input/output text
    @FXML
    private TextField tfCodedMessage;

    @FXML
    private TextField tfKey;

    @FXML
    private TextField tfKeyInput;

    @FXML
    private TextField tfMessageInput;

    // Handling the user clicking the about button in the about menu
    @FXML
    void onAboutClick(ActionEvent event) {
        // Creates a new FXML window from 'about.fxml' file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("About Enigma");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Handling the user clicking the clear button
    @FXML
    void onClearClick(MouseEvent event) {
        // Clears all the text fields, creates new enigma objects, resets member values
        tfKeyInput.clear();
        tfMessageInput.clear();
        tfCodedMessage.clear();
        tfKey.clear();
        gEnigma = new GEnigma();
        pEnigma = new PrimesEnigma();
        tEnigma = new TexasEnigma();
        enigmas[0] = gEnigma;
        enigmas[1] = pEnigma;
        enigmas[2] = tEnigma;
        codedMessage = "";
        message = "";
        lblError.setText("");
    }

    // Handling the user clicking the decode button
    @FXML
    void onDecodeClick(MouseEvent event) {
        // If the user hasn't opened a file to decode, the user is prompted to do so first
        if (codedMessage == null || codedMessage.isEmpty()) {
            lblError.setText("Please load coded message file.");
            return;
        }
        // Determining which type of decode was selected
        index = 0;
        enigmaType = "GEnigma";
        if (rbPrimesEnigma.isSelected()) {
            index = 1;
            enigmaType = "PrimesEnigma";
        }
        else if (rbTexasEnigma.isSelected()) {
            index = 2;
            enigmaType = "TexasEnigma";
        }
        // Sets the coded message and key into the appropriate enigma object
        enigmas[index].setCodedMessage(codedMessage, key);
        // Sets the message variable to the enigma decoded message and displays it
        message = enigmas[index].getMessage();
        tfMessageInput.setText(message);
        lblError.setText("");
    }

    // Handling the user clicking the encode button
    @FXML
    void onEncodeClick(MouseEvent event) {
        // Try/catch block since this relies on user input
        try {
            // Sets the message to the message the user input
            message = tfMessageInput.getText();
            // If the message is not empty...
            if (!message.isEmpty()) {
                // Determining which type of decode was selected
                index = 0;
                enigmaType = "GEnigma";
                if (rbPrimesEnigma.isSelected()) {
                    index = 1;
                    enigmaType = "PrimesEnigma";
                }
                else if (rbTexasEnigma.isSelected()) {
                    index = 2;
                    enigmaType = "TexasEnigma";
                }
                // Sets the message and the key (if the user selected to use a provided key), or sets the message and auto generates a key
                if (rbFixedKey.isSelected()) {
                    key = Integer.parseInt(tfKeyInput.getText());
                    enigmas[index].setMessage(message, key);
                } else {
                    enigmas[index].setMessage(message);
                    key = enigmas[index].getKey();
                }
                // Sets the key and encoded message values (calculated by the enigma object) into their fields
                tfKey.setText(String.valueOf(enigmas[index].getKey()));
                codedMessage = enigmas[index].getCodedMessage();
                tfCodedMessage.setText(codedMessage);
                lblError.setText("");
            // If the message is empty...
            } else {
                // Returns an error message to the user and resets text fields
                lblError.setText("Please enter a valid message and/or key.");
                tfCodedMessage.setText("");
                tfKey.setText("");
                // Resetting this value so clicking the decode button doesn't have confusing output
                codedMessage = "";
            }
            // Handling input errors (empty fields, not putting a number for the key)
        } catch (Exception e) {
            lblError.setText("Please enter a valid message and/or key.");
            tfCodedMessage.setText("");
            tfKey.setText("");
            codedMessage = "";
        }
    }

    // Handling the user clicking the open button in the file menu
    @FXML
    void onOpenClick(ActionEvent event) {
        // Clearing any messages prior to opening a file
        tfMessageInput.clear();
        // Creating a file chooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Open a coded message and key in a file.");
        // Setting extension filter (only .txt files)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        // Showing open file dialog
        File file = fileChooser.showOpenDialog(null);
        // If a file is chosen...
        if (file != null) {
            try {
                // Creating filename from path
                String filename = file.getCanonicalPath();
                // Creating a file from filename
                File myFile = new File(filename);
                // Creating a scanner to read the file
                Scanner inputFile = new Scanner(myFile);
                // Scanning the lines for the coded message and the key, and putting them in the relevant text fields.
                codedMessage = inputFile.nextLine();
                key = Integer.parseInt(inputFile.nextLine());
                //  Getting the index and selecting the appropriate radio button
                index = inputFile.nextInt();
                switch (index) {
                    case 0:
                        rbGEnigma.setSelected(true);
                        enigmaType = "GEnigma";
                        break;
                    case 1:
                        rbPrimesEnigma.setSelected(true);
                        enigmaType = "PrimesEnigma";
                        break;
                    case 2:
                        rbTexasEnigma.setSelected(true);
                        enigmaType = "TexasEnigma";
                        break;
                }
                tfCodedMessage.setText(codedMessage);
                tfKey.setText(String.valueOf(key));
                // Closing the file
                inputFile.close();
                // Logging any errors
            } catch (IOException ex) {
                Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Handling the user clicking the save button
    @FXML
    void onSaveClick(ActionEvent event) {
        // Assigning the appropriate enigma based on the selected radio button
        index = 0;
        enigmaType = "GEnigma";
        if (rbPrimesEnigma.isSelected()) {
            index = 1;
            enigmaType = "PrimesEnigma";
        }
        if (rbTexasEnigma.isSelected()) {
            index = 2;
            enigmaType = "TexasEnigma";
        }
        // Creating a file chooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Save a coded message in a file.");
        // Setting extension filter (only .txt files)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        // Showing the save file dialog
        File file = fileChooser.showSaveDialog(null);
        // If the user saves a file...
        if (file != null) {
            // Creating an output file
            PrintWriter outputFile = null;
            try {
                // Getting path and assigning it to the output file
                String filename = file.getCanonicalPath();
                outputFile = new PrintWriter(filename);
                // Printing the coded message on one line, the key on the next, and the enigma type on the last
                outputFile.println(enigmas[index].getCodedMessage());
                outputFile.println(enigmas[index].getKey());
                outputFile.println(index);
                // Closing the file
                outputFile.close();
                // Logging any errors
            } catch (IOException ex) {
                Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
