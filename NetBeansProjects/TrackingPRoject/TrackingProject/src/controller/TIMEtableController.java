/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import db.koneksi;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import model.MasActivity;
import model.MasActivityDao;
import model.MasScope;
import model.MasScopeDao;

import model.Timetable;
import model.TimetableDao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;


/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class TIMEtableController implements Initializable {

    @FXML
    private BorderPane viewMaster;
    @FXML
    private ScrollPane chartView;
    @FXML
    private JFXListView<MasActivity> listActivityView;
    
    //
    public String idPorject, taskPlann;
    public int idActivity;
    int dateStart, dateEnd, yearStart, monthStart, monthEnd, yearEnd;
    int dateActStart, dateActEnd, monthActStart, monthActEnd,yearActStart,yearActEnd;
    int year = Year.now().getValue();
    
    koneksi kon = new koneksi();
    TimetableDao dao =new TimetableDao();
    Timetable model;
    MasActivityDao modelActivity = new MasActivityDao();
    
    private ObservableList<Timetable> dataTimeTable;
    private ObservableList<MasActivity> dataAcitivity;

    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }    

    
//    private IntervalCategoryDataset getCategoryDataset() throws SQLException{
//        dataTimeTable=FXCollections.observableArrayList();
//        kon.res=kon.stat.executeQuery(dao.queryloadString);
//        
//        final TaskSeries s1 = new TaskSeries("Scheduled");
//        final TaskSeries s2 = new TaskSeries("Actual");
//        while (kon.res.next()) {   
//            try {
//                dataTimeTable.add(new Timetable(kon.res.getString(1), kon.res.getString(2), 
//                kon.res.getInt(3),kon.res.getInt(4),kon.res.getInt(5),kon.res.getInt(6),kon.res.getInt(7),
//                kon.res.getInt(8),kon.res.getInt(9),kon.res.getInt(10),kon.res.getInt(11),kon.res.getInt(12)
//                ,kon.res.getInt(13),kon.res.getInt(14)));
//                
//                taskPlann=kon.res.getString(2);
//                dateStart=kon.res.getInt(3);
//                monthStart=kon.res.getInt(4);
//                yearStart=kon.res.getInt(5);
//                dateEnd=kon.res.getInt(6);
//                monthEnd=kon.res.getInt(7);
//                yearEnd=kon.res.getInt(8);
//                
//                s1.add(new Task(taskPlann, Date.from(LocalDate.of(yearStart, monthStart, dateStart).atStartOfDay().toInstant(ZoneOffset.UTC)),
//                Date.from(LocalDate.of(yearEnd, monthEnd, dateEnd).atStartOfDay().toInstant(ZoneOffset.UTC))));
//
//                dateActStart=kon.res.getInt(9);
//                monthActStart=kon.res.getInt(10);
//                yearActStart=kon.res.getInt(11);
//                dateActEnd=kon.res.getInt(12);
//                monthActEnd=kon.res.getInt(13);
//                yearActEnd=kon.res.getInt(14);
//                
//                if(dateActStart!=0 ){
//                    if(dateActEnd==0){
//                    } else {
//                        s2.add(new Task(taskPlann, Date.from(LocalDate.of(yearActStart, monthActStart, dateActStart).atStartOfDay().toInstant(ZoneOffset.UTC)),
//                        Date.from(LocalDate.of(yearActEnd, monthActEnd, dateActEnd).atStartOfDay().toInstant(ZoneOffset.UTC))));
//                    }
//                    
//                }
//                
//            } catch (Exception e) {
//                
//            }
//
//        }
//        
//        final TaskSeriesCollection collection = new TaskSeriesCollection();
//        collection.add(s1);
//        collection.add(s2);
//
//        return collection;
//    }
    
    private void loadData(int idActivity) throws SQLException{
      kon.db();
      //chartView.getChildren().clear();
      
      //get data chart from above
      IntervalCategoryDataset dataset = getCategoryDataset(idActivity);
        JFreeChart chart = ChartFactory.createGanttChart("", "", "", dataset);
        
        //Style plot
        chart.getPlot().setBackgroundPaint(new Color(200, 200, 200));
        chart.getPlot().setBackgroundAlpha(1f);
        chart.getPlot().setOutlineVisible(false);
        chart.getPlot().setForegroundAlpha(0.6f);
        chart.getPlot().setNoDataMessage("No Data");
        chart.getPlot().getLegendItems();
        
        

        //style chart
        chart.setBackgroundPaint(new Color (231,231,231));
        
        
        
        
        //load chart
        SwingNode chartSwingNode = new SwingNode();
        ChartPanel jchaChartPanel = new ChartPanel(chart);
        jchaChartPanel.setFillZoomRectangle(true);
        jchaChartPanel.setMouseWheelEnabled(true);
        jchaChartPanel.setAutoscrolls(true);
        jchaChartPanel.getAutoscrolls();
        jchaChartPanel.setPreferredSize(new Dimension(1290, 1000));
        chartSwingNode.setContent(jchaChartPanel); 
        //chartView.getStylesheets().addAll();
        chartView.setContent(chartSwingNode);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kon.db();
        try {
            setListActivity();
            idActivity = 1;
            loadData(idActivity);
        } catch (SQLException ex) {
            Logger.getLogger(TIMEtableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void setListActivity() throws SQLException{
        //modelActivity.loadScope(idProject);
        dataAcitivity =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelActivity.selectall);
        while (kon.res.next()) {                
                dataAcitivity.add(new MasActivity(kon.res.getInt(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listActivityView.setItems(dataAcitivity);
            listActivityView.setCellFactory(activityListView -> new MasActivityDao());
            listActivityView.setVerticalGap(80.0);
            listActivityView.setExpanded(true);
            listActivityView.depthProperty().set(1);
            listActivityView.getStyleClass().add("mylistview");
    }
    
    private IntervalCategoryDataset getCategoryDataset(int idActivity) throws SQLException{
        //dao.loadActivityTimeTable(idActivity);
        dao.loadActivityTimeTablebyYear(idActivity, year);
        dataTimeTable=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(dao.loadData);
        
        final TaskSeries s1 = new TaskSeries("Scheduled");
        final TaskSeries s2 = new TaskSeries("Actual");
        while (kon.res.next()) {   
            try {
                dataTimeTable.add(new Timetable(kon.res.getString(1), kon.res.getString(2), 
                kon.res.getInt(3),kon.res.getInt(4),kon.res.getInt(5),kon.res.getInt(6),kon.res.getInt(7),
                kon.res.getInt(8),kon.res.getInt(9),kon.res.getInt(10),kon.res.getInt(11),kon.res.getInt(12)
                ,kon.res.getInt(13),kon.res.getInt(14)));
                
                taskPlann=kon.res.getString(2);
                dateStart=kon.res.getInt(3);
                monthStart=kon.res.getInt(4);
                yearStart=kon.res.getInt(5);
                dateEnd=kon.res.getInt(6);
                monthEnd=kon.res.getInt(7);
                yearEnd=kon.res.getInt(8);
                
                s1.add(new Task(taskPlann, Date.from(LocalDate.of(yearStart, monthStart, dateStart).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(yearEnd, monthEnd, dateEnd).atStartOfDay().toInstant(ZoneOffset.UTC))));

                dateActStart=kon.res.getInt(9);
                monthActStart=kon.res.getInt(10);
                yearActStart=kon.res.getInt(11);
                dateActEnd=kon.res.getInt(12);
                monthActEnd=kon.res.getInt(13);
                yearActEnd=kon.res.getInt(14);
                
                if(dateActStart!=0 ){
                    if(dateActEnd==0){
                    } else {
                        s2.add(new Task(taskPlann, Date.from(LocalDate.of(yearActStart, monthActStart, dateActStart).atStartOfDay().toInstant(ZoneOffset.UTC)),
                        Date.from(LocalDate.of(yearActEnd, monthActEnd, dateActEnd).atStartOfDay().toInstant(ZoneOffset.UTC))));
                    }
                    
                }
                
            } catch (Exception e) {
                
            }

        }
        
        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
        collection.add(s2);

        return collection;
    }

    @FXML
    private void loadTimeTableTask(MouseEvent event) throws SQLException {
        try{
            idActivity = listActivityView.getSelectionModel().getSelectedItem().getIdAcitivity();
            loadData(idActivity);
        }catch (Exception e) {
                
        }

    }
    
}
