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
public class ProfileLineDao {
    
    public String selectPlanLine = "SELECT quarter,\n" +
        "(@sum:=@sum + countPlan) as accumPlanEnd\n" +
        "from\n" +
        "(SELECT idproject, quarter(endmonth) as quarter, COUNT(endmonth) as countPlan "
            + "from project "
            + "group by quarter HAVING countPlan >1 ) as counttable,\n" +
        "(SELECT @sum:=0) as total\n" +
        "group by quarter";
    
    public String selectCompleteLine = "SELECT quarter,\n" +
        "(@sum:=@sum + countPlan) as CountValue\n" +
        "from\n" +
        "(SELECT idproject, quarter(`act_month_end`) as quarter, COUNT(`idproject`) as countPlan \n" +
        " from project \n" +
        " where status_idstatus = 4\n" +
        " group by quarter HAVING countPlan >1 ) as counttable,\n" +
        "(SELECT @sum:=0) as total\n" +
        "group by quarter";
    
    public String selectInprogress = "SELECT quarter,\n" +
        "(@sum:=@sum + countPlan) as CountValue\n" +
        "from\n" +
        "(SELECT idproject, quarter(now()) as quarter, COUNT(`idproject`) as countPlan \n" +
        " from project \n" +
        " where status_idstatus = 2\n" +
        " group by quarter HAVING countPlan >1 ) as counttable,\n" +
        "(SELECT @sum:=0) as total\n" +
        "group by quarter";
    
    
}
