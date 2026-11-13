package com.cis2235.walkerp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;


// Controller class, has a PartyData object that will contain the data, as well as various controls
public class HelloController {

    private PartyData party;

    // Groups for the radio buttons
    @FXML
    private ToggleGroup DrinkBrand;

    @FXML
    private ToggleGroup SnackBrand;

    // Save and Summary buttons
    @FXML
    private Button btnSave;

    @FXML
    private Button btnSummary;

    // Checkboxes for boolean values
    @FXML
    private CheckBox cbAlcohol;

    @FXML
    private CheckBox cbBouncer;

    @FXML
    private CheckBox cbDJ;

    @FXML
    private CheckBox cbKidsWelcome;

    @FXML
    private CheckBox cbPetsWelcome;

    @FXML
    private CheckBox cbPlusOne;

    // Combobox to select theme. An observable list is created from the themes array in the party data class
    @FXML
    private ComboBox<String> cbxTheme;

    private ObservableList<String> cbList = FXCollections.observableArrayList(PartyData.themes);

    // Initializes the combo box with the themes list and sets a starting value
    @FXML
    private void initialize() {
        cbxTheme.setValue("70s");
        cbxTheme.setItems(cbList);
    }

    // Labels for controls
    @FXML
    private Label lblAddress;

    @FXML
    private Label lblDrinkBrand;

    @FXML
    private Label lblHeader;

    @FXML
    private Label lblLength;

    @FXML
    private Label lblNumGuests;

    @FXML
    private Label lblOther;

    @FXML
    private Label lblSnackBrand;

    @FXML
    private Label lblTheme;

    // Radio Buttons
    @FXML
    private RadioButton rbCoke;

    @FXML
    private RadioButton rbLays;

    @FXML
    private RadioButton rbOffBrandDrink;

    @FXML
    private RadioButton rbOffBrandSnack;

    @FXML
    private RadioButton rbPepsi;

    @FXML
    private RadioButton rbRuffles;

    // Slider for the length of the party
    @FXML
    private Slider sliderHours;

    // Text boxes for user input and a text area for the party summary
    @FXML
    private TextField tbxNumGuests;

    @FXML
    private TextArea tfSummary;

    @FXML
    private TextField txbAddress;

    // Handling clicking of the Save button
    @FXML
    void onSaveClick(MouseEvent event) {
        try
        {
            // Collecting values from the various controls
            String theme = cbxTheme.getValue();
            int numGuests = Integer.parseInt(tbxNumGuests.getText());
            String address = txbAddress.getText();
            int numHours = (int) sliderHours.getValue();
            String snackBrand;
            if (rbLays.isSelected()) {
                snackBrand = "Lays";
            }
            else if (rbRuffles.isSelected()) {
                snackBrand = "Ruffles";
            }
            else
            {
                snackBrand = "Off Brand";
            }
            String drinkBrand;
            if (rbCoke.isSelected()) {
                drinkBrand = "Coke";
            }
            else if (rbPepsi.isSelected()) {
                drinkBrand = "Pepsi";
            }
            else {
                drinkBrand = "Off Brand";
            }
            boolean dj = cbDJ.isSelected();
            boolean bouncer = cbBouncer.isSelected();
            boolean alcohol = cbAlcohol.isSelected();
            boolean kids = cbKidsWelcome.isSelected();
            boolean pets = cbPetsWelcome.isSelected();
            boolean plusOne = cbPlusOne.isSelected();

            // Creating a PartyData object from the user inputs
            party = new PartyData(theme, numGuests, address, numHours, snackBrand, drinkBrand, dj, bouncer, alcohol, kids, pets, plusOne);

            // Creating a file chooser and a starting directory
            FileChooser fileChooser = new FileChooser();
            File currentDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setInitialDirectory(currentDirectory);

            // Starting a save dialog - if the user provides a valid filename, then the filepath != null and the file is written
            File file = fileChooser.showSaveDialog(null);
            if(file != null)
            {
                party.WriteFile(file);
            }
        }
        // If there is an exception it is reported to the user through summary text field
        catch (NumberFormatException ex) {
            tfSummary.setText("Error: Number of guests must be a whole number.");
        }
        catch (Exception ex) {
            tfSummary.setText("Error: " + ex.getClass().getSimpleName() + " " + ex.getMessage());
        }
    }

    // Makes text bigger when the mouse hovers over the button
    @FXML
    void onSaveEntered(MouseEvent event) {
        btnSave.setStyle("-fx-font-size: 18px;");
    }

    // Makes text smaller when the mouse leaves the button area
    @FXML
    void onSaveExited(MouseEvent event) {
        btnSave.setStyle("-fx-font-size: 12px;");
    }

    // Handling clicking the summary button
    @FXML
    void onSummaryClick(MouseEvent event) {
        try
        {
            // Assigns the values from the controls to variables, then instantiates the PartyData object with those values
            String theme = cbxTheme.getValue();
            int numGuests = Integer.parseInt(tbxNumGuests.getText());
            String address = txbAddress.getText();
            int numHours = (int) sliderHours.getValue();
            String snackBrand;
            if (rbLays.isSelected()) {
                snackBrand = "Lays";
            }
            else if (rbRuffles.isSelected()) {
                snackBrand = "Ruffles";
            }
            else
            {
                snackBrand = "Off Brand";
            }
            String drinkBrand;
            if (rbCoke.isSelected()) {
                drinkBrand = "Coke";
            }
            else if (rbPepsi.isSelected()) {
                drinkBrand = "Pepsi";
            }
            else {
                drinkBrand = "Off Brand";
            }
            boolean dj = cbDJ.isSelected();
            boolean bouncer = cbBouncer.isSelected();
            boolean alcohol = cbAlcohol.isSelected();
            boolean kids = cbKidsWelcome.isSelected();
            boolean pets = cbPetsWelcome.isSelected();
            boolean plusOne = cbPlusOne.isSelected();
            party = new PartyData(theme, numGuests, address, numHours, snackBrand, drinkBrand, dj, bouncer, alcohol, kids, pets, plusOne);

            // Prints party.toString() to the Summary text field
            tfSummary.setText(party.toString());
        }
        // Reports exceptions to the user
        catch (NumberFormatException ex) {
            tfSummary.setText("Error: Number of guests must be a whole number.");
        }
        catch (Exception ex) {
            tfSummary.setText("Error: " + ex.getClass().getSimpleName() + " " + ex.getMessage());
        }
    }

    // Makes text bigger when the mouse hovers over the button
    @FXML
    void onSummaryEntered(MouseEvent event) {
        btnSummary.setStyle("-fx-font-size: 18px;");
    }

    // Makes text smaller when the mouse hovers over the button
    @FXML
    void onSummaryExited(MouseEvent event) {
        btnSummary.setStyle("-fx-font-size: 12px;");
    }

}

