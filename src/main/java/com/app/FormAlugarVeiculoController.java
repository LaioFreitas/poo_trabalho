package com.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.Veiculo;
import com.app.servises.Alugar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormAlugarVeiculoController implements Initializable {


    private VeiculoServise service;

    private Alugar aluguel;

    private Cliente cliente;

    private Veiculo veiculo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtEstado;
    
    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtCnh;

    @FXML
    private Button btAlugar;

    @FXML Button btCancelar;

    @FXML
    public void onBtAlugarAction() {
        // try {
        //     if (cliente == null) {
        //         cliente = new Cliente();
        //     }
        //     cliente.setNome(txtNome.getText());
        //     cliente.setCpf(txtCpf.getText());
        //     cliente.setRua(txtRua.getText());
        //     cliente.setNumero(txtNumero.getText());
        //     cliente.setBairro(txtBairro.getText());
        //     cliente.setCidade(txtCidade.getText());
        //     cliente.setEstado(txtEstado.getText());
        //     cliente.setTelefone(txtTelefone.getText());
        //     cliente.setCnh(txtCnh.getText());
        //     aluguel.setCliente(cliente);
        //     aluguel.setVeiculo(veiculo);
        //     aluguel.alugar();
        //     service.saveOrUpdate(veiculo);
        //     service.saveOrUpdate(cliente);
        //     service.saveOrUpdate(aluguel);
        //     Alerts.showAlert("Aluguel", null, "Aluguel efetuado com sucesso", Alert.AlertType.INFORMATION);
        // } catch (Exception e) {
        //     Alerts.showAlert("Erro ao alugar", null, e.getMessage(), Alert.AlertType.ERROR);
        // }
        System.out.println("onBtSalvarAction");
    }

    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    public VeiculoServise getService() {
        return service;
    }

    public void setService(VeiculoServise service) {
        this.service = service;
    }

    public Alugar getAluguel() {
        return aluguel;
    }

    public void setAluguel(Alugar aluguel) {
        this.aluguel = aluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
