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
public class ListCountProject {

    private final StringProperty idactivity;
    private final StringProperty civitascol;
    private final StringProperty valueCount;
    
    public ListCountProject(String idActivity, String civitasCol,String countProject){
        this.idactivity = new SimpleStringProperty(idActivity);
        this.civitascol = new SimpleStringProperty(civitasCol);
        this.valueCount = new SimpleStringProperty(countProject);
        
        
    }

    public String getIdActivity() {
        return idactivity.get();
    }
    
    public String getCivitascol() {
        return civitascol.get();
    }

    public String getValueCount() {
        return valueCount.get();
    }


    public void setIdActivity(String value) {
        idactivity.setValue(value);
    }
    
    public void setCivitascol(String value) {
        civitascol.setValue(value);
    }

    public void setValueCount(String value) {
        valueCount.setValue(value);
    }

    
}
