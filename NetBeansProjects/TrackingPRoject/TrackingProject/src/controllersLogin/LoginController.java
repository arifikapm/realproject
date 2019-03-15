/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.sudo
 */
package controllersLogin;

import db.koneksi;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnSignin;
    @FXML
    private Button btnFB;
    @FXML
    private Label lblErrors;
    @FXML
    private Button btnSetting;
    @FXML
    private AnchorPane paneViewSetting;
    
    
    /// -- 
    Connection con = null;
    koneksi kon = new koneksi();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("Success")) {
                System.out.println("success login" );
                try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/ROOT.fxml")));
                    stage.setScene(scene);
                    stage.setMaximized(true);
                    stage.show();

                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(" Check your connection ! \n or changes your connection into public ");
                alert.showAndWait();
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        Properties properties = new Properties();
        
        if (kon == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            testDB();
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }


    public LoginController() {
        kon.db();

    }

    //we gonna use string to check for status
    private String logIn() {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        //query
        String sql = "SELECT * FROM userlogin Where username = ? and password = ?";
        

        try {
            preparedStatement = kon.con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Enter Correct Username / Password");
                System.err.println("Wrong Logins --///");
                return "Error";

            } else {
                lblErrors.setTextFill(Color.GREEN);
                lblErrors.setText("Login Successful..Redirecting..");
                System.out.println("Successfull Login");
                return "Success";
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Exception";
        }

    }    
    
    public void testDB(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("setting.properties"));
            String username_prop = properties.getProperty("user");
            String password_prop = properties.getProperty("password");
            String server_prop = properties.getProperty("serverName");
            String database_prop = properties.getProperty("databaseName");
            String port_prop = properties.getProperty("port");
            kon.testKoneksi(server_prop, port_prop, database_prop, username_prop, password_prop);
            
        } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(" Check your setting ! \n or changes your connection into public ");
                alert.showAndWait();
        }
    }


    @FXML
    private void handleConnectionSetting(MouseEvent event) throws IOException {
        
         // New window (Stage)
            final Stage primaryStage = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewLogin/ConnectionSetting.fxml"));
            AnchorPane newScene = loader.load();
            //NEWPROJECTController mct = loader.getController();
            //mct.setData(idPorject);
            Scene scene = new Scene(newScene);
           
            //new Scene load new windows
            Stage newWindow = new Stage();
            newWindow.setScene(scene);
 
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
 
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);
 
            // Set position of second window, related to primary window.
            
 
            newWindow.show();
        
   // AnchorPane temp = FXMLLoader.load(getClass().getResource("/viewLogin/ConnectionSetting.fxml"));
    //paneViewSetting.getChildren().setAll(temp);
    
    }
    
}
