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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.Count;
import model.CountDao;
import model.ListCountProject;
import model.ListCountProjectDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DASHBOARDController implements Initializable {
  
    private String textProject;

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
    private StackedBarChart<String, Number> stackedAssurance;
    @FXML
    private StackedBarChart<?, ?> stackedRisk;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private JFXListView<ListCountProject> listCountProject;
    @FXML
    private Label valueCountProject;
    
    koneksi kon = new koneksi();
    ListCountProjectDao dao =new ListCountProjectDao();
    CountDao daoCount = new CountDao();
    //PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<ListCountProject> dataCountProject;
    private ObservableList<Count> dataCount;

    
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
            System.out.println(textProject);
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
        
//        loadPieAss();
//        labelPieAss();
//        
//        loadPieRisk();
//        labelPieRisk();
//        
//        loadPieOth();
//        labelPieOth();
//        
//        loadPieAdv();
//        labelPieAdv();
//
//        loadListCountProject();
//        
//        loadStackedBarAssurance();
//        
//        loadProfileQuarter();
    }    

//    private void showPercentage(MouseEvent event) {
//        final Label caption = new Label("");
//caption.setTextFill(Color.DARKORANGE);
//caption.setStyle("-fx-font: 24 arial;");
//
////for (final PieChart.Data data : pieAssurance.getData()) {
////    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
////        new EventHandler<MouseEvent>() {
////            @Override public void handle(MouseEvent e) {
////                caption.setTranslateX(e.getSceneX());
////                caption.setTranslateY(e.getSceneY());
////                caption.setText(String.valueOf(data.getPieValue()) + "%");
////             }
////        });
////    }
////    }
//    

