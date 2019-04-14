/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class TaskController implements Initializable {

    @FXML
    private JFXListView<?> currentTask;
    @FXML
    private JFXListView<?> listTask;
    @FXML
    private JFXButton btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleListCurrentScope(MouseEvent event) {
    }

    @FXML
    private void handleListScope(MouseEvent event) {
    }

    @FXML
    private void loadRefresScope(MouseEvent event) {
    }

    @FXML
    private void btnSave(MouseEvent event) {
    }
    
}
