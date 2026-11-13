module com.cis2235.walkerp5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.naming;
    requires java.desktop;


    opens com.cis2235.walkerp5 to javafx.fxml;
    exports com.cis2235.walkerp5;
}