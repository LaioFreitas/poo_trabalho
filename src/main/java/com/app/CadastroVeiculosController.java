package com.app;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.app.data.service.VeiculoServise;
import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.utils.Utils;
import com.app.veiculos.Carro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroVeiculosController implements Initializable {

    private Veiculo entity;

    private VeiculoServise service;
    
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
    private ComboBox<Status> comboBoxStatus;

    private ObservableList<Status> obsList;

    @FXML
    private ComboBox<Veiculo> comboBoxVeiculo;

    public void setVeiculo(Veiculo entity) {
        this.entity = entity;
    }

    public void setVeiculoServise(VeiculoServise service) {
        this.service = service;
    }

    @FXML
    public void onComboBoxStatusAction() {
        Status status = comboBoxStatus.getValue();

    }

    @FXML
    public void onBtSalvarAction(ActionEvent event) {
        entity = getFormData();
        service.save(entity);
        Utils.currentStage(event).close();
    } 

    private Veiculo getFormData() {
        Locale.setDefault(Locale.US);
        Veiculo obj;

        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String chassi = txtChassi.getText();
        Double kilometragem = Double.parseDouble(txtKilometragem.getText());
        Status status = comboBoxStatus.getSelectionModel().getSelectedItem();

        obj = new Carro(placa, modelo, chassi, kilometragem, status);
        // obj = new Carro("miau", "miau", "miau", 1.0, Status.DISPONIVEL);

       return obj;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        List<Status> list = Arrays.asList(Status.values());
        System.out.println(list.get(0));
        obsList = FXCollections.observableArrayList(list);
        comboBoxStatus.setItems(obsList); 

    }

}
