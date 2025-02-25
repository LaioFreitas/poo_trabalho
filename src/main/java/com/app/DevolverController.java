package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.app.entities.Veiculo;
import com.app.servises.Alugar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DevolverController implements Initializable {

    private Veiculo entity;

    @FXML
    private TableView<Alugar> tableView;

    @FXML 
    private TableColumn<Alugar, String> tableCollumnCliente;

    @FXML
    private TableColumn<Alugar, String> tableCollumnModelo;

    @FXML
    private TableColumn<Alugar, String> tableCollumnPlaca;

    @FXML
    private TableColumn<Alugar, Alugar> tableCollumnDevolver;




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tableCollumnCliente.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        tableCollumnModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
        tableCollumnPlaca.setCellValueFactory(new PropertyValueFactory<>("Placa"));

        Stage stage = (Stage) App.getMainScene().getWindow();
        tableView.prefHeightProperty().bind(stage.heightProperty());
    }

}
