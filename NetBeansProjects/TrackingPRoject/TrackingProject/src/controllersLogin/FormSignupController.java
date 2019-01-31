/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersLogin;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class FormSignupController implements Initializable {

    @FXML
    private AnchorPane viewConnection;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordCheck;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnSave;
    @FXML
    private HBox btnBack;
    @FXML
    private FontAwesomeIconView btnDropDown;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveUser(MouseEvent event) {
    }

    @FXML
    private void handleCloseConnection(MouseEvent event) {
    }

    @FXML
    private void handleDropDown(MouseEvent event) {
    }
    
}
