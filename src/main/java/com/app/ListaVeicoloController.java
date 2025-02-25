package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.app.entities.Veiculo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml"));
            App.setRoot(loader.load());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Stage stage = (Stage) App.getMainScene().getWindow();
        tableViewVeiculo.prefHeightProperty().bind(stage.heightProperty());
    }

}
