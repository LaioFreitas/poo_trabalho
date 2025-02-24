package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroVeiculosController implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtChassi;

    @FXML
    private TextField txtKilometragem;

    @FXML
    private TextField txtStatus;

    @FXML
    public void onBtSalvarAction() {
        System.out.println("onBtSalvarAction");
    } 


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }


}
