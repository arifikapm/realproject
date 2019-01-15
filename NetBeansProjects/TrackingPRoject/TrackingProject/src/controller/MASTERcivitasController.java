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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MASTERcivitasController implements Initializable {

    
    @FXML
    private BorderPane viewInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadCivitas(MouseEvent event) throws IOException {
        viewInput.setCenter(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InputCivitas.fxml"));
        BorderPane newScene = loader.load();
        InputCivitasController mct = loader.getController();
        //mct.setData(idPro);
        viewInput.setCenter(newScene);
    }

    @FXML
    private void loadGroup(MouseEvent event) throws IOException {
        viewInput.setCenter(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InputGroupCivitas.fxml"));
        BorderPane newScene = loader.load();
        InputGroupCivitasController mct = loader.getController();
        //mct.setData(idPro);
        viewInput.setCenter(newScene);
        
    }
    
}
