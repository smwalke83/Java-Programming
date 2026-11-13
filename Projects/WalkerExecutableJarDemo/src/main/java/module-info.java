module com.cis2235.walkerexecutablejardemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.walkerexecutablejardemo to javafx.fxml;
    exports com.cis2235.walkerexecutablejardemo;
}