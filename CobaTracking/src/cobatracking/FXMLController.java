/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobatracking;

import com.jfoenix.controls.JFXListView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class FXMLController implements Initializable {

    @FXML
    private JFXListView<Label> listView;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(int i=0;i<4;i++){
            try{
                Label lbl=new Label("Item "+i);
                lbl.setGraphic(new ImageView(new Image(new FileInputStream("/home/kuupie/Pictures/home-icon.png"))));
                
                listView.getItems().add(lbl);
            }catch (FileNotFoundException ex){
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }    
    
}
