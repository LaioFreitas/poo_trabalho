package com.app;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.app.data.exceptions.ValidationExeception;
import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.Veiculo;
import com.app.gui.Alerts;
import com.app.servises.Alugar;
import com.app.utils.Constraints;
import com.app.utils.Endereco;
import com.app.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TextField txtDataDeDevolucao;

    @FXML
    private Label labelNome;
    
    @FXML
    private Label labelCpf;

    @FXML
    private Label labelRua;

    @FXML
    private Label lableNumero;

    @FXML
    private Label labelBairro;

    @FXML
    private Label labelCidade;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelCnh;

    @FXML
    private Label labelDataDeDEvolucao;

    
    @FXML
    private Button btAlugar;

    @FXML 
    private Button btCancelar;

    @FXML
    public void onBtAlugarAction(ActionEvent event) {
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
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (service == null) {
            throw new IllegalStateException("sem service");
        }
        // if (aluguel == null) {
        //     throw new IllegalStateException("Aluguel e nulo");
        // }
        try {
            cliente = getFormData();
            LocalDate date = LocalDate.parse(txtDataDeDevolucao.getText(), fmt1);

            aluguel = new Alugar(cliente, date, veiculo);
            aluguel.alugar(service); 
            Utils.currentStage(event).close();
            Alerts.showAlert("aluguel realizado", null, "veiculo alugado com sucesso", AlertType.INFORMATION);
        }
        catch (ValidationExeception e) {
            setErrorMessage(e.getErrors());
        }
    }

    @FXML
    public void onBtCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    private Cliente getFormData() {
        Cliente obj;
        ValidationExeception exeception = new ValidationExeception("Error de validacao");

        String name = txtNome.getText();
        String cpf = txtCpf.getText();
        String rua = txtRua.getText();
        Integer numero = Utils.tryParceToInteger(txtNumero.getText());
        String bairro = txtBairro.getText();
        String cidade = txtCidade.getText();
        String estado = txtEstado.getText();
        String telefone = txtTelefone.getText();
        String cnh = txtCnh.getText();
        String data = txtDataDeDevolucao.getText();

        if (name == null || name.trim().equals("")) {
            exeception.addError("nome", "Campo nao pode ser vazil");
        }
        if (cpf == null || cpf.trim().equals("")) {
            exeception.addError("cpf", "Campo nao pode ser vazil");
        }
        if (rua == null || rua.trim().equals("")) {
            exeception.addError("rua", "Campo nao pode ser vazil");
        }
        if (numero == null || numero < 0) {
            exeception.addError("numero", "Campo nao pode ser vazil");
        }
        if (bairro == null || bairro.trim().equals("")) {
            exeception.addError("bairro", "Campo nao pode ser vazil");
        }
        if (estado == null || estado.trim().equals("")) {
            exeception.addError("estado", "Campo nao pode ser vazil");
        }
        if (cidade == null || cidade.trim().equals("")) {
            exeception.addError("cidade", "Campo nao pode ser vazil");
        }
        if (telefone == null || telefone.trim().equals("")) {
            exeception.addError("telefone", "Campo nao pode ser vazil");
        }
        if (cnh == null || cnh.trim().equals("")) {
            exeception.addError("cnh", "Campo nao pode ser vazil");
        }
        if (data == null || data.trim().equals("")) {
            exeception.addError("data", "Campo nao pode ser vazil");
        }

        if (exeception.getErrors().size() > 0) {
            throw exeception;
        }

        Endereco e = (new Endereco(rua, numero, bairro, cidade, estado));
        obj = new Cliente(name, cpf, e, telefone, cnh);
        return obj;
    }

    private void setErrorMessage(Map<String, String> errors) {

        Set<String> fields = errors.keySet();

        if (fields.contains("nome")) {
            labelNome.setText(errors.get("nome"));
        }
        if (fields.contains("cpf")) {
            labelCpf.setText(errors.get("cpf"));
        }
        if (fields.contains("rua")) {
            labelRua.setText(errors.get("rua"));
        }
        if (fields.contains("numero")) {
            lableNumero.setText(errors.get("numero"));
        }
        if (fields.contains("bairro")) {
            labelBairro.setText(errors.get("bairro"));
        }
        if (fields.contains("cidade")) {
            labelCidade.setText(errors.get("cidade"));
        }
        if (fields.contains("estado")) {
            labelEstado.setText(errors.get("estado"));
        }
        if (fields.contains("telefone")) {
            labelTelefone.setText(errors.get("telefone"));
        }
        if (fields.contains("cnh")) {
            labelCnh.setText(errors.get("cnh"));
        }
        if (fields.contains("data")) {
            labelDataDeDEvolucao.setText(errors.get("data"));
        }
    }

    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Constraints.setTextFieldDataFormater(txtDataDeDevolucao);
        Constraints.setTextFieldInterger(txtNumero);
        Constraints.setTextFieldInterger(txtCpf);
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
