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
public class MASTERActivityController implements Initializable {

    @FXML
    private AnchorPane loadInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInputActivityVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTActivity.fxml"));
        loadInput.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputScoupeVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTScoupe.fxml"));
        loadInput.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputStatusVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTStatus.fxml"));
        loadInput.getChildren().addAll(pane);
    }
    
}