//    public void loadPieAss() {
//        ObservableList<PieChart.Data> pieChartAssurance1=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        labelPieChart.setClockwise(true);
//        labelPieChart.setLabelLineLength(0);
//        labelPieChart.setLabelsVisible(false);
//        labelPieChart.setMinSize(280, 280);
//        labelPieChart.setLegendVisible(true);
//        labelPieChart.setLegendSide(Side.TOP);
//        labelPieChart.setData(pieChartAssurance1);
//
//        
//    }
//    
//    public void labelPieAss(){
//        ObservableList<PieChart.Data> pieChartAssurance2=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        pieChart.setClockwise(true);
//        pieChart.setLabelLineLength(5);
//
//        pieChart.setMaxSize(270, 270);
//        pieChart.setLabelsVisible(true);
//
//        pieChart.setLegendVisible(false);
//        pieChart.setData(pieChartAssurance2);
//        
//        DoubleBinding total = Bindings.createDoubleBinding(() ->
//        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
//        
//        pieChartAssurance2.forEach(data -> 
//        data.nameProperty().bind(Bindings.concat(
//        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
//        // #a9a9a9
//        
//        for (PieChart.Data data : pieChartAssurance2) {
//            int idx = pieChartAssurance2.indexOf(data);
//            data.getNode().setStyle("-fx-pie-color: #ffffff");
//            
//        }
//    }
//    
//    public void loadPieRisk() {
//        ObservableList<PieChart.Data> pieChartAssurance1=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        labelPieChart2.setClockwise(true);
//        labelPieChart2.setLabelLineLength(0);
//        labelPieChart2.setLabelsVisible(false);
//        labelPieChart2.setMinSize(280, 280);
//        labelPieChart2.setLegendVisible(true);
//        labelPieChart2.setLegendSide(Side.TOP);
//        labelPieChart2.setData(pieChartAssurance1);
//
//        
//    }
//    
//    public void labelPieRisk(){
//        ObservableList<PieChart.Data> pieChartAssurance2=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        pieChart2.setClockwise(true);
//        pieChart2.setLabelLineLength(5);
//
//        pieChart2.setMaxSize(270, 270);
//        pieChart2.setLabelsVisible(true);
//
//        pieChart2.setLegendVisible(false);
//        pieChart2.setData(pieChartAssurance2);
//        
//        DoubleBinding total = Bindings.createDoubleBinding(() ->
//        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
//        
//        pieChartAssurance2.forEach(data -> 
//        data.nameProperty().bind(Bindings.concat(
//        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
//        // #a9a9a9
//        
//        for (PieChart.Data data : pieChartAssurance2) {
//            int idx = pieChartAssurance2.indexOf(data);
//            data.getNode().setStyle("-fx-pie-color: #ffffff");
//            
//        }
//    }
//    
//    public void loadPieOth() {
//        ObservableList<PieChart.Data> pieChartAssurance1=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        labelPieChart1.setClockwise(true);
//        labelPieChart1.setLabelLineLength(0);
//        labelPieChart1.setLabelsVisible(false);
//        labelPieChart1.setMinSize(280, 280);
//        labelPieChart1.setLegendVisible(true);
//        labelPieChart1.setLegendSide(Side.TOP);
//        labelPieChart1.setData(pieChartAssurance1);
//
//        
//    }
//    
//    public void labelPieOth(){
//        ObservableList<PieChart.Data> pieChartAssurance2=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        pieChart1.setClockwise(true);
//        pieChart1.setLabelLineLength(5);
//
//        pieChart1.setMaxSize(240, 240);
//        pieChart1.setLabelsVisible(true);
//
//        pieChart1.setLegendVisible(false);
//        pieChart1.setData(pieChartAssurance2);
//        
//        DoubleBinding total = Bindings.createDoubleBinding(() ->
//        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
//        
//        pieChartAssurance2.forEach(data -> 
//        data.nameProperty().bind(Bindings.concat(
//        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
//        // #a9a9a9
//        
//        for (PieChart.Data data : pieChartAssurance2) {
//            int idx = pieChartAssurance2.indexOf(data);
//            data.getNode().setStyle("-fx-pie-color: #ffffff");
//            
//        }
//    }
//    
//    public void loadPieAdv() {
//        ObservableList<PieChart.Data> pieChartAssurance1=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        labelPieChart3.setClockwise(true);
//        labelPieChart3.setLabelLineLength(0);
//        labelPieChart3.setLabelsVisible(false);
//        labelPieChart3.setMinSize(280, 280);
//        labelPieChart3.setLegendVisible(true);
//        labelPieChart3.setLegendSide(Side.TOP);
//        labelPieChart3.setData(pieChartAssurance1);
//
//        
//    }
//    
//    public void labelPieAdv(){
//        ObservableList<PieChart.Data> pieChartAssurance2=
//                FXCollections.observableArrayList(
//                new PieChart.Data("Not Yet", 3),
//                new PieChart.Data("In Progress", 5),
//                new PieChart.Data("Complete", 7),
//                new PieChart.Data("Finish", 1));
//        
//        pieChart3.setClockwise(true);
//        pieChart3.setLabelLineLength(5);
//
//        pieChart3.setMaxSize(240, 240);
//        pieChart3.setLabelsVisible(true);
//
//        pieChart3.setLegendVisible(false);
//        pieChart3.setData(pieChartAssurance2);
//        
//        DoubleBinding total = Bindings.createDoubleBinding(() ->
//        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
//        
//        pieChartAssurance2.forEach(data -> 
//        data.nameProperty().bind(Bindings.concat(
//        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
//        // #a9a9a9
//        
//        for (PieChart.Data data : pieChartAssurance2) {
//            int idx = pieChartAssurance2.indexOf(data);
//            data.getNode().setStyle("-fx-pie-color: #ffffff");
//            
//        }
//    }
//    
//    public void loadStackedBarAssurance(){
//        //defining the axes
////      CategoryAxis yAxis = new CategoryAxis();    
////      yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
////         ("Manufacture", "Trading", "Corporate")));
////      
////      yAxis.setLabel("Status");
////      NumberAxis xAxis = new NumberAxis(); 
////      xAxis.setLabel("Population");
//      
//      //Creating the Bar chart 
//      //stackedAssurance = new StackedBarChart(xAxis, yAxis);
//      //stackedAssurance.setTitle("haloooo percobaan");
//      
//       //Prepare XYChart.Series objects by setting data 
//      XYChart.Series<String, Number> series1 = new XYChart.Series<>();  
//      series1.setName("Not Yet Due"); 
//      series1.getData().add(new XYChart.Data<>("Manufactured",10));
//      series1.getData().add(new XYChart.Data<>("Trading",3));
//      series1.getData().add(new XYChart.Data<>("Corporate",1));
//
//         
//      XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
//      series2.setName("In Progress"); 
//      series2.getData().add(new XYChart.Data<>("Manufactured",3));
//      series2.getData().add(new XYChart.Data<>("Trading",2));
//      series2.getData().add(new XYChart.Data<>("Corporate",0));
//     
//      XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
//      series3.setName("Closed"); 
//      series3.getData().add(new XYChart.Data<>("Manufactured",2));
//      series3.getData().add(new XYChart.Data<>("Trading",1));
//      series3.getData().add(new XYChart.Data<>("Corporate",0));
//      
//      XYChart.Series<String, Number> series4 = new XYChart.Series<>(); 
//      series4.setName("Complete"); 
//      series4.getData().add(new XYChart.Data<>("Manufactured",4));
//      series4.getData().add(new XYChart.Data<>("Trading",5));
//      series4.getData().add(new XYChart.Data<>("Corporate",2));
//      
//      //Setting the data to bar chart
//      
//      stackedAssurance.getData().addAll(series1); 
//      stackedAssurance.setVisible(true);
//      
//      
//        System.out.println(stackedAssurance);
//        
//    }
//    public void loadProfileQuarter(){
//        
//            XYChart.Series series1 = new XYChart.Series();
//        series1.setName("Plan");
//        series1.getData().addAll(new XYChart.Data<>("Q1", 10));
//        series1.getData().addAll(new XYChart.Data<>("Q3", 20));
//        series1.getData().addAll(new XYChart.Data<>("Q4", 30));
//        series1.getData().addAll(new XYChart.Data<>("Q5", 50));
//        
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("In Progress");
//        series2.getData().addAll(new XYChart.Data<>("Q1", 0));
//        series2.getData().addAll(new XYChart.Data<>("Q3", 10));
//        series2.getData().addAll(new XYChart.Data<>("Q4", 20));
//        series2.getData().addAll(new XYChart.Data<>("Q5", 30));
//        
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("Complete");
//        series3.getData().addAll(new XYChart.Data<>("Q1", 5));
//        series3.getData().addAll(new XYChart.Data<>("Q3", 0));
//        series3.getData().addAll(new XYChart.Data<>("Q4", 10));
//        series3.getData().addAll(new XYChart.Data<>("Q5", 4));
//        
//        lineChart.getData().addAll(series1,series2,series3);
//        lineChart.setLegendVisible(true);
//        
//    }
}
