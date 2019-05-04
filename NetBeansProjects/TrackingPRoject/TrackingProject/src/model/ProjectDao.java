/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.time.LocalDate;
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
    public String update; 
    public String delete; 
    
    public String queryListProject= "SELECT PRO.idproject,PRO.projectcol, \n" +
        "COUNT(PMK.master_task_idtask) AS line, MIC.civitascol,MAC.activitycol,\n" +
        "RFA.risk_valuecol as valuerisk, AUG.audit_gradingcol, MAS.statuscol, MAS.INISIAL_STATUS, \n" +
        "(CASE WHEN PRO.startmonth = '0000-00-00' THEN NULL\n" +
        "	ELSE \n" +
        "    PRO.startmonth \n" +
        "    END \n" +
        "    ) as fullStartMonth, \n" +
        "(CASE WHEN PRO.endmonth = '0000-00-00' THEN NULL\n" +
        " 	ELSE\n" +
        " 	PRO.endmonth\n" +
        " END\n" +
        " 	)as fullEndMonth,\n" +
        "(CASE WHEN PRO.act_month_start = '0000-00-00' THEN NULL\n" +
        "	ELSE\n" +
        "	PRO.act_month_start\n" +
        "END) AS act_month_start ,\n" +
        "(CASE WHEN PRO.act_month_end = '0000-00-00' THEN NULL\n" +
        "	ELSE\n" +
        "	PRO.act_month_end\n" +
        "END) AS act_month_end,\n" +
        "(COUNT(act_dateend)/ COUNT(PMK.master_task_idtask)) as percentage,DATE_FORMAT(PRO.startmonth, '%b') as namestarMonth,"
            + "DATE_FORMAT(PRO.endmonth, '%b') as nameendMonth,day(PRO.startmonth) as dateStart,month(PRO.startmonth)as monthStart, \n" +
        "YEAR(PRO.startmonth) as yearStart, day(PRO.endmonth) as dateEnd, month(PRO.endmonth)as monthEnd, "
            + "YEAR(PRO.endmonth) as yearEnd, day(PRO.act_month_start) as dateActStart, \n" +
        "month(PRO.act_month_start) as monthActStart, year(PRO.act_month_start) as yearActStart, "
            + "day(PRO.act_month_end) as dateActEnd, month(PRO.act_month_end) as monthActEnd, \n" +
        "year(PRO.act_month_end) as yearActEnd, MAC.inisial_jenis AS inisialActivity,\n" +
        "concat(round((COUNT(act_dateend)/ COUNT(PMK.master_task_idtask))*100),\"%\") as showPercent,"
            + "AUG.color_index AS indexAudit\n" +
        "FROM project AS PRO INNER JOIN project_has_master_task AS PMK ON PMK.project_idproject=PRO.idproject\n" +
        "LEFT JOIN master_civitas AS MIC ON PRO.civitas_idcivitas=MIC.idcivitas\n" +
        "LEFT JOIN master_activity AS MAC ON PRO.master_activity_idactivity=MAC.idactivity\n" +
        "LEFT JOIN risk_factore AS RFA ON PRO.risk_factore_idrisk_factore=RFA.idrisk_value\n" +
        "LEFT JOIN audit_grading as AUG ON PRO.audit_grading_idaudit_grading=AUG.idaudit_grading\n" +
        "LEFT JOIN master_status AS MAS ON PRO.status_idstatus=MAS.idstatus\n" +
        "GROUP BY PMK.project_idproject"  ;
    
    public String querySelect="SELECT PRO.idproject, PRO.projectcol,\n" +
