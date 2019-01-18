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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ProfileProjectRoot;
import model.ProfileProjectRootDao;
import model.ProjectDetail;
import model.ProjectDetailDao;
import model.Scope;
import model.ScopeDao;
import model.TaskForm;
import model.TaskFormDao;
import model.Team;
import model.TeamDao;


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
public class PROJECTdetailController implements Initializable {
    
    
    private String idPro, textCivitas, textActivity, textStratMonth, textEndMonth, startlbl, endLbl,
            textCountDown, jtsDayStart, jtsDayEnd, jtsMonthStart, jtsMonthEnd;
    public String idPorject, taskPlann;
    int dateStart, dateEnd, yearStart, monthStart, monthEnd, yearEnd;
    int dateActStart, dateActEnd, monthActStart, monthActEnd,yearActStart,yearActEnd;
    
    
    @FXML
    private Label lblStartMonth;
    @FXML
    private Label lblEndMonth;
    @FXML
    private JFXListView<Scope> listScope;
    @FXML
    private JFXListView<Team> listTeam;
    @FXML
    private Label txtStartMonth;
    @FXML
    private Label txtEndMonth;
    @FXML
    private Label txtTglStart;
    @FXML
    private Label txtTglEnd;
    @FXML
    private Label txtCountDown;
    @FXML
    private Label lblActivity;
    @FXML
    private Label lblProjectCivitas;
    @FXML
    private ScrollPane paneView;
    @FXML
    private JFXListView<ProfileProjectRoot> listProjectProfile;
    
    
    @FXML
    private TableView<TaskForm> tblTask;

    @FXML
    private TableColumn<TaskForm, String> colTask;

    @FXML
    private TableColumn<TaskForm, String> colStartPlan;

    @FXML
    private TableColumn<TaskForm, String> colEndPlan;

    @FXML
    private TableColumn<TaskForm, String> colActStart;

    @FXML
    private TableColumn<TaskForm, String> colActEnd;

    @FXML
    private TableColumn<TaskForm, String> colEdit;

    @FXML
    private TableColumn<TaskForm, String> colDelete;
    
    //Koneki
    koneksi kon = new koneksi();
    ProjectDetailDao model = new ProjectDetailDao();
    ScopeDao modelScope = new ScopeDao();
    TeamDao modelTeam = new TeamDao();
    TaskFormDao modelTask = new TaskFormDao();
    ProfileProjectRootDao modelProfileProjectRoot = new ProfileProjectRootDao();
    
   
    private ObservableList<ProjectDetail> data;
    private ObservableList<Scope>dataScope;
    private ObservableList<Team>dataTeam;
    private ObservableList<TaskForm>dataTaskForm;
    private ObservableList<ProfileProjectRoot>dataProfileProject;

    

    
    public void setData (String idProject) throws SQLException{
        kon.db();
        idPorject = idProject;
        
        //System.out.println(idPorject);
        
        setScope(idProject);
        setTeamMember(idProject);
        setProfileProjectRoot(idProject);
        //getCategoryDataset(idProject);
        loadDataTask();
        
        
        //model.loadDetail(idProject);
        model.loadProjectDetail(idProject);
        
        
        data=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(model.queryload);
        
        while (kon.res.next()) {                
                data.add(new ProjectDetail(kon.res.getString(1), kon.res.getString(2), kon.res.getString(3), 
                        kon.res.getString(5), kon.res.getString(4), 
                        kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                        kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), 
                        kon.res.getString(14), kon.res.getString(15)));
                textCivitas = kon.res.getString(3);
                textActivity = kon.res.getString(4);
                textStratMonth = kon.res.getString(6);
                textEndMonth = kon.res.getString(7);
                jtsDayStart = kon.res.getString(11);
                jtsMonthStart = kon.res.getString(12);
                jtsDayEnd = kon.res.getString(13);
                jtsMonthEnd = kon.res.getString(14);
                textCountDown = kon.res.getString(15);
                
            }
                
                //label atas
                lblProjectCivitas.setText(textCivitas);
                lblActivity.setText(textActivity);
                lblStartMonth.setText(textStratMonth);
                lblEndMonth.setText(textEndMonth);
                
