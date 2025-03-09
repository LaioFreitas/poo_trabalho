package com.app;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.Veiculo;
import com.app.servises.Alugar;
import com.app.utils.Utils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DevolverController implements Initializable {

    private VeiculoServise servise;

    
    
    private ObservableList<Alugar> obsList;
    @FXML
    private TableView<Alugar> tableView;
    
    @FXML 
    private TableColumn<Alugar, Cliente> tableCollumnCliente;
    
    @FXML
    private TableColumn<Alugar, Veiculo> tableCollumnModelo;
    
    @FXML
    private TableColumn<Alugar, Veiculo> tableCollumnPlaca;
    
    @FXML
    private TableColumn<Alugar, Alugar> tableCollumnDevolver;

    @FXML
    private Button btVoltar;
    
    public VeiculoServise getServise() {
        return servise;
    }

    public void setServise(VeiculoServise servise) {
        this.servise = servise;
    }

    public void updateTableView() {
        if (servise == null) {
            throw new IllegalStateException("servise has null");
        }       


        List<Alugar> list = servise.findAllAlugados();
        obsList = FXCollections.observableArrayList(list);
        tableView.setItems(obsList); 
        //initEditButtons();
    }    


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
        tableCollumnCliente.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        tableCollumnModelo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        tableCollumnPlaca.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        tableCollumnDevolver.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

        Stage stage = (Stage) App.getMainScene().getWindow();
        tableView.prefHeightProperty().bind(stage.heightProperty());

        Callback<TableColumn<Alugar, Cliente>, TableCell<Alugar, Cliente>> factory = lv -> new TableCell<Alugar, Cliente>() {

            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
                setAlignment(Pos.CENTER_LEFT);
            }
        };
        Callback<TableColumn<Alugar, Veiculo>, TableCell<Alugar, Veiculo>> factory2 = param -> new TableCell<Alugar, Veiculo>() {

            @Override            
            protected void updateItem(Veiculo item, boolean empty) {
                //this.setTextAlignment(TextAlignment.CENTER);
                super.updateItem(item, empty);
                setText(empty ? "" : item.getModelo());
                // this.textAlignmentProperty().bind(TextAlignment.CENTER);
                System.out.println(this.textProperty());
                // textAlignmentProperty().bind();
                setAlignment(Pos.CENTER_LEFT);
            }
        };
        Callback<TableColumn<Alugar, Alugar>, TableCell<Alugar, Alugar>> factory3 = param -> new TableCell<Alugar, Alugar>() {

            private final Button button = new Button("Devolver");
            @Override 
            protected void updateItem(Alugar item, boolean empty) {
                
                param.setPrefWidth(80);
                
                super.updateItem(item, empty);
                if (item == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
            }
        };

        tableCollumnCliente.setCellFactory(factory);
        tableCollumnModelo.setCellFactory(factory2);
        tableCollumnPlaca.setCellFactory(factory2);
        tableCollumnDevolver.setCellFactory(factory3);
    }    
}
