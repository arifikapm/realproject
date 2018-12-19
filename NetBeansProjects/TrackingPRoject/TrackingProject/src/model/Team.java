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
public class Team {
    
    private final StringProperty teamMember;
    private final StringProperty asA;
    
    public Team(String teammember, String asa){
        this.teamMember=new SimpleStringProperty(teammember);
        this.asA=new SimpleStringProperty(asa);
    }

    public String getTeamMember() {
        return teamMember.get();
    }

    public String getAsA() {
        return asA.get();
    }

    public void setTeamMember(String value) {
        teamMember.setValue(value);
    }

    public void setAsA(String value) {
        asA.setValue(value);
    }
    
}
