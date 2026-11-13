package com.cis2235.menudemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

// Controller class
public class HelloController {

    // Label to contain results
    @FXML
    private TextArea tfResult;

    // Handling user clicking about in the about menu
    @FXML
    void onAboutClick(ActionEvent event) {
        // Displays an about message
        String message = "Welcome to the Menu Demo! Use the file menu to view or save a text file! Saving a file writes the line 'File writing accomplished!' to that file.";
        JOptionPane.showMessageDialog(null, message);
    }

    // Handling user clicking open file in the file menu
    @FXML
    void onOpenClick(ActionEvent event) {
        // Creating the file chooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Open a Message in a File");
        // Filtering extensions to .txt files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("text files (*.text)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        // Displaying open file dialog
        File file = fileChooser.showOpenDialog(null);

        // If a file is selected...
        if (file != null) {
            // Creating filename and text variables
            String filename = null;
            StringBuilder text = new StringBuilder();
            try {
                // Getting path of selected file and assigning it to a file object
                filename = file.getCanonicalPath();
                File myFile = new File(filename);
                // Creating a scanner to read the file
                Scanner inputFile = new Scanner(myFile);
                while (inputFile.hasNextLine()) {
                    text.append(inputFile.nextLine());
                    text.append("\n");
                }
                // Displaying the text. Note that I changed the code a bit to display the entirety of the text file.
                tfResult.setText(text.toString());
            // Error handling
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Handling the user clicking save file in the file menu
    @FXML
    void onSaveClick(ActionEvent event) {
        // Creating a file chooser object
        FileChooser fileChooser = new FileChooser();
        // Creating and setting the current directory
        File currentDirectory = new File (System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(currentDirectory);
        fileChooser.setTitle("Write a Message in your File");
        // Setting extension filter for only .txt files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        // Showing save file dialog
        File file = fileChooser.showSaveDialog(null);

        // If the user saves a file...
        if (file != null) {
            // Creating an output file and filename string
            PrintWriter outputFile = null;
            String filename = null;
            try {
                // Getting the filepath for the file name
                filename = file.getCanonicalPath();
                // Initializing output file with filename, printing a line to it, and closing it
                outputFile = new PrintWriter(filename);
                outputFile.println("File writing accomplished!");
                outputFile.close();
            // Error handling
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
