package com.cis2235.filechooserdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;

public class HelloController {

    @FXML
    private Button btnSave;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblName;

    @FXML
    private TextField tfAge;

    @FXML
    private TextField tfName;

    private DemoData data;

    @FXML
    void onActionSave(ActionEvent event) {
        String name = tfName.getText();
        data.setName(name);
        String sAge = tfAge.getText();
        int age = 1;
        if (sAge == null) {
            JOptionPane.showMessageDialog(null, "Must enter an integer.");
        } else {
            age = Integer.parseInt(sAge);
            data.setAge(age);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.setTitle("Save your data");
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("text files (*.txt)", "*txt");
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                data.writeFile(file);
            }
        }
    }

    @FXML
    void onActionMouseEntered(MouseEvent event) {
        btnSave.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
    }

    @FXML
    void onActionMouseExited(MouseEvent event) {
        btnSave.setFont(Font.font("Tahoma", FontWeight.NORMAL, 11));
    }

    @FXML
    void initialize() {
        data = new DemoData();
    }
}
