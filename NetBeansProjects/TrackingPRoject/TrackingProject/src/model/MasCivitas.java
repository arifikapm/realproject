/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class MasCivitas {
    
    private final IntegerProperty idCivitas;
    private final StringProperty civitasCol;
    private final StringProperty inisialCol;
    private final StringProperty lokasiCol;
    private final StringProperty alamatCol;
    private final StringProperty groupCivitas;
    private final StringProperty controllerCol;
    private final StringProperty emailCol;
    private final StringProperty nohp_controller;
    private final StringProperty risk_champion;
    private final StringProperty email_risk_champion;
    private final StringProperty dicCol;
    private final StringProperty nohp_riskchampion;
    private final StringProperty email_dic;
    private final StringProperty eic;
    private final StringProperty email_eic;
    
    public MasCivitas(int idcivitas, String civitascol, String inisialcol,String lokasicol, String alamatcol, String groupcivitas,
            String controllercol, String emailcol, String nohpController, String riskChampion, String emailRisk, String noHpRisk, String diccol,
            String emailDIc,String eicCol, String emailEic){
        this.idCivitas = new SimpleIntegerProperty(idcivitas);
        this.civitasCol = new SimpleStringProperty(civitascol);
        this.inisialCol = new SimpleStringProperty(inisialcol);
        this.lokasiCol = new SimpleStringProperty(lokasicol);
        this.alamatCol = new SimpleStringProperty(alamatcol);
        this.groupCivitas = new SimpleStringProperty(groupcivitas);
        this.controllerCol = new SimpleStringProperty(controllercol);
        this.emailCol = new SimpleStringProperty(emailcol);
        this.nohp_controller = new SimpleStringProperty(nohpController);
        this.risk_champion = new SimpleStringProperty(riskChampion);
        this.email_risk_champion = new SimpleStringProperty(emailRisk);
        this.nohp_riskchampion = new SimpleStringProperty(noHpRisk);
        this.dicCol = new SimpleStringProperty(diccol);
        this.email_dic = new SimpleStringProperty(emailDIc);
        this.eic = new SimpleStringProperty(eicCol);
        this.email_eic = new SimpleStringProperty(emailEic);
        
    }

    public int getIdCivitas() {
        return idCivitas.get();
    }

    public String getCivitasCol() {
        return civitasCol.get();
    }

    public String getInisialCol() {
        return inisialCol.get();
    }

    public String getLokasiCol() {
        return lokasiCol.get();
    }

    public String getAlamatCol() {
        return alamatCol.get();
    }

    public String getGroupCivitas() {
        return groupCivitas.get();
    }

    public String getControllerCol() {
        return controllerCol.get();
    }

    public String getEmailCol() {
        return emailCol.get();
    }

    public String getNohp_controller() {
        return nohp_controller.get();
    }

    public String getRisk_champion() {
        return risk_champion.get();
    }

    public String getEmail_risk_champion() {
        return email_risk_champion.get();
    }

    public String getDicCol() {
        return dicCol.get();
    }

    public String getNohp_riskchampion() {
        return nohp_riskchampion.get();
    }

    public String getEmail_dic() {
        return email_dic.get();
    }

    public String getEic() {
        return eic.get();
    }

    public String getEmail_eic() {
        return email_eic.get();
    }
    
    public void setIdCivitas(Integer value) {
        this.idCivitas.setValue(value);
    }

    public void setCivitasCol(String value) {
        this.civitasCol.setValue(value);
    }

    public void setInisialCol(String value) {
        this.inisialCol.setValue(value);
    }

    public void setLokasiCol(String value) {
        this.lokasiCol.setValue(value);
    }

    public void setAlamatCol(String value) {
        this.alamatCol.setValue(value);
    }

    public void setGroupCivitas(String value) {
        this.groupCivitas.setValue(value);
    }

    public void setControllerCol(String value) {
        this.controllerCol.setValue(value);
    }

    public void setEmailCol(String value) {
        this.emailCol.setValue(value);
    }

    public void setNohp_controller(String value) {
        this.nohp_controller.setValue(value);
    }

    public void setRisk_champion(String value) {
        this.risk_champion.setValue(value);
    }

    public void setEmail_risk_champion(String value) {
        this.email_risk_champion.setValue(value);
    }

    public void setDicCol(String value) {
        this.dicCol.setValue(value);
    }

    public void setNohp_riskchampion(String value) {
        this.nohp_riskchampion.setValue(value);
    }

    public void setEmail_dic(String value) {
        this.email_dic.setValue(value);
    }

    public void setEic(String value) {
        this.eic.setValue(value);
    }

    public void setEmail_eic(String value) {
        this.email_eic.setValue(value);
    }

   
}
