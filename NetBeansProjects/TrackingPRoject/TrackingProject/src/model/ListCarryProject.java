/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class ListCarryProject {
 
 private final StringProperty IdProject;
 private final StringProperty ProjectCol;
 private final StringProperty CivitasCol;
 private final StringProperty InisialJenis;
 private final StringProperty StatusCol;
 private final StringProperty StartProject;
 private final StringProperty EndProject;
 private final StringProperty Percentage;

    public ListCarryProject(String idProject, String projectCol, String civitasCol, 
            String inisialJenis, String statusCol, String startProject, 
            String endProject, String percentage) {
        
        this.IdProject = new SimpleStringProperty(idProject);
        this.ProjectCol = new SimpleStringProperty(projectCol);
        this.CivitasCol = new SimpleStringProperty(civitasCol);
        this.InisialJenis = new SimpleStringProperty(inisialJenis);
        this.StatusCol = new SimpleStringProperty(statusCol);
        this.StartProject = new SimpleStringProperty(startProject);
        this.EndProject = new SimpleStringProperty(endProject);
        this.Percentage = new SimpleStringProperty(percentage);
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

    public String getInisialJenis() {
        return InisialJenis.get();
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

    public String getPercentage() {
        return Percentage.get();
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

    public void setInisialJenis(String value) {
        this.InisialJenis.setValue(value);
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

    public void setPercentage(String value) {
        this.Percentage.setValue(value);
    }
    


    
}
