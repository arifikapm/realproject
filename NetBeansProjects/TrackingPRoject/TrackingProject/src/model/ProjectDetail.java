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
    //`idproject`, `projectcol`, 
    //`startmonth`, `endmonth`, `civitas_idcivitas`, `status_idstatus`, `master_activity_idactivity`, `project_percentage`
    private final StringProperty idproject;
    private final StringProperty civitascol;
    private final StringProperty activitycol;
    private final StringProperty startproject;
    private final StringProperty dayproject;
    private final StringProperty endproject;
    private final StringProperty dayendproject;
    private StringProperty CountDown;
    //private final StringProperty percentage;
    
   
    public ProjectDetail(String idproject, String civitascol, String activitycol, String startproject, String dayproject, String endproject ,
            String dayendproject,String countDown){
        this.idproject = new SimpleStringProperty(idproject);
        this.civitascol = new SimpleStringProperty(civitascol);
        this.activitycol = new SimpleStringProperty(activitycol);
        this.startproject = new SimpleStringProperty(startproject);
        this.dayproject = new SimpleStringProperty(dayproject);
        this.endproject = new SimpleStringProperty(endproject);
        this.dayendproject = new SimpleStringProperty(dayendproject);
        this.CountDown = new SimpleStringProperty(countDown);
        //this.percentage = new SimpleStringProperty(percentage);
        
    }

    public String getIdproject() {
        return idproject.get();
    }

    public String getCivitascol() {
        return civitascol.get();
    }

    public String getActivitycol() {
        return activitycol.get();
    }

    public String getStartproject() {
        return startproject.get();
    }

    public String getDayproject() {
        return dayproject.get();
    }

    public String getEndproject() {
        return endproject.get();
    }

    public String getDayendproject() {
        return dayendproject.get();
    }

    public String getCountDown() {
        return CountDown.get();
    }

    public void setCountDown(String value) {
        this.CountDown.setValue(value);
    }

    public void setIdactivity(String value) {
       idproject.setValue(value);
    }

    public void setCivitas(String value) {
        civitascol.setValue(value);
    }

    public void setActivity(String value) {
        activitycol.setValue(value);
    }

    public void setStartmonthName(String value) {
        startproject.setValue(value);
    }

    public void setTglStartMonth(String value){
        dayproject.setValue(value);
    }

    public void setEndmonthName(String value) {
        endproject.setValue(value);
    }

    public void setTglEndMonth(String value) {
        dayendproject.setValue(value);
    }

    
}
