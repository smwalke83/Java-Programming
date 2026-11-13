package com.cis2235.walkermultiplewindowdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// Controller class for hello-view
public class HelloController {

    // Button and label definitions
    @FXML
    private Button btnPaper;

    @FXML
    private Label lblMessage;

    // Method to switch to a new window and pass a message to it
    public void switchToSecondScene(ActionEvent event) {
        try {
            // Creates a loader for second-scene.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("second-scene.fxml"));
            Parent root = loader.load();
            // Creates an instance of the secondController associated w/ the loader and calls the transferNumber method
            SecondController controller = loader.getController();
            controller.transferNumber(42);
            //show scene in new window
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Paper");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        // sets the old stage to the scene/window with btnPaper and closes it
        Stage oldStage = (Stage) btnPaper.getScene().getWindow();
        oldStage.close();
    }

    // Set the message into the label
    public void transferMessage(String mess) {
        lblMessage.setText(mess);
    }
}
