/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.koneksi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DetailPro;
import model.DetailProDao;
import model.Project;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DetailProController implements Initializable {

    @FXML
    private Label lblIdPro;
    @FXML
    private Label lblidActivity;
    @FXML
    private TableView<DetailPro> tableView;
    @FXML
    private TableColumn<DetailPro, String> idCol;
    @FXML
    private TableColumn<DetailPro, String> activityCol;
    @FXML
    private TableColumn<DetailPro, String> startmonthCol;
    @FXML
    private TableColumn<DetailPro, String> endmonthCol;
    @FXML
    private TableColumn<DetailPro, String> jenisCol;
    @FXML
    private TableColumn<DetailPro, String> civitasCol;
    @FXML
    private TableColumn<DetailPro, String> statusCol;
    
    private ObservableList<DetailPro> data;
    private String idPro;
    
    koneksi kon = new koneksi();
    DetailProDao model = new DetailProDao();
    DetailPro pro;

    
    public void setData(String idProject, String civitas) throws SQLException{
        this.lblIdPro.setText(idProject);
        this.lblidActivity.setText(civitas);
        idPro = lblIdPro.getText();
        model.tabelDetailProject(idPro);
        data=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(model.queryload);
        while (kon.res.next()) {                
                data.add(new DetailPro(kon.res.getString(1)
                        , kon.res.getString(2), kon.res.getString(3), kon.res.getString(4)
                        , kon.res.getString(5), kon.res.getString(6), kon.res.getString(7)));
            }
            //`idactivity`, `activitycol`, `startmonth`, `endmonth`, `jenis_idjenis`, `civitas_idcivitas`, 
            //`status_idstatus` FROM `activity
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            activityCol.setCellValueFactory(new PropertyValueFactory<>("activity"));
            startmonthCol.setCellValueFactory(new PropertyValueFactory<>("startmonth"));
            endmonthCol.setCellValueFactory(new PropertyValueFactory<>("endmonth"));
            jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis"));
            civitasCol.setCellValueFactory(new PropertyValueFactory<>("civitas"));
            statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
            tableView.setItems(null);
            tableView.setItems(data);
            //lblidActivity.setText(pro.getActivity());
            
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        //loadDataTable();
    }    
    
}
