package com.cis2235.walkermultiplewindowdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// Controller class for second scene
public class SecondController {
    // Class variables for JavaFX
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Label definition
    @FXML
    private Label lblNumber;

    // Method to switch to a new window and pass a message over
    public void switchToHelloView(ActionEvent event) {
        try {
            // getClass - gets the class object representing the current class
            // getResource finds/loads the hello-view file
            // FXMLLoader reads/interprets the fxml, sets up the window, and connects it to the controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            root = loader.load();
            // Gets the controller associated with the loader
            HelloController controller = loader.getController();
            // Uses the transferMessage method from the HelloController to set the message into the label
            controller.transferMessage("Message from SecondController");
            // (Node)event.getSource() gets the control that triggered the event as a Node
            // Then it gets the scene and the window that the control is in and casts that into a stage
            // Now stage represents the currently displayed window
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // This creates a new scene based on hello-view, sets it on the current stage, and displays it
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // Sets a number into the label
    public void transferNumber(int num) {
        lblNumber.setText("" + num);
    }
}