                //label bawah
                txtTglStart.setText(jtsDayStart);
                txtStartMonth.setText(jtsMonthStart);
                txtTglEnd.setText(jtsDayEnd);
                txtEndMonth.setText(jtsMonthEnd);
                txtCountDown.setText(textCountDown);
    }
    
    public void setScope(String idProject) throws SQLException{
        modelScope.loadScope(idProject);
        dataScope =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelScope.scopequery);
        while (kon.res.next()) {                
                dataScope.add(new Scope(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listScope.setItems(dataScope);
            listScope.setCellFactory(scopeListView -> new ScopeDao());
    }
    
    public void setTeamMember(String idProject) throws SQLException{
        modelTeam.teamLoad(idProject);
        dataTeam =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelTeam.queryteam);
        while (kon.res.next()) {                
                dataTeam.add(new Team(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listTeam.setItems(dataTeam);
            listTeam.setCellFactory(teamListView -> new TeamDao());
    }
    
    public void setProfileProjectRoot(String idProject) throws SQLException{
//        try {
            modelProfileProjectRoot.loadProfileRoot(idProject);
            dataProfileProject=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelProfileProjectRoot.loadProfile);
            ///

            ////
            while (kon.res.next()) {                
                dataProfileProject.add(new ProfileProjectRoot(kon.res.getString(1), kon.res.getDouble(2)));
            }
            listProjectProfile.setItems(dataProfileProject);
            listProjectProfile.setCellFactory(profileListView -> new ProfileProjectRootDao());
                
//        } catch (Exception e) {
//        }
        
        
    }
    
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }    
    
     private void loadDataTask() throws SQLException{
      kon.db();
      
      
      //get data chart from above
      IntervalCategoryDataset dataset = getCategoryDataset(idPorject);
        JFreeChart chart = ChartFactory.createGanttChart("", "", "", dataset);
        
        //Style plot
        chart.getPlot().setBackgroundPaint(new Color(153,153,153));
        //chart.getPlot().setBackgroundAlpha(1.0f);
        chart.getPlot().setOutlineVisible(false);
        //chart.getPlot().setForegroundAlpha(1.0f);
        chart.getPlot().setNoDataMessage("No Data");
        
        

        //style chart
        chart.setBackgroundPaint(new Color (255,255,255));
        //chart.getXYPlot().setWeight(yearEnd);
        
        
        
        
        //load chart
        SwingNode chartSwingNode = new SwingNode();
        ChartPanel jchaChartPanel = new ChartPanel(chart);
        jchaChartPanel.setFillZoomRectangle(true);
        //jchaChartPanel.setMouseWheelEnabled(true);
        jchaChartPanel.setAutoscrolls(true);
        jchaChartPanel.getAutoscrolls();
        jchaChartPanel.setPreferredSize(new Dimension(745,700));
        chartSwingNode.setContent(jchaChartPanel); 
        paneView.setContent(chartSwingNode);
    }
    
    private IntervalCategoryDataset getCategoryDataset(String idProject) throws SQLException{
        modelTask.loadDataSelected(idProject);
        dataTaskForm=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelTask.queryload);
        
        final TaskSeries s1 = new TaskSeries("Scheduled");
        final TaskSeries s2 = new TaskSeries("Actual");
        while (kon.res.next()) {   
            try {
                dataTaskForm.add(new TaskForm(kon.res.getString(1), kon.res.getString(2), 
                kon.res.getInt(3),kon.res.getInt(4),kon.res.getInt(5),kon.res.getInt(6),kon.res.getInt(7),
                kon.res.getInt(8),kon.res.getInt(9),kon.res.getInt(10),kon.res.getInt(11),kon.res.getInt(12)
                ,kon.res.getInt(13),kon.res.getInt(14),kon.res.getString(15),kon.res.getString(16),kon.res.getString(17)
                ,kon.res.getString(18),kon.res.getString(19)));
                
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
    
   
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        try {
            loadDataTask();
        } catch (SQLException ex) {
            Logger.getLogger(PROJECTdetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void loadTaskProject(MouseEvent event) throws IOException, SQLException {
         // New window (Stage)
            final Stage primaryStage = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NEWPROJECT_1.fxml"));
            BorderPane newScene = loader.load();
            NEWPROJECTController mct = loader.getController();
            mct.setData(idPorject);
            Scene scene = new Scene(newScene);
           
            //new Scene load new windows
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
 
            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);
 
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);
 
            // Set position of second window, related to primary window.
            
 
            newWindow.show();
    }
    
}
