/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MASTERController implements Initializable {

    @FXML
    private BorderPane viewMaster;
    @FXML
    private HBox btnMKaryawan;
    @FXML
    private HBox btnCivitas;
    @FXML
    private HBox btnTask;
    @FXML
    private HBox btnProject;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadKaryawan(MouseEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MASTERkaryawan.fxml"));
//        BorderPane newScene = loader.load();
//        MASTERkaryawanController mct = loader.getController();
//        viewMaster.setCenter(newScene);
    }

    @FXML
    private void loadCivitas(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MASTERcivitas.fxml"));
        BorderPane newScene = loader.load();
        MASTERcivitasController mct = loader.getController();
        viewMaster.setCenter(newScene);
    }

    @FXML
    private void loadTask(MouseEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MASTERtask.fxml"));
//        BorderPane newScene = loader.load();
//        MASTERtaskController mct = loader.getController();
//        viewMaster.setCenter(newScene);
    }

    @FXML
    private void loadProject(MouseEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MASTERproject.fxml"));
//        BorderPane newScene = loader.load();
//        MASTERprojectController mct = loader.getController();
//        viewMaster.setCenter(newScene);

    }

    
}
