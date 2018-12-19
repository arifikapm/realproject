/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kuupie
 */
public class ProfileChartPieDao {
    
    public String Select;
    public String Queryload="SELECT mac.activitycol,mas.statuscol,COUNT(pro.idproject) as projectprofile\n" +
        "from project as pro\n" +
        "INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" +
        "INNER join master_status as mas on pro.status_idstatus = mas.idstatus ";
    public String Where;
    public String Groupby;
    public String Order;
    
    public void returnLoadProfile(String idActivity){
        Where =" WHERE mac.idactivity = "+idActivity;
        Groupby=" group by mac.idactivity,mas.idstatus";
        Select=Queryload+Where+Groupby;
    }
}
