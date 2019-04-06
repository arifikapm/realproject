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
public class DetailPro {
    private final StringProperty idactivity;
    private final StringProperty activitycol;
    private final StringProperty startmonth;
    private final StringProperty endmonth;
    private final StringProperty jenis;
    private final StringProperty civitas;
    private final StringProperty status;
    
    public DetailPro(String idactivity, String activitycol, String startmonth, String endmonth, String jenis, String civitas, String status){
        this.idactivity = new SimpleStringProperty(idactivity);
        this.activitycol = new SimpleStringProperty(activitycol);
        this.startmonth = new SimpleStringProperty(startmonth);
        this.endmonth = new SimpleStringProperty(endmonth);
        this.jenis = new SimpleStringProperty(jenis);
        this.civitas = new SimpleStringProperty(civitas);
        this.status = new SimpleStringProperty(status);
        
    }

    public String getId() {
        return idactivity.get();
    }

    public String getActivity() {
        return activitycol.get();
    }

    public String getStartmonth() {
        return startmonth.get();
    }

    public String getEndmonth() {
        return endmonth.get();
    }

    public String getJenis() {
        return jenis.get();
    }

    public String getCivitas() {
        return civitas.get();
    }

    public String getStatus() {
        return status.get();
    }

    public void setId(String value) {
        idactivity.setValue(value);
    }

    public void setActivity(String value) {
        activitycol.setValue(value);
    }
    
    public void setStartMonth(String value) {
        startmonth.setValue(value);
    }
    
    public void setEndMonth(String value) {
        endmonth.setValue(value);
    }
    
    public void setJenis(String value) {
        jenis.setValue(value);
    }
    
    public void setCivitas(String value) {
        civitas.setValue(value);
    }
  
    public void setStatus(String value) {
        status.setValue(value);
    }
    
}
