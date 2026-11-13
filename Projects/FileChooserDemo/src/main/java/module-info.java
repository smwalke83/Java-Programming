module com.cis2235.filechooserdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.cis2235.filechooserdemo to javafx.fxml;
    exports com.cis2235.filechooserdemo;
}