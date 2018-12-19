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

    private final StringProperty civitascol;
    private final StringProperty valueCount;
    
    public ListCountProject(String civitasCol,String countProject){
        this.civitascol = new SimpleStringProperty(civitasCol);
        this.valueCount = new SimpleStringProperty(countProject);
        
        
    }

    public String getCivitascol() {
        return civitascol.get();
    }

    public String getValueCount() {
        return valueCount.get();
    }


    public void setCivitascol(String value) {
        civitascol.setValue(value);
    }

    public void setValueCount(String value) {
        valueCount.setValue(value);
    }

    
}
