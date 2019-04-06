/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import model.Project;


/**
 *
 * @author kuupie
 */
public class ProjectDao extends ListCell<Project>{
    
    
    @FXML
    private Label titleCivitas;
    @FXML
    private Label titleStratMonth;
    @FXML
    private Label titleEndMonth;
    @FXML
    private ProgressBar barProgress;
    @FXML
    private Label titleProsentase;
    
    @FXML
    private HBox gridPane;

    private FXMLLoader mLLoader;
    
    public String loadActivity="SELECT ac.idactivity, ci.civitascol, ac.startmonth, "
            + "ac.endmonth, jn.jeniscol, ci.civitascol,st.statuscol FROM activity as ac, "
            + "jenis as jn, civitas as ci, status as st  WHERE ac.jenis_idjenis = jn.idjenis "
            + "and ac.civitas_idcivitas = ci.idcivitas and ac.status_idstatus = st.idstatus "
            + "order by ac.idactivity asc";
    
    @Override
    protected void updateItem(Project project, boolean empty) {
        super.updateItem(project, empty);
        
        if(empty || project == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCellPro.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            titleCivitas.setText(project.getCivitas());
            titleStratMonth.setText(project.getStartmonth());
            titleEndMonth.setText(project.getEndmonth());
            gridPane.getStyleClass().add("mylistview");
            
            /*
            if(student.getGender().equals(Student.GENDER.MALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.MARS);
            } else if(student.getGender().equals(Student.GENDER.FEMALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.VENUS);
            } else {
                fxIconGender.setIcon(FontAwesomeIcon.GENDERLESS);
            }
*/
            
        }
        setText(null);
        setGraphic(project == null ? null : gridPane);

    }
}
