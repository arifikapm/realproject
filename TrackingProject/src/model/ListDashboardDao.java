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
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;

/**
 *
 * @author kuupie
 */
public class ListDashboardDao extends ListCell<ListDasboard>{
        
    @FXML
    private HBox gridPane;
    @FXML
    private HBox labelCivitas;
    @FXML
    private HBox labelRiskFactor;
    @FXML
    private HBox labelAuditVa;
    @FXML
    private Label textCivitas;
    
    String riskFtor,AuditV;

    private FXMLLoader mLLoader;
    
    public String queryListDasboard="SELECT mac.civitascol, p.riskfactor, p.auditvalue\n" +
"FROM project as p, master_civitas as mac\n" +
"where p.civitas_idcivitas= mac.idcivitas\n" +
"and p.master_activity_idactivity=1";
    
    @Override
    protected void updateItem(ListDasboard list, boolean empty) {
        super.updateItem(list, empty);
        
        if(empty || list == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellDashboard.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
            textCivitas.setText(list.getCivitascol());
            riskFtor = list.getRiskfactor();
            System.out.print(riskFtor);
            if(riskFtor=="orange"){
                labelRiskFactor.setBackground(Background.EMPTY);
  String style = "-fx-background-color: #D7D7D7;";
  labelAuditVa.setStyle(style);
            }
            AuditV = list.getAuditvalue();
            System.out.println(" ||  "+AuditV);
            System.out.println(" ");
                    
            
            
        }
        setText(null);
        setGraphic(list == null ? null : gridPane);
        

    }
    
}
