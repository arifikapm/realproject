/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarcrud;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class FXMLController implements Initializable {

    @FXML
    private Tab btnHome;
    @FXML
    private AnchorPane rootHomePane;
    @FXML
    private Tab btnConn;
    @FXML
    private AnchorPane rootViewConn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootHomePane.getChildren().addAll(pane);
    }    

    private void loadSettingConnection(MouseEvent event) throws IOException {
        // try to show new scene
        
    }

    @FXML
    private void loadConnection(Event event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        rootViewConn.getChildren().addAll(pane);
    }

    @FXML
    private void loadHome(Event event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        rootHomePane.getChildren().addAll(pane);
    }
    
}
