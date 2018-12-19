/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kuupie
 */
public class ChartBarProfile {
    
    private final SimpleStringProperty ValueId;
    private final SimpleStringProperty ValueCol;
    private final SimpleStringProperty ValueName;
    private final SimpleIntegerProperty ValueCount;
    
    public ChartBarProfile(String valueId, String valueCol, String valueName, int valueCount ){
        this.ValueId = new SimpleStringProperty(valueId);
        this.ValueCol = new SimpleStringProperty(valueCol);
        this.ValueName = new SimpleStringProperty(valueName);
        this.ValueCount = new SimpleIntegerProperty(valueCount);
    }

    public String getValueId() {
        return ValueId.get();
    }
    
    public String getValueCol() {
        return ValueCol.get();
    }

    public String getValueName() {
        return ValueName.get();
    }

    public int getValueCount() {
        return ValueCount.get();
    }

    public void setValueId(String v) {
        this.ValueId.setValue(v);
    }
    
    public void setValueCol(String v) {
        this.ValueCol.setValue(v);
    }

    public void setValueName(String v) {
        this.ValueName.setValue(v);
    }

    public void setValueCount(int v) {
        this.ValueCount.setValue(v);
    }
    
}
