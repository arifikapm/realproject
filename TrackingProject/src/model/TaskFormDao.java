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
public class TaskFormDao {
    
    koneksi kon = new koneksi();
    
    public String queryload;
    public String select="SELECT pmt.project_idproject as idproject, mt.taskcol as task, day(pmt.est_datestart) as dateStart, \n" +
"month(pmt.est_datestart) as monthStart, year(pmt.est_datestart) as yearStart,\n" +
"day(pmt.est_dateend) as dateEnd, month(pmt.est_dateend) as monthEnd,\n" +
"year(pmt.est_dateend) as yearEnd,\n" +
"day(pmt.act_datestart) as dateActStart, month(pmt.act_datestart) as monthActStart,\n" +
"YEAR(pmt.act_datestart) as yearActStart,\n" +
"day(pmt.act_dateend) as dateActEnd, month(pmt.act_dateend) as monthActEnd,\n" +
"year(pmt.act_dateend) as yearActEnd\n" +
"FROM project as pr\n" +
"LEFT JOIN project_has_master_task as pmt\n" +
"on pr.idproject=pmt.project_idproject\n" +
"LEFT JOIN master_task as mt\n" +
"on pmt.master_task_idtask=mt.idtask\n" ;
    public String where;
    public String and;
    
    public void loadData(String idProject){
        where = " WHERE pr.idproject="+idProject+"";
        queryload=select+where;
        
    }
}
