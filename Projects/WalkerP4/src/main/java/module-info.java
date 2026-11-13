module com.cis2235.walkerp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.walkerp4 to javafx.fxml;
    exports com.cis2235.walkerp4;
}