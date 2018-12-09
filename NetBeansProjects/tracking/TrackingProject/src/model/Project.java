/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class Project {
    private final StringProperty IdActivity;
    private final StringProperty Projectcol;
    private final StringProperty StartMonth;
    private final StringProperty EndMonth;
    private final StringProperty CivitasCol;
    private final StringProperty InisialProgress;
    private final StringProperty ActivityCol;
    //private final IntegerProperty Project_Percentage;
    private final StringProperty Project_Percentage;
    
    
    public Project(String idActivity, String projectcol, String startMonth, String endMonth, 
            String civitascol, String inisialprogres, String activitycol, String project_percentage){
        this.IdActivity = new SimpleStringProperty(idActivity);
        this.Projectcol = new SimpleStringProperty(projectcol);
        this.StartMonth = new SimpleStringProperty(startMonth);
        this.EndMonth = new SimpleStringProperty(endMonth);
        this.CivitasCol = new SimpleStringProperty(civitascol);
        this.InisialProgress = new SimpleStringProperty(inisialprogres);
        this.ActivityCol = new SimpleStringProperty(activitycol);
        this.Project_Percentage=new SimpleStringProperty(project_percentage);
    }

    public String getIdActivity() {
        return IdActivity.get();
    }

    public String getProjectcol() {
        return Projectcol.get();
    }

    public String getStartMonth() {
        return StartMonth.get();
    }

    public String getEndMonth() {
        return EndMonth.get();
    }

    public String getCivitasCol() {
        return CivitasCol.get();
    }

    public String getInisialProgress() {
        return InisialProgress.get();
    }

    public String getActivityCol() {
        return ActivityCol.get();
    }

    public String getProject_Percentage() {
        return Project_Percentage.get();
    }

    public void setIdActivity(String value) {
        IdActivity.setValue(value);
    }

    public void setProjectcol(String value) {
        Projectcol.setValue(value);
    }

    public void setStartMonth(String value) {
        StartMonth.setValue(value);
    }

    public void setEndMonth(String value) {
        EndMonth.setValue(value);
    }

    public void setCivitasCol(String value) {
        CivitasCol.setValue(value);
    }

    public void setInisialProgress(String value) {
       InisialProgress.setValue(value);
    }

    public void setActivityCol(String value) {
        ActivityCol.setValue(value);
    }

    public void setProject_Percentage(String value) {
        Project_Percentage.setValue(value);
    }
    
    
    
    
}
