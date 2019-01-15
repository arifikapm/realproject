/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import db.koneksi;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.ProfileChartBar;
import model.ProfileChartBarDao;
import model.ProfileChartPie;
import model.ProfileChartPieDao;
import model.Count;
import model.CountDao;
import model.ListCarryProject;
import model.ListCarryProjectDao;
import model.ListCountProject;
import model.ListCountProjectDao;
import model.ProfileAverageDao;
import model.ProfileLine;
import model.ProfileLineDao;
import model.ProfileOverdue;
import model.ProfileOverdueDao;
import model.Project;
import model.ProjectDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DASHBOARDController implements Initializable {
  
    public String textProject, testStringValue;

//    @FXML
//    private BorderPane viewProject;
    @FXML
    private PieChart labelPieChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private PieChart labelPieChart1;
    @FXML
    private PieChart pieChart1;
    @FXML
    private PieChart labelPieChart2;
    @FXML
    private PieChart pieChart2;
    @FXML
    private PieChart labelPieChart3;
    @FXML
    private PieChart pieChart3;
    
    @FXML
    private PieChart legendAss;
    @FXML
    private PieChart legendRisk;
    @FXML
    private PieChart legendAdv;
    @FXML
    private PieChart legendOthers;
    
    @FXML
    private BarChart<String, Number> barProfileRisk;
    @FXML
    private BarChart<String, Number> barProfileAssurance;
//    @FXML
//    private LineChart<String, Number> lineChart;
    @FXML
    private JFXListView<ListCountProject> listCountProject;
    @FXML
    private JFXListView<ListCarryProject>listCarryProject;
//    @FXML
//    private JFXListView<ProfileOverdue> listOverdue;
//    @FXML
//    private JFXListView<ProfileOverdue> listAverage;
    @FXML
    private TableView<Project> listProject;
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
    @FXML
    private Label valueCountProject;
    
    
    
    
    koneksi kon = new koneksi();
    ListCountProjectDao model =new ListCountProjectDao();
    ListCarryProjectDao modelCarry =new ListCarryProjectDao();
    CountDao modelCount = new CountDao();
    ProjectDao modelProject = new ProjectDao();
    ProfileChartPieDao modelChartProfile = new ProfileChartPieDao();
    ProfileChartBarDao barProfileDao = new ProfileChartBarDao();
    ProfileOverdueDao modelProfileOverdue = new ProfileOverdueDao();
    ProfileAverageDao modelProfileAverage = new ProfileAverageDao();
    ProfileLineDao modelProfileLine = new ProfileLineDao();
    
    private ObservableList<ProfileChartBar> datachartBarProfiles;
    private ObservableList<ListCountProject> dataCountProject;
    private ObservableList<ListCarryProject> dataCarryProject;
    private ObservableList<ProfileLine> dataProfileLine;
    private ObservableList<ProfileOverdue> dataProfileOverdue;
    private ObservableList<ProfileOverdue> dataProfileAverage;
    private ObservableList<Count> dataCount;
    private ObservableList<Project> dataProject;
    private ObservableList<PieChart.Data> AssuranceData;
    private ObservableList<PieChart.Data> RiskAssesment;
    private ObservableList<PieChart.Data> Advisory;
    private ObservableList<PieChart.Data> Others;


    
//    private void loadListProject() throws SQLException{
//        try {
////            String load = "1";
////            modelProject.queryLoadAllListProject(load);
//            double percent = 0;
//            dataProject=FXCollections.observableArrayList();
//            kon.res=kon.stat.executeQuery(modelProject.queryListProject);
//            
//            while (kon.res.next()) {                
//                dataProject.add(new Project
//                        (kon.res.getString(1), kon.res.getInt(2), kon.res.getString(3), kon.res.getString(4), 
//                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), 
//                        kon.res.getString(9), kon.res.getString(10),kon.res.getString(11), kon.res.getString(12), 
//                        kon.res.getDouble(13),kon.res.getString(14), kon.res.getString(15), kon.res.getInt(16), 
//                        kon.res.getInt(17), kon.res.getInt(18), kon.res.getInt(19), kon.res.getInt(20), kon.res.getInt(21),
//                        kon.res.getInt(22), kon.res.getInt(23), kon.res.getInt(24), kon.res.getInt(25), kon.res.getInt(26),
//                        kon.res.getInt(27),kon.res.getString(28),kon.res.getString(29),kon.res.getString(30)));
//                
//                colBisnisUnit.setCellValueFactory(new PropertyValueFactory<>("CivitasCol"));
//                colCategory.setCellValueFactory(new PropertyValueFactory<>("InisialActivity"));
//                colStart.setCellValueFactory(new PropertyValueFactory<>("NameStartMonth"));
//                colFinisih.setCellValueFactory(new PropertyValueFactory<>("NameEndMonth"));
//                percent = kon.res.getDouble(13) * 100 ;
//                colProgress.setCellValueFactory(new PropertyValueFactory<>("ShowPercent"));
//                colRFactor.setCellValueFactory(new PropertyValueFactory<>("ValueRisk"));
//                colIndex.setCellValueFactory(new PropertyValueFactory<>("IndexAudit"));
//                listProject.setItems(null);
//                listProject.setItems(dataProject);
//
//            }
//        }catch (Exception e) {
//        }
//    }




    private void loadBarProfileRisk(){
  
        try {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            kon.res=kon.stat.executeQuery(barProfileDao.testLoad);

            while (kon.res.next()) {
                
                series.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series.setName(kon.res.getString(2)); 
                
            }
            barProfileRisk.getData().addAll(series);
        } catch (Exception e) {
        }
       
      
    }
    
    private void loadProfileRisk(){
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();  
      series1.setName("Not Yet Due"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="2";
            int idStatus=1;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series1.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series1.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series2 = new XYChart.Series<>();  
      series2.setName("In Progress"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="2";
            int idStatus=2;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series2.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series2.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series3 = new XYChart.Series<>();  
      series3.setName("Close"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="2";
            int idStatus=3;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series3.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series3.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series4 = new XYChart.Series<>();  
      series4.setName("Complete"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="2";
            int idStatus=4;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series4.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series4.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      barProfileRisk.getData().addAll(series1,series2,series3,series4);
    }
    
    private void loadProfileAssurance(){
              XYChart.Series<String, Number> series1 = new XYChart.Series<>();  
      series1.setName("Not Yet Due"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="1";
            int idStatus=1;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series1.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series1.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series2 = new XYChart.Series<>();  
      series2.setName("In Progress"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="1";
            int idStatus=2;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series2.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series2.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series3 = new XYChart.Series<>();  
      series3.setName("Close"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="1";
            int idStatus=3;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series3.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series3.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      XYChart.Series<String, Number> series4 = new XYChart.Series<>();  
      series4.setName("Complete"); 
      try {
            //XYChart.Series<String, Number> series = new XYChart.Series<>();
            String idActivity="1";
            int idStatus=4;
            
            barProfileDao.returnLoadBarProfile(idActivity, idStatus);
            kon.res=kon.stat.executeQuery(barProfileDao.Select);
            
            while (kon.res.next()) {
                
                series4.getData().add(new XYChart.Data<>(kon.res.getString(3),kon.res.getInt(4)));
                series4.setName(kon.res.getString(2)); 
                
            }
            
        } catch (Exception e) {
        }
      
      barProfileAssurance.getData().addAll(series1,series2,series3,series4);
    }
    
    
    private void loadListCountProject(){
        try {
                dataCountProject=FXCollections.observableArrayList();
                kon.res=kon.stat.executeQuery(model.queryLoadCountProject);

                while (kon.res.next()) {                
                    dataCountProject.add(new ListCountProject(kon.res.getString(1),kon.res.getString(2)));
            }
                listCountProject.setItems(dataCountProject);
                listCountProject.setCellFactory(list -> new ListCountProjectDao());
                listCountProject.setVerticalGap(30.0);
                listCountProject.setExpanded(true);
                listCountProject.depthProperty().set(1);
                listCountProject.getStyleClass().add("mylistview");

        } catch (Exception e) {
        }
    }
    private void loadListCarryProject(){
        try {
                dataCarryProject=FXCollections.observableArrayList();
                kon.res=kon.stat.executeQuery(modelCarry.queryLoadCarryProject);
                
                
                while (kon.res.next()) {                
                    dataCarryProject.add(new ListCarryProject(kon.res.getString(1), kon.res.getString(2), 
                            kon.res.getString(3), kon.res.getString(4), kon.res.getString(5), 
                            kon.res.getString(6), kon.res.getString(7), kon.res.getString(8)));
            }
                listCarryProject.setItems(dataCarryProject);
                listCarryProject.setCellFactory(list -> new ListCarryProjectDao());
                listCarryProject.setVerticalGap(30.0);
                listCarryProject.setExpanded(true);
                listCarryProject.depthProperty().set(1);
                listCarryProject.getStyleClass().add("mylistview");

        } catch (Exception e) {
        }
    }
    
    private void loadAllCountProject(){
        try {
            dataCount=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelCount.selectCount);
            
            while (kon.res.next()) {                
                dataCount.add(new Count(kon.res.getString(1)));
                textProject = kon.res.getString(1);
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
    }
    
//    private void loadListOverdueProject(){
//        try {
//                dataProfileOverdue=FXCollections.observableArrayList();
//                kon.res=kon.stat.executeQuery(modelProfileOverdue.queryLoadOverdue);
//
//                while (kon.res.next()) {                
//                    dataProfileOverdue.add(new ProfileOverdue(kon.res.getString(1), kon.res.getDouble(2), 
//                            kon.res.getDouble(3)));
//                    
//            }
//                listOverdue.setItems(dataProfileOverdue);
//                listOverdue.setCellFactory(list -> new ProfileOverdueDao());
//
//        } catch (Exception e) {
//            
//        }
//    }
        
//    private void loadListAverageProject(){
//        try {
//                dataProfileOverdue=FXCollections.observableArrayList();
//                kon.res=kon.stat.executeQuery(modelProfileAverage.queryLoadOverdue);
//
//                while (kon.res.next()) {                
//                    dataProfileOverdue.add(new ProfileOverdue(kon.res.getString(1), kon.res.getDouble(2), 
//                            kon.res.getDouble(3)));
//            }
//                listAverage.setItems(dataProfileOverdue);
//                listAverage.setCellFactory(list -> new ProfileAverageDao());
//
//        } catch (Exception e) {
//        }
//    }
    
//    private void loadProfileLine(){
//      XYChart.Series series1 = new XYChart.Series<>();  
//      series1.setName("Plan"); 
//      try {
//            kon.res=kon.stat.executeQuery(modelProfileLine.selectPlanLine);
//            
//            while (kon.res.next()) {
//                
//                series1.getData().add(new XYChart.Data<>(kon.res.getString(1),kon.res.getInt(2)));
//                //series1.setName(kon.res.getString(2)); 
//                
//            }
//            
//        } catch (Exception e) {
//            System.out.println("plan error ===! "+e);
//        }
//      
//      XYChart.Series series2 = new XYChart.Series<>();  
//      series2.setName("In Progres"); 
//      try {
//            kon.res=kon.stat.executeQuery(modelProfileLine.selectInprogress);
//            
//            while (kon.res.next()) {
//                
//                series2.getData().add(new XYChart.Data<>(kon.res.getString(1),kon.res.getInt(2)));
//                //series1.setName(kon.res.getString(2)); 
//                
//            }
//            
//        } catch (Exception e) {
//            System.out.println("plan error ===! "+e);
//        }
//      
//      XYChart.Series series3 = new XYChart.Series<>();  
//      series3.setName("Complete"); 
//      try {
//            kon.res=kon.stat.executeQuery(modelProfileLine.selectCompleteLine);
//            
//            while (kon.res.next()) {
//                
//                series3.getData().add(new XYChart.Data<>(kon.res.getString(1),kon.res.getInt(2)));
//                //series1.setName(kon.res.getString(2)); 
//                
//            }
//            
//        } catch (Exception e) {
//            System.out.println("plan error ===! "+e);
//        }
//      lineChart.getData().addAll(series1,series2,series3);
//      lineChart.setLegendVisible(true);
//    }

    /**
     * Initializes the controller class.
     */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        loadListCountProject();
        loadListCarryProject();
        loadAllCountProject();
//        loadListOverdueProject();
//        loadListAverageProject();
        
        loadPieAss();
        labelPieAss();
        legendPieAss();
//        
        loadPieRisk();
        labelPieRisk();
        legendPieRisk(); 
//        
        loadPieOth();
        labelPieOth();
        legendPieOth();
        
        loadPieAdv();
        labelPieAdv();
        legendPieAdv();
        
        //loadBarProfileRisk();
        
        loadProfileRisk();
        loadProfileAssurance();
//        loadProfileLine();
        try {
            int idStatusLoad = 2;
            loadListProject(idStatusLoad);
//
//        loadListCountProject();
//

//        
//        loadProfileQuarter();
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void legendPieAss() {

        try {
            String set_idacticvity = "1";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                AssuranceData.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        legendAss.setLegendSide(Side.TOP);
        legendAss.setData(AssuranceData);
        
        for (PieChart.Data data : AssuranceData) {
            int idx = AssuranceData.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: transparent");
        }

        
    }
    
    public void loadPieAss() {

        try {
            String set_idacticvity = "1";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                AssuranceData.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        labelPieChart.setClockwise(true);
        labelPieChart.setLabelLineLength(0);
        labelPieChart.setLabelsVisible(false);
        labelPieChart.setMinSize(150, 150);
        labelPieChart.setLegendVisible(false);
        labelPieChart.setData(AssuranceData);

        
    }
    
    public void labelPieAss(){

        try {
            String set_idacticvity = "1";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                AssuranceData.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(10);

        pieChart.setMaxSize(350, 350);
        pieChart.setLabelsVisible(true);

        pieChart.setLegendVisible(false);
        pieChart.setData(AssuranceData);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        AssuranceData.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), AssuranceData);
        
        AssuranceData.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.1f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : AssuranceData) {
            int idx = AssuranceData.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
//    
    public void legendPieRisk() {

        try {
            String set_idacticvity = "2";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                RiskAssesment.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        legendRisk.setLegendSide(Side.TOP);
        legendRisk.setData(RiskAssesment);
        
        for (PieChart.Data data : RiskAssesment) {
            int idx = RiskAssesment.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: transparent");
        }

        
    }
    
    public void loadPieRisk() {
        try {
            String set_idacticvity = "2";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                RiskAssesment.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart2.setClockwise(true);
        labelPieChart2.setLabelsVisible(false);
        //labelPieChart2.setMinSize(20, 20);
        labelPieChart2.setLegendVisible(false);
        labelPieChart2.setLegendSide(Side.TOP);
        labelPieChart2.setData(RiskAssesment);

        
    }
//    
    
    public void labelPieRisk(){
        try {
            String set_idacticvity = "2";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                RiskAssesment.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        pieChart2.setClockwise(true);
        pieChart2.setLabelLineLength(10);

        pieChart2.setMaxSize(2550,2550);
        pieChart2.setLabelsVisible(true);

        pieChart2.setLegendVisible(false);
        pieChart2.setData(RiskAssesment);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        RiskAssesment.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), RiskAssesment);
        
        RiskAssesment.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.1f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : RiskAssesment) {
            int idx = RiskAssesment.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
//    
    public void legendPieOth() {

        try {
            String set_idacticvity = "4";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Others.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        legendOthers.setLegendSide(Side.TOP);
        legendOthers.setData(Others);
        
        for (PieChart.Data data : Others) {
            int idx = RiskAssesment.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: transparent");
        }

        
    }
    
    public void loadPieOth() {
        try {
            String set_idacticvity = "4";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Others.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart1.setClockwise(true);
        
        labelPieChart1.setLabelsVisible(false);
        labelPieChart1.setMinSize(150, 150);
        labelPieChart1.setLegendVisible(false);
        labelPieChart1.setLegendSide(Side.TOP);
        labelPieChart1.setData(Others);

        
    }
//       
    public void labelPieOth(){
        try {
            String set_idacticvity = "4";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Others.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart1.setClockwise(true);
        pieChart1.setLabelLineLength(10);

        pieChart1.setMaxSize(280, 280);
        pieChart1.setLabelsVisible(true);

        pieChart1.setLegendVisible(false);
        pieChart1.setData(Others);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        Others.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), Others);
        
        Others.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.1f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : Others) {
            int idx = Others.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
//    
       public void legendPieAdv() {

        try {
            String set_idacticvity = "3";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Advisory.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        legendAdv.setLegendSide(Side.TOP);
        legendAdv.setData(Advisory);
        
        for (PieChart.Data data : Advisory) {
            int idx = Advisory.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: transparent");
        }

        
    }
    
    public void loadPieAdv() {
        try {
            String set_idacticvity = "3";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Advisory.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart3.setClockwise(true);
        labelPieChart3.setLabelLineLength(0);
        labelPieChart3.setLabelsVisible(false);
        labelPieChart3.setMinSize(150, 150);
        //labelPieChart3.setLegendVisible(true);
        labelPieChart3.setLegendSide(Side.TOP);
        labelPieChart3.setData(Advisory);

        
    }
//    
    public void labelPieAdv(){
        try {
            String set_idacticvity = "3";
            modelChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(modelChartProfile.Select);
            
            while (kon.res.next()) {                
                Advisory.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart3.setClockwise(true);
        pieChart3.setLabelLineLength(10);

        pieChart3.setMaxSize(280, 280);
        pieChart3.setLabelsVisible(true);

        pieChart3.setLegendVisible(false);
        pieChart3.setData(Advisory);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        Advisory.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), Advisory);
        
        Advisory.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.1f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : Advisory) {
            int idx = Advisory.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
    
    private void loadListProject(int idStatusLoad) throws SQLException{
        try {
//            String load = "1";
//            modelProject.queryLoadAllListProject(load);
            double percent = 0;
            modelProject.loadProfilePerStatus(idStatusLoad);
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
    
    
    }
