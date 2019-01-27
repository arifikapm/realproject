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
public class MasResponsibility {
    private IntegerProperty IdResponsibility;
    private StringProperty FinalResponsibilitycol;
    private StringProperty Inisial_Responsibility;
    
    public MasResponsibility(int idResponsibility, 
            String finalResponsibilitycol, String inisial_Responsibility) {
        this.IdResponsibility = new SimpleIntegerProperty(idResponsibility);
        this.FinalResponsibilitycol = new SimpleStringProperty(finalResponsibilitycol);
        this.Inisial_Responsibility = new SimpleStringProperty(inisial_Responsibility);
    }

    public Integer getIdResponsibility() {
        return IdResponsibility.get();
    }

    public String getFinalResponsibilitycol() {
        return FinalResponsibilitycol.get();
    }

    public String getInisial_Responsibility() {
        return Inisial_Responsibility.get();
    }

    public void setIdResponsibility(Integer value) {
        this.IdResponsibility.set(value);
    }

    public void setFinalResponsibilitycol(String velue) {
        this.FinalResponsibilitycol.set(velue);
    }

    public void setInisial_Responsibility(String value) {
        this.Inisial_Responsibility.set(value);
    }

    
}
