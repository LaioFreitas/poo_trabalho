package com.app;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.app.data.exceptions.ValidationExeception;
import com.app.data.service.VeiculoServise;
import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.gui.Alerts;
import com.app.utils.Constraints;
import com.app.utils.Utils;
import com.app.veiculos.Carro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    private Label labelErrorPlaca;

    @FXML
    private Label labelErrorModelo;

    @FXML
    private Label labelErrorChassi;

    @FXML
    private Label labelErrorKilometragem;

    @FXML
    private Label labelErrorStatus;

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

    }

    @FXML
    public void onBtSalvarAction(ActionEvent event) {
        try {
            
            entity = getFormData();
            service.save(entity);
            Utils.currentStage(event).close();
            Alerts.showAlert("cadastro realizado", null, "veiculo cadastrado com sucesso", AlertType.INFORMATION);
        }
        catch (ValidationExeception e) {
            setErrorMessage(e.getErrors());
        }
    } 
    @FXML
    public void onBtCancelAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    private Veiculo getFormData() {
        Locale.setDefault(Locale.US);
        Veiculo obj;
        ValidationExeception exeception = new ValidationExeception("Erro de validação");

        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String chassi = txtChassi.getText();
        Double kilometragem = Utils.tryParseToDouble(txtKilometragem.getText());
        Status status = comboBoxStatus.getSelectionModel().getSelectedItem();

        if (placa == null || placa.trim().equals("")) {
            exeception.addError("placa", "Campo não pode ser vazio");
        }
        if (modelo == null || modelo.trim().equals("")) {
            exeception.addError("modelo", "Campo não pode ser vazio");
        }
        if (chassi == null || chassi.trim().equals("")) {
            exeception.addError("chassi", "Campo não pode ser vazio");
        }
        if (kilometragem == null || kilometragem < 0) {
            exeception.addError("kilometragem", "Campo não pode ser vazio");
        }
        if (status == null) {
            exeception.addError("status", "Campo não pode ser vazio");
        }
        if (exeception.getErrors().size() > 0) {
            throw exeception;
        }

        obj = new Carro(placa, modelo, chassi, kilometragem, status);
        // obj = new Carro("miau", "miau", "miau", 1.0, Status.DISPONIVEL);

       return obj;
    }

    private void setErrorMessage(Map<String, String> errors) {

        Set<String> fields = errors.keySet();

        if (fields.contains("placa")) {
            labelErrorPlaca.setText(errors.get("placa"));
        }
        if (fields.contains("modelo")) {
            labelErrorModelo.setText(errors.get("modelo"));
        }
        if (fields.contains("chassi")) {
            labelErrorChassi.setText(errors.get("chassi"));
        }
        if (fields.contains("kilometragem")) {
            labelErrorKilometragem.setText(errors.get("kilometragem"));
        }
        if (fields.contains("status")) {
            labelErrorStatus.setText(errors.get("status"));
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Constraints.setTextFieldMaxLength(txtPlaca, 7);
        Constraints.setTextFieldDouble(txtKilometragem);
        
        List<Status> list = Arrays.asList(Status.values());
        System.out.println(list.get(0));
        obsList = FXCollections.observableArrayList(list);
        comboBoxStatus.setItems(obsList); 

    }

}
