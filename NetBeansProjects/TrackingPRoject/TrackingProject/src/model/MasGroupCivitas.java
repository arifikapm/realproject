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
public class MasGroupCivitas {
    
    private final IntegerProperty idGroupCivitas;
    private final StringProperty groupcivitasCol;
    
    public MasGroupCivitas(int idGroupcivitas, String groupCivitascol){
        this.idGroupCivitas = new SimpleIntegerProperty(idGroupcivitas);
        this.groupcivitasCol = new SimpleStringProperty(groupCivitascol);
    }

    public int getIdCivitas() {
        return idGroupCivitas.get();
    }

    public String getGroupCivitasCol() {
        return groupcivitasCol.get();
    }

    public void setIdCivitas(Integer value) {
        this.idGroupCivitas.setValue(value);
    }

    public void setCivitasCol(String value) {
        this.groupcivitasCol.setValue(value);
    }
    
}
