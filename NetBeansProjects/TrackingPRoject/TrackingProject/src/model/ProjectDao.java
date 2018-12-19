/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;



/**
 *
 * @author kuupie
 */
public class ProjectDao extends ListCell<Project>{
    
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, ORANGE_BAR, YELLOW_BAR, GREEN_BAR };
    
    @FXML
    private Label titleCivitas;
    @FXML
    private Label titleActivity;
    @FXML
    private Label titleStratMonth;
    @FXML
    private Label titleEndMonth;
    @FXML
    private ProgressBar barProgress;
    @FXML
    private Label titleProsentase;
    @FXML
    private Label lblProgres;

    
    @FXML
    private HBox gridPane;

    private FXMLLoader mLLoader;
    
    public String SelectNeeded; 
    
    public String queryListProject="SELECT PRO.idproject, COUNT(PMK.master_task_idtask) AS LINE, MIC.civitascol,MAC.activitycol,RFA.risk_valuecol, AUG.audit_gradingcol, MAS.statuscol, MAS.INISIAL_STATUS, PRO.startmonth, PRO.endmonth,PRO.act_month_start,PRO.act_month_end,\n" +
        "(COUNT(act_dateend)/ COUNT(PMK.master_task_idtask)) as PERCENTAGE,\n" +
        "DATE_FORMAT(PRO.startmonth, '%b') as starMonth,\n" +
        "DATE_FORMAT(PRO.endmonth, '%b') as endMonth,\n" +
        "day(PRO.startmonth) as dateStart,month(PRO.startmonth)as monthStart, YEAR(PRO.startmonth) as yearStart, day(PRO.endmonth) as dateEnd, month(PRO.endmonth)as monthEnd, YEAR(PRO.endmonth) as yearEnd, day(PRO.act_month_start) as dateActStart, month(PRO.act_month_start) as monthActStart, year(PRO.act_month_start) as yearActStart, day(PRO.act_month_end) as dateActEnd, month(PRO.act_month_end) as monthActEnd, year(PRO.act_month_end) as yearActEnd \n" +
        "FROM project AS PRO\n" +
        "INNER JOIN project_has_master_task AS PMK ON PMK.project_idproject=PRO.idproject\n" +
        "LEFT JOIN master_civitas AS MIC ON PRO.civitas_idcivitas=MIC.idcivitas\n" +
        "LEFT JOIN master_activity AS MAC ON PRO.master_activity_idactivity=MAC.idactivity\n" +
        "LEFT JOIN risk_factore AS RFA ON PRO.risk_factore_idrisk_factore=RFA.idrisk_value\n" +
        "LEFT JOIN audit_grading as AUG ON PRO.audit_grading_idaudit_grading=AUG.idaudit_grading\n" +
        "LEFT JOIN master_status AS MAS ON PRO.status_idstatus=MAS.idstatus\n" +
        "\n" ;
    public String where; 
    public String groupBy; 
    public String orderBy; 
    
    public void queryLoadAllListProject(){
        groupBy=" GROUP BY PMK.project_idproject";
        orderBy=" ORDER BY pr.idproject";
        SelectNeeded = queryListProject+groupBy+orderBy;
    }
    
    @Override
    protected void updateItem(Project project, boolean empty) {
        super.updateItem(project, empty);
        
        if(empty || project == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellPro.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
//            gridPane.getStylesheets().add(getClass().getResource("/view/stylesheet.css").toExternalForm());
             
            String Prosentase=project.getProject_Percentage();
            double Prs = Double.parseDouble(Prosentase);
            double Setnu = Prs*100;
            String valPro = Double.toString(Setnu);
            titleProsentase.setText(valPro);
            barProgress.setProgress(Prs);
            
//            barProgress.progressProperty().addListener(new ChangeListener<Number>(){
//                @Override
//                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                    double Prse = newValue == null ? 0 :newValue.doubleValue();
//                    
//                    if(Prse<0.33){
//                        setStyleBarClass(barProgress, RED_BAR);
//                    }else if(Prse<0.50){
//                        setStyleBarClass(barProgress, ORANGE_BAR);
//                    }else if(Prse<0.80){
//                        setStyleBarClass(barProgress, YELLOW_BAR);
//                    }else{
//                        setStyleBarClass(barProgress, GREEN_BAR);
//                    }
//                }
//                
//                private void setStyleBarClass (ProgressBar barPrs,String barStyleClass){
//                    barPrs.getStyleClass().removeAll(barColorStyleClasses);
//                    barPrs.getStyleClass().add(barStyleClass);
//                }
//                
//            });
            
            titleCivitas.setText(project.getCivitasCol());
            titleActivity.setText(project.getActivityCol());
            titleStratMonth.setText(project.getStartMonth());
            titleEndMonth.setText(project.getEndMonth());
            lblProgres.setText(project.getInisialProgress());
            gridPane.getStyleClass().add("mylistview");
           
            
            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);
        

    }
}
