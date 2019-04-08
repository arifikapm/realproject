/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import db.koneksi;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.MasScope;
import model.MasScopeDao;
import model.ProfileProjectRoot;
import model.ProfileProjectRootDao;
import model.Project;
import model.ProjectDao;
import model.ProjectDetail;
import model.ProjectDetailDao;
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
public class PROJECT_1Controller implements Initializable {

    @FXML
    private BorderPane viewProject;
    @FXML
    private JFXTextField textSearch;
    @FXML
    private JFXListView<Project> rootViewList;
    @FXML
    private Label lblStartMonth;
    @FXML
    private Label lblEndMonth;
    @FXML
    private Label lblProjectCivitas;
    @FXML
    private Label lblActivity;
    @FXML
    private Label lblCivitas;
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
    private ScrollPane paneView;
    @FXML
    private JFXListView<ProfileProjectRoot> listProjectProfile;
    @FXML
    private JFXListView<MasScope> listScope;
    @FXML
    private JFXListView<Team> listTeam;
    
    private String textCivitas, textActivity, textStratMonth, textEndMonth, startlbl, endLbl,
            textCountDown, jtsDayStart, jtsDayEnd, jtsMonthStart, jtsMonthEnd;
    public String idPorject, taskPlann;
    int dateStart, dateEnd, yearStart, monthStart, monthEnd, yearEnd;
    int dateActStart, dateActEnd, monthActStart, monthActEnd,yearActStart,yearActEnd;
    
    public String SearchKey="";
    int year = Year.now().getValue();
    private String idPro;
    private final String civitas = "";
    private final String startMonth = "";
    private final String endMonth = "";
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    
    koneksi kon = new koneksi();
    ProjectDao modelProject =new ProjectDao();
    PROJECTdetailController detail = new PROJECTdetailController();
    
    private ObservableList<Project> data;
    private ObservableList<Project> filteredData;
    
