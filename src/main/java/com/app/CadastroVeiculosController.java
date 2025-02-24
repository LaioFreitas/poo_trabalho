package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.veiculos.Carro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroVeiculosController implements Initializable {

    private Veiculo entity;
    
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
    private ComboBox<Veiculo> comboBoxVeiculo;

    public void setVeiculo(Veiculo entity) {
        this.entity = entity;
    }

    @FXML
    public void onBtSalvarAction() {
        System.out.println("onBtSalvarAction");
    } 

    private Veiculo getFormData() {
        Veiculo obj;

        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String chassi = txtChassi.getText();
        Double kilometragem = Double.parseDouble(txtKilometragem.getText());
        Status status = Status.valueOf(txtStatus.getText());

        obj = new Carro(placa, modelo, chassi, kilometragem, status);

       return obj;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }


}
