/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import db.koneksi;

/**
 *
 * @author kuupie
 */
public class DetailProDao {
    //koneksi kon = new koneksi();
    public String queryload;
    public String select="SELECT ac.idactivity, ci.civitascol, ac.startmonth, "
            + "ac.endmonth, jn.jeniscol, ci.civitascol,st.statuscol FROM activity as ac, "
            + "jenis as jn, civitas as ci, status as st ";
    public String where;
    public String and= "and ac.jenis_idjenis = jn.idjenis "
            + "and ac.civitas_idcivitas = ci.idcivitas and ac.status_idstatus = st.idstatus "
            + "order by ac.idactivity asc";
    
    public void tabelDetailProject(String idProjectActivity){
        System.out.println(idProjectActivity);
        where="where ac.idactivity="+idProjectActivity+" ";
        queryload= select+where+and;
        //return idProjectActivity;
    }
    
   
}
