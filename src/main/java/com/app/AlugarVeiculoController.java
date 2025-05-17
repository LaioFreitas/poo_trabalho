package com.app;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.Veiculo;
import com.app.gui.Alerts;
import com.app.servises.Alugar;
import com.app.utils.Utils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlugarVeiculoController implements Initializable {

    private VeiculoServise service;
    
    @FXML
    private Button btVoltar;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TableView<Veiculo> tabelaVeiculosDisponiveis;    

    @FXML
    private TableColumn<Veiculo, String> collumnModelo;

    @FXML
    private TableColumn<Veiculo, String> collumnKilometragem;

    @FXML
    private TableColumn<Veiculo, String> collumnPlaca;

    @FXML
    private TableColumn<Veiculo, Veiculo> collumnAlugar;

    private ObservableList<Veiculo> obsList;

    @FXML
    public void onVoltarAction() {
        loadView("telaInicial", x -> {
            AnchorPane pane = (AnchorPane) ((VBox) x.getRoot()).getChildren().get(1);
            pane.prefHeightProperty().bind(x.heightProperty());
            pane.getProperties().put("vbox-margin", new Insets(100, 20, 20, 20));

        });
        
    }

    public void searchVeiculo() {
    
        txtPesquisa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("miauu");
                List<Veiculo> list = obsList.stream().filter((var veiculo) -> newValue.isEmpty() 
                || newValue.isBlank() || newValue == null || veiculo.getModelo().toLowerCase().contains(newValue.toLowerCase())).toList();
                SortedList<Veiculo> sortedList = new SortedList<>(FXCollections.observableArrayList(list));
                sortedList.comparatorProperty().bind(tabelaVeiculosDisponiveis.comparatorProperty());
                tabelaVeiculosDisponiveis.setItems(sortedList);
                txtPesquisa.textProperty().removeListener(this);
            }
        }); 
        // {
        //     System.out.println("miauu");

        //     List<Veiculo> list = obsList.stream().filter((var veiculo) -> newValue.isEmpty() 
        //     || newValue.isBlank() || newValue == null || veiculo.getModelo().toLowerCase().contains(newValue.toLowerCase())).toList();
        //     SortedList<Veiculo> sortedList = new SortedList<>(FXCollections.observableArrayList(list));
        //     sortedList.comparatorProperty().bind(tabelaVeiculosDisponiveis.comparatorProperty());
        //     tabelaVeiculosDisponiveis.setItems(sortedList);        
        //     txtPesquisa.textProperty().removeListener(this);
        // });
    }

    public EventHandler<KeyEvent> searchVeiculo2() {
        EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    txtPesquisa.textProperty().addListener((_, _, newValue) -> {
    
                        List<Veiculo> list = obsList.stream().filter((var veiculo) -> newValue.isEmpty() 
                        || newValue.isBlank() || newValue == null || veiculo.getModelo().toLowerCase().contains(newValue.toLowerCase())).toList();
                        SortedList<Veiculo> sortedList = new SortedList<>(FXCollections.observableArrayList(list));
                        sortedList.comparatorProperty().bind(tabelaVeiculosDisponiveis.comparatorProperty());
                        tabelaVeiculosDisponiveis.setItems(sortedList);
                    });
                }
            }
        };
        return event;
    }
    
    private void loadView(String absoluteName, Consumer<Scene> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName + ".fxml"));
            Parent p = loader.load();
            App.setRoot(p);
            initializingAction.accept(p.getScene());
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
        // txtPesquisa.setOnKeyPressed(event -> {
        //     System.out.println(event.getCode());
        //     if (event.getCode() == KeyCode.ENTER) {
        //         searchVeiculo();
        //         event.consume();
        //     }
        // });
        // txtPesquisa.setOnAction(e -> {searchVeiculo();});
        // txtPesquisa.setOnKeyPressed(searchVeiculo2());
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
       
        List<Veiculo> list = service.findAllDisponiveis();
        obsList = FXCollections.observableArrayList(list);
        tabelaVeiculosDisponiveis.setItems(obsList);
        initEditButtons();
    }


    private void creatDialogFormAlugar(Veiculo veiculo, String absoluteName, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formAlugarVeiculo.fxml"));
            Pane pane = loader.load();
            FormAlugarVeiculoController controller = loader.getController();
            controller.setVeiculo(veiculo);
            controller.setService(new VeiculoServise());
            controller.setCliente(new Cliente());
            

        
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Alugar Veiculo");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
            
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
        
    }

    private void initEditButtons() {
        collumnAlugar.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        collumnAlugar.setCellFactory(param -> new TableCell<Veiculo, Veiculo>() {
            private final Button button = new Button("Alugar");

            @Override
            protected void updateItem(Veiculo obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                    event -> creatDialogFormAlugar(obj, "formAlugarVeiculo.fxml", Utils.currentStage(event))
                );
            }
        });
    }
    
    public TextField getTxtPesquisa() {
        return txtPesquisa;
    }




}
