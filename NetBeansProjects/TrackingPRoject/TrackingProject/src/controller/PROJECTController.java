/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import db.koneksi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.Project;
import model.ProjectDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class PROJECTController implements Initializable {

    @FXML
    private JFXListView<Project> rootViewList;
    
    private String idPro="", civitas="", startMonth="", endMonth="";
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    
    koneksi kon = new koneksi();
    ProjectDao modelProject =new ProjectDao();
    PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<Project> data;
    @FXML
    private BorderPane viewProject;
    
    private void loadListProject(){
        try {
//            String load = "1";
//            modelProject.queryLoadAllListProject(load);
            data=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelProject.queryListProject);
            while (kon.res.next()) {                
                data.add(new Project
                        (kon.res.getString(1), kon.res.getString(2), kon.res.getInt(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), 
                        kon.res.getString(9), kon.res.getString(10),kon.res.getString(11), kon.res.getString(12), 
                        kon.res.getString(13),kon.res.getDouble(14), kon.res.getString(15), kon.res.getString(16), 
                        kon.res.getInt(17), kon.res.getInt(18), kon.res.getInt(19), kon.res.getInt(20), kon.res.getInt(21),
                        kon.res.getInt(22), kon.res.getInt(23), kon.res.getInt(24), kon.res.getInt(25), kon.res.getInt(26),
                        kon.res.getInt(27), kon.res.getInt(28), kon.res.getString(29), kon.res.getString(30),
                        kon.res.getString(31)));
            }
            
            rootViewList.setItems(data);
            rootViewList.setCellFactory(projectListView -> new ProjectDao());
            rootViewList.setVerticalGap(30.0);
            rootViewList.setExpanded(true);
            rootViewList.depthProperty().set(1);
            rootViewList.getStyleClass().add("mylistview");
        } catch (Exception e) {

        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        loadListProject();
        
        //rootViewList.setExpanded(Boolean.TRUE);
    }    

    @FXML
    private void loadDetailProject(MouseEvent event) throws IOException, SQLException {
        idPro = rootViewList.getSelectionModel().getSelectedItem().getIdProject();
//        civitas = rootViewList.getSelectionModel().getSelectedItem().getCivitasCol();
//        startMonth = rootViewList.getSelectionModel().getSelectedItem().getStartmonth();
//        endMonth = rootViewList.getSelectionModel().getSelectedItem().getEndmonth();
        openDetail();
        
    }

    private void openDetail() throws IOException, SQLException {
        viewProject.setCenter(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PROJECTdetail.fxml"));
        BorderPane newScene = loader.load();
        PROJECTdetailController mct = loader.getController();
        System.out.println("idPro = "+idPro);
        mct.setData(idPro);
        viewProject.setCenter(newScene);
    }
    
    
}
