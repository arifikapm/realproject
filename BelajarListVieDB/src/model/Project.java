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
public class Project {
    private final StringProperty IdActivity;
    private final StringProperty CivitasCol;
    private final StringProperty StartMonth;
    private final StringProperty EndMonth;
    private int prosentase;
    
    
    public Project(String idActivity, String civitas, String startMonth, String endMonth){
        this.IdActivity = new SimpleStringProperty(idActivity);
        this.CivitasCol = new SimpleStringProperty(civitas);
        this.StartMonth = new SimpleStringProperty(startMonth);
        this.EndMonth = new SimpleStringProperty(endMonth);
    }

    public String getCivitas() {
        return CivitasCol.get();
    }

    public String getStartmonth() {
        return StartMonth.get();
    }

    public String getEndmonth() {
        return EndMonth.get();
    }

    public int getProsentase() {
        return prosentase;
    }

    public void setCivitas(String civitas) {
        CivitasCol.setValue(civitas);
    }

    public void setStartmonth(String startmonth) {
        StartMonth.setValue(startmonth);
    }

    public void setEndmonth(String endmonth) {
        EndMonth.setValue(endmonth);
    }

    public void setProsentase(int prosentase) {
        this.prosentase = prosentase;
    }

    public String getIdActivity() {
        return IdActivity.get();
    }

    public void setIdActivity(String idActivity) {
        IdActivity.setValue(idActivity);
    }
    
    
}
