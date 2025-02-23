package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.app.entities.Veiculo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaVeicoloController implements Initializable {

    @FXML
    private Button rbVoltar;

    @FXML
    private TableView<Veiculo> tableViewVeiculo;

    @FXML
    private TableColumn<Veiculo, String> tableColumnCarros;

    @FXML
    private TableColumn<Veiculo, String> tableColumnMotos;

    @FXML
    private TableColumn<Veiculo, String> tableColumnCaminhoes;

    @FXML
    public void onBtVoltarAction() {
        try {
            App.setRoot("telaInicial");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

}
