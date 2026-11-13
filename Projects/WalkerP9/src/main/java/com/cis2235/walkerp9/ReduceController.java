// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: ReduceController.java

package com.cis2235.walkerp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

// Controller for the reduce quiz window
public class ReduceController {
    // Contains a reduce grade object and a reference to the main controller window (used to call a method on submit click)
    private Grade reduce;
    private MainController controller;

    // Sets the grade object, called when creating the window
    public void setGrade(Grade reduce) {
        this.reduce = reduce;
    }

    // Sets the main controller object, called when creating the window
    public void setMainController(MainController controller) {
        this.controller = controller;
    }

    // Submit button
    @FXML
    private Button btnSubmit;

    // 10 checkboxes for the quiz prompts
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
        // Sets the user's quiz score to zero
        reduce.setScore(0);
        // Increments the score by 1 for each box checked
        if (cbOne.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbTwo.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbThree.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbFour.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbFive.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbSix.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbSeven.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbEight.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbNine.isSelected()) {
            reduce.addToScore(1);
        }
        if (cbTen.isSelected()) {
            reduce.addToScore(1);
        }
        // Sets the result in the main controller
        this.controller.setReduceResult(reduce.toString());
        // Closes this window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    // Sets the checkbox text properties to the quiz prompts
    public void setLabels() {
        if (reduce.getPrompts().length == 10) {
            cbOne.setText(reduce.getPrompts()[0]);
            cbTwo.setText(reduce.getPrompts()[1]);
            cbThree.setText(reduce.getPrompts()[2]);
            cbFour.setText(reduce.getPrompts()[3]);
            cbFive.setText(reduce.getPrompts()[4]);
            cbSix.setText(reduce.getPrompts()[5]);
            cbSeven.setText(reduce.getPrompts()[6]);
            cbEight.setText(reduce.getPrompts()[7]);
            cbNine.setText(reduce.getPrompts()[8]);
            cbTen.setText(reduce.getPrompts()[9]);
        }
    }
}

