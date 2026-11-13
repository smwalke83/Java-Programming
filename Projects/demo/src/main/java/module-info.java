module com.cis2235.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.demo to javafx.fxml;
    exports com.cis2235.demo;
}