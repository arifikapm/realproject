/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kuupie
 */
public class Project {

    private final StringProperty IdProject;
    private final IntegerProperty Line ;
    private final StringProperty CivitasCol;
    private final StringProperty ActivityCol;
    private final StringProperty ValueRisk;
    private final StringProperty Audit_GradingCol;
    private final StringProperty StatusCol;
    private final StringProperty Inisial_Status;
    private final StringProperty FullStartMonth;
    private final StringProperty FullEndMonth;
    private final StringProperty Act_Month_Start;
    private final StringProperty Act_Month_End;
    private final DoubleProperty Percentage;
    private final StringProperty NameStartMonth;
    private final StringProperty NameEndMonth;
    private final IntegerProperty DateStart;
    private final IntegerProperty MonthStart;
    private final IntegerProperty YearStart;
    private final IntegerProperty DateEnd;
    private final IntegerProperty MonthEnd;
    private final IntegerProperty YearEnd;
    private final IntegerProperty DateActStart;
    private final IntegerProperty MonthActStart;
    private final IntegerProperty YearActStart;
    private final IntegerProperty DateActEnd;
    private final IntegerProperty MonthActEnd;
    private final IntegerProperty YearActEnd;
    private final StringProperty InisialActivity;
    private final StringProperty ShowPercent;
    private final StringProperty IndexAudit;
    
    
    public Project(String idproject, int line, String civitascol, String activitycol,
            String valuerisk, String audit_gradingcol, String statuscol, String INISIAL_STATUS, 
            String fullStartMonth ,String fullEndMonth, String act_month_start, String act_month_end,
            double percentage, String namestarMonth, String nameendMonth, int dateStart, int monthStart,
            int yearStart, int dateEnd, int monthEnd, int yearEnd, int dateActStart, int monthActStart, 
            int yearActStart, int dateActEnd, int monthActEnd, int yearActEnd, String inisialActivity,
            String showPercent, String indexAudit){
       
        this.IdProject = new SimpleStringProperty(idproject);
        this.Line = new SimpleIntegerProperty(line);
        this.CivitasCol = new SimpleStringProperty(civitascol);
        this.ActivityCol = new SimpleStringProperty(activitycol);
        this.ValueRisk = new SimpleStringProperty(valuerisk);
        this.Audit_GradingCol = new SimpleStringProperty(audit_gradingcol);
        this.StatusCol = new SimpleStringProperty(statuscol);
        this.Inisial_Status = new SimpleStringProperty(INISIAL_STATUS);
        this.FullStartMonth = new SimpleStringProperty(fullStartMonth);
        this.FullEndMonth = new SimpleStringProperty(fullEndMonth);
        this.Act_Month_Start = new SimpleStringProperty(act_month_start);
        this.Act_Month_End = new SimpleStringProperty(act_month_end);
        this.Percentage = new SimpleDoubleProperty(percentage);
        this.NameStartMonth = new SimpleStringProperty(namestarMonth);
        this.NameEndMonth = new SimpleStringProperty(nameendMonth);
        this.DateStart = new SimpleIntegerProperty(dateStart);
        this.MonthStart = new SimpleIntegerProperty(monthStart);
        this.YearStart = new SimpleIntegerProperty(yearStart);
        this.DateEnd = new SimpleIntegerProperty(dateEnd);
        this.MonthEnd = new SimpleIntegerProperty(monthEnd);
        this.YearEnd = new SimpleIntegerProperty(yearEnd);
        this.DateActStart =new SimpleIntegerProperty(dateActStart);
        this.MonthActStart = new SimpleIntegerProperty(monthActStart);
        this.YearActStart = new SimpleIntegerProperty(yearActStart);
        this.DateActEnd = new SimpleIntegerProperty(dateActEnd);
        this.MonthActEnd = new SimpleIntegerProperty(monthActEnd);
        this.YearActEnd = new SimpleIntegerProperty(yearActEnd);
        this.InisialActivity = new SimpleStringProperty(inisialActivity);
        this.ShowPercent = new SimpleStringProperty(showPercent);
        this.IndexAudit = new SimpleStringProperty(indexAudit);
    }

    public String getIdProject() {
        return IdProject.get();
    }

    public int getLine() {
        return Line.get();
    }

    public String getCivitasCol() {
        return CivitasCol.get();
    }

    public String getActivityCol() {
        return ActivityCol.get();
    }

