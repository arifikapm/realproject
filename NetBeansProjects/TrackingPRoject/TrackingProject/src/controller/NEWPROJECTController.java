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
import db.koneksi;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.StringConverter;
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
import model.MasResponsibility;
import model.MasResponsibilityDao;
import model.MasRiskFactor;
import model.MasRiskFactorDao;
import model.ProjectDetail;
import model.ProjectDetailDao;
import model.MasScope;
import model.MasScopeDao;
import model.MasStatusProject;
import model.MasStatusProjectDao;
import model.MasTask;
import model.MasTaskDao;
import model.Project;
import model.ProjectDao;
import model.TeamDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class NEWPROJECTController implements Initializable {
    
   // MasCivitas civitasData;
    
    public  String textProject, textActivity, textCivitas, textStartDate, textEndDate, textRiskFactore;
    private String idProject, idScope, idKaryawan, idAsa, idTask, nowValue, civi;
    private int hd;
    public int visi = 0;
    private String estStart = null;
    private String actStart  = null;
    private String actEnd = null;
    private String estEnd = null;
    private Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    final ContextMenu contextMenu = new ContextMenu();
    final ContextMenu contextTask = new ContextMenu();
    
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
    private TextField valueProject;
    @FXML
    private TextField valueActivity1;
    @FXML
    private TextField valueCivitas1;
    @FXML
    private TextField valueRiskFactor1;
    @FXML
    private TextField valueAuditGrading1;
    @FXML
    private TextField valueStatus1;
    
//    @FXML
//    private JFXTextField valueProject;
    @FXML
    private JFXDatePicker dateStart;
    @FXML
    private JFXDatePicker dateEnd;
    
    @FXML
    private JFXButton btnMod;

    @FXML
    private JFXButton btnSave;
    
    @FXML
    private JFXButton btnInput;
    
    @FXML
    private TableView<ListTaskProject> tblTask;
    
    @FXML
    private TableColumn<ListTaskProject, String> colNo;
//    private TableColumn<ListTaskProject, Number> colNo;

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
    ListTaskDatePicker modelDatePicker = new ListTaskDatePicker();
    MasRiskFactorDao modelRiskFactor = new MasRiskFactorDao();
    MasAuditIndexDao modelAuditIndex = new MasAuditIndexDao();
    MasStatusProjectDao modelStatusProject = new MasStatusProjectDao();
    MasResponsibilityDao modelResponsibility = new MasResponsibilityDao();
    MasTaskDao modelMasTask = new MasTaskDao();
    TeamDao modelTeam = new TeamDao();
    
    //insert
    ProjectDao modelProject = new ProjectDao();
    
    //list
    private ObservableList<MasCivitas> dataCivitas;
    private ObservableList<MasActivity> dataAcitivy;
    private ObservableList<MasScope>dataScope;
    private ObservableList<MasKaryawan>dataKaryawan;
    private ObservableList<ProjectDetail>dataProjectDetail;
    private ObservableList<Project>dataProject;
    private ObservableList<ListTaskProject>dataDatePicker;
    private ObservableList<MasRiskFactor>dataRiskFactor;
    private ObservableList<MasAuditIndex>dataAuditIndex;
    private ObservableList<MasStatusProject>dataStatusProject;
    private ObservableList<MasResponsibility>dataResponsibility;
    private ObservableList<MasTask>dataTask;
    private Label lblErrors;
    @FXML
    private JFXButton btnTaskDel;
    @FXML
    private JFXButton btnTaskMod;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        popupAsa();
        popupTask();
        listKaryawan.setDisable(true);
        listScope.setDisable(true);
        
        //setBtnDisable();
        
        try {

            comboBoxCivitas();
            comboBoxActivity();
            comboBoxAuditIndex();
            comboBoxStatusProject();
            comboBoxRiskFactor();
            
            setKaryawan();
            setScope();
            

            
        
            
            tblTask.getStyleClass().add("mylistview.css");
            
        } catch (SQLException ex) {
            Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  


    
    
    //Setdata on combo box
    public void comboBoxCivitas() throws SQLException{
        
        //query set on class
        kon.db();
        dataCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelCivitas.Select);
        try {
            while (kon.res.next()) {                
                dataCivitas.add(new MasCivitas(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                        kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), kon.res.getString(14), 
                        kon.res.getString(15), kon.res.getString(16)));
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
                    valueCivitas1.setText(civitasCol.getCivitasCol());
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
                    valueActivity1.setText(activityCol.getAcitivitycol());
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
                    valueRiskFactor1.setText(activityCol.getRisk_Valuecol());
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
                    valueAuditGrading1.setText(activityCol.getAudit_Gradingcol());
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
                    valueStatus1.setText(activityCol.getStatusCol());
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
    
    
    @FXML
    private void btnSave(MouseEvent event) throws SQLException {
        //Initiate to updateData value form
            String civitasValue;
            String activityValue;
            String auditindexValue;
            String statusValue;
            String riskfactorValue;
            
            if (checkForm().equals("Success")) {
                String projectValue = valueProject.getText();
                civitasValue = Integer.toString(comboCivitas.getSelectionModel().getSelectedItem().getIdCivitas());
                activityValue = Integer.toString(comboAcitivity.getSelectionModel().getSelectedItem().getIdAcitivity());
                auditindexValue = Integer.toString(comboAuditIndex.getSelectionModel().getSelectedItem().getIdaudit_Grading());
                riskfactorValue = Integer.toString(comboRiskFactor.getSelectionModel().getSelectedItem().getIdrisk_Value());
                LocalDate start = dateStart.getValue();
                LocalDate end = dateEnd.getValue();
                LocalDate nowDate = LocalDate.now();

                if (!makeId().equals(null)){
                    if (comboStatus.getValue() == null){
                    //gg
                        statusValue = "1";
                        //int status_idstatus = 1;
                        try {
                             //setquery save
                            modelProject.insertProject(idProject,projectValue,civitasValue,activityValue,
                                riskfactorValue,auditindexValue,statusValue,start,end,nowDate);
                            kon.stat.executeUpdate(modelProject.SelectNeeded);

                            setDataListTask(idProject);

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Input Success");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(" Project "+projectValue+" \n" +" Input Success "));
                            alert.showAndWait();

                        } catch (SQLException ex) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(ex));
                            alert.showAndWait();
                        }

                   
                    
                    } else{

                        statusValue = Integer.toString(comboStatus.getSelectionModel().getSelectedItem().getIdStatus());
                        //int status_idstatus = 1;
                        try {
                             //setquery save
                            modelProject.insertProject(idProject,projectValue,civitasValue,activityValue,
                                riskfactorValue,auditindexValue,statusValue,start,end,nowDate);
                            kon.stat.executeUpdate(modelProject.SelectNeeded);

                            setDataListTask(idProject);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Input Success");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(" Project "+projectValue+" \n" +" Input Success "));
                            alert.showAndWait();

                        } catch (SQLException ex) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(ex));
                            alert.showAndWait();
                        }

                    }
                }

            } else {
                
            }
            setBtnDisable();
    }
    
    
    @FXML
    void btnRefreshForm(MouseEvent event) {

    }


    @FXML
    private void btnModiified(MouseEvent event) {
            
            if (checkForm().equals("Success")) {
                String projectValue = valueProject.getText();
                //String civitasValue = Integer.toString(comboCivitas.getSelectionModel().getSelectedItem().getIdCivitas());
                //String activityValue = Integer.toString(comboAcitivity.getSelectionModel().getSelectedItem().getIdAcitivity());
                String auditindexValue = Integer.toString(comboAuditIndex.getSelectionModel().getSelectedItem().getIdaudit_Grading());
                String riskfactorValue = Integer.toString(comboRiskFactor.getSelectionModel().getSelectedItem().getIdrisk_Value());
                String statusValue = Integer.toString(comboStatus.getSelectionModel().getSelectedItem().getIdStatus());
                        
                LocalDate start = dateStart.getValue();
                LocalDate end = dateEnd.getValue();
                LocalDate nowDate = LocalDate.now();
                
                try {
                    modelProject.updateProject(idProject,
                                riskfactorValue,auditindexValue,statusValue,start,end,nowDate);
                    kon.stat.executeUpdate(modelProject.update);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Input Success");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(" Project "+projectValue+" \n" +" Update Success "));
                            alert.showAndWait();
                } catch (Exception e) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText(String.valueOf(e));
                            alert.showAndWait();
                }
                
        }
        
    }
    
    
    public void setLoadData(String idProject) throws SQLException{
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
        
        setBtnDisable();
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

//                
            }
             valueProject.setText(textProject);
             valueActivity1.setText(textActivity);
             valueCivitas1.setText(textCivitas);
             
             
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             
             // Date Start
             if(textStartDate == null){
                 dateStart.setValue(null);
                 dateStart.setDisable(false);
             } else{
                LocalDate localDateSt = LocalDate.parse(textStartDate, formatter);
                dateStart.setValue(localDateSt);
              
             }

             // date End
             if(textEndDate == null){
                 dateEnd.setValue(null);
                 dateEnd.setDisable(false);
             } else{
                LocalDate localDateEnd = LocalDate.parse(textEndDate, formatter);
                dateEnd.setValue(localDateEnd);
               
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
     
        modelDatePicker.loadNeWTaskProject(idProject);
        dataDatePicker=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelDatePicker.queryToLoad);
        
        
        try {
            while (kon.res.next()) {                
                dataDatePicker.addAll(new ListTaskProject(kon.res.getString(1), kon.res.getString(2),
                        kon.res.getDate(3), kon.res.getDate(4), kon.res.getDate(5), kon.res.getDate(6)));
                
                civi = kon.res.getString(1);
                //visi = Integer.parseInt(civi);
            
            }
            
            tblTask.setItems(null);
            tblTask.setEditable(true);
            
            //colNo.setCellValueFactory(column-> new ReadOnlyObjectWrapper<>(tblTask.getItems().indexOf(column.getValue())+1));
            colNo.setCellValueFactory(new PropertyValueFactory<>("IdTask"));
            
            //set style when mandatory task
            colNo.setCellFactory(column -> {
                return new TableCell<ListTaskProject, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            // set Text on Column.
                            //setText(Integer.toString(item));
                            setText(this.getTableRow().getIndex()+ 1 + "");
                            
                            // Style when it's mandatory task with a different color.
                            int x = Integer.parseInt(item);
                            if (checkMandatoryTask(x) == true) {
                                setTextFill(Color.CHOCOLATE);
                                setStyle("-fx-background-color: yellow");
                            } else {
                                setTextFill(Color.BLACK);
                                setStyle("");
                            }
                        }
                    }
                };
            });
            
            colTask.setCellValueFactory(new PropertyValueFactory<>("TaskCol"));
            
            colStartPlan.setCellValueFactory(cell -> cell.getValue().dateEstStart());
            colStartPlan.setCellFactory(cell -> new ListTaskDatePicker());
            colStartPlan.setOnEditCommit(event -> {
                //set on class listTaskProject
                event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setEst_Datestart(event.getNewValue());
                idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
                try {
                    updateHandleCommitStartPlan();
                } catch (SQLException ex) {
                    Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            colEndPlan.setCellValueFactory(cell -> cell.getValue().dateEstEnd());
            colEndPlan.setCellFactory(cell -> new ListTaskDatePicker());
            colEndPlan.setOnEditCommit(event -> {
                event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setEst_Dateend(event.getNewValue());
                idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
                try {
                    updateHandleCommitEndPlan();
                } catch (SQLException ex) {
                    Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            colActStart.setCellValueFactory(cell -> cell.getValue().dateActStart());
            colActStart.setCellFactory(cell -> new ListTaskDatePicker());
            colActStart.setOnEditCommit(event -> {
                event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setAct_Datestart(event.getNewValue());
                idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
                try {
                    updateHandleCommitActStart();
                } catch (SQLException ex) {
                    Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            colActEnd.setCellValueFactory(cell -> cell.getValue().dateActEnd());
            colActEnd.setCellFactory(cell -> new ListTaskDatePicker());
            colActEnd.setOnEditCommit(event -> {
                event.getTableView().getItems()
                    .get(event.getTablePosition().getRow()).setAct_Dateend(event.getNewValue());
                idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
                try {
                    updateHandleCommitActEnd();
                } catch (SQLException ex) {
                    Logger.getLogger(NEWPROJECTController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            tblTask.setEditable(true);
            tblTask.setItems(dataDatePicker);
            
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
//        
    }
    
    
    //add mouse event focus
    //focus show karyawan as a detail 
    
    @FXML
    void loadRefreshTeam(MouseEvent event) throws SQLException {
        //it can clear and add again
        listKaryawan.refresh();
        
        setKaryawan();
    }
    
    @FXML
    void handleListCurrentTeam(MouseEvent event) {
        hd = 1;
        
        try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    if(getIdKaryawan() != null){
                        transferListMasKaryawan(currentTeam, listKaryawan);
                        modelTeam.setOnDeleteProjectHasTeam(getIdProject(),getIdKaryawan());
                        kon.stat.executeUpdate(modelTeam.onDelete);
                    }


                    // ... user chose OK
                    
                } else {
                   alert.close();
                    // ... user chose CANCEL or closed the dialog
                }

        } catch (SQLException e) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText(String.valueOf(e));
                        alert.showAndWait();
        }
            
        
    }
    
    @FXML
    void handleListTeam(MouseEvent event) {
        hd = 2;
        //contextMenu.show(listKaryawan, Side.LEFT, 0, 0);
        try {
            listKaryawan.setContextMenu(contextMenu);
        } catch (Exception e) {
        }
        
        
        //transferListMasKaryawan(listKaryawan, currentTeam);
    }
    
        
    @FXML
    void loadRefresScope(MouseEvent event) throws SQLException {

    }
    
    @FXML
    void handleListCurrentScope(MouseEvent event) throws SQLException {
        // the way to delete scope from project has master scope
        int hd = 1;
        
        try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");
                
                transferListMasScope(currentScope, listScope, hd );
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    if(getIdScope() != null){
                        modelScope.setOnDeleteProjectHasScope(getIdProject(),getIdScope());
                        kon.stat.executeUpdate(modelScope.deleteProjectScope);                      
                    }

                   
                    // ... user chose OK
                    
                } else {
                   alert.close();
                    // ... user chose CANCEL or closed the dialog
                }

        } catch (Exception e) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText(String.valueOf(" Scope Contains on list \n Duplicate Scope "));
                        alert.showAndWait();
        }
//       
        
        
    }
    
    @FXML
    private void handleListScope(MouseEvent event) throws SQLException {
        //the way to insert scope on project has master scope
        int hd = 2;
        
        try {
            transferListMasScope(listScope, currentScope, hd);
            modelScope.setQueryProjectHasScopeSave(getIdProject(),getIdScope());
            kon.stat.executeUpdate(modelScope.insertInto);
        } catch (Exception e) {
                        
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText(String.valueOf("Duplicate Scope "));
                        alert.showAndWait();
        }
            
 
    }
    
    @FXML
    public void handleDelete(MouseEvent event) throws SQLException {
        String idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
        int taskId = Integer.parseInt(idTask);
        
        if(checkMandatoryTask(taskId) == true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(String.valueOf("Mandatory Task \n Task Tidak Dapat dihapus"));
            alert.showAndWait();
        } else{
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    
                    modelDetail.setOnDeleteTask(getIdProject(),idTask);
                    kon.stat.executeUpdate(modelDetail.delete);
                    
                    // ... user chose OK
                    

                } else {
                   alert.close();
                    // ... user chose CANCEL or closed the dialog
                }
                
                tblTask.refresh();
                setDataListTask(idProject);
                
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(String.valueOf(e));
                alert.showAndWait();
            }
            
        }
        //model to set on query
        
        
        
    }

    @FXML
    void handleInput(MouseEvent event) throws SQLException {
        try {
            btnInput.setContextMenu(contextTask);
        } catch (Exception e) {
        }
        
    }

  
    @FXML
    void handleModTask(MouseEvent event) throws SQLException {
        onSelectionTable();
        try {
        modelDetail.setOnModifiedTask(idProject,idTask,getEstStart(),getEstEnd(),getActStart(),getActEnd(),nowValue);
        kon.stat.executeUpdate(modelDetail.update);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Success");
            alert.setHeaderText(null);
            alert.setContentText(String.valueOf(" Project "+tblTask.getSelectionModel().getSelectedItem().getTaskCol()+" "
                    + "\n" +" Mod Success on \n"));
            alert.showAndWait();
            estEnd =null;
            estStart = null;
            actEnd =null;
            actStart = null;
            tblTask.refresh();
            setDataListTask(idProject);
        } catch (Exception e) {

        }
        

    }
    
    @FXML
    void handleTaskChange(MouseEvent event) {
        
        //Date now = Date.UTC(hd, hd, hd, hd, hd, hd);
        
        
    }
    
    /* 
    * this method is container listview selection
    * to move cell listview between
    * list to current
    * or current to list
    *
    */
    private void transferListMasKaryawan(JFXListView<MasKaryawan> listRemover, JFXListView<MasKaryawan> listContainer){
        MasKaryawan maska= listRemover.getSelectionModel().getSelectedItem();
        idKaryawan = listRemover.getSelectionModel().getSelectedItem().getIdKaryawan();
        
        
        listRemover.getSelectionModel().clearSelection();
        
        if(maska != null){
            if(listContainer == null){

                listRemover.getItems().remove(maska);
                listContainer.getItems().add(maska);
                
            } else{
                
                //check id karyawan exis
                //if id karyawan exis
                // do below
                if(checkIdExisKaryawan( listRemover, listContainer) == true){
                    
                    //check id list remover exis
                    //when idkaryawan on listkaryawan (the origin source)
                    //do method below and just remove the origin
                    if (hd == 2) {
                        listRemover.getItems().remove(maska);
                        
                    } else{
                        if(checkIdExisKaryawan(listRemover,listContainer) == true){
                            listRemover.getItems().remove(maska);
                        } else{
                            listRemover.getItems().remove(maska);
                            listContainer.getItems().add(maska);

                        }
                        
                    }
                    
                    // when the id karyawan not exis in additioner list
                    // do below
                } else{
                    //get the origin source and set to current list
                    // and save to database
                    if (hd == 2) {
                        onInsertKaryawan();
                    }

                    listRemover.getItems().remove(maska);
                    listContainer.getItems().add(maska);
                }                
            }
            listContainer.setCellFactory(maskaView -> new MasKaryawanDao());
        }
        
        currentTeam.setExpanded(true);
        currentTeam.depthProperty().set(1);
        currentTeam.getStyleClass().add("mylistview");
        
    }

    private void transferListMasScope(JFXListView<MasScope> listRemover, JFXListView<MasScope> listContainer, int hd){
        MasScope masScope= listRemover.getSelectionModel().getSelectedItem();
        idScope = listRemover.getSelectionModel().getSelectedItem().getIdScope();
        
        listRemover.getSelectionModel().clearSelection();

       //checking exis selection from list remover to listcontainer 
        if(masScope != null){
            if(listContainer == null){

                listRemover.getItems().remove(masScope);
                listContainer.getItems().add(masScope);
                
            } else{
                
                if(checkIdExisScope(listRemover, listContainer) == true){
                    
                    if (hd == 2) {

                        listRemover.getItems().remove(masScope);
                        
                    } else{
                        if(checkIdExisScope(listRemover, listContainer) == true){
                            listRemover.getItems().remove(masScope);
                        } else{
                            listRemover.getItems().remove(masScope);
                            listContainer.getItems().add(masScope);

                        }
                        
                    }
                    
                } else{

                    listRemover.getItems().remove(masScope);
                    listContainer.getItems().add(masScope);
                    //listContainer.setCellFactory(masScopeView -> new MasScopeDao());
                }                
            }
            listContainer.setCellFactory(masScopeView -> new MasScopeDao());
        }
        
        currentScope.setVerticalGap(30.0);
        currentScope.setExpanded(true);
        currentScope.depthProperty().set(1);
        currentScope.getStyleClass().add("mylistview");
        
    }
    
    /*
    this method below
    to check the destination list view have same data  
    */
 
    
    
    
    public void popupAsa(){
        String idItem = null;
        MenuItem quit = null;
        MenuItem quit2 = null;
        
        try {
            dataResponsibility=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelResponsibility.selectAll); 

            while (kon.res.next()) {
                dataResponsibility.addAll(new MasResponsibility(kon.res.getInt(1), kon.res.getString(2), 
                kon.res.getString(3)));
                
                //set text
                //set id text
                quit2 = new MenuItem(kon.res.getString(2));
                idItem = Integer.toString(kon.res.getInt(1));
                quit2.setId(idItem);
                contextMenu.getItems().addAll(quit2);
            }
            //an action on mouse clicked
            contextMenu.setOnAction(evt -> {
                idAsa = ((MenuItem)evt.getTarget()).getId();
                transferListMasKaryawan(listKaryawan, currentTeam);
                
            });
            
        } catch (Exception e) {
        }
    }
    
    public void onInsertKaryawan(){
        try {
            modelTeam.setQueryProjectHasTeam(idProject, idKaryawan, idAsa);
            kon.stat.executeUpdate(modelTeam.insertInto);
        } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText(String.valueOf(e));
                        alert.showAndWait();
        }
    }
    
    public void onSelectionTable(){
        formatter = new SimpleDateFormat("yyyy-MM-dd");
         try {
        idTask = tblTask.getSelectionModel().getSelectedItem().getIdTask();
        Date dateEstStart = tblTask.getSelectionModel().getSelectedItem().getEst_Datestart();
        Date dateEstEnd = tblTask.getSelectionModel().getSelectedItem().getEst_Dateend();
        Date dateActStart = tblTask.getSelectionModel().getSelectedItem().getAct_Datestart();
        Date dateActEnd = tblTask.getSelectionModel().getSelectedItem().getAct_Dateend();
        
        estStart = formatter.format(dateEstStart);
        estEnd = formatter.format(dateEstEnd);
        actStart = formatter.format(dateActStart);
        actEnd = formatter.format(dateActEnd);
        
        Date dateNow = new Date();
        nowValue = formatter.format(dateNow);
        } catch (Exception e) {
        }
   

    }
    

    
    public void popupTask(){
        String idItemTask = null;
        //MenuItem task = null;
        MenuItem menuTaskItem= null;
        
        try {
            dataTask=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelMasTask.selectAll); 

            while (kon.res.next()) {
                dataTask.addAll(new MasTask(kon.res.getString(1), kon.res.getString(2),
                        kon.res.getString(3),kon.res.getString(4),kon.res.getString(5) ));
                
                //set text
                //set id text
                menuTaskItem = new MenuItem(kon.res.getString(2));
                idItemTask = Integer.toString(kon.res.getInt(1));
                menuTaskItem.setId(idItemTask);
                contextTask.getItems().addAll(menuTaskItem);
            }
            //an action on mouse clicked
            contextTask.setOnAction(evt -> {
                idTask = ((MenuItem)evt.getTarget()).getId();
                onInputHandle();
                
                
            });

            tblTask.refresh();
            setDataListTask(idProject);
            
        } catch (Exception e) {
        }
    }
    
    private void onInputHandle() {
        if(checkIdExisTask(tblTask)==true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(String.valueOf("Duplicate Entry"));
            alert.showAndWait();
        }else{
            try {
                modelDetail.setOnInsertTask(idProject, idTask);
                kon.stat.executeUpdate(modelDetail.insertInto);

                tblTask.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(String.valueOf("Success add Task"));
                alert.showAndWait();
                tblTask.refresh();
                setDataListTask(idProject);
                
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(String.valueOf(e));
                alert.showAndWait();

            }
        }
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
    
    public String getIdAsa() {
        return idAsa;
    }

    public void setIdAsa(String value) {
        this.idAsa = value;
    }
    
    public int getIdHd() {
        return hd;
    }

    public void setIdHd(int value) {
        this.hd = value;
    }

    public String getEstStart() {
        String saString;
        if (estStart == null) {
            saString = null;
        } else {
            saString = "'"+estStart+"'";
        }
        return saString;
    }

    public String getEstEnd() {
        String saString;
        if (estEnd == null) {
            saString = null;
        } else {
            saString = "'"+estEnd+"'";
        }
        return saString;
    }

    public String getActStart() {
        String saString;
        if (actStart == null) {
            saString = null;
        } else {
            saString = "'"+actStart+"'";
        }
        return saString;
    }

    public String getActEnd() {
        String saString;
        if (actEnd == null) {
            saString = null;
        } else {
            saString = "'"+actEnd+"'";
        }
        return saString;
    }

    public void setEstStart(String estStart) {
        this.estStart = estStart;
    }

    public void setEstEnd(String estEnd) {
        this.estEnd = estEnd;
    }

    public void setActStart(String actStart) {
        this.actStart = actStart;
    }

    public void setActEnd(String actEnd) {
        this.actEnd = actEnd;
    }

    public String getNowValue() {
        return nowValue;
    }

    public void setNowValue(String nowValue) {
        this.nowValue = nowValue;
    }

    public String getIdTask() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }


    private void updateHandleCommitStartPlan() throws SQLException {
        try{
            Date dateActStart = tblTask.getSelectionModel().getSelectedItem().getEst_Datestart();
            String estStart1 = formatter.format(dateActStart);
            
            String valueSet ="`est_datestart`= '"+estStart1+"' ";
                    
            modelDetail.setOnModifiedDate(idProject,idTask,valueSet);
            kon.stat.executeUpdate(modelDetail.update);          
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Success Update Date");
        } catch (SQLException e){
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Error Data " + tblTask.getSelectionModel().getSelectedItem().getTaskCol() +" cannot Update Start Plan");
        }


    }

    private void updateHandleCommitEndPlan() throws SQLException {
        try{
            Date dateActStart = tblTask.getSelectionModel().getSelectedItem().getEst_Dateend();
            String estStart1 = formatter.format(dateActStart);
            
            String valueSet = "`est_dateend`= '"+estStart1+"'";
            modelDetail.setOnModifiedDate(idProject,idTask,valueSet);
            kon.stat.executeUpdate(modelDetail.update);
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Success Update Date");
        } catch (SQLException e){
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Error Data " + tblTask.getSelectionModel().getSelectedItem().getTaskCol() +" cannot Update Start Plan");
        }


    }

    private void updateHandleCommitActStart() throws SQLException {
        try{
            Date dateActStart = tblTask.getSelectionModel().getSelectedItem().getAct_Datestart();
            String estStart1 = formatter.format(dateActStart);
            
            String valueSet = "`act_datestart`= '"+estStart1+" '" ;
            modelDetail.setOnModifiedDate(idProject,idTask,valueSet);
            kon.stat.executeUpdate(modelDetail.update); 
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Success Update Date");
        } catch (SQLException e){
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Error Data " + tblTask.getSelectionModel().getSelectedItem().getTaskCol() +" cannot Update Start Plan");
        }


    }

    private void updateHandleCommitActEnd() throws SQLException {
        try{
            Date dateActStart = tblTask.getSelectionModel().getSelectedItem().getAct_Dateend();
            String estStart1 = formatter.format(dateActStart);
             
            String valueSet = "`act_dateend`= '"+estStart1+"'";
            modelDetail.setOnModifiedDate(idProject,idTask,valueSet);
            kon.stat.executeUpdate(modelDetail.update);
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Success Update Date");
        } catch (SQLException e){
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Error Data " + tblTask.getSelectionModel().getSelectedItem().getTaskCol() +" cannot Update Start Plan");
        }
    }
    
    public String makeId(){
        String  sql = "SELECT max(idproject) from project";
        
        try{
            preparedStatement = kon.con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                idProject = Integer.toString(resultSet.getInt(1)+1);
            } else{
                idProject=null;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return idProject;
    }
    
    public String checkForm(){
        
            if(comboCivitas.getValue()==null){
                if (idProject!= null) {
                    return "Success";
                } else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo CIvitas kosong"));
                    alert.showAndWait();
                    return "Error";
                }
            }else if(comboAcitivity.getValue()==null){
                if(idProject != null){
                    return "Success";
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboAcitivity kosong"));
                    alert.showAndWait();
                    return "Error";
                }
            }else if(comboAuditIndex.getValue()==null){
                if(idProject != null){
                    return "Success";
                } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboAuditIndex kosong"));
                    alert.showAndWait();
                    return "Error";
                }
            }else if(comboRiskFactor.getValue()==null){
                if(idProject != null){
                    return "Success";
                } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo comboRiskFactor kosong"));
                    alert.showAndWait();
                    return "Error";
                }
            } else if(dateStart.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo dateStart kosong"));
                    alert.showAndWait();
                    return "Error";
            }else if(dateEnd.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo dateEnd kosong"));
                    alert.showAndWait();
                    return "Error";
            }else if(valueProject.getText()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo valueProject kosong"));
                    alert.showAndWait();
                    return "Error";
            }
            else if(dateStart.getValue().isAfter(dateEnd.getValue())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("Check Date Value"));
                    alert.showAndWait();
                    return "Error";
            } 
            else {
                return "Success";
            }
           
    }
    
    public void setBtnDisable(){
        if(getIdProject() == null){
            listKaryawan.setDisable(true);
            listScope.setDisable(true);
            currentScope.setDisable(true);
            currentTeam.setDisable(true);
            btnMod.setDisable(true);
            btnInput.setDisable(true);
            btnTaskDel.setDisable(true);
            btnTaskMod.setDisable(true);
            
        } else{
            btnSave.setDisable(true);
            valueProject.setDisable(true);
            valueActivity1.setDisable(true);
            comboAcitivity.setDisable(true);
            comboAcitivity.setVisible(false);
            valueCivitas1.setDisable(true);
            comboCivitas.setDisable(true);
            comboCivitas.setVisible(false);
            
            
            dateEnd.setDisable(false);
            dateStart.setDisable(false);
            listKaryawan.setDisable(false);
            listScope.setDisable(false);
            currentScope.setDisable(false);
            currentTeam.setDisable(false);
            btnMod.setDisable(false);
            btnInput.setDisable(false);
            btnTaskDel.setDisable(false);
            btnTaskMod.setDisable(false);
        }
            
    }
    
       private boolean checkIdExisKaryawan(JFXListView<MasKaryawan> listRemover, JFXListView<MasKaryawan> listContainer) {
        //bolean checking id selection list remover to list array on list container
        List<String> listChecker = listContainer.getItems().stream().
                        map(MasKaryawan::getIdKaryawan).
                        collect(Collectors.toList());
        
        for (String listChecker1 : listChecker) {
            if (listChecker1.trim().contains(listRemover.getId())) {        
                return true;
            }
        }     

        return false;
    }
    
    private boolean checkIdExisScope(JFXListView<MasScope> listRemover, JFXListView<MasScope> listContainer) {
        //bolean checking id selection list remover to list array on list container
        List<String> listChecker = listContainer.getItems().stream().
                        map(MasScope::getIdScope).
                        collect(Collectors.toList());
        for (String listChecker1 : listChecker) {
            if (listChecker1.trim().contains(idScope)) {
                
                return true;
            }
        }
        return false;
    }
    

    /*
    checking 
    when user remove mandatory task,
    mandatory task blocked to removed 
    */
    private boolean checkMandatoryTask(int taskId) {
        //bolean checking id selection list 
        if(taskId == 1 || taskId == 3 || taskId == 7 || taskId == 12 || taskId == 13
                || taskId == 15){
            return true;
        } else {
            return false;
        }
        
    }
    
        private boolean checkIdExisTask(TableView<ListTaskProject> tblContainer) {
        //bolean checking id selection list remover to list array on list container
        List<String> listChecker = tblContainer.getItems().stream().
                        map(ListTaskProject::getIdTask).
                        collect(Collectors.toList());
        
        for (String listChecker1 : listChecker) {
            if (idTask.trim().contains(listChecker1)) {        
                return true;
            }
        }     
        return false;
    }
}
