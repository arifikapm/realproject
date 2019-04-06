/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobatracking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MASTERController implements Initializable {

    @FXML
    private AnchorPane loadVIewInputData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInputKaryawan(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MASTERKaryawan.fxml"));
        loadVIewInputData.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputCivitas(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MASTERCivitas.fxml"));
        loadVIewInputData.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputProgress(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MASTERProgress.fxml"));
        loadVIewInputData.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputActivity(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MASTERActivity.fxml"));
        loadVIewInputData.getChildren().addAll(pane);
    }
    
}
