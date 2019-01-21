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
public class MasRiskFactor {
    	
private final IntegerProperty Idrisk_Value;
private final StringProperty Risk_Valuecol;

    public MasRiskFactor(int idrisk_value, String risk_valuecol) {
        this.Idrisk_Value = new SimpleIntegerProperty(idrisk_value);
        this.Risk_Valuecol = new SimpleStringProperty(risk_valuecol);

    }

    public int getIdrisk_Value() {
        return Idrisk_Value.get();
    }

    public String getRisk_Valuecol() {
        return Risk_Valuecol.get();
    }

    public void setIdrisk_Value(int value) {
        this.Idrisk_Value.set(value);
    }

    public void setRisk_Valuecol(String value) {
        this.Risk_Valuecol.set(value);
    }
    
}
