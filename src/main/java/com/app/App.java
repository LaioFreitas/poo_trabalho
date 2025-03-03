package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("telaInicial.fxml"));
        VBox VBox = fxmlLoader.load();

        scene = new Scene(VBox);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(Parent p) throws IOException {
        Parent root = p;
        scene.setRoot(root);
    }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     fxmlLoader.getController();
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

    public static Scene getMainScene() {
        return scene;
    }

}