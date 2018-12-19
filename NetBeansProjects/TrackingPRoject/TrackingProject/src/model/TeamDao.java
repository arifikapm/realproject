/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
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
public class TeamDao extends ListCell<Team> {
    
    @FXML
    private HBox gridPane;
    @FXML
    private Label titleTeam;
    @FXML
    private Label titleAs;

    private FXMLLoader mLLoader;
    
    public String queryteam;
    public String select="SELECT mk.karyawancol as teammember, res.responsibilitycol as asa "
            + "FROM project as pr LEFT JOIN project_has_master_karyawan as pmk on pr.idproject=pmk.project_idproject "
            + "LEFT join master_karyawan as mk on pmk.master_karyawan_idkaryawan=mk.idkaryawan "
            + "LEFT JOIN responsibility as res on pmk.responsibility_idresponsibility=res.idresponsibility ";
    public String where;
    public String and;
    
     @Override
    protected void updateItem(Team team, boolean empty) {
        super.updateItem(team, empty);
        
        if(empty || team == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellTeam.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            titleTeam.setText(team.getTeamMember());
            titleAs.setText(team.getAsA());
            
            
        }
        setText(null);
        setGraphic(team == null ? null : gridPane);

    }
    
    public void teamLoad(String IdProject){
        where=" where pr.idproject="+IdProject+"  ";
        queryteam=select+where;
        
    }
    
}
