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
public class MASTERKaryawanController implements Initializable {

    @FXML
    private AnchorPane loadInputView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInputKaryawanVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTKaryawan.fxml"));
        loadInputView.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputDepartemenVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTDepartemen.fxml"));
        loadInputView.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputJabatanVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTJabatan.fxml"));
        loadInputView.getChildren().addAll(pane);
    }

    @FXML
    private void loadInputStatusVIew(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INPUTStatusKaryawan.fxml"));
        loadInputView.getChildren().addAll(pane);
    }
    
}
