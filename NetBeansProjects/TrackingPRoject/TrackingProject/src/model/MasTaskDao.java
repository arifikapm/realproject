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
public class MasTaskDao {
    
    public String selectAll = "SELECT mta.idtask, mta.taskcol, mta.inisial_task, rta.rootprocesscol\n" +
            " from master_task as mta\n" +
            " inner join roottask as rta on mta.roottask_idroottask = rta.idroottask ";

    
}
