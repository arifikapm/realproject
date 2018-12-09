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
public class Activity {
    
    private final IntegerProperty IdAcitivity;
    private final StringProperty Acitivitycol;
    private final StringProperty Inisialjenis;
    
    public Activity(int idactivity, String activitycol, String inisial_jenis){
        this.IdAcitivity = new SimpleIntegerProperty(idactivity);
        this.Acitivitycol = new SimpleStringProperty(activitycol);
        this.Inisialjenis = new SimpleStringProperty(inisial_jenis);
    }

    public int getIdAcitivity() {
        return IdAcitivity.get();
    }

    public String getAcitivitycol() {
        return Acitivitycol.get();
    }

    public String getInisialjenis() {
        return Inisialjenis.get();
    }

    public void setIdAcitivity(int value) {
        IdAcitivity.setValue(value);
    }

    public void setAcitivitycol(String value) {
        Acitivitycol.setValue(value);
    }

    public void setInisialjenis(String value) {
        Inisialjenis.setValue(value);
    }
    
}
