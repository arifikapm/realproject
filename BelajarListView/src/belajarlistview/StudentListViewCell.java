/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarlistview;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import javafx.scene.layout.HBox;

/**
 * Created by Johannes on 23.05.16.
 *
 */

public class StudentListViewCell extends ListCell<Student> {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private FontAwesomeIconView fxIconGender;

    @FXML
    private HBox gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);
        
 //       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/listCellItem.fxml"));
   //     fxmlLoader.setController(this);
//
//                try {
//                    mLLoader.load();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            label1.setText(String.valueOf(student.getStudentId()));
//            label2.setText(student.getName());
//
//            if(student.getGender().equals(Student.GENDER.MALE)) {
//                fxIconGender.setIcon(FontAwesomeIcon.MARS);
//            } else if(student.getGender().equals(Student.GENDER.FEMALE)) {
//                fxIconGender.setIcon(FontAwesomeIcon.VENUS);
//            } else {
//                fxIconGender.setIcon(FontAwesomeIcon.GENDERLESS);
//            }
//
//            setText(null);
//            setGraphic(gridPane);

        if(empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCell.fxml"));
                mLLoader.setController(this);

                try {
                    gridPane = mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            label1.setText(String.valueOf(student.getStudentId()));
            label2.setText(student.getName());

            if(student.getGender().equals(Student.GENDER.MALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.MARS);
            } else if(student.getGender().equals(Student.GENDER.FEMALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.VENUS);
            } else {
                fxIconGender.setIcon(FontAwesomeIcon.GENDERLESS);
            }

            
        }
        setText(null);
        setGraphic(student == null ? null : gridPane);

    }
}