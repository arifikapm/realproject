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
    private PieChart pieAssurance;
    @FXML
    private PieChart pieAssurance11;
    @FXML
    private PieChart pieAssurance2;
    @FXML
    private PieChart pieAssurance1;
    @FXML
    private PieChart pieAssurance3;
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
    @FXML
    private JFXListView<ListDasboard> rootViewList;
    
    koneksi kon = new koneksi();
    ListDashboardDao dao =new ListDashboardDao();
    //PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<ListDasboard> data;
//    @FXML
//    private BorderPane viewProject;
    
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
     public void loadPieManfAss(){
        ObservableList<PieChart.Data> pieChartAssurance=
                FXCollections.observableArrayList(
                new PieChart.Data("NY", 3),
                new PieChart.Data("IP", 2),
                new PieChart.Data("Co", 8),
                new PieChart.Data("Fi", 37));
        
        pieAssurance.setClockwise(true);
        pieAssurance.setLabelLineLength(-15);
        pieAssurance.setLabelsVisible(true);
        pieAssurance.setMinSize(320, 320);
        pieAssurance.setLegendVisible(true);
        pieAssurance.setData(pieChartAssurance);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance);
        
        pieChartAssurance.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
                    
        //pieAssurance11.setLabelLineLength(0);
        //pieAssurance11.setLabelsVisible(true);
//        DoubleBinding total = Bindings.createDoubleBinding(() ->
//        pieChartAssurance11.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance11);
//        final Label caption = new Label("");
//        caption.setTextFill(Color.DARKORANGE);
//        caption.setStyle("-fx-font: 24 arial;");
//        
//        for (final PieChart.Data data : pieAssurance11.getData()) {
//        data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//            e -> {
//                caption.setTranslateX(e.getSceneX());
//                caption.setTranslateY(e.getSceneY());
//                String text = String.format("%.1f%%", 100*data.getPieValue()/total.get()) ;
//                caption.setText(text);
//             }
//            );
//    }
      
    }
     
     public void loadPieTreddAss(){
        ObservableList<PieChart.Data> pieChartAssurance1=
                FXCollections.observableArrayList(
                new PieChart.Data("NY", 0),
                new PieChart.Data("IP", 0),
                new PieChart.Data("Co", 2),
                new PieChart.Data("Fi", 1));
        
        pieAssurance1.setClockwise(true);
        pieAssurance1.setLabelLineLength(-15);
        pieAssurance1.setLabelsVisible(true);
        pieAssurance1.setMinSize(320, 320);
        pieAssurance1.setLegendVisible(true);
        pieAssurance1.setData(pieChartAssurance1);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance1.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance1);
        
        pieChartAssurance1.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
     }
    
     public void loadPieManfRisk(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("NY", 0),
                new PieChart.Data("IP", 2),
                new PieChart.Data("Co", 3),
                new PieChart.Data("Fi", 1));
        
        pieAssurance2.setClockwise(true);
        pieAssurance2.setLabelLineLength(-15);
        pieAssurance2.setLabelsVisible(true);
        pieAssurance2.setMinSize(320, 320);
        pieAssurance2.setLegendVisible(true);
        pieAssurance2.setData(pieChartAssurance2);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance2.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance2);
        
        pieChartAssurance2.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
     }
     
     public void loadPieTredRisk(){
        ObservableList<PieChart.Data> pieChartAssurance3=
                FXCollections.observableArrayList(
                new PieChart.Data("NY", 0),
                new PieChart.Data("IP", 0),
                new PieChart.Data("Co", 2),
                new PieChart.Data("Fi", 1));
        
        pieAssurance3.setClockwise(true);
        pieAssurance3.setLabelLineLength(-15);
        pieAssurance3.setLabelsVisible(true);
        pieAssurance3.setMinSize(320, 320);
        pieAssurance3.setLegendVisible(true);
        pieAssurance3.setData(pieChartAssurance3);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance3.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance3);
        
        pieChartAssurance3.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
     }
     
     public void loadPieAdvisory(){
        ObservableList<PieChart.Data> pieChartAssurance11=
                FXCollections.observableArrayList(
                new PieChart.Data("NY", 0),
                new PieChart.Data("IP", 0),
                new PieChart.Data("CO", 1),
                new PieChart.Data("Finish", 0));
        
        pieAssurance11.setClockwise(true);
        pieAssurance11.setLabelLineLength(-5);
        pieAssurance11.setLabelsVisible(true);
        pieAssurance11.setMinSize(200, 200);
        pieAssurance11.setLegendVisible(true);
        pieAssurance11.setData(pieChartAssurance11);
        
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance11.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance11);
        
        pieChartAssurance11.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        loadPieManfAss();
        loadPieManfRisk();
        loadPieTredRisk();
        loadPieTreddAss();
        loadPieAdvisory();
        loadListProject();
    }    

    @FXML
    private void showPercentage(MouseEvent event) {
        final Label caption = new Label("");
caption.setTextFill(Color.DARKORANGE);
caption.setStyle("-fx-font: 24 arial;");

for (final PieChart.Data data : pieAssurance.getData()) {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText(String.valueOf(data.getPieValue()) + "%");
             }
        });
    }
    }
    
}
