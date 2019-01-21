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
public class MasScope {
    
    private final StringProperty idProject;
    private final StringProperty idScope;
    private final StringProperty scopeCol;
    
    public MasScope(String idproject, String idscope, String scopecol) {
        this.idProject = new SimpleStringProperty(idproject);
        this.idScope = new SimpleStringProperty(idscope);
        this.scopeCol = new SimpleStringProperty(scopecol);
    }

    public String getIdProject() {
        return idProject.get();
    }
    
    public String getIdScope() {
        return idScope.get();
    }

    public String getScopeCol() {
        return scopeCol.get();
    }

    public void setIdProject(String value) {
        idProject.setValue(value);
    }
    
    public void setIdScope(String value) {
        idScope.setValue(value);
    }

    public void setScopeCol(String value) {
        scopeCol.setValue(value);
    }
    
}
