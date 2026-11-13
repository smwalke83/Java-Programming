module com.cis2235.walkerp8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.cis2235.walkerp8 to javafx.fxml;
    exports com.cis2235.walkerp8;
}