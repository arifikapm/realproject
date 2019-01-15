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
public class TaskForm {
   

    private final StringProperty idProject;
    private final StringProperty task;
    private final IntegerProperty dateStart;
    private final IntegerProperty monthStart;
    private final IntegerProperty yearStart;
    private final IntegerProperty dateEnd;
    private final IntegerProperty monthEnd;
    private final IntegerProperty yearEnd;
    private final IntegerProperty dateActStart;
    private final IntegerProperty monthActStart;
    private final IntegerProperty yearActStart;
    private final IntegerProperty dateActEnd;
    private final IntegerProperty monthActEnd;
    private final IntegerProperty yearActEnd;
    private final StringProperty IdTask;
    private final StringProperty EstDateStart;
    private final StringProperty EstDateEnd;
    private final StringProperty ActDateStart;
    private final StringProperty ActDateEnd;
    
    public TaskForm(String idproject, String task,int dateStart,int monthStart,int yearStart,int dateEnd, 
            int monthEnd, int yearEnd, int dateActStart, int monthActStart, int yearActStart, 
            int dateActEnd, int monthActEnd, int yearActEnd, String idTask, String estDateStart,
            String estDateEnd,String actDateStart, String actDateEnd){
        
        
        this.idProject =new SimpleStringProperty(idproject);
        this.task =new SimpleStringProperty(task);
        this.dateStart =new SimpleIntegerProperty(dateStart);
        this.monthStart =new SimpleIntegerProperty(monthStart);
        this.yearStart =new SimpleIntegerProperty(yearStart);
        this.dateEnd =new SimpleIntegerProperty(dateEnd);
        this.monthEnd =new SimpleIntegerProperty(monthEnd);
        this.yearEnd =new SimpleIntegerProperty(yearEnd);
        this.dateActStart =new SimpleIntegerProperty(dateActStart);
        this.monthActStart =new SimpleIntegerProperty(monthActStart);
        this.yearActStart =new SimpleIntegerProperty(yearActStart);
        this.dateActEnd =new SimpleIntegerProperty(dateActEnd);
        this.monthActEnd =new SimpleIntegerProperty(monthActEnd);
        this.yearActEnd =new SimpleIntegerProperty(yearActEnd);
        this.IdTask =new SimpleStringProperty(idTask);
        this.EstDateStart =new SimpleStringProperty(estDateStart);
        this.EstDateEnd =new SimpleStringProperty(estDateEnd);
        this.ActDateStart =new SimpleStringProperty(actDateStart);
        this.ActDateEnd =new SimpleStringProperty(actDateEnd);
        
    }

    public String getIdProject() {
        return idProject.get();
    }

    public String getTask() {
        return task.get();
    }

    public int getDateStart() {
        return dateStart.get();
    }

    public int getMonthStart() {
        return monthStart.get();
    }

    public int getYearStart() {
        return yearStart.get();
    }

    public int getDateEnd() {
        return dateEnd.get();
    }

    public int getMonthEnd() {
        return monthEnd.get();
    }

    public int getYearEnd() {
        return yearEnd.get();
    }

    public int getDateActStart() {
        return dateActStart.get();
    }

    public int getMonthActStart() {
        return monthActStart.get();
    }

    public int getYearActStart() {
        return yearActStart.get();
    }

    public int getDateActEnd() {
        return dateActEnd.get();
    }

    public int getMonthActEnd() {
        return monthActEnd.get();
    }

    public int getYearActEnd() {
        return yearActEnd.get();
    }
    public String getIdTask() {
        return IdTask.get();
    }
  
    public String getEstDateStart() {
        return EstDateStart.get();
    }
    public String getEstDateEnd() {
        return EstDateEnd.get();
    }
    public String getActDateStart() {
        return ActDateStart.get();
    }
    public String getActDateEnd() {
        return ActDateEnd.get();
    }

    public void setIdProject(String value) {
        this.idProject.setValue(value);
    }

    public void setTask(String value) {
        this.task.setValue(value);
    }

    public void setDateStart(int value) {
        this.dateStart.setValue(value);
    }

    public void setMonthStart(int value) {
        this.monthStart.setValue(value);
    }

    public void setYearStart(int value) {
        this.yearStart.setValue(value);
    }

    public void setDateEnd(int value) {
        this.dateEnd.setValue(value);
    }

    public void setMonthEnd(int value) {
        this.monthEnd.setValue(value);
    }

    public void setYearEnd(int value) {
        this.yearEnd.setValue(value);
    }

    public void setDateActStart(int value) {
        this.dateActStart.setValue(value);
    }

    public void setMonthActStart(int value) {
        this.monthActStart.setValue(value);
    }

    public void setYearActStart(int value) {
        this.yearActStart.setValue(value);
    }

    public void setDateActEnd(int value) {
        this.dateActEnd.setValue(value);
    }

    public void setMonthActEnd(int value) {
        this.monthActEnd.setValue(value);
    }

    public void setYearActEnd(int value) {
        this.yearActEnd.setValue(value);
    }
    
    public void setIdTask(String value) {
        this.IdTask.setValue(value);
    }
    
    public void setEstDateStart(String value) {
        this.EstDateStart.setValue(value);
    }
    public void setEstDateEnd(String value) {
        this.EstDateEnd.setValue(value);
    }
    public void setActDateStart(String value) {
        this.ActDateStart.setValue(value);
    }
    public void setActDateEnd(String value) {
        this.ActDateEnd.setValue(value);
    }
    
}
