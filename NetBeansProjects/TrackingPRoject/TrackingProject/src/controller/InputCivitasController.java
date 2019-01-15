/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class InputCivitasController implements Initializable {

    @FXML
    private JFXTextField textNameCivitas;
    @FXML
    private JFXTextField textInisial;
    @FXML
    private JFXTextField textLokasi;
    @FXML
    private JFXComboBox<?> comboGroup;
    @FXML
    private Label btnSave;
    @FXML
    private HBox btnModified;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSave(MouseEvent event) {
    }

    @FXML
    private void btnModiified(MouseEvent event) {
    }
    
}
