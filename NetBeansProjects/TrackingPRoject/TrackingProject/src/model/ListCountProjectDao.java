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

/**
 *
 * @author kuupie
 */
public class ListCountProjectDao extends ListCell<ListCountProject>{
        
  
    @FXML
    private GridPane gridPane;

    @FXML
    private Label valueCount;

    @FXML
    private Label textCivitas;
    

    private FXMLLoader mLLoader;
    
    public String queryLoad;
    public String selectQuery =  "SELECT mac.activitycol, count(pro.idproject) as countProject\n" +
            "FROM project as pro\n" +
            "INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" ;
    public String where;
    public String groupBy = " GROUP by mac.idactivity ";
    
    
    public String queryLoadCountProject = "SELECT mac.activitycol, count(pro.idproject) as countProject\n" +
            "FROM project as pro\n" +
            "INNER join master_activity as mac on pro.master_activity_idactivity = mac.idactivity\n" +
            "GROUP by mac.idactivity";
    
//    public String queryListDasboard="SELECT mac.civitascol, p.riskfactor, p.auditvalue\n" +
//"FROM project as p, master_civitas as mac\n" +
//"where p.civitas_idcivitas= mac.idcivitas\n" +
//"and p.master_activity_idactivity=1";
    
    @Override
    protected void updateItem(ListCountProject list, boolean empty) {
        super.updateItem(list, empty);
        
        if(empty || list == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellCountProject.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
            textCivitas.setText(list.getCivitascol());
            valueCount.setText(list.getValueCount());
    
        }
        setText(null);
        setGraphic(list == null ? null : gridPane);
        

    }

    public void loadCountbyYear(int year) {
        where =" where YEAR(pro.startmonth) = "+year+"";
        queryLoad = selectQuery+where+groupBy;
    }
    
}
