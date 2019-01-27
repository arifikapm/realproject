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
public class CountDao {
    
    public String selectCount = "SELECT COUNT(*) AS countPROJECT FROM project";
    public String loadCount;
    public String where;

    public void loadCountbyYear(int year) {
       where = " where YEAR(startmonth) = "+year+"";
       loadCount=selectCount+where;
    }
    
    
}
