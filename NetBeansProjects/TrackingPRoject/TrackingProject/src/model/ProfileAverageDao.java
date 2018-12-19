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
public class ProfileAverageDao extends ListCell<ProfileOverdue>{
        
  
    @FXML
    private GridPane gridPane;

    @FXML
    private Label valueCount;
    

    private FXMLLoader mLLoader;
    
    public String queryLoadOverdue = "SELECT MAC.activitycol, \n" +
                    "round((SUM(TOTAL_WEEKDAYS(pro.act_month_end, pro.endmonth))/ COUNT(pro.act_month_end)),1) as overdue,\n" +
                    "round((SUM(TOTAL_WEEKDAYS(pro.act_month_end, pro.act_month_start))/ COUNT(pro.act_month_end)),1) as averageProject\n" +
                    "from project as pro\n" +
                    "INNER JOIN master_activity AS MAC ON pro.master_activity_idactivity = MAC.idactivity\n" +
                    "GROUP BY MAC.idactivity";
    
//    public String queryListDasboard="SELECT mac.civitascol, p.riskfactor, p.auditvalue\n" +
//"FROM project as p, master_civitas as mac\n" +
//"where p.civitas_idcivitas= mac.idcivitas\n" +
//"and p.master_activity_idactivity=1";
    
    @Override
    protected void updateItem(ProfileOverdue list, boolean empty) {
        super.updateItem(list, empty);
        
        if(empty || list == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellProfileAverage.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            String value = String.valueOf(list.getAverageProject());

            valueCount.setText(value);
    
        }
        setText(null);
        setGraphic(list == null ? null : gridPane);
        

    }
    
}
