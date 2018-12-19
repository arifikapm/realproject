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
public class Count {
    
    private final SimpleStringProperty CountAllProject;
    
    public Count(String countProject){
        this.CountAllProject = new SimpleStringProperty(countProject);
        
    }

    public String getCountAllProject() {
        return CountAllProject.get();
    }

    public void setCountAllProject(String value) {
        this.CountAllProject.setValue(value);
    }
    
}
