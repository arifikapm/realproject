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
public class MasKaryawan {
    
    private final StringProperty idKaryawan;
    private final StringProperty karyawanCol;
    private final StringProperty inisial_Karyawan;
    private final StringProperty unitCol;
    private final StringProperty jabatanCol;
    private final StringProperty status_Karyawancol;
    
    public MasKaryawan(String idkaryawan, String karyawancol, String inisial_karyawan, String unitcol, 
            String jabatancol, String status_karyawancol){
        this.idKaryawan=new SimpleStringProperty(idkaryawan);
        this.karyawanCol=new SimpleStringProperty(karyawancol);
        this.inisial_Karyawan=new SimpleStringProperty(inisial_karyawan);
        this.unitCol=new SimpleStringProperty(unitcol);
        this.jabatanCol=new SimpleStringProperty(jabatancol);
        this.status_Karyawancol=new SimpleStringProperty(status_karyawancol);
                       
                
    }

    public String getIdKaryawan() {
        return idKaryawan.get();
    }

    public String getKaryawanCol() {
        return karyawanCol.get();
    }

    public String getInisialKaryawan() {
        return inisial_Karyawan.get();
    }

    public String getUnitCol() {
        return unitCol.get();
    }

    public String getJabatanCol() {
        return jabatanCol.get();
    }

    public String getStatus() {
        return status_Karyawancol.get();
    }

    public void setIdKaryawan(String value) {
        idKaryawan.setValue(value);
    }

    public void setKaryawanCol(String value) {
        karyawanCol.setValue(value);
    }

    public void setInisialKaryawan(String value) {
        inisial_Karyawan.setValue(value);
    }

    public void setUnitCol(String value) {
        unitCol.setValue(value);
    }

    public void setJabatanCol(String value) {
        jabatanCol.setValue(value);
    }

    public void setStatus(String value) {
        status_Karyawancol.setValue(value);
    }

    
}
