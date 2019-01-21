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
public class MasStatusProject {
    
    private final IntegerProperty IdStatus;
    private final SimpleStringProperty StatusCol;
    private final SimpleStringProperty Inisial_Status;
    
    public MasStatusProject(int idStatus, String statusCol, String inisial_Status){
        this.IdStatus = new SimpleIntegerProperty(idStatus);
        this.StatusCol = new SimpleStringProperty(statusCol);
        this.Inisial_Status = new SimpleStringProperty(inisial_Status);
    }

    public int getIdStatus() {
        return IdStatus.get();
    }

    public String getStatusCol() {
        return StatusCol.get();
    }

    public String getInisialstatus() {
        return Inisial_Status.get();
    }

    public void setIdStatus(int value) {
        IdStatus.setValue(value);
    }

    public void setStatuscol(String value) {
        StatusCol.setValue(value);
    }

    public void setInisialstatus(String value) {
        Inisial_Status.setValue(value);
    }
    
}
