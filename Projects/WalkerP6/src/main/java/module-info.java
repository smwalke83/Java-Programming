module com.cis2235.walkerp6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.walkerp6 to javafx.fxml;
    exports com.cis2235.walkerp6;
}