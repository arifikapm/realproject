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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.DetailProDao;
import model.Project;
import model.ProjectDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MainViewController implements Initializable {

    @FXML
    private Tab btnHome;
    @FXML
    private JFXListView<Project> rootViewList;
    @FXML
    private Tab btnSetting;
    @FXML
    private AnchorPane rootVIewSetting;
    @FXML
    private AnchorPane rootDetailView;
    
    private String idPro="", civitas = "";
    
    koneksi kon = new koneksi();
    ProjectDao model = new ProjectDao();
    DetailProController detail = new DetailProController();
    
    private ObservableList<Project> data ;
   
    
//    private TableView<Project> tableView;
//    private TableColumn<Project, String> idCol;
//    private TableColumn<Project, String> activityCol;
//    private TableColumn<Project, String> startmonthCol;
//    private TableColumn<Project, String> endmonthCol;
    //@FXML
   // private TableColumn<?, ?> jenisCol;
    //@FXML
    private TableColumn<?, ?> civitasCol;
   // @FXML
   // private TableColumn<?, ?> statusCol;
    
    private void loadTable(){
        try {
            data=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(model.loadActivity);
           
            while (kon.res.next()) {                
                data.addAll(new Project(kon.res.getString(1)
                        , kon.res.getString(2), kon.res.getString(3), kon.res.getString(4)));
            }
            //`idactivity`, `activitycol`, `startmonth`, `endmonth`, `jenis_idjenis`, `civitas_idcivitas`, 
            //`status_idstatus` FROM `activity
//            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//            activityCol.setCellValueFactory(new PropertyValueFactory<>("activity"));
//            startmonthCol.setCellValueFactory(new PropertyValueFactory<>("startmonth"));
//            endmonthCol.setCellValueFactory(new PropertyValueFactory<>("endmonth"));
            //jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis"));
            //civitasCol.setCellValueFactory(new PropertyValueFactory<>("civitas"));
            //statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
//            tableView.setItems(null);
//            tableView.setItems(data);
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
        kon.db();
        loadTable();
        rootViewList.setItems(data);
        rootViewList.setCellFactory(studentListView -> new ProjectDao());
        rootViewList.setVerticalGap(20.0);
        rootViewList.setExpanded(true);
        rootViewList.depthProperty().set(1);
        rootViewList.getStyleClass().add("mylistview");
        //System.out.println(model.loadActivity);
    }    

    @FXML
    private void loadHome(Event event) {
    }

    @FXML
    private void loadDBSetting(Event event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/view/KoneksiDB.fxml"));
        rootVIewSetting.getChildren().addAll(pane);
    }

    @FXML
    private void loadDetailPro(MouseEvent event) throws IOException, SQLException {
        idPro = rootViewList.getSelectionModel().getSelectedItem().getIdActivity();
        civitas = rootViewList.getSelectionModel().getSelectedItem().getCivitas();
        openDetail();
    }

    private void openDetail() throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
        Loader = new FXMLLoader(getClass().getResource("/view/DetailPro.fxml"));
        Parent pane = Loader.load();
        DetailProController ubahUserManagement = Loader.getController();
        ubahUserManagement.setData(idPro, civitas);
        rootDetailView.getChildren().setAll(pane);
    }
    
}