"COUNT(PMK.master_task_idtask) AS line, MIC.civitascol,MAC.activitycol,\n" +
"RFA.risk_valuecol as valuerisk, AUG.audit_gradingcol, MAS.statuscol, MAS.INISIAL_STATUS, \n" +
"(CASE WHEN PRO.startmonth = '0000-00-00' THEN NULL\n" +
"	ELSE \n" +
"    PRO.startmonth \n" +
"    END \n" +
"    ) as fullStartMonth, \n" +
"(CASE WHEN PRO.endmonth = '0000-00-00' THEN NULL\n" +
" 	ELSE\n" +
" 	PRO.endmonth\n" +
" END\n" +
" 	)as fullEndMonth,\n" +
"(CASE WHEN PRO.act_month_start = '0000-00-00' THEN NULL\n" +
"	ELSE\n" +
"	PRO.act_month_start\n" +
"END) AS act_month_start ,\n" +
"(CASE WHEN PRO.act_month_end = '0000-00-00' THEN NULL\n" +
"	ELSE\n" +
"	PRO.act_month_end\n" +
"END) AS act_month_end,\n" +
"(COUNT(act_dateend)/ COUNT(PMK.master_task_idtask)) as percentage,DATE_FORMAT(PRO.startmonth, '%b') as namestarMonth,\n" +
"DATE_FORMAT(PRO.endmonth, '%b') as nameendMonth,day(PRO.startmonth) as dateStart,month(PRO.startmonth)as monthStart, \n" +
"YEAR(PRO.startmonth) as yearStart, day(PRO.endmonth) as dateEnd, month(PRO.endmonth)as monthEnd, YEAR(PRO.endmonth) as yearEnd, \n" +
"day(PRO.act_month_start) as dateActStart, month(PRO.act_month_start) as monthActStart, year(PRO.act_month_start) as yearActStart, \n" +
"day(PRO.act_month_end) as dateActEnd, month(PRO.act_month_end) as monthActEnd, year(PRO.act_month_end) as yearActEnd, MAC.inisial_jenis as inisialActivity,\n" +
"concat(round((COUNT(act_dateend)/ COUNT(PMK.master_task_idtask))*100),\"%\") as showPercent,AUG.color_index AS indexAudit\n" +
"FROM project AS PRO INNER JOIN project_has_master_task AS PMK ON PMK.project_idproject=PRO.idproject\n" +
"LEFT JOIN master_civitas AS MIC ON PRO.civitas_idcivitas=MIC.idcivitas\n" +
"LEFT JOIN master_activity AS MAC ON PRO.master_activity_idactivity=MAC.idactivity\n" +
"LEFT JOIN risk_factore AS RFA ON PRO.risk_factore_idrisk_factore=RFA.idrisk_value\n" +
"LEFT JOIN audit_grading as AUG ON PRO.audit_grading_idaudit_grading=AUG.idaudit_grading\n" +
"LEFT JOIN master_status AS MAS ON PRO.status_idstatus=MAS.idstatus ";
    
    public String where; 
    public String groupBy=" GROUP BY PMK.project_idproject" ; 
    public String orderBy;
    public String insert;
    
    
    
    public void loadProfilePerStatus(int idStatus){
        where = " where PRO.status_idstatus = "+idStatus+"";
        SelectNeeded = querySelect+where+groupBy;
        
    }
    
    public void loadPerProject(String idProject){
        where = " where PMK.project_idproject = "+idProject+"";
        SelectNeeded = querySelect+where+groupBy;
    }
    
    public void loadProfilePerStatusbyYear(int idStatus, int year) {
        where = " where PRO.status_idstatus = "+idStatus+""
                + " and YEAR(PRO.startmonth) = "+year+"";
        SelectNeeded = querySelect+where+groupBy;
    }
    
    public void loadProjectbyYear(int year) {
        where = " where YEAR(PRO.startmonth) = "+year+"";
        SelectNeeded = querySelect+where+groupBy;
    }
    
    public void loadProjectSearch(int year, String SearchKey) {
        where = " where YEAR(PRO.startmonth) = "+year+""
                + " and PRO.projectcol like '%"+SearchKey+"%' "
                + " or MIC.civitascol like '%"+SearchKey+"%' "
                + " or MAC.activitycol like '%"+SearchKey+"%'";
        SelectNeeded = querySelect+where+groupBy;
    }
    
    public void loadProfilebyYearActivity(int idStatusLoad, String idAct, int year) {
        where = " where MAC.idactivity= "+idAct+" \n"
                + "and PRO.status_idstatus = "+idStatusLoad+""
                + " and YEAR(PRO.startmonth) = "+year+"";
        SelectNeeded = querySelect+where+groupBy;
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
             
            //String Prosentase=project.getProject_Percentage();
            double Prs = project.getPercentage();
            double Setnu = Prs*100;
            String valPro = Double.toString(Setnu);
            titleProsentase.setText(valPro);
            barProgress.setProgress(project.getPercentage());
            
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
            titleCivitas.setText(project.getProjectCol());
            titleActivity.setText(project.getActivityCol());
            titleStratMonth.setText(project.getNameStartMonth());
            titleEndMonth.setText(project.getNameEndMonth());
            lblProgres.setText(project.getInisialStatus());
            gridPane.getStyleClass().add("mylistview");
           
            
            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);
        

    }

    public void insertProject(String idProject, String projectValue, String civitasValue, 
            String activityValue, String riskfactorValue, String auditindexValue, String status_idstatus, LocalDate start, 
            LocalDate end, LocalDate nowDate) {
        insert = "INSERT INTO `project` (`idproject`, `projectcol`, `lineproject`, \n" +
"                       `civitas_idcivitas`, `master_activity_idactivity`, \n" +
"                       `risk_factore_idrisk_factore`, `audit_grading_idaudit_grading`, \n" +
"                       `status_idstatus`, `startmonth`, `endmonth`, `act_month_start`, \n" +
"                       `act_month_end`, `create_date`, `mod_date`) \n" +
"                       VALUES ('"+idProject+"', '"+projectValue+"', '0', '"+civitasValue+"', "
                + "'"+activityValue+"', '"+riskfactorValue+"', '"+auditindexValue+"', '"+status_idstatus+"', \n" +
"                               '"+start+"', '"+end+"', NULL, NULL, '"+nowDate+"', NULL)";
        
        SelectNeeded = insert;
        
    }
    
    public void updateActStart(String idProject, String actDateStart){
        update = "UPDATE `project` SET `act_month_start` = "+actDateStart+" and WHERE `project`.`idproject` = "+idProject+" ";
    }

    public void deleteProject(String idProject){
        delete="DELETE FROM `project` WHERE idproject="+idProject+"";
    }
    public void deleteProjectHasKaryawan(String idProject){
        delete="DELETE FROM `project_has_master_karyawan` WHERE project_idproject="+idProject+"";
    }
    public void deleteProjectHasScope(String idProject){
        delete="DELETE FROM `project_has_master_scope` WHERE project_idproject="+idProject+"";
    }
    public void deleteProjectHasTask(String idProject){
        delete="DELETE FROM `project_has_master_task` WHERE project_idproject="+idProject+"";
    }

    public void updateProject(String idProject ,String riskfactorValue, 
            String auditindexValue, String statusValue, LocalDate start, LocalDate end, LocalDate nowDate) {
        update = "UPDATE `project` SET `risk_factore_idrisk_factore` = "+riskfactorValue+", `audit_grading_idaudit_grading` = "+auditindexValue+", "
                + "`status_idstatus` = "+statusValue+" ,"
                + "`startmonth` = '"+start+"', `endmonth` = '"+end+"' , mod_date = now() WHERE `project`.`idproject` = "+idProject+" ";
        System.out.println(update);
    }

    
}
