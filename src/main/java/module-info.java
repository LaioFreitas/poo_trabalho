module com.app {
    //requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.base;
    requires transitive javafx.controls;

    opens com.app to javafx.fxml, javafx.base, javafx.graphics;
    exports com.app;
    exports com.app.entities;
    exports com.app.data.service;
    exports com.app.enums;
    exports com.app.utils;
    exports com.app.servises;
}
