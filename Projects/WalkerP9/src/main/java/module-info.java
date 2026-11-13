module com.cis2235.walkerp9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.walkerp9 to javafx.fxml;
    exports com.cis2235.walkerp9;
}