package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
        VBox vbox = fxmlLoader.load();
        scene = new Scene(vbox);
        AnchorPane achor = (AnchorPane) ((VBox) scene.getRoot()).getChildren().get(1);
        // achor.getStyleClass().add("vbox-com-contorno");
        // achor.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        achor.prefHeightProperty().bind(scene.getWindow().heightProperty());
        achor.getProperties().put("vbox-margin", new Insets(100, 20, 20, 20));
    }

    static void setRoot(Parent p) throws IOException {
        Parent root = p;
        scene.setRoot(root);
    }
    
    public static void main(String[] args) {
        launch();
    }


    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     fxmlLoader.getController();
    //     return fxmlLoader.load();
    // }

    public static Scene getMainScene() {
        return scene;
    }

}