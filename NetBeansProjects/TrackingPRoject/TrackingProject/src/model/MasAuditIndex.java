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
public class MasAuditIndex {
    

    private final IntegerProperty Idaudit_Grading;
    private final SimpleStringProperty Audit_Gradingcol;
    private final SimpleStringProperty Color_Index;
    
    public MasAuditIndex(int idaudit_Grading, String audit_Gradingcol, String color_Index){
        this.Idaudit_Grading = new SimpleIntegerProperty(idaudit_Grading);
        this.Audit_Gradingcol = new SimpleStringProperty(audit_Gradingcol);
        this.Color_Index = new SimpleStringProperty(color_Index);
    }

    public int getIdaudit_Grading() {
        return Idaudit_Grading.get();
    }

    public String getAudit_Gradingcol() {
        return Audit_Gradingcol.get();
    }

    public String getColor_Index() {
        return Color_Index.get();
    }

    public void setIdaudit_Grading(int value) {
        Idaudit_Grading.setValue(value);
    }

    public void setAudit_Gradingcol(String value) {
        Audit_Gradingcol.setValue(value);
    }

    public void setColor_Index(String value) {
        Color_Index.setValue(value);
    }
    
}
