/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarcrud;

import db.koneksi;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.homeDAO;
import model.homeModel;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class HomeScreenController implements Initializable {

    @FXML
    private TableColumn<homeModel, String> idCol;
    @FXML
    private TableColumn<homeModel, String> activityCol;
    @FXML
    private TableColumn<homeModel, String> startmonthCol;
    @FXML
    private TableColumn<homeModel, String> endmonthCol;
    @FXML
    private TableColumn<homeModel, String> jenisCol;
    @FXML
    private TableColumn<homeModel, String> civitasCol;
    @FXML
    private TableColumn<homeModel, String> statusCol;
    @FXML
    private TableView<homeModel> tableView;
    
    private ObservableList<homeModel> data;
    
    koneksi kon = new koneksi();
    homeDAO model = new homeDAO();
    @FXML
    private Button selectallBtn;
    
    private void setStyleTable(){
        activityCol.setStyle("-fx-alignment: CENTER");
        startmonthCol.setStyle("-fx-alignment: CENTER");
        endmonthCol.setStyle("-fx-alignment: CENTER");
        jenisCol.setStyle("-fx-alignment: CENTER");
        statusCol.setStyle("-fx-alignment: CENTER");
        civitasCol.setStyle("-fx-alignment: CENTER");
    }
    
    private void loadTable(){
        try {
            data=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(model.loadAll);
            while (kon.res.next()) {                
                data.add(new homeModel(kon.res.getString(1)
                        , kon.res.getString(2), kon.res.getString(3), kon.res.getString(4)
                        , kon.res.getString(5), kon.res.getString(6), kon.res.getString(7)));
            }
            //`idactivity`, `activitycol`, `startmonth`, `endmonth`, `jenis_idjenis`, `civitas_idcivitas`, 
            //`status_idstatus` FROM `activity
            idCol.setCellValueFactory(new PropertyValueFactory<>("idactivity"));
            activityCol.setCellValueFactory(new PropertyValueFactory<>("activitycol"));
            startmonthCol.setCellValueFactory(new PropertyValueFactory<>("startmonth"));
            endmonthCol.setCellValueFactory(new PropertyValueFactory<>("endmonth"));
            jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis_idjenis"));
            civitasCol.setCellValueFactory(new PropertyValueFactory<>("civitas_idcivitas"));
            statusCol.setCellValueFactory(new PropertyValueFactory<>("status_idstatus"));
            tableView.setItems(null);
            tableView.setItems(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //setStyleTable();
        kon.db();
        loadTable();
        
    }    

    @FXML
    private void loadTableAll(MouseEvent event) {
        //setStyleTable();
        kon.db();
        loadTable();
        System.out.println(model.loadAll);
    }
    
}
