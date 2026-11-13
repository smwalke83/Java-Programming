package com.cis2235.javafxdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private ToggleGroup buttonGroup1;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Label lblCheckBox;

    @FXML
    private Label lblResults;

    @FXML
    private Label lblSlider;

    @FXML
    private RadioButton rButton1;

    @FXML
    private RadioButton rButton2;

    @FXML
    private Slider slider1;

    @FXML
    private TextField tfFirst;

    @FXML
    private TextField tfSecond;

    @FXML
    private Label lblRadio;

    @FXML
    private Label lblComboBox;


    private ObservableList<String> cbList = FXCollections.observableArrayList("I love Java", "I love C++");

    @FXML
    void handleCheckBox2Click(ActionEvent event) {
        if(checkBox2.isSelected()) {
            lblCheckBox.setText("CheckBox 2 last selected.");
        }
    }

    @FXML
    void handleCheckBox1Click(ActionEvent event) {
        if(checkBox1.isSelected()) {
            lblCheckBox.setText("CheckBox 1 last selected.");
        }
    }

    @FXML
    void handleRButton1Clicked(ActionEvent event) {
        if (rButton1.isSelected()) {
            // instructions didn't say what to do here, I just added a label to say which one is selected
            lblRadio.setText("Radio Button 1 selected.");
        }
    }

    @FXML
    void handleRButton2Clicked(ActionEvent event) {
        RadioButton selectedRB = (RadioButton) buttonGroup1.getSelectedToggle();
        String buttonText = selectedRB.getText();
        if (buttonText.equals("Radio Button 2")) {
            lblRadio.setText("Radio Button 2 selected.");
        }
    }

    @FXML
    void onActionComboBoxEvent(ActionEvent event) {
        int index = comboBox1.getSelectionModel().getSelectedIndex();
        // instructions didn't say what to do here, I just added a label to display the selection
        lblComboBox.setText("Your selection: " + cbList.get(index));
    }

    @FXML
    void onActionHandleAddButton(ActionEvent event) {
        double n1 = Double.parseDouble(tfFirst.getText());
        double n2 = Double.parseDouble(tfSecond.getText());
        double sum = n1 + n2;
        String results = n1 + " + " + n2 + " = " + sum;
        lblResults.setText(results);
    }

    @FXML
    void sliderClicked(MouseEvent event) {
        double value = slider1.getValue();
        lblSlider.setText(String.format("%.2f", value));
    }

    @FXML
    private void initialize() {
        comboBox1.setValue("I love Java");
        comboBox1.setItems(cbList);
    }
}

