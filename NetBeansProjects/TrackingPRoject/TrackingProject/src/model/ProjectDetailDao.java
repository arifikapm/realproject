/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.koneksi;

/**
 *
 * @author kuupie
 */
public class ProjectDetailDao {
    
    koneksi kon = new koneksi();
    
    public String queryload;
    public String insertInto;
    public String update;
    public String delete;
    
    
    public String select="SELECT pr.idproject, ci.civitascol, ma.activitycol,"
            + "monthname(pr.startmonth) as startproject,day(pr.startmonth) as dayproject ,"
            + "monthname(pr.endmonth) as endproject,day(pr.endmonth) as dayendproject, " +
                "(CASE " +
                "	WHEN pr.status_idstatus=4 then  " +
                " 			(sum(TOTAL_WEEKDAYS(pr.act_month_end,pr.endmonth))) " +
                " 	WHEN pr.status_idstatus<=3 and pr.endmonth < now() THEN " +
                " 			(sum(TOTAL_WEEKDAYS(now(),pr.endmonth))*-1) " +
                " 	WHEN pr.status_idstatus<=3 and pr.endmonth > now() THEN " +
                " 			(sum(TOTAL_WEEKDAYS(now(),pr.endmonth))) " +
                " end " +
                ")as countDown "
            + " FROM project as pr, master_civitas as ci, master_activity as ma ";
              
    public String and=" and pr.civitas_idcivitas= ci.idcivitas and pr.master_activity_idactivity=ma.idactivity ORDER BY pr.idproject";
    
    public String where;
    public String innerSelected;
    public String textFrom=" from ";
    public String innerFrom;
    
    public String selected=" SELECT pmt.project_idproject, pro.projectcol, mci.civitascol, mac.activitycol,mas.statuscol, " +
                    "monthname(pro.startmonth) as startproject,monthname(pro.endmonth) as endproject ";
    
    public String tglCount=", tglstart,tglend,tglactend, day(tglstart),monthname(tglstart),day(tglend),monthname(tglend),";
    public String cases = " (CASE " +
                    "WHEN pro.status_idstatus=4 then  " +
                    " 		(TOTAL_WEEKDAYS(tglactend,tglend)) " +
                    " WHEN pro.status_idstatus < 4 and tglend > now() THEN " +
                    " 		(TOTAL_WEEKDAYS(now(),tglend)*-1) " +
                    " WHEN pro.status_idstatus <  4 and tglend < now() THEN " +
                    " 		concat(\"+\",(TOTAL_WEEKDAYS(now(),tglend))) " +
                    " end " +
                    ")as countDown ";
    public String from = " project_has_master_task as pmt";
    public String union = " LEFT join project as pro on pmt.project_idproject = pro.idproject " +
                    "INNER join master_civitas as mci on pro.civitas_idcivitas = mci.idcivitas " +
                    "INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity " +
                    " INNER join master_status as mas on pro.status_idstatus = mas.idstatus";
    
    public String groupBy=" GROUP by pmt.project_idproject ";
    
    public void loadProjectDetail(String IdProject){
        innerFrom = " (SELECT est_datestart as tglstart " +
                    "from project_has_master_task " +
                    "WHERE project_idproject = "+IdProject+" " +
                    "and master_task_idtask = 1) as tgl_start, " +
                    "(SELECT est_datestart as tglend " +
                    "from project_has_master_task  " +
                    "WHERE project_idproject = "+IdProject+" " +
                    "and master_task_idtask = 15) as tgl_end, " +
                    "(SELECT act_dateend as tglactend " +
                    "from project_has_master_task  " +
                    "WHERE project_idproject = "+IdProject+" " +
                    "and master_task_idtask = 15) as tgl_Actend,";
        where=  " WHERE pro.idproject="+IdProject+"  ";
        queryload=selected+tglCount+cases+textFrom+innerFrom+from+union+where+groupBy;
        //System.out.println(queryload);
    }
    
    public void loadDetail(String IdProject){
        
        where=  " WHERE pr.idproject="+IdProject+"  ";
        queryload=select+where+and;
    }

    public void setDeleteTask(String idProject, String idTask) {
        delete ="DELETE FROM `project_has_master_task` \n" +
            "WHERE `project_has_master_task`.`project_idproject` = "+idProject+" \n" +
            "AND `project_has_master_task`.`master_task_idtask` = "+idTask+"";
    }
    
    public void setOnModified(){
        
    }
    
    public void setOnInsert(){
        
    }
    
}
