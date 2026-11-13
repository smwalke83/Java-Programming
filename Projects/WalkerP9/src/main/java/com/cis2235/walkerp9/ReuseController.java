// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: ReuseController.java

package com.cis2235.walkerp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

// Controller for the reuse quiz window
public class ReuseController {
    // Contains a reuse grade object and a reference to the main window
    private Grade reuse;
    private MainController controller;

    // Used to set the grade object, called when the window is created to pass the object between windows
    public void setGrade(Grade reuse) {
        this.reuse = reuse;
    }

    // Used to set the main controller, called when the window is created to pass the object between windows
    public void setMainController(MainController controller) {
        this.controller = controller;
    }

    // Submit button
    @FXML
    private Button btnSubmit;

    // 10 checkboxes to display the quiz prompts
    @FXML
    private CheckBox cbEight;

    @FXML
    private CheckBox cbFive;

    @FXML
    private CheckBox cbFour;

    @FXML
    private CheckBox cbNine;

    @FXML
    private CheckBox cbOne;

    @FXML
    private CheckBox cbSeven;

    @FXML
    private CheckBox cbSix;

    @FXML
    private CheckBox cbTen;

    @FXML
    private CheckBox cbThree;

    @FXML
    private CheckBox cbTwo;

    // Handling the user clicking submit
    @FXML
    void onSubmitClick(ActionEvent event) {
        // Setting the user's quiz score to zero
        reuse.setScore(0);
        // Incrementing the user's score for each box checked
        if (cbOne.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbTwo.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbThree.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbFour.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbFive.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbSix.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbSeven.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbEight.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbNine.isSelected()) {
            reuse.addToScore(1);
        }
        if (cbTen.isSelected()) {
            reuse.addToScore(1);
        }
        // Setting the results in the main window
        this.controller.setReuseResult(reuse.toString());
        // Closing this window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    // Sets the text value of each checkbox to the quiz prompts
    public void setLabels() {
        if (reuse.getPrompts().length == 10) {
            cbOne.setText(reuse.getPrompts()[0]);
            cbTwo.setText(reuse.getPrompts()[1]);
            cbThree.setText(reuse.getPrompts()[2]);
            cbFour.setText(reuse.getPrompts()[3]);
            cbFive.setText(reuse.getPrompts()[4]);
            cbSix.setText(reuse.getPrompts()[5]);
            cbSeven.setText(reuse.getPrompts()[6]);
            cbEight.setText(reuse.getPrompts()[7]);
            cbNine.setText(reuse.getPrompts()[8]);
            cbTen.setText(reuse.getPrompts()[9]);
        }
    }
}
