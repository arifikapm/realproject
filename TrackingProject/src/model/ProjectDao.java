/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;



/**
 *
 * @author kuupie
 */
public class ProjectDao extends ListCell<Project>{
    
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, ORANGE_BAR, YELLOW_BAR, GREEN_BAR };
    
    @FXML
    private Label titleCivitas;
    @FXML
    private Label titleActivity;
    @FXML
    private Label titleStratMonth;
    @FXML
    private Label titleEndMonth;
    @FXML
    private ProgressBar barProgress;
    @FXML
    private Label titleProsentase;
    @FXML
    private Label lblProgres;

    
    @FXML
    private HBox gridPane;

    private FXMLLoader mLLoader;
    
    public String queryListProject="SELECT pr.idproject, pr.projectcol, monthname(pr.startmonth), "
            + "monthname(pr.endmonth), ci.civitascol, ms.inisialprogres, ma.activitycol, pr.project_percentage, "
            + "pr.create_date, pr.mod_date FROM project as pr, master_civitas as ci, master_activity as ma, "
            + "master_status as ms WHERE pr.civitas_idcivitas= ci.idcivitas and pr.status_idstatus=ms.idstatus "
            + "and pr.master_activity_idactivity=ma.idactivity "
            + "ORDER BY pr.idproject";
    
    @Override
    protected void updateItem(Project project, boolean empty) {
        super.updateItem(project, empty);
        
        if(empty || project == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellPro.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
//            gridPane.getStylesheets().add(getClass().getResource("/view/stylesheet.css").toExternalForm());
             
            String Prosentase=project.getProject_Percentage();
            double Prs = Double.parseDouble(Prosentase);
            double Setnu = Prs*100;
            String valPro = Double.toString(Setnu);
            titleProsentase.setText(valPro);
            barProgress.setProgress(Prs);
            
//            barProgress.progressProperty().addListener(new ChangeListener<Number>(){
//                @Override
//                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                    double Prse = newValue == null ? 0 :newValue.doubleValue();
//                    
//                    if(Prse<0.33){
//                        setStyleBarClass(barProgress, RED_BAR);
//                    }else if(Prse<0.50){
//                        setStyleBarClass(barProgress, ORANGE_BAR);
//                    }else if(Prse<0.80){
//                        setStyleBarClass(barProgress, YELLOW_BAR);
//                    }else{
//                        setStyleBarClass(barProgress, GREEN_BAR);
//                    }
//                }
//                
//                private void setStyleBarClass (ProgressBar barPrs,String barStyleClass){
//                    barPrs.getStyleClass().removeAll(barColorStyleClasses);
//                    barPrs.getStyleClass().add(barStyleClass);
//                }
//                
//            });
            
            titleCivitas.setText(project.getCivitasCol());
            titleActivity.setText(project.getActivityCol());
            titleStratMonth.setText(project.getStartMonth());
            titleEndMonth.setText(project.getEndMonth());
            lblProgres.setText(project.getInisialProgress());
           
            
            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);
        

    }
}
