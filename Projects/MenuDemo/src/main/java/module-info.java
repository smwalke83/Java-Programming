module com.cis2235.menudemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.cis2235.menudemo to javafx.fxml;
    exports com.cis2235.menudemo;
}