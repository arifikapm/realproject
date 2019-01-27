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
public class MasResponsibilityDao {
    
    public String selectAll="SELECT `idresponsibility`, `responsibilitycol`, `inisial_responsibility` "
            + "FROM `responsibility`";
    public String where;
    public String groupBy;
    
    
}
