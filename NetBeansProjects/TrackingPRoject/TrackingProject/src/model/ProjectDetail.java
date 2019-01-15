/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class ProjectDetail {
    
    private final StringProperty IdProject;
    private final StringProperty ProjectCol;
    private final StringProperty CivitasCol;
    private final StringProperty ActivityCol;
    private final StringProperty StatusCol;
    private final StringProperty StartProject;
    private final StringProperty EndProject;
    private final StringProperty TglStart;
    private final StringProperty TglEnd;
    private final StringProperty DayStart;
    private final StringProperty MonthnameStart;
    private final StringProperty DayEnd;
    private final StringProperty MonthnameEnd;
    private final StringProperty TglActEnd;
    private final StringProperty CountDown;

    public ProjectDetail(String idProject, String projectCol, String civitasCol, 
            String activityCol, String statusCol, String startProject, 
            String endProject, String tglStart, String tglEnd, String dayStart, 
            String monthnameStart, String dayEnd, String monthnameEnd, String tglActEnd, 
            String countDown) {
        
        this.IdProject = new SimpleStringProperty(idProject);
        this.ProjectCol = new SimpleStringProperty(projectCol);
        this.CivitasCol = new SimpleStringProperty(civitasCol);
        this.ActivityCol = new SimpleStringProperty(activityCol);
        this.StatusCol = new SimpleStringProperty(statusCol);
        this.StartProject = new SimpleStringProperty(startProject);
        this.EndProject = new SimpleStringProperty(endProject);
        this.TglStart = new SimpleStringProperty(tglStart);
        this.TglEnd = new SimpleStringProperty(tglEnd);
        this.DayStart = new SimpleStringProperty(dayStart);
        this.MonthnameStart = new SimpleStringProperty(monthnameStart);
        this.DayEnd = new SimpleStringProperty(dayEnd);
        this.MonthnameEnd = new SimpleStringProperty(monthnameEnd);
        this.TglActEnd = new SimpleStringProperty(tglActEnd);
        this.CountDown = new SimpleStringProperty(countDown);
    }

     public String getIdProject() {
        return IdProject.get();
    }

     public String getProjectCol() {
        return ProjectCol.get();
    }

     public String getCivitasCol() {
        return CivitasCol.get();
    }

     public String getActivityCol() {
        return ActivityCol.get();
    }

     public String getStatusCol() {
        return StatusCol.get();
    }

     public String getStartProject() {
        return StartProject.get();
    }

     public String getEndProject() {
        return EndProject.get();
    }

     public String getTglStart() {
        return TglStart.get();
    }

     public String getTglEnd() {
        return TglEnd.get();
    }

     public String getDayStart() {
        return DayStart.get();
    }

     public String getMonthnameStart() {
        return MonthnameStart.get();
    }

     public String getDayEnd() {
        return DayEnd.get();
    }

     public String getMonthnameEnd() {
        return MonthnameEnd.get();
    }

     public String getTglActEnd() {
        return TglActEnd.get();
    }

     public String getCountDown() {
        return CountDown.get();
    }

    public void setIdProject(String value) {
        this.IdProject.setValue(value);
    }

    public void setProjectCol(String value) {
        this.ProjectCol.setValue(value);
    }

    public void setCivitasCol(String value) {
        this.CivitasCol.setValue(value);
    }

    public void setActivityCol(String value) {
        this.ActivityCol.setValue(value);
    }

    public void setStatusCol(String value) {
        this.StatusCol.setValue(value);
    }

    public void setStartProject(String value) {
        this.StartProject.setValue(value);
    }

    public void setEndProject(String value) {
        this.EndProject.setValue(value);
    }

    public void setTglStart(String value) {
        this.TglStart.setValue(value);
    }

    public void setTglEnd(String value) {
        this.TglEnd.setValue(value);
    }

    public void setDayStart(String value) {
        this.DayStart.setValue(value);
    }

    public void setMonthnameStart(String value) {
        this.MonthnameStart.setValue(value);
    }

    public void setDayEnd(String value) {
        this.DayEnd.setValue(value);
    }

    public void setMonthnameEnd(String value) {
        this.MonthnameEnd.setValue(value);
    }

    public void setTglActEnd(String value) {
        this.TglActEnd.setValue(value);
    }

    public void setCountDown(String value) {
        this.CountDown.setValue(value);
    }
    

    
    //private final StringProperty percentage;
    
        
    }
