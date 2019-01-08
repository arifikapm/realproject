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
    public String where;
    public String groupBy;
    public String like;
    
            
    public void loadActivityTimeTable(int idAcitivity){
        where = " where master_activity_idactivity = " +idAcitivity+ " ";
        loadData = queryloadString+where;
    }
}
