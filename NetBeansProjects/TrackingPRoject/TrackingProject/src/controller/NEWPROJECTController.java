/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.sun.glass.ui.PlatformFactory;
import db.koneksi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import model.Activity;
import model.ActivityDao;
import model.Civitas;
import model.CivitasDao;
import model.Karyawan;
import model.KaryawanDao;
import model.Scope;
import model.ScopeDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class NEWPROJECTController implements Initializable {
    
   // Civitas civitasData;

    @FXML
    private BorderPane viewMaster;
    @FXML
    private JFXComboBox<Civitas> comboCivitas;
    @FXML
    private JFXComboBox<Activity> comboAcitivity;
    @FXML
    private JFXListView<Scope> listScope;
    @FXML
    private JFXListView<Karyawan> listKaryawan;
    @FXML
    private JFXListView<Scope> currentScope;
    @FXML
    private JFXListView<Karyawan> currentTeam;
    @FXML
    private JFXComboBox<?> comboRiskFactor;
    
    
    //Koneksi
    koneksi kon = new koneksi();
    CivitasDao modelCivitas = new CivitasDao();
    ActivityDao modelActivity = new ActivityDao();
    KaryawanDao modelKaryawan= new KaryawanDao();
    ScopeDao modelScope = new ScopeDao();

    
    //list
    private ObservableList<Civitas> dataCivitas;
    private ObservableList<Activity> dataAcitivy;
    private ObservableList<Scope>dataScope;
    private ObservableList<Karyawan>dataKaryawan;


    
    
    //Setdata on combo box
    public void comboBoxCivitas() throws SQLException{
        
        //query set on class
        kon.db();
        dataCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelCivitas.selectNameId);
        try {
            while (kon.res.next()) {                
                dataCivitas.add(new Civitas(kon.res.getInt(1), kon.res.getString(2)) );
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboCivitas.getItems().addAll(dataCivitas);
            
            //load the field value every query row
            comboCivitas.setCellFactory(new Callback<ListView<Civitas>, ListCell<Civitas>>() {
            @Override public ListCell<Civitas> call(ListView<Civitas> param) {
                final ListCell<Civitas> cell = new ListCell<Civitas>() {

                    @Override public void updateItem(Civitas item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getCivitasCol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            comboCivitas.setConverter(new StringConverter<Civitas>() {
              @Override
              public String toString(Civitas civitasCol) {
                if (civitasCol == null){
                  return null;
                } else {
                    //System.out.println("load the id = "+civitasCol.getIdCivitas());
                    //saveMode(civitasCol.getIdCivitas());
                  return civitasCol.getCivitasCol();
                }
              }

            @Override
            public Civitas fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboCivitas.setMaxHeight(25);    
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //Setdata on combo box
    public void comboBoxActivity() throws SQLException{
        
        //query set on class
        kon.db();
        dataAcitivy=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelActivity.selectall);
        try {
            while (kon.res.next()) {                
                dataAcitivy.add(new Activity(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboAcitivity.getItems().addAll(dataAcitivy);
            
            //load the field value every query row
            comboAcitivity.setCellFactory(new Callback<ListView<Activity>, ListCell<Activity>>() {
            @Override public ListCell<Activity> call(ListView<Activity> param) {
                final ListCell<Activity> cell = new ListCell<Activity>() {

                    @Override public void updateItem(Activity item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getAcitivitycol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            comboAcitivity.setConverter(new StringConverter<Activity>() {
              @Override
              public String toString(Activity activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                    //System.out.println("load the id = "+civitasCol.getIdCivitas());
                    //saveMode(civitasCol.getIdCivitas());
                  return activityCol.getAcitivitycol();
                }
              }

            @Override
            public Activity fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboAcitivity.setMaxHeight(25);    
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setScope() throws SQLException{
        
        dataScope =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelScope.queryCoPro);
        while (kon.res.next()) {                
                dataScope.add(new Scope(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listScope.setItems(dataScope);
            listScope.setCellFactory(scopeListView -> new ScopeDao());
            listScope.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
                if(newValue!=null){
                    Platform.runLater(() -> {
                        listScope.getSelectionModel().select(-1);
                        currentScope.getItems().add(newValue);
                        currentScope.setCellFactory(scopeListView -> new ScopeDao());
                        currentScope.getSelectionModel().selectedItemProperty().addListener((obt, bfrValue, afrValue)->{
                            if(afrValue!=null){
                                Platform.runLater(() -> {
                                    currentScope.getSelectionModel().select(-1);
                                    //listScope.getItems();
                                    currentScope.getItems().remove(afrValue);
                                    
                                    //listScope.setCellFactory(scopeListView -> new ScopeDao());
                                });
                            }
                        });
                        listScope.getItems().remove(newValue);
                        currentScope.setVerticalGap(30.0);
                        currentScope.setExpanded(true);
                        currentScope.depthProperty().set(1);
                        currentScope.getStyleClass().add("mylistview");
                    });

                } 
                
            });
            listScope.setVerticalGap(30.0);
            listScope.setExpanded(true);
            listScope.depthProperty().set(1);
            listScope.getStyleClass().add("mylistview");
    }
    
    public void setKaryawan() throws SQLException{
 
        kon.res=kon.stat.executeQuery(modelKaryawan.selectActive);
        dataKaryawan =FXCollections.observableArrayList();
        while (kon.res.next()) {                
               dataKaryawan.add(new Karyawan(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3),
                       kon.res.getString(4),kon.res.getString(5),kon.res.getString(6)));
            }

            listKaryawan.setItems(dataKaryawan);
            listKaryawan.setCellFactory(karyawanListView -> new KaryawanDao());
            listKaryawan.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
                if(newValue!=null){
                    Platform.runLater(() -> {
                        listKaryawan.getSelectionModel().select(-1);
                        currentTeam.getItems().add(newValue);
                        currentTeam.setCellFactory(karywanListView -> new KaryawanDao());
                        listKaryawan.getItems().remove(newValue);
                        currentTeam.setVerticalGap(30.0);
                        currentTeam.setExpanded(true);
                        currentTeam.depthProperty().set(1);
                        currentTeam.getStyleClass().add("mylistview");
                    });

                } 
                
            });
            listKaryawan.setVerticalGap(30.0);
            listKaryawan.setExpanded(true);
            listKaryawan.depthProperty().set(1);
            listKaryawan.getStyleClass().add("mylistview");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        try {
            comboBoxCivitas();
            comboBoxActivity();
            setKaryawan();
            setScope();
        } catch (SQLException ex) {
            Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    


    @FXML
    private void btnSave(MouseEvent event) {
        //ystem.out.println();
    }


    @FXML
    private void btnModiified(MouseEvent event) {
    }
    
    
    public void setData(String idProject){
        System.out.println(idProject);
        
        
    }
    
}