    ProjectDetailDao modelProjectDetail = new ProjectDetailDao();
    MasScopeDao modelScope = new MasScopeDao();
    TeamDao modelTeam = new TeamDao();
    TaskFormDao modelTask = new TaskFormDao();
    ProfileProjectRootDao modelProfileProjectRoot = new ProfileProjectRootDao();
    
   
    private ObservableList<ProjectDetail> dataDetail;
    private ObservableList<MasScope>dataScope;
    private ObservableList<Team>dataTeam;
    private ObservableList<TaskForm>dataTaskForm;
    private ObservableList<ProfileProjectRoot>dataProfileProject;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        loadListProject();
    }    


    @FXML
    private void loadSearchOnRelease(KeyEvent event) {
        SearchKey = textSearch.getText();
        if ("".equals(SearchKey) || SearchKey.isEmpty()) {
            // No filter --> Add all.
            loadListProject();
        } else{
            loadListSearchProject();
        }
    }


    @FXML
    private void loadSearchProject(MouseEvent event) {
    }

    @FXML
    private void loadDetailProject(MouseEvent event) {
        try {
            idPro = rootViewList.getSelectionModel().getSelectedItem().getIdProject();
            setData();
            setProfileProjectRoot();
            setScope();
            setTeamMember();
            setTimeSchedule(idPro);
        } catch (Exception e) {
            
        }
    }

    @FXML
    private void loadTaskProject(MouseEvent event) throws IOException, SQLException {
        // New window (Stage)
            final Stage primaryStage = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NEWPROJECT_1.fxml"));
            BorderPane newScene = loader.load();
            NEWPROJECTController mct = loader.getController();
            mct.setData(idPro);
            Scene scene = new Scene(newScene);
           
            //new Scene load new windows
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
 
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
 
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);
 
            // Set position of second window, related to primary window.
            
 
            newWindow.show();
    }

    @FXML
    private void deleteProject(MouseEvent event) {
        try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("You will delete : \n "+textActivity+" \n"+textCivitas+"");
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    //deletedFirst();
                    if(deletedFirst().equals("Success")){
                        System.out.println("succes");
                        modelProject.deleteProject(idPro);
                        kon.stat.executeUpdate(modelProject.delete);
                        

                        
                    } else{
                        System.out.println("Error Delete project");
                    }
//                     refreshAllProject();
                     refreshAll();

                    // ... user chose OK
                    
                } else {
                   alert.close();
                    
                    // ... user chose CANCEL or closed the dialog
                    
                }
                
        } catch(Exception e){
        
        }
    }
    
    public void loadListProject(){
        try {
            rootViewList.setItems(null);
//            String load = "1";
//            modelProject.queryLoadAllListProject(load);

                modelProject.loadProjectbyYear(year);

            
            data=FXCollections.observableArrayList();
            filteredData = FXCollections.observableArrayList();
            //kon.res=kon.stat.executeQuery(modelProject.queryListProject);
            kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
            while (kon.res.next()) {                
                data.add(new Project
                        (kon.res.getString(1), kon.res.getString(2), kon.res.getInt(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), 
                        kon.res.getString(9), kon.res.getString(10),kon.res.getString(11), kon.res.getString(12), 
                        kon.res.getString(13),kon.res.getDouble(14), kon.res.getString(15), kon.res.getString(16), 
                        kon.res.getInt(17), kon.res.getInt(18), kon.res.getInt(19), kon.res.getInt(20), kon.res.getInt(21),
                        kon.res.getInt(22), kon.res.getInt(23), kon.res.getInt(24), kon.res.getInt(25), kon.res.getInt(26),
                        kon.res.getInt(27), kon.res.getInt(28), kon.res.getString(29), kon.res.getString(30),
                        kon.res.getString(31)));
            }
            
            // Initially add all data to filtered data
            filteredData.addAll(data);

            
            rootViewList.setItems(data);
            rootViewList.setCellFactory(projectListView -> new ProjectDao());
            rootViewList.setVerticalGap(30.0);
            rootViewList.setExpanded(true);
            rootViewList.depthProperty().set(1);
            rootViewList.getStyleClass().add("mylistview");
        } catch (SQLException e) {

        }
        
    }
    
    private void loadListSearchProject(){
        try {
            rootViewList.setItems(null);

            modelProject.loadProjectSearch(year, SearchKey);
            
            
            data=FXCollections.observableArrayList();
            filteredData = FXCollections.observableArrayList();
            //kon.res=kon.stat.executeQuery(modelProject.queryListProject);
            kon.res=kon.stat.executeQuery(modelProject.SelectNeeded);
//            System.out.println(modelProject.SelectNeeded);
            while (kon.res.next()) {                
                data.add(new Project
                        (kon.res.getString(1), kon.res.getString(2), kon.res.getInt(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), 
                        kon.res.getString(9), kon.res.getString(10),kon.res.getString(11), kon.res.getString(12), 
                        kon.res.getString(13),kon.res.getDouble(14), kon.res.getString(15), kon.res.getString(16), 
                        kon.res.getInt(17), kon.res.getInt(18), kon.res.getInt(19), kon.res.getInt(20), kon.res.getInt(21),
                        kon.res.getInt(22), kon.res.getInt(23), kon.res.getInt(24), kon.res.getInt(25), kon.res.getInt(26),
                        kon.res.getInt(27), kon.res.getInt(28), kon.res.getString(29), kon.res.getString(30),
                        kon.res.getString(31)));
            }
            
            // Initially add all data to filtered data
            filteredData.addAll(data);

            
            rootViewList.setItems(data);
            rootViewList.setCellFactory(projectListView -> new ProjectDao());
            rootViewList.setVerticalGap(30.0);
            rootViewList.setExpanded(true);
            rootViewList.depthProperty().set(1);
            rootViewList.getStyleClass().add("mylistview");
        } catch (Exception e) {

        }
        
    }
    
    private boolean checkIdExisTask(JFXListView<Project> tblContainer, String SearchKey) {
        //bolean checking id selection list remover to list array on list container
        List<String> listChecker = tblContainer.getItems().stream().
                        map(Project::getProjectCol).
                        collect(Collectors.toList());
        System.out.println("check");
        for (String listChecker1 : listChecker) {
            if (listChecker1.trim().contains(SearchKey)) { 
                System.out.println("listChecker1 "+listChecker1);
                return true;
            }
        }
        System.out.println("false");
        return false;
    }
    
    public void setData () throws SQLException{
        kon.db();

        //loadDataTask();
        
        
        //model.loadDetail(idProject);
        modelProjectDetail.loadProjectDetail(idPro);
        
        dataDetail=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelProjectDetail.queryload);
        System.out.println(modelProjectDetail.queryload);

        while (kon.res.next()) {                
                dataDetail.add(new ProjectDetail(kon.res.getString(1), kon.res.getString(2), kon.res.getString(3), 
                        kon.res.getString(5), kon.res.getString(4), 
                        kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                        kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), 
                        kon.res.getString(14), kon.res.getString(15)));
                textCivitas = kon.res.getString(2);
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
    
    public void setScope() throws SQLException{
        listScope.refresh();
        modelScope.loadScope(idPro);
        dataScope =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelScope.scopequery);
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
    
    public void setTeamMember() throws SQLException{
        listTeam.refresh();
        modelTeam.teamLoad(idPro);
        dataTeam =FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelTeam.queryteam);
        while (kon.res.next()) {                
                dataTeam.add(new Team(kon.res.getString(1),kon.res.getString(2),kon.res.getString(3)));
            }
            listTeam.setItems(dataTeam);
            listTeam.setCellFactory(teamListView -> new TeamDao());
            listTeam.setVerticalGap(30.0);
            listTeam.setExpanded(true);
            listTeam.depthProperty().set(1);
            listTeam.getStyleClass().add("mylistview");
    }
    
    public void setProfileProjectRoot() throws SQLException{

            listProjectProfile.refresh();
            modelProfileProjectRoot.loadProfileRoot(idPro);
            dataProfileProject=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(modelProfileProjectRoot.loadProfile);

            while (kon.res.next()) {                
                dataProfileProject.add(new ProfileProjectRoot(kon.res.getString(1), kon.res.getDouble(2)));
            }
            listProjectProfile.setItems(dataProfileProject);
            listProjectProfile.setCellFactory(profileListView -> new ProfileProjectRootDao());
            listProjectProfile.setVerticalGap(30.0);
            listProjectProfile.setExpanded(true);
            listProjectProfile.depthProperty().set(1);
            listProjectProfile.getStyleClass().add("mylistview");
        
    }
    
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }    
    
     private void setTimeSchedule(String idPro) throws SQLException{
      kon.db();
      
      
      //get data chart from above
      IntervalCategoryDataset dataset = getCategoryDataset(idPro);
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
    
    public String deletedFirst(){
        try{
            modelProject.deleteProjectHasKaryawan(idPro);
            kon.stat.executeUpdate(modelProject.delete);
            modelProject.deleteProjectHasScope(idPro);
            kon.stat.executeUpdate(modelProject.delete);
            modelProject.deleteProjectHasTask(idPro);
            kon.stat.executeUpdate(modelProject.delete);
            return "Success";
        } catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(String.valueOf(e));
                alert.showAndWait();
            return "Error";
        }
    }
    
    public void refreshAll() throws SQLException, IOException{
        //label atas
                lblProjectCivitas.setText("");
                lblActivity.setText("");
                lblStartMonth.setText("");
                lblEndMonth.setText("");
                
                //label bawah
                txtTglStart.setText("");
                txtStartMonth.setText("");
                txtTglEnd.setText("");
                txtEndMonth.setText("");
                txtCountDown.setText("");
                
                listProjectProfile.refresh();
                setProfileProjectRoot();
                listScope.refresh();
                setScope();
                listTeam.refresh();
                setTeamMember();
                rootViewList.refresh();
                loadListProject();
                
                //setData("");
//                listTeam.setItems(null);
//                listProjectProfile.setItems(null);
//                listScope.setItems(null);
                //refreshProject();
    }
    
}
