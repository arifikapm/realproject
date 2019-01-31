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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author kuupie
 */
public class ListCarryProjectDao extends ListCell<ListCarryProject>{
        

    @FXML
    private GridPane gridPane;

    @FXML
    private Label textProject;

    @FXML
    private Label valueCount;

    @FXML
    private Label textInisial;

    @FXML
    private Label textPercentage;
    

    private FXMLLoader mLLoader;
    
    public String queryLoadCarryProject = "SELECT pmt.project_idproject, pro.projectcol, mci.civitascol, "
            + "mac.inisial_jenis,mas.inisial_status, \n" +
"                    monthname(pro.startmonth) as startproject,monthname(pro.endmonth) as endproject,\n" +
"                    concat(round((COUNT(pmt.act_dateend)/ COUNT(pmt.master_task_idtask) *100)),\"%\") as percentage\n" +
"                    \n" +
                "FROM\n" +
                "project_has_master_task as pmt\n" +
                "\n" +
                "LEFT join project as pro on pmt.project_idproject = pro.idproject \n" +
                "                    INNER join master_civitas as mci on pro.civitas_idcivitas = mci.idcivitas \n" +
                "                    INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" +
                "                    INNER join master_status as mas on pro.status_idstatus = mas.idstatus\n" ;
    
    public String loadQuery;
    public String select;
    public String where;
    public String groupBy = " GROUP by pmt.project_idproject ";
    
    public void loadCarryProject(int year){
        where = " WHERE\n" +
                "mas.idstatus <4\n" +
                "AND\n" +
                "year(pro.endmonth) < "+year+"" ;
        loadQuery = queryLoadCarryProject+where+groupBy;
    }
    
//    public String queryListDasboard="SELECT mac.civitascol, p.riskfactor, p.auditvalue\n" +
//"FROM project as p, master_civitas as mac\n" +
//"where p.civitas_idcivitas= mac.idcivitas\n" +
//"and p.master_activity_idactivity=1";
    
    @Override
    protected void updateItem(ListCarryProject list, boolean empty) {
        super.updateItem(list, empty);
        
        if(empty || list == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellCarryProject.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
            //textCivitas.setText(list.getCivitascol());
            textProject.setText(list.getProjectCol());

            valueCount.setText(list.getStatusCol());
            
            textInisial.setText(list.getInisialJenis());
            textPercentage.setText(list.getPercentage());

        }
        setText(null);
        setGraphic(list == null ? null : gridPane);
        

    }
    
}
