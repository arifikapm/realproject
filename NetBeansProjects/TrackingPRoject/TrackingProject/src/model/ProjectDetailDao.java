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
    public String select="SELECT pr.idproject, ci.civitascol, ma.activitycol,"
            + "monthname(pr.startmonth) as startproject,day(pr.startmonth) as dayproject ,"
            + "monthname(pr.endmonth) as endproject,day(pr.endmonth) as dayendproject,\n" +
                "(CASE\n" +
                "	WHEN pr.status_idstatus=4 then \n" +
                " 			(sum(TOTAL_WEEKDAYS(pr.act_month_end,pr.endmonth)))\n" +
                " 	WHEN pr.status_idstatus<=3 and pr.endmonth < now() THEN\n" +
                " 			(sum(TOTAL_WEEKDAYS(now(),pr.endmonth))*-1)\n" +
                " 	WHEN pr.status_idstatus<=3 and pr.endmonth > now() THEN\n" +
                " 			(sum(TOTAL_WEEKDAYS(now(),pr.endmonth)))\n" +
                " end\n" +
                ")as countDown "
            + " FROM project as pr, master_civitas as ci, master_activity as ma ";
            
    public String where;
    public String and="and pr.civitas_idcivitas= ci.idcivitas and pr.master_activity_idactivity=ma.idactivity ORDER BY pr.idproject";
    
    public void loadDetail(String IdProject){
        
        where=  " WHERE pr.idproject="+IdProject+"  ";
        queryload=select+where+and;
    }
    
}
