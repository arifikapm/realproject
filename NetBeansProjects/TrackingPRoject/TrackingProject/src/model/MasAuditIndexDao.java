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
public class MasAuditIndexDao extends ListCell<MasAuditIndex>{

    @FXML
    private GridPane gridPane;

    @FXML
    private Label textActivity;
    
    private FXMLLoader mLLoader;
    
    public String selectall= "SELECT `idaudit_grading`, `audit_gradingcol`, `color_index` \n" +
            "FROM `audit_grading` \n" +
            "WHERE 1";
//    public String select= "SELECT `idstatus`, `statuscol`, `inisial_status` "
//            + " ";
//    public String from = " FROM `master_status` ";
//    public String join;
//    public String where;
//    public String groupBy;
//    public String queryLoad;
//    
//    public void statusLoad(String IdStatus){
//        where = "WHERE idstatus = "+IdStatus+" ";
//        queryLoad = select+from+where;
//    }
    
    
    @Override
    protected void updateItem(MasAuditIndex team, boolean empty) {
        super.updateItem(team, empty);
        
        if(empty || team == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellActivity.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            textActivity.setText(team.getAudit_Gradingcol());
            
            
        }
        setText(null);
        setGraphic(team == null ? null : gridPane);

    }
    
    
}
