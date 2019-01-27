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
    
    public String insertInto;
    public String queryteam;
    public String select="SELECT mk.karyawancol as teammember, res.responsibilitycol as asa, "
            + "res.inisial_responsibility as inAs "
            + "FROM project as pr LEFT JOIN project_has_master_karyawan as pmk on pr.idproject=pmk.project_idproject "
            + "LEFT join master_karyawan as mk on pmk.master_karyawan_idkaryawan=mk.idkaryawan "
            + "LEFT JOIN responsibility as res on pmk.responsibility_idresponsibility=res.idresponsibility ";
    public String where;
    public String and;
    public String onDelete;
    
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
            titleAs.setText(team.getInAsa());
            
            
        }
        setText(null);
        setGraphic(team == null ? null : gridPane);

    }
    
    public void teamLoad(String IdProject){
        where=" where pr.idproject="+IdProject+"  ";
        queryteam=select+where;
        
    }

    public void setQueryProjectHasTeam(String idProject, String idKaryawan, String idAsa) {
        insertInto = "INSERT INTO `project_has_master_karyawan` \n" +
                "(`project_idproject`, `master_karyawan_idkaryawan`, \n" +
                "`responsibility_idresponsibility`) \n" +
                "VALUES ('"+idProject+"', '"+idKaryawan+"', '"+idAsa+"') ";
        System.out.println(insertInto);
        System.out.println("VALUES ('"+idProject+"', '"+idKaryawan+"', "+idAsa+");");    
    }

    public void setOnDeleteProjectHasTeam(String idProject, String idKaryawan) {
        onDelete="DELETE FROM `project_has_master_karyawan` \n" +
                "WHERE `project_has_master_karyawan`.`project_idproject` = "+idProject+" \n" +
                "AND `project_has_master_karyawan`.`master_karyawan_idkaryawan` = "+idKaryawan+"";
        System.out.println(onDelete);
        System.out.println("`project_idproject` ="+idProject +"\n  idKaryawan = "+idKaryawan );
    }
    
    
    
}
