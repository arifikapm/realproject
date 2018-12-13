/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import db.koneksi;
import java.net.URL;
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
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.ListDasboard;
import model.ListDashboardDao;
import model.Project;
import model.ProjectDao;
import org.jfree.data.general.Series;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class DASHBOARDController implements Initializable {

    @FXML
    private Label txtTglStart;
    @FXML
    private Label txtTglStart1;
    @FXML
    private Label txtTglStart11;
    @FXML
    private Label txtTglStart111;
    @FXML
    private Label txtTglStart112;
    private JFXListView<ListDasboard> rootViewList;
    
    koneksi kon = new koneksi();
    ListDashboardDao dao =new ListDashboardDao();
    //PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<ListDasboard> data;
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
    
    private void loadListProject(){
        try {
            data=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(dao.queryListDasboard);
            
            while (kon.res.next()) {                
                data.add(new ListDasboard(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            rootViewList.setItems(data);
            rootViewList.setCellFactory(list -> new ListDashboardDao());
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
        loadPieAss();
        labelPieAss();
        
        loadPieRisk();
        labelPieRisk();
        
        loadPieOth();
        labelPieOth();
        
        loadPieAdv();
        labelPieAdv();

        loadListProject();
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

    public void loadPieAss() {
        ObservableList<PieChart.Data> pieChartAssurance1=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        labelPieChart.setClockwise(true);
        labelPieChart.setLabelLineLength(0);
        labelPieChart.setLabelsVisible(false);
        labelPieChart.setMinSize(280, 280);
        labelPieChart.setLegendVisible(true);
        labelPieChart.setLegendSide(Side.TOP);
        labelPieChart.setData(pieChartAssurance1);

        
    }
    
    public void labelPieAss(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(5);

        pieChart.setMaxSize(270, 270);
        pieChart.setLabelsVisible(true);

        pieChart.setLegendVisible(false);
        pieChart.setData(pieChartAssurance2);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
        
        pieChartAssurance2.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : pieChartAssurance2) {
            int idx = pieChartAssurance2.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
    
    public void loadPieRisk() {
        ObservableList<PieChart.Data> pieChartAssurance1=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        labelPieChart2.setClockwise(true);
        labelPieChart2.setLabelLineLength(0);
        labelPieChart2.setLabelsVisible(false);
        labelPieChart2.setMinSize(280, 280);
        labelPieChart2.setLegendVisible(true);
        labelPieChart2.setLegendSide(Side.TOP);
        labelPieChart2.setData(pieChartAssurance1);

        
    }
    
    public void labelPieRisk(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        pieChart2.setClockwise(true);
        pieChart2.setLabelLineLength(5);

        pieChart2.setMaxSize(270, 270);
        pieChart2.setLabelsVisible(true);

        pieChart2.setLegendVisible(false);
        pieChart2.setData(pieChartAssurance2);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
        
        pieChartAssurance2.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : pieChartAssurance2) {
            int idx = pieChartAssurance2.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
    
    public void loadPieOth() {
        ObservableList<PieChart.Data> pieChartAssurance1=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        labelPieChart1.setClockwise(true);
        labelPieChart1.setLabelLineLength(0);
        labelPieChart1.setLabelsVisible(false);
        labelPieChart1.setMinSize(280, 280);
        labelPieChart1.setLegendVisible(true);
        labelPieChart1.setLegendSide(Side.TOP);
        labelPieChart1.setData(pieChartAssurance1);

        
    }
    
    public void labelPieOth(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        pieChart1.setClockwise(true);
        pieChart1.setLabelLineLength(5);

        pieChart1.setMaxSize(240, 240);
        pieChart1.setLabelsVisible(true);

        pieChart1.setLegendVisible(false);
        pieChart1.setData(pieChartAssurance2);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
        
        pieChartAssurance2.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : pieChartAssurance2) {
            int idx = pieChartAssurance2.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
    
    public void loadPieAdv() {
        ObservableList<PieChart.Data> pieChartAssurance1=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        labelPieChart3.setClockwise(true);
        labelPieChart3.setLabelLineLength(0);
        labelPieChart3.setLabelsVisible(false);
        labelPieChart3.setMinSize(280, 280);
        labelPieChart3.setLegendVisible(true);
        labelPieChart3.setLegendSide(Side.TOP);
        labelPieChart3.setData(pieChartAssurance1);

        
    }
    
    public void labelPieAdv(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        pieChart3.setClockwise(true);
        pieChart3.setLabelLineLength(5);

        pieChart3.setMaxSize(240, 240);
        pieChart3.setLabelsVisible(true);

        pieChart3.setLegendVisible(false);
        pieChart3.setData(pieChartAssurance2);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
        
        pieChartAssurance2.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(
        String.format("%.0f%%", 100*data.getPieValue()/total.get()))));
        // #a9a9a9
        
        for (PieChart.Data data : pieChartAssurance2) {
            int idx = pieChartAssurance2.indexOf(data);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            
        }
    }
    
}
