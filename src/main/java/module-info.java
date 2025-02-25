module com.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.app to javafx.fxml;
    exports com.app;
    exports com.app.entities;
    exports com.app.data.service;
    exports com.app.enums;
}
