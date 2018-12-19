/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class Timetable {
    
//    //"SELECT idproject, projectcol as task, day(startmonth) as dateStart, "
//            + "monthname(startmonth)as monthStart, YEAR(startmonth) as yearStart, day(endmonth) as dateEnd, "
//            + "monthname(endmonth)as monthEnd, YEAR(endmonth) as yearEnd, day(act_month_start) as dateActStart, "
//            + "monthname(act_month_start) as monthActStart, year(act_month_start) as yearActStart, day(act_month_end) as dateActEnd, "
//            + "monthname(act_month_end) as monthActEnd, year(act_month_end) as yearActEnd from project";
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
    
    
    public Timetable(String idProject, String task,int dateStart,int monthStart,int yearStart,int dateEnd, 
            int monthEnd, int yearEnd, int dateActStart, int monthActStart, int yearActStart, 
            int dateActEnd, int monthActEnd, int yearActEnd){
        Date dateSt;
        
        this.idProject =new SimpleStringProperty(idProject);
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
    
}
