// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// File: MainController.java

package com.cis2235.walkerp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

// Main Controller controls the main window
public class MainController {
    // Three grade objects - one for each quiz
    private Grade reduce;
    private Grade reuse;
    private Grade recycle;

    // Sets a string into the reduce text area
    public void setReduceResult(String result) {
        taReduce.setText(result);
    }

    // Sets a string into the reuse text area
    public void setReuseResult(String result) {
        taReuse.setText(result);
    }

    // Sets a string into the recycle text area
    public void setRecycleResult(String result) {
        taRecycle.setText(result);
    }

    // Initialize method
    @FXML
    private void initialize() {
        // Initialize the reduce grade object and set the quiz prompts (each quiz needs 10 prompts)
        reduce = new Grade();
        String[] reducePrompts = {"I employ reusable cloth bags when shopping.",
                "I buy in bulk to reduce packaging.",
                "I avoid plastic cups/straws/bottles/cutlery/etc.",
                "I plan my grocery purchases to reduce spoilage.",
                "I turn off electronics when not using them.",
                "I make an effort to take short showers.",
                "I turn off the tap while brushing my teeth.",
                "I only replace things when truly necessary.",
                "I turn off my irrigation when it rains.",
                "I use natural cooling/heating options if possible."
        };
        reduce.setPrompts(reducePrompts);
        // Initialize the reuse grade object and set the quiz prompts (each quiz needs 10 prompts)
        reuse = new Grade();
        String[] reusePrompts = {"I reuse plastic grocery bags.",
                "I reuse grocery containers like jars or tubs.",
                "I use old clothing as rags/bags/etc.",
                "I save and reuse shipping and storage boxes.",
                "I use old newspaper as gift wrap.",
                "I buy used items whenever possible.",
                "I donate unused but usable items.",
                "I use recycled paper/plastic products.",
                "I repurpose old building materials when possible.",
                "I repurpose waste into art."
        };
        reuse.setPrompts(reusePrompts);
        // Initialize the recycle grade object and set the quiz prompts (each quiz needs 10 prompts)
        recycle = new Grade();
        String[] recyclePrompts = {"I recycle glass.",
                "I recycle plastic.",
                "I recycle paper.",
                "I recycle styrofoam.",
                "I recycle metals.",
                "I recycle electronics.",
                "I recycle cardboard.",
                "I recycle furniture.",
                "I recycle appliances.",
                "I recycle (compost) food waste."
        };
        recycle.setPrompts(recyclePrompts);
    }

    // A button for each quiz
    @FXML
    private Button btnRecycle;

    @FXML
    private Button btnReduce;

    @FXML
    private Button btnReuse;

    // Text areas for quiz results
    @FXML
    private TextArea taRecycle;

    @FXML
    private TextArea taReduce;

    @FXML
    private TextArea taReuse;

    // Handling the user clicking recycle - open the recycle quiz and pass the recycle object
    @FXML
    void onRecycleClick(ActionEvent event) {
        try {
            // Create loader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("recycle-window.fxml"));
            Parent root = loader.load();
            // Create controller object to call method to set the grade object and prompts
            RecycleController controller = loader.getController();
            controller.setGrade(recycle);
            controller.setLabels();
            // Also passes a reference to the main controller for setting the resulting data from the reduceController
            controller.setMainController(this);
            // Show scene in new window
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Recycle Quiz");
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // Handling the user clicking reduce - open the reduce quiz and pass the reduce object
    @FXML
    void onReduceClick(ActionEvent event) {
        try {
            // open reduce quiz and pass reduce object
            // Create loader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reduce-window.fxml"));
            Parent root = loader.load();
            // Create controller object to call method to set the grade object and prompts
            ReduceController controller = loader.getController();
            controller.setGrade(reduce);
            controller.setLabels();
            // Also passes a reference to the main controller for setting the resulting data from the reduceController
            controller.setMainController(this);
            // Show scene in new window
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Reduce Quiz");
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // Handling the user clicking reuse - open the reuse quiz and pass the reuse object
    @FXML
    void onReuseClick(ActionEvent event) {
        try {
            // open reuse quiz and pass reduce object
            // Create loader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reuse-window.fxml"));
            Parent root = loader.load();
            // Create controller object to call method to set the grade object and prompts
            ReuseController controller = loader.getController();
            controller.setGrade(reuse);
            controller.setLabels();
            // Also passes a reference to the main controller for setting the resulting data from the reduceController
            controller.setMainController(this);
            // Show scene in new window
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Reuse Quiz");
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
