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
public class MasKaryawanDao extends ListCell<MasKaryawan> {
    
    @FXML
    private HBox gridPane;
    @FXML
    private Label titleKaryawan;

    private FXMLLoader mLLoader;
    
    public String queryteam;
    public String insertInto;
    
    public String selectAll="SELECT mk.idkaryawan, mk.karyawancol, mk.inisial_karyawan, dp.unitcol,"
            + "jb.jabatancol, st.status_karyawancol FROM master_karyawan as mk left join departemen as dp\n" +
            "on mk.departemen_iddepartemen=dp.iddepartemen\n" +
            "left join jabatan as jb\n" +
            "on mk.jabatan_idjabatan=jb.idjabatan\n" +
            "LEFT join status_karyawan as st\n" +
            "on mk.status_karyawan_idstatus_karyawan=st.idstatus_karyawan\n" +
            "ORDER by jb.idjabatan";
    
    public String selectActive="SELECT mk.idkaryawan, mk.karyawancol, mk.inisial_karyawan, dp.unitcol,"
            + "jb.jabatancol, st.status_karyawancol FROM master_karyawan as mk left join departemen as dp\n" +
            "on mk.departemen_iddepartemen=dp.iddepartemen\n" +
            "left join jabatan as jb\n" +
            "on mk.jabatan_idjabatan=jb.idjabatan\n" +
            "LEFT join status_karyawan as st\n" +
            "on mk.status_karyawan_idstatus_karyawan=st.idstatus_karyawan\n"
            + " where mk.status_karyawan_idstatus_karyawan=1 " +
            "ORDER by jb.idjabatan";
    
    public String selectTerm="SELECT mk.idkaryawan, mk.karyawancol as teammember, mk.inisial_karyawan, \n" +
            "res.responsibilitycol as asa, \n" +
            "res.inisial_responsibility as inAs, res.inisial_responsibility as inAs \n" +
            "FROM project as pr LEFT JOIN project_has_master_karyawan as pmk on pr.idproject=pmk.project_idproject \n" +
            "LEFT join master_karyawan as mk on pmk.master_karyawan_idkaryawan=mk.idkaryawan \n" +
            "            LEFT JOIN responsibility as res on pmk.responsibility_idresponsibility=res.idresponsibility \n" ;
    
    public String where;
    
    public String and;
    
    //public String queryKaryawan="SELECT idkaryawan, karyawancol FROM master_karyawan";
    
     @Override
    protected void updateItem(MasKaryawan karyawan, boolean empty) {
        super.updateItem(karyawan, empty);
        
        if(empty || karyawan == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellKaryawan.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            titleKaryawan.setText(karyawan.getKaryawanCol());
            
        }
        setText(null);
        setGraphic(karyawan == null ? null : gridPane);

    }
    
    public void teamLoad(String IdProject){
        where=" where pr.idproject="+IdProject+"  ";
        queryteam=selectAll+where;
        
    }
    
    public void loadTeamProject(String IdProject){
        where = "            where pr.idproject =  "+IdProject+"";
        queryteam= selectTerm+where;
    }
    
    public void setQueryProjectHasTeamSave(String IdProject, String string){
        System.out.println("ini di setQuery = "+string);
        insertInto = "INSERT INTO `project_has_master_karyawan` \n" +
                "(`project_idproject`, `master_karyawan_idkaryawan`, \n" +
                "`responsibility_idresponsibility`) \n" +
                "VALUES ('"+IdProject+"', '"+string+"', NULL);";
        System.out.println(insertInto);
    }
    
    public void setQueryProjectHasTeamMod(){
        
    }
}
