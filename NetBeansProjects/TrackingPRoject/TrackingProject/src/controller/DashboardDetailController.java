/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.koneksi;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Project;
import model.ProjectDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DashboardDetailController implements Initializable {
    
    private int year;
    public String idAct;
    
    @FXML
    private TableView<Project> listProject;
    @FXML
    private TableColumn<Project, Number> colNo;
    @FXML
    private TableColumn<Project, String> colProject;
    @FXML
    private TableColumn<Project, String> colBisnisUnit;
    @FXML
    private TableColumn<Project, String> colCategory;
    @FXML
    private TableColumn<Project, String> colStart;
    @FXML
    private TableColumn<Project, String> colFinisih;
    @FXML
    private TableColumn<Project, Double> colProgress;
    @FXML
    private TableColumn<Project, String> colRFactor;
    @FXML
    private TableColumn<Project, String> colIndex;
    
    ProjectDao modelProject = new ProjectDao();
    private ObservableList<Project> dataProject;
    
    koneksi kon = new koneksi();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
    }

    public void setData(String idActivity, int Sheyear){
        idAct = idActivity;
        setYear(Sheyear);
        System.out.println(" id Act "+idAct);
        try {
            int idStatusLoad = 2;
            loadListProject(idStatusLoad);
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadComplete(MouseEvent event) {
        int idStatusLoad = 4;
        listProject.setItems(null);
        try {
            loadListProject(idStatusLoad);
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadInProgress(MouseEvent event) {
        int idStatusLoad = 2;
        listProject.setItems(null);
        try {
            loadListProject(idStatusLoad);
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadNotYet(MouseEvent event) {
        int idStatusLoad = 1;
        listProject.setItems(null);
        try {
            loadListProject(idStatusLoad);
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadListProject(int idStatusLoad) throws SQLException{
        try {
//            String load = "1";
//            modelProject.queryLoadAllListProject(load);
            double percent = 0;
            if(idAct == null ){
                modelProject.loadProfilePerStatusbyYear(idStatusLoad, getYear());
            } else {
                modelProject.loadProfilebyYearActivity(idStatusLoad,idAct, getYear());;
            }
            
            //modelProject.loadProfilePerStatus(idStatusLoad);
            dataProject=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
            
            while (kon.res.next()) {                
                dataProject.add(new Project
                        (kon.res.getString(1), kon.res.getString(2), kon.res.getInt(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), 
                        kon.res.getString(9), kon.res.getString(10),kon.res.getString(11), kon.res.getString(12), 
                        kon.res.getString(13),kon.res.getDouble(14), kon.res.getString(15), kon.res.getString(16), 
                        kon.res.getInt(17), kon.res.getInt(18), kon.res.getInt(19), kon.res.getInt(20), kon.res.getInt(21),
                        kon.res.getInt(22), kon.res.getInt(23), kon.res.getInt(24), kon.res.getInt(25), kon.res.getInt(26),
                        kon.res.getInt(27), kon.res.getInt(28), kon.res.getString(29), kon.res.getString(30),
                        kon.res.getString(31)));
                
                colNo.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(listProject.getItems().indexOf(column.getValue())+1));
                colProject.setCellValueFactory(new PropertyValueFactory<>("ProjectCol"));
                colBisnisUnit.setCellValueFactory(new PropertyValueFactory<>("CivitasCol"));
                colCategory.setCellValueFactory(new PropertyValueFactory<>("InisialActivity"));
                colStart.setCellValueFactory(new PropertyValueFactory<>("NameStartMonth"));
                colFinisih.setCellValueFactory(new PropertyValueFactory<>("NameEndMonth"));
                //percent = kon.res.getDouble(13) * 100 ;
                colProgress.setCellValueFactory(new PropertyValueFactory<>("ShowPercent"));
                colRFactor.setCellValueFactory(new PropertyValueFactory<>("ValueRisk"));
                colIndex.setCellValueFactory(new PropertyValueFactory<>("IndexAudit"));
                listProject.setItems(null);
                listProject.setItems(dataProject);

            }
        }catch (Exception e) {
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
