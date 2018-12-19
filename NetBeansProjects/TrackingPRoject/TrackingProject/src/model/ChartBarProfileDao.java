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
public class ChartBarProfileDao {
//    " where mac.idactivity = 1 \n" +
//            "and mas.idstatus = 4\n" +
//            "group by mas.idstatus, gac.idgroup_civitas";
    public String Select;
    public String Queryload="SELECT mas.idstatus as valueId,mas.statuscol as valueCol,gac.group_civitascol as valueName,COUNT(pro.idproject) as valueCount\n" +
            "from project as pro INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" +
            "INNER join master_status as mas on pro.status_idstatus = mas.idstatus\n" +
            "INNER join master_civitas as mci on pro.civitas_idcivitas = mci.idcivitas\n" +
            "INNER join group_civitas as gac on mci.group_civitas_idgroup_civitas = gac.idgroup_civitas\n " ;
            
    public String Where;
    public String Groupby;
    public String Order;
    
    public String testCount;
    
    public String testLoad="SELECT mas.idstatus as valueId,mas.statuscol as valueCol,gac.group_civitascol as valueName,COUNT(pro.idproject) as valueCount\n" +
            "from project as pro INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" +
            "INNER join master_status as mas on pro.status_idstatus = mas.idstatus\n" +
            "INNER join master_civitas as mci on pro.civitas_idcivitas = mci.idcivitas\n" +
            "INNER join group_civitas as gac on mci.group_civitas_idgroup_civitas = gac.idgroup_civitas\n" +
            "where mac.idactivity = 1 \n" +
            "group by mas.idstatus, gac.idgroup_civitas";
    
    public void returnLoadStatus(int idStatus){
        Where=" where mas.idstatus = "+idStatus;
        Select=Queryload+Where;
    }
    
    public void returnLoadBarProfile(String idactivity, int idStatus){
        Where = " where mac.idactivity = " +idactivity+" and mas.idstatus = "+idStatus+ "";
        Groupby=" group by mas.idstatus, gac.idgroup_civitas";
        Select=Queryload+Where+Groupby;
    }
    
    
}
