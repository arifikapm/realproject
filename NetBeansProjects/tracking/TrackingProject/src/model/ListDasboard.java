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
public class ListDasboard {

    private final StringProperty civitascol;
    private final StringProperty riskfactor;
    private final StringProperty auditvalue;
    
    public ListDasboard(String civitasCol,String riskfactor,String auditvalue){
        this.civitascol = new SimpleStringProperty(civitasCol);
        this.riskfactor = new SimpleStringProperty(riskfactor);
        this.auditvalue = new SimpleStringProperty(auditvalue);
        
    }

    public String getCivitascol() {
        return civitascol.get();
    }

    public String getRiskfactor() {
        return riskfactor.get();
    }

    public String getAuditvalue() {
        return auditvalue.get();
    }

    public void setCivitascol(String value) {
        civitascol.setValue(value);
    }

    public void setRiskfactor(String value) {
        riskfactor.setValue(value);
    }

    public void setAuditvalue(String value) {
        auditvalue.setValue(value);
    }
    
    
}
