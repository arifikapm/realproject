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
public class TimetableDao {
    koneksi kon = new koneksi();
    
    public String loadData;
    public String queryloadString = "SELECT idproject, projectcol as task, day(startmonth) as dateStart, "
            + "month(startmonth)as monthStart, YEAR(startmonth) as yearStart, day(endmonth) as dateEnd, "
            + "month(endmonth)as monthEnd, YEAR(endmonth) as yearEnd, day(act_month_start) as dateActStart, "
            + "month(act_month_start) as monthActStart, year(act_month_start) as yearActStart, "
            + "day(act_month_end) as dateActEnd, "
            + "month(act_month_end) as monthActEnd, year(act_month_end) as yearActEnd from project";
    public String queryInnerLoad = "SELECT idproject, projectcol as task, day(startmonth) as dateStart,\n" +
            "month(startmonth)as monthStart, YEAR(startmonth) as yearStart, day(endmonth) as dateEnd, \n" +
            "month(endmonth)as monthEnd, YEAR(endmonth) as yearEnd, day(act_month_start) as dateActStart,\n" +
            "month(act_month_start) as monthActStart, year(act_month_start) as yearActStart, \n" +
            "day(act_month_end) as dateActEnd, \n" +
            "month(act_month_end) as monthActEnd, year(act_month_end) as yearActEnd \n" +
            "from project\n" +
            "INNER join master_civitas as mas on project.civitas_idcivitas = mas.idcivitas\n" +
            "INNER join group_civitas as gac on mas.group_civitas_idgroup_civitas = gac.idgroup_civitas\n ";
    public String where;
    public String groupBy;
    public String like;
    
            
    public void loadActivityTimeTable(int idAcitivity){
        where = " where master_activity_idactivity = " +idAcitivity+ " ";
        loadData = queryloadString+where;
    }

    public void loadActivityTimeTablebyYear(int idActivity, int year) {
        where = " where master_activity_idactivity = " +idActivity+ " \n "
                + " and YEAR(startmonth) = "+year+"";
        loadData = queryloadString+where;
    }

    public void loadActivityTimeTableGroup(int idActivity, int year, String idGroup) {
        where = " WHERE master_activity_idactivity = "+idActivity+" \n" +
                " and YEAR(startmonth) = "+year+" \n " +
                " and gac.idgroup_civitas = "+idGroup+"" ;
        loadData = queryInnerLoad+where;
    }
}