    public String getValueRisk() {
        return ValueRisk.get();
    }

    public String getAuditGradingCol() {
        return Audit_GradingCol.get();
    }

    public String getStatusCol() {
        return StatusCol.get();
    }

    public String getInisialStatus() {
        return Inisial_Status.get();
    }

    public String getFullStartMonth() {
        return FullStartMonth.get();
    }

    public String getFullEndMonth() {
        return FullEndMonth.get();
    }

    public String getActMonthStart() {
        return Act_Month_Start.get();
    }

    public String getActMonthEnd() {
        return Act_Month_End.get();
    }

    public double getPercentage() {
        return Percentage.get();
    }

    public String getNameStartMonth() {
        return NameStartMonth.get();
    }

    public String getNameEndMonth() {
        return NameEndMonth.get();
    }

    public int getDateStart() {
        return DateStart.get();
    }

    public int getMonthStart() {
        return MonthStart.get();
    }

    public int getYearStart() {
        return YearStart.get();
    }

    public int getDateEnd() {
        return DateEnd.get();
    }

    public int getMonthEnd() {
        return MonthEnd.get();
    }

    public int getYearEnd() {
        return YearEnd.get();
    }

    public int getDateActStart() {
        return DateActStart.get();
    }

    public int getMonthActStart() {
        return MonthActStart.get();
    }

    public int getYearActStart() {
        return YearActStart.get();
    }

    public int getDateActEnd() {
        return DateActEnd.get();
    }

    public int getMonthActEnd() {
        return MonthActEnd.get();
    }

    public int getYearActEnd() {
        return YearActEnd.get();
    }

    public String getInisialActivity() {
        return InisialActivity.get();
    }

    public String getShowPercent() {
        return ShowPercent.get();
    }

    public String getIndexAudit() {
        return IndexAudit.get();
    }

    public void setInisialActivity(String value) {
        this.InisialActivity.setValue(value);
    }

    public void setShowPercent(String value) {
        this.ShowPercent.setValue(value);
    }

    public void setIndexAudit(String value) {
        this.IndexAudit.setValue(value);
    }
    
    public void setIdProject(String value) {
        IdProject.setValue(value);
    }

    public void setLine(int value) {
        Line.setValue(value);
    }

    public void setCivitasCol(String value) {
        CivitasCol.setValue(value);
    }

    public void setActivityCol(String value) {
        ActivityCol.setValue(value);
    }

    public void setValueRisk(String value) {
        ValueRisk.setValue(value);
    }

    public void setAuditGradingCol(String value) {
        Audit_GradingCol.setValue(value);
    }

    public void setStatusCol(String value) {
        StatusCol.setValue(value);
    }

    public void setInisialStatus(String value) {
        Inisial_Status.setValue(value);
    }

    public void setFullStartMonth(String value) {
        FullStartMonth.setValue(value);
    }

    public void setFullEndMonth(String value) {
        FullEndMonth.setValue(value);
    }

    public void setActMonthStart(String value) {
        Act_Month_Start.setValue(value);
    }

    public void setActMonthEnd(String value) {
        Act_Month_End.setValue(value);
    }

    public void setPercentage(double value) {
        Percentage.setValue(value);
    }

    public void setNameStartMonth(String value) {
        NameStartMonth.setValue(value);
    }

    public void setNameEndMonth(String value) {
        NameEndMonth.setValue(value);
    }

    public void setDateStart(int value) {
        DateStart.setValue(value);
    }

    public void setMonthStart(int value) {
        MonthStart.setValue(value);
    }

    public void setYearStart(int value) {
        YearStart.setValue(value);
    }

    public void setDateEnd(int value) {
        DateEnd.setValue(value);
    }

    public void setMonthEnd(int value) {
        MonthEnd.setValue(value);
    }

    public void setYearEnd(int value) {
        YearEnd.setValue(value);
    }

    public void setDateActStart(int value) {
        DateActStart.setValue(value);
    }

    public void setMonthActStart(int value) {
        MonthActStart.setValue(value);
    }

    public void setYearActStart(int value) {
        YearActStart.setValue(value);
    }

    public void setDateActEnd(int value) {
        DateActEnd.setValue(value);
    }

    public void setMonthActEnd(int value) {
        MonthActEnd.setValue(value);
    }

    public void setYearActEnd(int value) {
        YearActEnd.setValue(value);
    }


    
    
}
