// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: RecycleController.java

package com.cis2235.walkerp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

// Controller for the recycle quiz window
public class RecycleController {
    // Contains a recycle grade object and a reference to the main window controller
    private Grade recycle;
    private MainController controller;

    // Sets the grade object to be edited on submit click
    public void setGrade(Grade recycle) {
        this.recycle = recycle;
    }

    // Sets the main controller object, used to call a method on submit click
    public void setMainController(MainController controller) {
        this.controller = controller;
    }

    // Submit button
    @FXML
    private Button btnSubmit;

    // 10 checkboxes (one for each prompt)
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
        // Sets user score to zero
        recycle.setScore(0);
        // Increments user score by one for each box checked
        if (cbOne.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbTwo.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbThree.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbFour.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbFive.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbSix.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbSeven.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbEight.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbNine.isSelected()) {
            recycle.addToScore(1);
        }
        if (cbTen.isSelected()) {
            recycle.addToScore(1);
        }
        // Calls the setRecycleResult method from the main controller
        this.controller.setRecycleResult(recycle.toString());
        // Closes the current window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    // Sets the text values of the checkboxes to the assigned prompts for the recycle grade object
    public void setLabels() {
        // This program requires 10 prompts to function properly
        if (recycle.getPrompts().length == 10) {
            cbOne.setText(recycle.getPrompts()[0]);
            cbTwo.setText(recycle.getPrompts()[1]);
            cbThree.setText(recycle.getPrompts()[2]);
            cbFour.setText(recycle.getPrompts()[3]);
            cbFive.setText(recycle.getPrompts()[4]);
            cbSix.setText(recycle.getPrompts()[5]);
            cbSeven.setText(recycle.getPrompts()[6]);
            cbEight.setText(recycle.getPrompts()[7]);
            cbNine.setText(recycle.getPrompts()[8]);
            cbTen.setText(recycle.getPrompts()[9]);
        }
    }
}
