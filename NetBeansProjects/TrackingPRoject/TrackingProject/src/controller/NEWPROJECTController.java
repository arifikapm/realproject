/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.ui.PlatformFactory;
import db.koneksi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JOptionPane;
import model.MasActivity;
import model.MasActivityDao;
import model.MasCivitas;
import model.MasCivitasDao;
import model.ListTaskDatePicker;
import model.ListTaskProject;
import model.MasAuditIndex;
import model.MasAuditIndexDao;
import model.MasKaryawan;
import model.MasKaryawanDao;
import model.MasRiskFactor;
import model.MasRiskFactorDao;
import model.ProjectDetail;
import model.ProjectDetailDao;
import model.MasScope;
import model.MasScopeDao;
import model.MasStatusProject;
import model.MasStatusProjectDao;
import model.Project;
import model.ProjectDao;
import model.Team;
import model.TeamDao;
import org.jfree.data.time.Day;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class NEWPROJECTController implements Initializable {
    
   // MasCivitas civitasData;
    
    public  String textProject, textActivity, textCivitas, textStartDate, textEndDate, textRiskFactore;
    private String idProject, idScope, idKaryawan;

    @FXML
    private BorderPane viewMaster;
    @FXML
    private JFXComboBox<MasCivitas> comboCivitas;
    @FXML
    private JFXComboBox<MasActivity> comboAcitivity;
    @FXML
    private JFXListView<MasScope> listScope;
    @FXML
    private JFXListView<MasKaryawan> listKaryawan;
    @FXML
    private JFXListView<MasScope> currentScope;
    @FXML
    private JFXListView<MasKaryawan> currentTeam;
    
    @FXML
    private JFXComboBox<MasRiskFactor> comboRiskFactor;

    @FXML
    private JFXComboBox<MasAuditIndex> comboAuditIndex;

    @FXML
    private JFXComboBox<MasStatusProject> comboStatus;
    
    @FXML
    private JFXTextField valueProject;
    @FXML
    private JFXDatePicker dateStart;
    @FXML
    private JFXDatePicker dateEnd;
    
    @FXML
    private JFXButton btnMod;

    @FXML
    private JFXButton btnSave;
    
    @FXML
    private TableView<ListTaskProject> tblTask;

    @FXML
    private TableColumn<ListTaskProject, String> colTask;

    @FXML
    private TableColumn<ListTaskProject, Date> colStartPlan;

    @FXML
    private TableColumn<ListTaskProject, Date> colEndPlan;

    @FXML
    private TableColumn<ListTaskProject, Date> colActStart;

    @FXML
    private TableColumn<ListTaskProject, Date> colActEnd;
    
    //load data
    koneksi kon = new koneksi();
    MasCivitasDao modelCivitas = new MasCivitasDao();
    MasActivityDao modelActivity = new MasActivityDao();
    MasKaryawanDao modelKaryawan= new MasKaryawanDao();
    MasScopeDao modelScope = new MasScopeDao();
    ProjectDetailDao modelDetail = new ProjectDetailDao();
    ListTaskDatePicker modelDate2 = new ListTaskDatePicker();
    MasRiskFactorDao modelRiskFactor = new MasRiskFactorDao();
    MasAuditIndexDao modelAuditIndex = new MasAuditIndexDao();
    MasStatusProjectDao modelStatusProject = new MasStatusProjectDao();
    
    //insert
    ProjectDao modelProject = new ProjectDao();
    
    //list
    private ObservableList<MasCivitas> dataCivitas;
    private ObservableList<MasActivity> dataAcitivy;
    private ObservableList<MasScope>dataScope;
    private ObservableList<MasKaryawan>dataKaryawan;
    private ObservableList<ProjectDetail>dataProjectDetail;
    private ObservableList<Project>dataProject;
    private ObservableList<ListTaskProject>dataDate1;
    private ObservableList<MasRiskFactor>dataRiskFactor;
    private ObservableList<MasAuditIndex>dataAuditIndex;
    private ObservableList<MasStatusProject>dataStatusProject;


    
    
    //Setdata on combo box
    public void comboBoxCivitas() throws SQLException{
        
        //query set on class
        kon.db();
        dataCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelCivitas.selectNameId);
        try {
            while (kon.res.next()) {                
                dataCivitas.add(new MasCivitas(kon.res.getInt(1), kon.res.getString(2)) );
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboCivitas.getItems().addAll(dataCivitas);
            
            //load the field value every query row
            comboCivitas.setCellFactory(new Callback<ListView<MasCivitas>, ListCell<MasCivitas>>() {
            @Override public ListCell<MasCivitas> call(ListView<MasCivitas> param) {
                final ListCell<MasCivitas> cell = new ListCell<MasCivitas>() {

                    @Override public void updateItem(MasCivitas item, boolean empty) {
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
            comboCivitas.setConverter(new StringConverter<MasCivitas>() {
              @Override
              public String toString(MasCivitas civitasCol) {
                if (civitasCol == null){
                  return null;
                } else {
                    //System.out.println("load the id = "+civitasCol.getIdCivitas());
                    //saveMode(civitasCol.getIdCivitas());
                  return civitasCol.getCivitasCol();
                }
              }

            @Override
            public MasCivitas fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboCivitas.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
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
                dataAcitivy.add(new MasActivity(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboAcitivity.getItems().addAll(dataAcitivy);
            
            //load the field value every query row
            comboAcitivity.setCellFactory(new Callback<ListView<MasActivity>, ListCell<MasActivity>>() {
            @Override public ListCell<MasActivity> call(ListView<MasActivity> param) {
                final ListCell<MasActivity> cell = new ListCell<MasActivity>() {

                    @Override public void updateItem(MasActivity item, boolean empty) {
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
            comboAcitivity.setConverter(new StringConverter<MasActivity>() {
              @Override
              public String toString(MasActivity activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                    //System.out.println("load the id = "+civitasCol.getIdCivitas());
                    //saveMode(civitasCol.getIdCivitas());
                  return activityCol.getAcitivitycol();
                }
              }

            @Override
            public MasActivity fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboAcitivity.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void comboBoxRiskFactor() throws SQLException{
        
        //query set on class
        dataRiskFactor=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelRiskFactor.select);
        try {
            while (kon.res.next()) {                
                dataRiskFactor.add(new MasRiskFactor(kon.res.getInt(1), kon.res.getString(2)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboRiskFactor.getItems().addAll(dataRiskFactor);
            
            //load the field value every query row
            comboRiskFactor.setCellFactory(new Callback<ListView<MasRiskFactor>, ListCell<MasRiskFactor>>() {
            @Override public ListCell<MasRiskFactor> call(ListView<MasRiskFactor> param) {
                final ListCell<MasRiskFactor> cell = new ListCell<MasRiskFactor>() {

                    @Override public void updateItem(MasRiskFactor item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getRisk_Valuecol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            comboRiskFactor.setConverter(new StringConverter<MasRiskFactor>() {
              @Override
              public String toString(MasRiskFactor activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                    //System.out.println("load the id = "+civitasCol.getIdCivitas());
                    //saveMode(civitasCol.getIdCivitas());
                  return activityCol.getRisk_Valuecol();
                }
              }

            @Override
            public MasRiskFactor fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboRiskFactor.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void comboBoxAuditIndex() throws SQLException{
        
        //query set on class
        dataAuditIndex=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelAuditIndex.selectall);
        try {
            while (kon.res.next()) {                
                dataAuditIndex.add(new MasAuditIndex(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboAuditIndex.getItems().addAll(dataAuditIndex);
            
            //load the field value every query row
            comboAuditIndex.setCellFactory(new Callback<ListView<MasAuditIndex>, ListCell<MasAuditIndex>>() {
            @Override public ListCell<MasAuditIndex> call(ListView<MasAuditIndex> param) {
                final ListCell<MasAuditIndex> cell = new ListCell<MasAuditIndex>() {

                    @Override public void updateItem(MasAuditIndex item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getAudit_Gradingcol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            comboAuditIndex.setConverter(new StringConverter<MasAuditIndex>() {
              @Override
              public String toString(MasAuditIndex activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                  return activityCol.getAudit_Gradingcol();
                }
              }

            @Override
            public MasAuditIndex fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboAuditIndex.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
     public void comboBoxStatusProject() throws SQLException{
        
        //query set on class
        int statusId= 5;
        modelStatusProject.statusLoad(statusId);
        dataStatusProject=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelStatusProject.queryLoad);
        try {
            while (kon.res.next()) {                
                dataStatusProject.add(new MasStatusProject(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboStatus.getItems().addAll(dataStatusProject);
            
            //load the field value every query row
            comboStatus.setCellFactory(new Callback<ListView<MasStatusProject>, ListCell<MasStatusProject>>() {
            @Override public ListCell<MasStatusProject> call(ListView<MasStatusProject> param) {
                final ListCell<MasStatusProject> cell = new ListCell<MasStatusProject>() {

                    @Override public void updateItem(MasStatusProject item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getStatusCol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            comboStatus.setConverter(new StringConverter<MasStatusProject>() {
              @Override
              public String toString(MasStatusProject activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                  return activityCol.getStatusCol();
                }
              }

            @Override
            public MasStatusProject fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboStatus.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void setScope() throws SQLException{
        
        dataScope =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelScope.queryCoPro);
        while (kon.res.next()) {                
                dataScope.add(new MasScope(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listScope.setItems(dataScope);
            listScope.setCellFactory(scopeListView -> new MasScopeDao());
//            listScope.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
//                if(newValue!=null){
//                    Platform.runLater(() -> {
//                        listScope.getSelectionModel().select(-1);
//                        currentScope.getItems().add(newValue);
//                        currentScope.setCellFactory(scopeListView -> new MasScopeDao());
//                        currentScope.getSelectionModel().selectedItemProperty().addListener((obt, bfrValue, afrValue)->{
//                            if(afrValue!=null){
//                                Platform.runLater(() -> {
//                                    currentScope.getSelectionModel().select(-1);
//                                    listScope.getItems().add(afrValue);
//                                    currentScope.getItems().remove(afrValue);
//                                    
//                                    //listScope.setCellFactory(scopeListView -> new MasScopeDao());
//                                });
//                            }
//                        });
//                        listScope.getItems().remove(newValue);
//                        currentScope.setVerticalGap(30.0);
//                        currentScope.setExpanded(true);
//                        currentScope.depthProperty().set(1);
//                        currentScope.getStyleClass().add("mylistview");
//                    });
//
//                } 
//                
//            });
            listScope.setVerticalGap(30.0);
            listScope.setExpanded(true);
            listScope.depthProperty().set(1);
            listScope.getStyleClass().add("mylistview");
    }
    
    public void setKaryawan() throws SQLException{
 
        kon.res=kon.stat.executeQuery(modelKaryawan.selectActive);
        dataKaryawan =FXCollections.observableArrayList();
        while (kon.res.next()) {                
               dataKaryawan.add(new MasKaryawan(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3),
                       kon.res.getString(4),kon.res.getString(5),kon.res.getString(6)));
            }

            listKaryawan.setItems(dataKaryawan);
            listKaryawan.setCellFactory(karyawanListView -> new MasKaryawanDao());
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
            comboBoxAuditIndex();
            comboBoxStatusProject();
            comboBoxRiskFactor();
            
            setKaryawan();
            setScope();
            
            listKaryawan.setDisable(true);
            listScope.setDisable(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    


    @FXML
    private void btnSave(MouseEvent event) throws SQLException {
        //Initiate to get value form
            String civitasValue;
            String activityValue;
            String auditindexValue;
            String statusValue;
            String riskfactorValue;
            
            if(comboCivitas.getValue()==null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo CIvitas kosong"));
                    alert.showAndWait();
            }else if(comboAcitivity.getValue()==null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboAcitivity kosong"));
                    alert.showAndWait();
            }else if(comboAuditIndex.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboAuditIndex kosong"));
                    alert.showAndWait();
            }else if(comboRiskFactor.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboRiskFactor kosong"));
                    alert.showAndWait();
            
            } else if(dateStart.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo dateStart kosong"));
                    alert.showAndWait();
            }else if(dateEnd.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo dateEnd kosong"));
                    alert.showAndWait();
            }else if(valueProject.getText()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo valueProject kosong"));
                    alert.showAndWait();
            }else {
                String projectValue = valueProject.getText();
                civitasValue = Integer.toString(comboCivitas.getSelectionModel().getSelectedItem().getIdCivitas());
                activityValue = Integer.toString(comboAcitivity.getSelectionModel().getSelectedItem().getIdAcitivity());
                auditindexValue = Integer.toString(comboAuditIndex.getSelectionModel().getSelectedItem().getIdaudit_Grading());
                riskfactorValue = Integer.toString(comboRiskFactor.getSelectionModel().getSelectedItem().getIdrisk_Value());
                LocalDate start = dateStart.getValue();
                LocalDate end = dateEnd.getValue();
                LocalDate nowDate = LocalDate.now();
                                           
                //create id
                
                String startDate = Integer.toString(start.getDayOfMonth());
                String startMonth = Integer.toString(start.getMonthValue());
                String endDate = Integer.toString(end.getDayOfMonth());
                String endMonth = Integer.toString(end.getMonthValue());

                idProject = ""+startMonth+""+civitasValue+""+activityValue+""+auditindexValue+""+riskfactorValue;
                
//                if (comboStatus.getValue() == null){
//                    
//                    statusValue = "1";
//                    //int status_idstatus = 1;
//                    try {
//                         //setquery save
//                        modelProject.insertProject(idProject,projectValue,civitasValue,activityValue,
//                            riskfactorValue,auditindexValue,statusValue,start,end,nowDate);
//                        kon.stat.executeUpdate(modelProject.SelectNeeded);
//                        
//                        setDataListTask(idProject);
//                        
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Input Success");
//                        alert.setHeaderText(null);
//                        alert.setContentText(String.valueOf(" Project "+projectValue+" \n" +" Input Success "));
//                        alert.showAndWait();
//                        
//                    } catch (SQLException ex) {
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Error");
//                        alert.setHeaderText(null);
//                        alert.setContentText(String.valueOf(ex));
//                        alert.showAndWait();
//                    }
//                    
//                   
//                    
//                } else{
//                    
//                    statusValue = Integer.toString(comboStatus.getSelectionModel().getSelectedItem().getIdStatus());
//                    //int status_idstatus = 1;
//                    try {
//                         //setquery save
//                        modelProject.insertProject(idProject,projectValue,civitasValue,activityValue,
//                            riskfactorValue,auditindexValue,statusValue,start,end,nowDate);
//                        kon.stat.executeUpdate(modelProject.SelectNeeded);
//                        
//                        setDataListTask(idProject);
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Input Success");
//                        alert.setHeaderText(null);
//                        alert.setContentText(String.valueOf(" Project "+projectValue+" \n" +" Input Success "));
//                        alert.showAndWait();
//                        
//                    } catch (SQLException ex) {
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Error");
//                        alert.setHeaderText(null);
//                        alert.setContentText(String.valueOf(ex));
//                        alert.showAndWait();
//                    }
//
//                }
                   
 
            }
            setIdProject(idProject);

            listKaryawan.setDisable(false);
            listScope.setDisable(false);
    }


    @FXML
    private void btnModiified(MouseEvent event) {
    }
    
    
    public void setData(String idProject) throws SQLException{
        // load list karyawan
        setDataListKaryawan(idProject);
        // load list scope
        setDataListScope(idProject);
        // load task
        setDataListTask(idProject);
        // load data project
        setDataProject(idProject);
        //set idProject for all project they need to modified
        setIdProject(idProject);
        
        btnSave.setDisable(true);
        
        listKaryawan.setDisable(false);
        listScope.setDisable(false);
        
    }
    
    public  void setDataProject(String idProject) throws SQLException{
        kon.db();
        modelProject.loadPerProject(idProject);
        
        dataProject=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
        try {
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
                textProject = kon.res.getString(2);
                textCivitas = kon.res.getString(4);
                textActivity = kon.res.getString(5);
                textStartDate = kon.res.getString(10);
                textEndDate = kon.res.getString(11);
                //textRiskFactore = kon.res.getString(textEndDate)
                 System.out.println(textProject);
                 System.out.println(textActivity);
                 System.out.println(textCivitas);
                 System.out.println(textStartDate);
                 System.out.println(textEndDate);
                 
//                jtsDayStart = kon.res.getString(11);
//                jtsMonthStart = kon.res.getString(12);
//                jtsDayEnd = kon.res.getString(13);
//                jtsMonthEnd = kon.res.getString(14);
//                textCountDown = kon.res.getString(15);
//                
            }
             valueProject.setText(textProject);
             valueProject.setDisable(true);
             
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             
             // Date Start
             if(textStartDate == null){
                 dateStart.setValue(null);
                 dateStart.setDisable(false);
             } else{
                LocalDate localDateSt = LocalDate.parse(textStartDate, formatter);
                dateStart.setValue(localDateSt);
                dateStart.setDisable(true);                 
             }

             
             // date End
             if(textEndDate == null){
                 dateEnd.setValue(null);
                 dateEnd.setDisable(false);
             } else{
                LocalDate localDateEnd = LocalDate.parse(textEndDate, formatter);
                dateEnd.setValue(localDateEnd);
                dateEnd.setDisable(true);                
             }
             
            

        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void setDataListScope(String idProject) throws SQLException{
        modelScope.loadScopeProject(idProject);
        dataScope =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelScope.scopequery);
    
        try {
            while (kon.res.next()) {                
                dataScope.add(new MasScope(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            currentScope.setItems(dataScope);
            currentScope.setCellFactory(scopeListView -> new MasScopeDao());
            currentScope.setVerticalGap(30.0);
            currentScope.setExpanded(true);
            currentScope.depthProperty().set(1);
            currentScope.getStyleClass().add("mylistview");
            
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void setDataListKaryawan(String idProject) throws SQLException{
        modelKaryawan.loadTeamProject(idProject);
        kon.res=kon.stat.executeQuery(modelKaryawan.queryteam);
        dataKaryawan =FXCollections.observableArrayList();
        System.out.println(modelKaryawan.queryteam);
        try {
            
        while (kon.res.next()) {                
               dataKaryawan.add(new MasKaryawan(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3),
                       kon.res.getString(4),kon.res.getString(5),kon.res.getString(6)));
            }

            currentTeam.setItems(dataKaryawan);
            currentTeam.setCellFactory(karyawanListView -> new MasKaryawanDao());
            currentTeam.setVerticalGap(30.0);
            currentTeam.setExpanded(true);
            currentTeam.depthProperty().set(1);
            currentTeam.getStyleClass().add("mylistview");
            
        } catch 
                (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }
    
    public void setDataListTask(String idProject) throws SQLException{
        int visi = 0;
        modelDate2.loadTaskProject(idProject);
        dataDate1=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelDate2.queryToLoad);
        
        
        try {
            while (kon.res.next()) {                
                dataDate1.addAll(new ListTaskProject(kon.res.getString(1), kon.res.getString(2),
                        kon.res.getDate(3), kon.res.getDate(4), kon.res.getDate(5), kon.res.getDate(6)));
                
                String civi = kon.res.getString(1);
                visi = Integer.parseInt(civi);
            
            }
            
            tblTask.setItems(null);
            tblTask.setEditable(true);
            colTask.setCellValueFactory(new PropertyValueFactory<>("TaskCol"));
            
            colStartPlan.setCellValueFactory(cell -> cell.getValue().dateEstStart());
            colStartPlan.setCellFactory(cell -> new ListTaskDatePicker());
            colStartPlan.setOnEditCommit(event -> event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setAct_Datestart(event.getNewValue()));
            
            colEndPlan.setCellValueFactory(cell -> cell.getValue().dateEstEnd());
            colEndPlan.setCellFactory(cell -> new ListTaskDatePicker());
            colEndPlan.setOnEditCommit(event -> event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setEst_Dateend(event.getNewValue()));
            
            colActStart.setCellValueFactory(cell -> cell.getValue().dateActStart());
            colActStart.setCellFactory(cell -> new ListTaskDatePicker());
            colActStart.setOnEditCommit(event -> event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setAct_Datestart(event.getNewValue()));
            
            colActEnd.setCellValueFactory(cell -> cell.getValue().dateEstEnd());
            colActEnd.setCellFactory(cell -> new ListTaskDatePicker());
            colActEnd.setOnEditCommit(event -> event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setAct_Dateend(event.getNewValue()));
            
            tblTask.setItems(dataDate1);
            
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
//        
    }


    @FXML
    void loadRefreshTeam(MouseEvent event) throws SQLException {
        //setKaryawan();
    }
    
   @FXML
    private void handleModTeam(MouseEvent event) throws SQLException {
        
        List<String> list = currentTeam.getItems().stream().
                map(MasKaryawan::getIdKaryawan).
                collect(Collectors.toList());
        for (String string : list) {
            System.out.println(string);
            modelKaryawan.setQueryProjectHasTeamSave(getIdProject(),string);
            //kon.stat.execute(modelKaryawan.insertInto);
        }
    }
    
    @FXML
    void handleListCurrentTeam(MouseEvent event) {
        transferListMasKaryawan(currentTeam, listKaryawan);
    }
    
    @FXML
    void handleListTeam(MouseEvent event) {
        transferListMasKaryawan(listKaryawan, currentTeam);
    }
    
        
    @FXML
    void loadRefresScope(MouseEvent event) throws SQLException {
        //setScope();
    }
    
    @FXML
    void handleListCurrentScope(MouseEvent event) throws SQLException {
        // the way to delete scope from project has master scope
        transferListMasScope(currentScope, listScope);
//        String idScope = currentScope.getSelectionModel().getSelectedItem().getIdScope();
//        try {
//            modelScope.setOnDeleteProjectHasScope(getIdProject(), idScope);
//            kon.stat.execute(modelScope.deleteProjectScope);
//            
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Error");
//            alert.setHeaderText(null);
//            alert.setContentText(String.valueOf(currentScope.getSelectionModel().getSelectedItem().getScopeCol()));
//            alert.showAndWait();
//            
//        } catch (SQLException ex) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setHeaderText(null);
//                    alert.setContentText(String.valueOf(ex));
//                    alert.showAndWait();
//        }
        
        
    }
    
    @FXML
    private void handleListScope(MouseEvent event) throws SQLException {
        //the way to insert scope on project has master scope
        transferListMasScope(listScope, currentScope);
        modelScope.setQueryProjectHasScopeSave(getIdProject(),getIdScope());
        System.out.println("getIdProject = "+getIdProject());
        System.out.println("getIdScope = "+getIdScope());
        //kon.stat.execute(modelScope.insertInto);
//         List<String> list = listScope.getItems().stream().
//                                map(MasScope::getIdScope).
//                                collect(Collectors.toList());
//         Set<String> set = listScope.getItems().stream().
//                 map(MasScope::getIdScope).collect(Collectors.toCollection(TreeSet::new));
//         System.out.println("ini set = "+set);
//         
//          String joined = listScope.getItems().stream()
//                           .map(Object::toString)
//                           .collect(Collectors.joining(", "));
//          System.out.println("inijoined = "+ joined);
////            for (String string : list) {
////                System.out.println(string);
////                modelScope.setQueryProjectHasScopeSave(getIdProject(),string);
////                kon.stat.execute(modelScope.insertInto);
////            }
//            
 
    }
    
    @FXML
    void handleCurrentScope(MouseEvent event) throws SQLException {
//        try {
//            List<String> list = currentScope.getItems().stream().
//                                map(MasScope::getIdScope).
//                                collect(Collectors.toList());
//            for (String string : list) {
//                System.out.println(string);
//                modelScope.setQueryProjectHasScopeSave(getIdProject(),string);
//                kon.stat.execute(modelScope.insertInto);
//            }
//            
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Success");
//                    alert.setHeaderText(null);
//                    alert.setContentText(String.valueOf("Add Scope \n Success "));
//                    alert.showAndWait();
//            
//        } catch (SQLException ex) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setHeaderText(null);
//                    alert.setContentText(String.valueOf(ex));
//                    alert.showAndWait();
//        }
        
    }
    



    @FXML
    void handleDelete(MouseEvent event) {
        String idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
        modelDetail.setDeleteTask(getIdProject(),idTask);
    }

    @FXML
    void handleInput(MouseEvent event) {

    }

  
    @FXML
    void handleModTask(MouseEvent event) {

    }
    
    
    private void transferListMasKaryawan(JFXListView<MasKaryawan> listRemover, JFXListView<MasKaryawan> listAddiver){
        MasKaryawan maska= listRemover.getSelectionModel().getSelectedItem();
        listRemover.getSelectionModel().clearSelection();
        if(maska != null){
            listRemover.getItems().remove(maska);
            listAddiver.getItems().add(maska);
            listAddiver.setCellFactory(maskaView -> new MasKaryawanDao());
                        //currentTeam.setVerticalGap(30.0);
                        currentTeam.setExpanded(true);
                        currentTeam.depthProperty().set(1);
                        currentTeam.getStyleClass().add("mylistview");
        }
        
    }

    private void transferListMasScope(JFXListView<MasScope> listRemover, JFXListView<MasScope> listAddiver){
        MasScope masScope= listRemover.getSelectionModel().getSelectedItem();
        idScope = listRemover.getSelectionModel().getSelectedItem().getIdScope();
        
        listRemover.getSelectionModel().clearSelection();
//        if(masScope != null){
//            listRemover.getItems().remove(masScope);
//            listAddiver.getItems().add(masScope);
//            listAddiver.setCellFactory(masScopeView -> new MasScopeDao());
//                        //currentTeam.setVerticalGap(30.0);

//        }
        
        if(masScope != null){
            if(listAddiver != null){
                List<String> list = listAddiver.getItems().stream().
                                map(MasScope::getIdScope).
                                collect(Collectors.toList());
            for (String string : list) {
                if(masScope.getIdScope().contains(string)){
                    listRemover.getItems().remove(masScope);
                    System.out.println("scope sudah ada");
                } else{
                    listRemover.getItems().remove(masScope);
                    
                    System.out.println("scope berhasil di add");
                    //listAddiver.setCellFactory(masScopeView -> new MasScopeDao());
                }
            }
            //listRemover.getItems().remove(masScope);
            //listAddiver.getItems().add(masScope);
//            listAddiver.getItems().add(masScope);
//            listAddiver.setCellFactory(masScopeView -> new MasScopeDao());
                
            } 
                listRemover.getItems().remove(masScope);
                listAddiver.getItems().add(masScope);
                listAddiver.setCellFactory(masScopeView -> new MasScopeDao());
            
            
            
        }
        currentScope.setVerticalGap(30.0);
        currentScope.setExpanded(true);
        currentScope.depthProperty().set(1);
        currentScope.getStyleClass().add("mylistview");
        
    }
    
    
    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String value) {
        this.idProject = value;
    }
    
    public String getIdScope() {
        return idScope;
    }

    public void setIdScope(String value) {
        this.idScope = value;
    }
    
    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String value) {
        this.idKaryawan = value;
    }

}
