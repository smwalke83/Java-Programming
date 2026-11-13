// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: MainApplication.java

package com.cis2235.walkerp9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Main Application class launches the application
public class MainApplication extends Application {
    @Override
    // Creates the starting window
    public void start(Stage stage) throws IOException {
        // Creating the launcher for main window
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-window.fxml"));
        // Setting dimensions and title, staging, and displaying the window
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Scott Walker - Program 9 Sustainability App");
        stage.setScene(scene);
        stage.show();
    }
}
