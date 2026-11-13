// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File Name: HelloApplication

package com.cis2235.walkerp5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// application class, called from the launcher
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Scott Walker - Program 5 - Databases");
        stage.setScene(scene);
        stage.show();
    }
}
