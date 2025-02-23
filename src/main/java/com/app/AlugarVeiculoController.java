package com.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.app.entities.Veiculo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AlugarVeiculoController implements Initializable {

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btAlugar;

    @FXML
    private TextField txtEscolha;

    @FXML
    private TableView<Veiculo> tabelaVeiculosDisponiveis;    

    @FXML
    private TableColumn<Veiculo, Button> collumnCarro;

    @FXML
    private TableColumn<Veiculo, Button> collumnMoto;

    @FXML
    private TableColumn<Veiculo, Button> collumnCaminhao;

    @FXML
    public void onVoltarAction() {
        loadView("telaInicial");
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
