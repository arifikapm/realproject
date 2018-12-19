/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import db.koneksi;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Set;
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
import model.ProfileChartBar;
import model.ProfileChartBarDao;
import model.ProfileChartPie;
import model.ProfileChartPieDao;
import model.Count;
import model.CountDao;
import model.ListCountProject;
import model.ListCountProjectDao;
import model.ProfileAverageDao;
import model.ProfileOverdue;
import model.ProfileOverdueDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DASHBOARDController implements Initializable {
  
    private String textProject, testStringValue;;

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
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private JFXListView<ListCountProject> listCountProject;
    @FXML
    private JFXListView<ProfileOverdue> listOverdue;
    @FXML
    private JFXListView<ProfileOverdue> listAverage;
    @FXML
    private Label valueCountProject;
    
    
    
    koneksi kon = new koneksi();
    ListCountProjectDao dao =new ListCountProjectDao();
    CountDao daoCount = new CountDao();
    ProfileChartPieDao daoChartProfile = new ProfileChartPieDao();
    ProfileChartBarDao barProfileDao = new ProfileChartBarDao();
    ProfileOverdueDao daoProfileOverdue = new ProfileOverdueDao();
    ProfileAverageDao daoProfileAverage = new ProfileAverageDao();
    
    private ObservableList<ProfileChartBar> datachartBarProfiles;
    private ObservableList<ListCountProject> dataCountProject;
    private ObservableList<ProfileOverdue> dataProfileOverdue;
    private ObservableList<ProfileOverdue> dataProfileAverage;
    private ObservableList<Count> dataCount;
    private ObservableList<PieChart.Data> AssuranceData;
    private ObservableList<PieChart.Data> RiskAssesment;
    private ObservableList<PieChart.Data> Advisory;
    private ObservableList<PieChart.Data> Others;



    private void loadBarProfileRisk(){
  
        try {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            kon.res=kon.stat.executeQuery(barProfileDao.testLoad);
            System.out.println(barProfileDao.testLoad);
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
                kon.res=kon.stat.executeQuery(dao.queryLoadCountProject);

                while (kon.res.next()) {                
                    dataCountProject.add(new ListCountProject(kon.res.getString(1),kon.res.getString(2)));
            }
                listCountProject.setItems(dataCountProject);
                listCountProject.setCellFactory(list -> new ListCountProjectDao());

        } catch (Exception e) {
        }
    }
    
    private void loadAllCountProject(){
        try {
            dataCount=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoCount.selectCount);
            
            while (kon.res.next()) {                
                dataCount.add(new Count(kon.res.getString(1)));
                textProject = kon.res.getString(1);
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
    }
    
    private void loadListOverdueProject(){
        try {
                dataProfileOverdue=FXCollections.observableArrayList();
                kon.res=kon.stat.executeQuery(daoProfileOverdue.queryLoadOverdue);

                while (kon.res.next()) {                
                    dataProfileOverdue.add(new ProfileOverdue(kon.res.getString(1), kon.res.getDouble(2), 
                            kon.res.getDouble(3)));
            }
                listOverdue.setItems(dataProfileOverdue);
                listOverdue.setCellFactory(list -> new ProfileOverdueDao());

        } catch (Exception e) {
        }
    }
        
    private void loadListAverageProject(){
        try {
                dataProfileOverdue=FXCollections.observableArrayList();
                kon.res=kon.stat.executeQuery(daoProfileAverage.queryLoadOverdue);

                while (kon.res.next()) {                
                    dataProfileOverdue.add(new ProfileOverdue(kon.res.getString(1), kon.res.getDouble(2), 
                            kon.res.getDouble(3)));
            }
                listAverage.setItems(dataProfileOverdue);
                listAverage.setCellFactory(list -> new ProfileAverageDao());

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
        loadListCountProject();
        loadAllCountProject();
        loadListOverdueProject();
        loadListAverageProject();
        
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
//
//        loadListCountProject();
//        
       
//        
//        loadProfileQuarter();
    }    
    
    public void legendPieAss() {

        try {
            String set_idacticvity = "1";
            daoChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                AssuranceData.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        labelPieChart.setClockwise(true);
        labelPieChart.setLabelLineLength(0);
        labelPieChart.setLabelsVisible(false);
        labelPieChart.setMinSize(250, 250);
        labelPieChart.setLegendVisible(false);
        labelPieChart.setData(AssuranceData);

        
    }
    
    public void labelPieAss(){

        try {
            String set_idacticvity = "1";
            daoChartProfile.returnLoadProfile(set_idacticvity);
            AssuranceData=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                AssuranceData.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(5);

        pieChart.setMaxSize(280, 280);
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                RiskAssesment.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart2.setClockwise(true);
        labelPieChart2.setLabelLineLength(0);
        labelPieChart2.setLabelsVisible(false);
        labelPieChart2.setMinSize(220, 220);
        labelPieChart2.setLegendVisible(false);
        labelPieChart2.setLegendSide(Side.TOP);
        labelPieChart2.setData(RiskAssesment);

        
    }
//    
    
    public void labelPieRisk(){
        try {
            String set_idacticvity = "2";
            daoChartProfile.returnLoadProfile(set_idacticvity);
            RiskAssesment=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                RiskAssesment.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        pieChart2.setClockwise(true);
        pieChart2.setLabelLineLength(5);

        pieChart2.setMaxSize(280, 280);
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                Others.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart1.setClockwise(true);
        labelPieChart1.setLabelLineLength(0);
        labelPieChart1.setLabelsVisible(false);
        labelPieChart1.setMinSize(180, 180);
        labelPieChart1.setLegendVisible(false);
        labelPieChart1.setLegendSide(Side.TOP);
        labelPieChart1.setData(Others);

        
    }
//       
    public void labelPieOth(){
        try {
            String set_idacticvity = "4";
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Others=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                Others.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart1.setClockwise(true);
        pieChart1.setLabelLineLength(0);

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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
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
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                Advisory.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        labelPieChart3.setClockwise(true);
        labelPieChart3.setLabelLineLength(0);
        labelPieChart3.setLabelsVisible(false);
        labelPieChart3.setMinSize(220, 220);
        //labelPieChart3.setLegendVisible(true);
        labelPieChart3.setLegendSide(Side.TOP);
        labelPieChart3.setData(Advisory);

        
    }
//    
    public void labelPieAdv(){
        try {
            String set_idacticvity = "3";
            daoChartProfile.returnLoadProfile(set_idacticvity);
            Advisory=FXCollections.observableArrayList();
            kon.res = kon.stat.executeQuery(daoChartProfile.Select);
            
            while (kon.res.next()) {                
                Advisory.add(new PieChart.Data(kon.res.getString(2),kon.res.getInt(3)));
            }
            valueCountProject.setText(textProject);
            
        } catch (Exception e) {
        }
        
        pieChart3.setClockwise(true);
        pieChart3.setLabelLineLength(5);

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
    
    
    }
