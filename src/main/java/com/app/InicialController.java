package com.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class InicialController implements Initializable {

    @FXML
    private Button btALugar;

    @FXML
    private Button btListar;

    @FXML
    private MenuItem menuItemCadastrar; 


    @FXML
    public void onMenuItemCadatrarAction() {
        
    }

    @FXML
    public void onListarAction() {
        loadView("ListaVeicolos");
    }

    @FXML
    public void onALugarAction() {
        loadView("alugarVeiculo");
    }

    private void loadView(String absoluteName) {
        try {
            App.setRoot(absoluteName);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

}
