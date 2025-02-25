package com.app;

import java.io.IOException;
import java.net.URL;
import java.util.List;
// import java.util.Observable;
import java.util.ResourceBundle;

import com.app.data.service.VeiculoServise;
import com.app.entities.Veiculo;
import com.app.veiculos.Carro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AlugarVeiculoController implements Initializable {

    private VeiculoServise service;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btAlugar;

    @FXML
    private TextField txtEscolha;

    @FXML
    private TableView<Veiculo> tabelaVeiculosDisponiveis;    

    @FXML
    private TableColumn<Veiculo, String> collumnModelo;

    @FXML
    private TableColumn<Veiculo, String> collumnKilometragem;

    @FXML
    private TableColumn<Veiculo, String> collumnPlaca;

    private ObservableList<Veiculo> obsList;

    @FXML
    public void onVoltarAction() {
        loadView("telaInicial");
    }
    
    private void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName + ".fxml"));
            Parent p = loader.load();
            App.setRoot(p);
        }
        catch (IOException e) {
            e.printStackTrace();
     }
    }

    public void setVeiculoService(VeiculoServise service) {
        this.service = service;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        inicializaNodes();
    }

    private void inicializaNodes() {

        
        collumnModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
        collumnKilometragem.setCellValueFactory(new PropertyValueFactory<>("Kilometragem"));
        collumnPlaca.setCellValueFactory(new PropertyValueFactory<>("Placa"));

        Stage stage = (Stage) App.getMainScene().getWindow();
        tabelaVeiculosDisponiveis.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView() {
        if (service == null) {
            throw new IllegalStateException("Service was null");
        }
        System.out.println("updateTableView");
        List<Veiculo> list = service.findAllDisponiveis();
        for (Veiculo veiculo : list) {
            System.out.println(((Carro)veiculo).toCSV());
        }
        obsList = FXCollections.observableArrayList(list);
        tabelaVeiculosDisponiveis.setItems(obsList);
    }

}
