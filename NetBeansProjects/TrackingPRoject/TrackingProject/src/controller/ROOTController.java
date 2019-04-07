/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.MasResponsibility;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class ROOTController implements Initializable {

    @FXML
    public BorderPane rootLoad;
    @FXML
    private VBox btnProject;
    @FXML
    private VBox btnSetting;
    
    
    public  int year = Year.now().getValue();
    
    final ContextMenu contextMenu = new ContextMenu();
    public String ChoseYear = null;
    
    @FXML
    private ImageView btnImageDash;
    @FXML
    private JFXButton btnDashboard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadDasboard();
            popupYear();
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
        rootLoad.setCenter(null);
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
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NEWPROJECT_1.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NEWPROJECT.fxml"));
        BorderPane newScene = loader.load();
        NEWPROJECTController mct = loader.getController();
        rootLoad.setCenter(newScene);
    }
    
    public void loadDasboard() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DASHBOARD_3.fxml"));
        BorderPane newScene = loader.load();
        DASHBOARDController mct = loader.getController();
        if(year == Year.now().getValue()){
            mct.setChoseYear(year);
        } else{
            mct.setChoseYear(year);
        }
        
        rootLoad.setCenter(newScene);
        rootLoad.maxHeight(0);
    }
    

    @FXML
    private void loadHome(MouseEvent event) throws IOException {
        if (event.getButton()==MouseButton.SECONDARY) {
            btnDashboard.setContextMenu(contextMenu);
        }else if(event.getButton() == MouseButton.PRIMARY){
            int year = Year.now().getValue();
            System.out.println("");
            loadDasboard();
        }
        
    }
    
    public void popupYear(){
        String idItem = null;
        MenuItem quit = null;
        MenuItem quit2 = null;
        
        try {
            int i = 0;
            for (i = 0; i < 3; i++) {
                String choseyear = Integer.toString(year-i); 
                quit2 = new MenuItem(choseyear);

                contextMenu.getItems().addAll(quit2);
            }
            
            contextMenu.setOnAction(evt -> {
                ChoseYear = ((MenuItem)evt.getTarget()).getText();
                year =  Integer.valueOf(ChoseYear);
                try {
                    loadDasboard();
                } catch (IOException ex) {
                    Logger.getLogger(ROOTController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void loadImgDash(MouseEvent event) {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void refresh() throws IOException{
        rootLoad.setCenter(null);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PROJECT.fxml"));
//        BorderPane newScene = loader.load();
//        PROJECTController asad = loader.getController();
//        rootLoad.setCenter(newScene);
    }
        
    
}
