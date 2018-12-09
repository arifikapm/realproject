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
public class Civitas {
    
    private final IntegerProperty idCivitas;
    private final StringProperty civitasCol;
    
    public Civitas(int idcivitas, String civitascol){
        this.idCivitas = new SimpleIntegerProperty(idcivitas);
        this.civitasCol = new SimpleStringProperty(civitascol);
    }

    public int getIdCivitas() {
        return idCivitas.get();
    }

    public String getCivitasCol() {
        return civitasCol.get();
    }

    public void setIdCivitas(Integer value) {
        this.idCivitas.setValue(value);
    }

    public void setCivitasCol(String value) {
        this.civitasCol.setValue(value);
    }
    
}
