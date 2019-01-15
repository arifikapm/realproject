/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

/**
 *
 * @author kuupie
 */
public class ProfileProjectRootDao extends ListCell<ProfileProjectRoot>{
    
    @FXML
    private GridPane gridPane;

    @FXML
    private Label labelRoot;

    @FXML
    private ProgressBar barRoot;

    @FXML
    private Label valueRoot;

    @FXML
    private Label txtTglStart2;
    
    private FXMLLoader mLLoader;
    private double percent;
    
    public String select="SELECT rte.rootprocesscol, \n" +
            "(COUNT(pr.act_dateend)/COUNT(pr.master_task_idtask)) as percent FROM project_has_master_task as pr, "
            + "master_task as mt, \n" +
            "roottask as rte ";
    public String where;
    public String and=" and pr.master_task_idtask = mt.idtask \n" +
            " and mt.roottask_idroottask = rte.idroottask ";
    public String groupBy=" GROUP by mt.roottask_idroottask";
    public String loadProfile;
    
    
    public void loadProfileRoot(String idProject){
        where=" WHERE pr.project_idproject =  "+idProject+" ";
        loadProfile=select+where+and+groupBy;
    }
   
    
    @Override
    protected void updateItem(ProfileProjectRoot project, boolean empty) {
        super.updateItem(project, empty);
        
        if(empty || project == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellProjectProfile.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            double Prs = project.getPercentage();
            double Setnu = Prs*100;
            String valPro = Double.toString(Setnu);
            labelRoot.setText(project.getRootTask());
            valueRoot.setText(valPro);
            barRoot.setProgress(project.getPercentage());

            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);

    }
    
   
    
}
