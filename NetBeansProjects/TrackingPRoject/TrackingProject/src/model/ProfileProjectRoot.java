/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class ProfileProjectRoot {
    private final StringProperty RootTask;
    private final DoubleProperty Percentage;

    public ProfileProjectRoot(String rootTask, double percentage) {
        this.RootTask = new SimpleStringProperty(rootTask);
        this.Percentage = new SimpleDoubleProperty(percentage);
    }

    public String getRootTask() {
        return RootTask.get();
    }

    public double getPercentage() {
        return Percentage.get();
    }

    public void setRootTask(String value) {
        this.RootTask.setValue(value);
    }

    public void setPercentage(int value) {
        this.Percentage.setValue(value);
    }
    
}
