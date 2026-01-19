module com.mycompany.coladoubleefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.coladoubleefx.controller to javafx.fxml;
    exports com.mycompany.coladoubleefx;
    exports com.mycompany.coladoubleefx.controller;
    exports com.mycompany.coladoubleefx.model;
    exports com.mycompany.coladoubleefx.view;
}
