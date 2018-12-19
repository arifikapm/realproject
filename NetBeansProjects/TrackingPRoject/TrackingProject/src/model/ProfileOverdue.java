/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kuupie
 */
public class ProfileOverdue {
    
    private final SimpleStringProperty ActivityCol;
    private final SimpleDoubleProperty OverDue;
    private final SimpleDoubleProperty AverageProject;
    
    public ProfileOverdue(String activityCol, double overDue, double averageProject){
        this.ActivityCol= new SimpleStringProperty(activityCol);
        this.OverDue = new SimpleDoubleProperty(overDue);
        this.AverageProject = new SimpleDoubleProperty(averageProject);
    }

    public String getActivityCol() {
        return ActivityCol.get();
    }

    public double getOverDue() {
        return OverDue.get();
    }

    public double getAverageProject() {
        return AverageProject.get();
    }

    public void setActivityCol(String value) {
        this.ActivityCol.setValue(value);
    }

    public void setOverDue(double value) {
        this.OverDue.set(value);
    }

    public void setAverageProject(double value) {
        this.AverageProject.set(value);
    }
}
