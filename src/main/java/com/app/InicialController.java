package com.app;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.app.data.service.VeiculoServise;
import com.app.gui.Alerts;
//import com.app.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InicialController implements Initializable {
    
    
    @FXML
    private Button btALugar;
    
    @FXML
    private Button btListar;
    
    @FXML
    private MenuItem menuItemCadastrarVeiculo; 
    
    
    @FXML
    public void onMenuItemCadatrarVeiculoAction(ActionEvent event) {
        //Stage parentStage = Utils.currentStage(event);
        createDialogForm("cadastroVeiculoForm.fxml", (Stage) App.getMainScene().getWindow());
        //loadView("cadastroVeiculoForm");
    }
    
    @FXML
    public void onListarAction() {
        loadView("ListaVeicolos", _x -> {});
    }
    
    @FXML
    public void onALugarAction() {
        loadView("alugarVeiculo", (AlugarVeiculoController controller) -> {
            controller.setVeiculoService(new VeiculoServise());
            controller.updateTableView();
        });
    }
    
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName + ".fxml"));
            Parent scene = loader.load();
            App.setRoot(scene);
            T controller = loader.getController();
            
            initializingAction.accept(controller);
            // Scene scene = App.getMainScene();
            // ScrollPane scrolllPane = ((ScrollPane) scene.getRoot());
            // scrolllPane.setFitToHeight(true);
            // scrolllPane.setFitToWidth(true);
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    private void createDialogForm(String absoluteName, Stage parentStage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();
            
            // DepartmentFormController controller = loader.getController();
            CadastroVeiculosController controller = loader.getController();
            controller.setVeiculoServise(new VeiculoServise());
            
            
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enter Veiculo Data");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            Alerts.showAlert("IO exception", "Error load view", e.getMessage(), Alert.AlertType.ERROR);
            //e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Locale.setDefault(Locale.US);
    }

}
