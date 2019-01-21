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
public class MasScopeDao extends ListCell<MasScope> {
    
    @FXML
    private Label titleScope;
    
    @FXML
    private HBox gridPane;

    private FXMLLoader mLLoader;
    
    public String scopequery;
    public String select="SELECT pms.project_idproject as idproject,pms.master_scope_idscope as idscope,ms.scopecol "
            + "FROM project as pr "
            + "left join project_has_master_scope as pms "
            + "on pr.idproject=pms.project_idproject "
            + "LEFT join master_scope as ms "
            + "on pms.master_scope_idscope=ms.idscope ";
    public String where;
    public String and;
    
    public String queryCoPro="SELECT idscope, idscope,scopecol FROM master_scope";
    
    public String insertInto;
    
    
    
    public void loadScopeProject(String idProject){
        where = " WHERE pms.project_idproject =  "+idProject+" ";
        scopequery = select+where;
        
    }
    
    
    @Override
    protected void updateItem(MasScope project, boolean empty) {
        super.updateItem(project, empty);
        
        if(empty || project == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellScope.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            titleScope.setText(project.getScopeCol());

            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);

    }
    
        public void loadScope(String idScope){
        where ="where pr.idproject="+idScope+" ";
        scopequery=select+where;
    }

    public void setQueryProjectHasScopeSave(String idProject, String string) {
        insertInto = "INSERT INTO `project_has_master_scope` \n" +
            "(`project_idproject`, `master_scope_idscope`) \n" +
            "VALUES ('"+idProject+"', '"+string+"')";
        System.out.println(insertInto);
    }
}
