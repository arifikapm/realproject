/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class MasTask {
    
    private final StringProperty idTask;
    private final StringProperty taskCol;
    private final StringProperty inisial_Task;
    private final StringProperty rootCol;

    
    public MasTask(String idtask, String taskcol, String inisial_task, 
            String rootcol){
        this.idTask=new SimpleStringProperty(idtask);
        this.taskCol=new SimpleStringProperty(taskcol);
        this.inisial_Task=new SimpleStringProperty(inisial_task);
        this.rootCol=new SimpleStringProperty(rootcol);
     
    }

    public String getIdTask() {
        return idTask.get();
    }

    public String getTaskCol() {
        return taskCol.get();
    }

    public String getInisialTask() {
        return inisial_Task.get();
    }

    public String getRootCol() {
        return rootCol.get();
    }

    public void setIdTask(String value) {
        idTask.setValue(value);
    }

    public void setTaskCol(String value) {
        taskCol.setValue(value);
    }

    public void setInisialTask(String value) {
        inisial_Task.setValue(value);
    }

    public void setRootCol(String value) {
        rootCol.setValue(value);
    }

    
}
