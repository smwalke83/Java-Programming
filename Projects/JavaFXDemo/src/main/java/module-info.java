module com.cis2235.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.cis2235.javafxdemo to javafx.fxml;
    exports com.cis2235.javafxdemo;
}