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
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MainController implements Initializable {

    @FXML
    private ScrollPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInformation(MouseEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("MainInfoView.fxml"));
        rootPane.setContent(pane);
    }

    @FXML
    private void loadNewProject(MouseEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("NEWProject.fxml"));
        rootPane.setContent(pane);
    }

    @FXML
    private void loadMaster(MouseEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("MASTER.fxml"));
        rootPane.setContent(pane);
    }

    @FXML
    private void loadTimeTable(MouseEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("TIMETable.fxml"));
        rootPane.setContent(pane);
    }
    
}
