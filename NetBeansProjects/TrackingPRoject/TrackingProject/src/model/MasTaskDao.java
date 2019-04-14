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
public class MasTaskDao extends ListCell<MasTask>  {
    
    private FXMLLoader mLLoader;
    
    @FXML
    private GridPane gridPane;

    @FXML
    private Label titleTask;
    
    public String selectAll = "SELECT mta.idtask, mta.taskcol, mta.inisial_task, rta.rootprocesscol, mta.mandatory\n" +
            " from master_task as mta\n" +
            " inner join roottask as rta on mta.roottask_idroottask = rta.idroottask ";

    public String selectTask = "SELECT `idtask`, `taskcol`, `inisial_task`, rt.rootprocesscol , \n" +
            "(case when mandatory = 1 then \"Mandatory\" else \"Not Mandatory\" end) as `mandatory list`\n" +
            "FROM `master_task` as mts\n" +
            "INNER JOIN roottask as rt on mts.roottask_idroottask = rt.idroottask \n" ;
    
    
    
    @Override
    protected void updateItem(MasTask task, boolean empty) {
        super.updateItem(task, empty);
        
        if(empty || task == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellTask.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            titleTask.setText(task.getTaskCol());
            gridPane.getStyleClass().add("mylistview");

        }
        setText(null);
        setGraphic(task == null ? null : gridPane);
        

    }
}
