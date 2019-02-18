/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import db.koneksi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.ListTaskProject;
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
    
    @FXML
    private JFXTextField textSearch;
    
    public String SearchKey="";
    int year = Year.now().getValue();
    private String idPro="", civitas="", startMonth="", endMonth="";
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    
    koneksi kon = new koneksi();
    ProjectDao modelProject =new ProjectDao();
    PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<Project> data;
    private ObservableList<Project> filteredData;
    
    @FXML
    private BorderPane viewProject;
    
    private void loadListProject(){
        try {
            rootViewList.setItems(null);
//            String load = "1";
//            modelProject.queryLoadAllListProject(load);

                modelProject.loadProjectbyYear(year);

            
            data=FXCollections.observableArrayList();
            filteredData = FXCollections.observableArrayList();
            //kon.res=kon.stat.executeQuery(modelProject.queryListProject);
            kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
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
            
            // Initially add all data to filtered data
            filteredData.addAll(data);

            
            rootViewList.setItems(data);
            rootViewList.setCellFactory(projectListView -> new ProjectDao());
            rootViewList.setVerticalGap(30.0);
            rootViewList.setExpanded(true);
            rootViewList.depthProperty().set(1);
            rootViewList.getStyleClass().add("mylistview");
        } catch (Exception e) {

        }
        
    }
    
    private void loadListSearchProject(){
        try {
            rootViewList.setItems(null);

            modelProject.loadProjectSearch(year, SearchKey);
            
            
            data=FXCollections.observableArrayList();
            filteredData = FXCollections.observableArrayList();
            //kon.res=kon.stat.executeQuery(modelProject.queryListProject);
            kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
//            System.out.println(modelProject.SelectNeeded);
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
            
            // Initially add all data to filtered data
            filteredData.addAll(data);

            
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
        try {
            idPro = rootViewList.getSelectionModel().getSelectedItem().getIdProject();
//              civitas = rootViewList.getSelectionModel().getSelectedItem().getCivitasCol();
//              startMonth = rootViewList.getSelectionModel().getSelectedItem().getStartmonth();
//              endMonth = rootViewList.getSelectionModel().getSelectedItem().getEndmonth();
            openDetail();
            
        } catch (Exception e) {
            
        }
    }

    private void openDetail() throws IOException, SQLException {
        viewProject.setCenter(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PROJECTdetail.fxml"));
        BorderPane newScene = loader.load();
        PROJECTdetailController mct = loader.getController();
        mct.setData(idPro);
        viewProject.setCenter(newScene);
    }
    
    @FXML
    void loadSearchOnInput(InputMethodEvent event) {
        //System.out.println("loadSearchOnInput "+textSearch.getText());
        
    }

    @FXML
    void loadSearchOnPress(KeyEvent event) {
        //System.out.println("loadSearchOnPress "+textSearch.getText());
        
    }

    @FXML
    void loadSearchOnRelease(KeyEvent event) {
        //System.out.println("loadSearchOnRelease "+textSearch.getText());
        SearchKey = textSearch.getText();
        if (SearchKey == "" || SearchKey.isEmpty()) {
            // No filter --> Add all.
            loadListProject();
        } else{
            loadListSearchProject();
        }
    }
    
    private boolean checkIdExisTask(JFXListView<Project> tblContainer, String SearchKey) {
        //bolean checking id selection list remover to list array on list container
        List<String> listChecker = tblContainer.getItems().stream().
                        map(Project::getProjectCol).
                        collect(Collectors.toList());
        System.out.println("check");
        for (String listChecker1 : listChecker) {
            if (listChecker1.trim().contains(SearchKey)) { 
                System.out.println("listChecker1 "+listChecker1);
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    @FXML
    void loadSearchOnType(KeyEvent event) {
       // System.out.println("loadSearchOnType "+textSearch.getText());

        
        //loadListProject();
    }

    @FXML
    void loadSearchProject(MouseEvent event) {
       // System.out.println("loadSearchProject "+textSearch.getText());
    }
    
    
}
