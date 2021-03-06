/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersLogin;

import com.jfoenix.controls.JFXTextField;
import db.koneksi;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class ConnectionSettingController implements Initializable {
    
    @FXML
    private AnchorPane viewConnection;
    @FXML
    private TextField server;
    @FXML
    private TextField port;
    @FXML
    private TextField database;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnTest;
    @FXML
    private Button btnSave;
    @FXML
    private HBox btnBack;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleTestConn(MouseEvent event) {
        String server_text = server.getText();
        String port_text = port.getText();
        String database_text = database.getText();
        String password_text = password.getText();
        String username_text = username.getText();
        koneksi kon = new koneksi();
        kon.testKoneksi(server_text, port_text, database_text, username_text, password_text);
    }

    @FXML
    private void handleSaveConn(MouseEvent event) {
        String server_text = server.getText();
        String port_text = port.getText();
        String database_text = database.getText();
        String password_text = password.getText();
        String username_text = username.getText();
        koneksi kon = new koneksi();
        kon.simpanKoneksi(server_text, port_text, database_text, username_text, password_text);
    }
    
    @FXML
    private void handleCloseConnection(MouseEvent event) throws IOException {
         //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
         // New window (Stage)
        
            final Stage primaryStage = null;
            Parent root = FXMLLoader.load(getClass().getResource("/loginForm/LoginController_1.fxml"));
            //NEWPROJECTController mct = loader.getController();
            //mct.setData(idPorject);
            Scene scene = new Scene(root);
           
            //new Scene load new windows
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
 
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
 
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);
 
            // Set position of second window, related to primary window.
            
 
            newWindow.show();
//        AnchorPane temp = FXMLLoader.load(getClass().getResource("/viewLogin/SidebarLogin.fxml"));
//        viewConnection.getChildren().setAll(temp);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("setting.properties"));
            String username_prop = properties.getProperty("user");
            String password_prop = properties.getProperty("password");
            String server_prop = properties.getProperty("serverName");
            String database_prop = properties.getProperty("databaseName");
            String port_prop = properties.getProperty("port");
            server.setText(server_prop);
            port.setText(port_prop);
            database.setText(database_prop);
            username.setText(username_prop);
            password.setText(password_prop);
            
        } catch (Exception e) {
        }
    } 
    
}
