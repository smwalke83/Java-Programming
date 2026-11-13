package com.cis2235.walkerp7;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

// Another controller class for another window. This window is called when the user clicks "about enigma"
public class AboutController {

    // A text area to display the summary
    @FXML
    private TextArea taAbout;

    // Initialize method
    @FXML
    private void initialize() {
        // Creating a text string to contain the summary. If there is an unexpected error, the initial text is used.
        String text = "An error occurred.";
        // Using a try-with-resources statement. This means that no matter what happens, the file will be closed at the end w/o a finally block
        // Creating an input stream from the about file
        try (InputStream input = getClass().getResourceAsStream("/about.txt")) {
            // If the file isn't found...
            if (input == null) {
                text = "Could not find file: about.txt";
                return;
            }
            // Otherwise, the contents are read and saved to the text variable
            text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        taAbout.setText(text);
    }
}

