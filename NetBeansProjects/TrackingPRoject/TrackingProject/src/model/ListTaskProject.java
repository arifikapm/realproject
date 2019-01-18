/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.jfoenix.controls.JFXButton;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class ListTaskProject {
    private final StringProperty IdTask;
    private final StringProperty TaskCol;
    private final SimpleObjectProperty<Date> Est_Datestart;
    private final SimpleObjectProperty<Date> Est_Dateend;
    private final SimpleObjectProperty<Date> Act_Datestart;
    private final SimpleObjectProperty<Date> Act_Dateend;

    public ListTaskProject(String idTask, String taskCol, 
            Date est_Datestart, Date est_Dateend, 
            Date act_Datestart, Date act_Dateend) {
        this.IdTask = new SimpleStringProperty(idTask);
        this.TaskCol = new SimpleStringProperty(taskCol);
        this.Est_Datestart = new SimpleObjectProperty<>(est_Datestart);
        this.Est_Dateend = new SimpleObjectProperty<>(est_Dateend);
        this.Act_Datestart = new SimpleObjectProperty<>(act_Datestart);
        this.Act_Dateend = new SimpleObjectProperty<>(act_Dateend);
    }
    

//    private final StringProperty IdProject;
//    private final StringProperty CivitasCol;
//    private final SimpleObjectProperty<Date> StartMonth;
//    private final SimpleObjectProperty<Date> EndMonth;
//    private final SimpleObjectProperty<Date> date;
//    private JFXButton SimpanData;

//    public ListTaskProject(String idproject, String civitascol, Date startMonth, Date endMonth, Date datet) {
//        this.IdProject = new SimpleStringProperty(idproject);
//        this.CivitasCol = new SimpleStringProperty(civitascol);
//        this.StartMonth = new SimpleObjectProperty<>(startMonth);
//        this.EndMonth = new SimpleObjectProperty<>(endMonth);
//        this.date = new SimpleObjectProperty<>(datet);
//        this.SimpanData = new JFXButton("Mod");
//    }
    
    public String getIdTask() {
        return IdTask.get();
    }
    
     public String getTaskCol() {
        return TaskCol.get();
    }

    public Date getEst_Datestart() {
        return Est_Datestart.get();
    }
    
    //property getter
    public SimpleObjectProperty<Date> dateEstStart() {
        return Est_Datestart;
    }

    public Date getEst_Dateend() {
        return Est_Dateend.get();
    }
    
     public SimpleObjectProperty<Date> dateEstEnd() {
        return Est_Dateend;
    }
    
     public Date getAct_Dateend() {
        return Act_Dateend.get();
    }
    
     public SimpleObjectProperty<Date> dateActEnd() {
        return Act_Dateend;
    }
    
     public Date getAct_Datestart() {
        return Act_Datestart.get();
    }
    
     public SimpleObjectProperty<Date> dateActStart() {
        return Act_Datestart;
    }


    public void setIdTask(String value) {
        IdTask.setValue(value);
    }
    
    public void setTaskCol(String value) {
        TaskCol.setValue(value);
    }

    public void setEst_Datestart(Date value) {
        Est_Datestart.setValue(value);
    }

    public void setEst_Dateend(Date value) {
        Est_Dateend.setValue(value);
    }
    public void setAct_Datestart(Date value) {
        Act_Datestart.setValue(value);
    }
    public void setAct_Dateend(Date value) {
        Act_Dateend.setValue(value);
    }

//
//    public String getIdActivity() {
//        return IdProject.get();
//    }
//
//    public void setIdActivity(String idActivity) {
//        IdProject.setValue(idActivity);
//    }
    
//    //getter
//    public Date getDate() {
//        return date.get();
//    }
//
//    //property getter
//    public SimpleObjectProperty<Date> dateProperty() {
//        return date;
//    }
//
//    //setter
//    public void setDate(Date date) {
//        this.date.set(date);
//    }
    
//    public JFXButton getSimpanData(){
//        return SimpanData;
//    }
//    
//    public void setSimpanData(JFXButton simpanData){
//        this.SimpanData = simpanData;
//    }
}
