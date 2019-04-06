/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piechart;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 *
 * @author kuupie
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private PieChart labelPieChart;
    @FXML
    private PieChart pieChart;
    
    
        public void loadPieTreddAss(){
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
        labelPieChart.setData(pieChartAssurance1);
        
        DoubleBinding total = Bindings.createDoubleBinding(() ->
        pieChartAssurance1.stream().collect(Collectors.summingDouble(PieChart.Data::getPieValue)), pieChartAssurance1);
        
        pieChartAssurance1.forEach(data -> 
        data.nameProperty().bind(Bindings.concat(data.getName()," (",
        String.format("%.0f%%", 100*data.getPieValue()/total.get()),")")));
     }
        
     public void loadPieTredd(){
        ObservableList<PieChart.Data> pieChartAssurance2=
                FXCollections.observableArrayList(
                new PieChart.Data("Not Yet", 3),
                new PieChart.Data("In Progress", 5),
                new PieChart.Data("Complete", 7),
                new PieChart.Data("Finish", 1));
        
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(15);
        //pieChart.setPrefSize(400, 400);
        pieChart.setMaxSize(280, 280);
        pieChart.setLabelsVisible(true);
        //pieChart.setMinSize(400, 400);
        
        
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
            //Color color = pieData.pieChartColors.get(idx);
            data.getNode().setStyle("-fx-pie-color: #ffffff");
            //pieChart.legend.getItems().get(idx).setSymbol(new Rectangle(8, 8, color));
        }
     }   

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadPieTreddAss();
        loadPieTredd();
    }    
    
}
