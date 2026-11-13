module com.cis2235.walkermultiplewindowdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cis2235.walkermultiplewindowdemo to javafx.fxml;
    exports com.cis2235.walkermultiplewindowdemo;
}