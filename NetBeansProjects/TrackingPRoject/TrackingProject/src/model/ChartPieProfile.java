/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kuupie
 */
public class ChartPieProfile {
    
    private final SimpleStringProperty activityCol;
    private final SimpleStringProperty statusCol;
    private final SimpleIntegerProperty projectProfile;
    
    public ChartPieProfile(String Activitycol,String Statuscol,int Projectprofile){
        this.activityCol = new SimpleStringProperty(Activitycol);
        this.statusCol = new SimpleStringProperty(Statuscol);
        this.projectProfile = new SimpleIntegerProperty(Projectprofile);
    }

    public String getActivityCol() {
        return activityCol.get();
    }

    public String getStatusCol() {
        return statusCol.get();
    }

    public int getProjectProfile() {
        return projectProfile.get();
    }

    public void setActivityCol(String v) {
        this.activityCol.setValue(v);
    }

    public void setStatusCol(String v) {
        this.statusCol.setValue(v);
    }

    public void setProjectProfile(int v) {
        this.projectProfile.setValue(v);
    }
    
}
