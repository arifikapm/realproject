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
public class ProfileLine {
    
    private StringProperty Quarter;
    private IntegerProperty CountValue;

    public ProfileLine(String quarter, int countValue) {
        this.Quarter = new SimpleStringProperty(quarter);
        this.CountValue = new SimpleIntegerProperty(countValue);
    }

    public String getQuarter() {
        return Quarter.get();
    }

    public int getCountValue() {
        return CountValue.get();
    }

    public void setQuarter(String value) {
        this.Quarter.set(value);
    }

    public void setCountValue(int value) {
        this.CountValue.set(value);
    }
    
   
    
    
}
