/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class ROOTController implements Initializable {

    @FXML
    private BorderPane rootLoad;
    @FXML
    private VBox btnProject;
    @FXML
    private VBox btnSetting;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            // TODO
            loadDasboard();
        } catch (IOException ex) {
            Logger.getLogger(ROOTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void loadMasterView(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MASTER.fxml"));
        //loader.setLocation(javafx.stage.Stage.class.getResource("MASTER.fxml"));
        BorderPane newScene = loader.load();
        MASTERController mct = loader.getController();
        //mct.setMain(this);
        rootLoad.setCenter(newScene);
        
    }

    @FXML
    private void loadProjectView(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PROJECT.fxml"));
        BorderPane newScene = loader.load();
        PROJECTController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }

    @FXML
    private void loadSetting(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DBconnection.fxml"));
        BorderPane newScene = loader.load();
        DBconnectionController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }

    @FXML
    private void loadAllTask(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TIMEtable.fxml"));
        BorderPane newScene = loader.load();
        TIMEtableController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }

    @FXML
    private void loadNewProject(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NEWPROJECT_1.fxml"));
        BorderPane newScene = loader.load();
        NEWPROJECTController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }
    
    public void loadDasboard() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DASHBOARD_2.fxml"));
        BorderPane newScene = loader.load();
        DASHBOARDController mct = loader.getController();
        rootLoad.setCenter(newScene);
        rootLoad.maxHeight(0);
    }
    
    public void loadDasboardView() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardView.fxml"));
        BorderPane newScene = loader.load();
        DashboardViewController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }

    @FXML
    private void loadHome(MouseEvent event) throws IOException {
        loadDasboard();
    }
        
    
}
