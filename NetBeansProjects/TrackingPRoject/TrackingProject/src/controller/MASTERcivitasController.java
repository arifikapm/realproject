/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.koneksi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.MasCivitas;
import model.MasCivitasDao;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class MASTERcivitasController implements Initializable {

    
    @FXML
    public BorderPane viewInput;
    @FXML
    private HBox btnBack;
    @FXML
    private HBox btnAddNew;
    @FXML
    private TableColumn<MasCivitas, Integer> No;
    @FXML
    private TableColumn<MasCivitas, String> civitasCol;
    @FXML
    private TableColumn<MasCivitas, String> insisialCol;
    @FXML
    private TableColumn<MasCivitas, String> lokasiCol;
    @FXML
    private TableColumn<MasCivitas, String> alamatCol;
    @FXML
    private TableColumn<MasCivitas, String> groupCol;
    @FXML
    private TableColumn<MasCivitas, String> controllerCol;
    @FXML
    private TableColumn<MasCivitas, String> riskChampionCol;
    @FXML
    private TableColumn<MasCivitas, String> dic;
    @FXML
    private TableColumn<MasCivitas, String> emailDic;
        @FXML
    private TableColumn<MasCivitas, String> noHPControl;
    @FXML
    private TableColumn<MasCivitas, String> emailController;
    @FXML
    private TableColumn<MasCivitas, String> contactRisk;
    @FXML
    private TableColumn<MasCivitas, String> emailRisk;
        @FXML
    private TableView<MasCivitas> tableCivitas;
        
    koneksi kon = new koneksi();
    
    public int idCivitas;
    
    private ObservableList<MasCivitas> dataCivitas;
    MasCivitasDao model = new MasCivitasDao();
    @FXML
    private TextField civitasCol1;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kon.db();
        try {
            // TODO

            setLoadData();
        } catch (SQLException ex) {
            Logger.getLogger(MASTERcivitasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnBack.setVisible(false);
        btnAddNew.setVisible(true);
    }    

    @FXML
    private void loadAddNewSide(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InputCivitasO.fxml"));
        BorderPane newScene = loader.load();
        InputCivitasOController mct = loader.getController();
        idCivitas = 0;
        //mct.setLoadData(idCivitas);
//        ScrollPane pane = FXMLLoader.load(getClass().getResource("/view/InputCivitasO.fxml"));
        //viewLoadRight.getChildren().setAll(pane);
        viewInput.setRight(newScene);
        btnBack.setVisible(true);
        btnAddNew.setVisible(false);
    
    }

    @FXML
    private void handleClose(MouseEvent event) throws SQLException {
        //viewInput.
        viewInput.setRight(null);
        btnBack.setVisible(false);
        btnAddNew.setVisible(true);
        setLoadData();
    }

    @FXML
    private void setnew(Event event) {
        //btnBack.setVisible(false);
        try {
            btnAddNew.setVisible(true);
        } catch (Exception e) {
        }
        
    }

    private void closeadnew(Event event) {
        viewInput.setRight(null);
        btnBack.setVisible(false);
        btnAddNew.setVisible(false);
    }


    @FXML
    private void loadSelection(MouseEvent event) {
        try {
            idCivitas = tableCivitas.getSelectionModel().getSelectedItem().getIdCivitas();
            //if (idCivitas != 0) {
                setloadSelection();
            //}
            
        } catch (Exception e) {
        }

    }
    
    public void setLoadData() throws SQLException{
        dataCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(model.Select);
        try {
            while (kon.res.next()) {                
                dataCivitas.add(new MasCivitas(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                        kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), kon.res.getString(14), 
                        kon.res.getString(15), kon.res.getString(16)));
            }
            tableCivitas.setItems(null);
            No.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(tableCivitas.getItems().indexOf(column.getValue())+1));
            civitasCol.setCellValueFactory(new PropertyValueFactory<>("civitasCol"));
            insisialCol.setCellValueFactory(new PropertyValueFactory<>("inisialCol"));
            lokasiCol.setCellValueFactory(new PropertyValueFactory<>("lokasiCol"));
            alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamatCol"));
            groupCol.setCellValueFactory(new PropertyValueFactory<>("groupCivitas"));
            controllerCol.setCellValueFactory(new PropertyValueFactory<>("controllerCol"));
            emailController.setCellValueFactory(new PropertyValueFactory<>("emailCol"));
            controllerCol.setCellValueFactory(new PropertyValueFactory<>("nohp_controller"));
            riskChampionCol.setCellValueFactory(new PropertyValueFactory<>("risk_champion"));
            emailRisk.setCellValueFactory(new PropertyValueFactory<>("email_risk_champion"));
            contactRisk.setCellValueFactory(new PropertyValueFactory<>("nohp_riskchampion"));
            dic.setCellValueFactory(new PropertyValueFactory<>("dicCol"));
            emailDic.setCellValueFactory(new PropertyValueFactory<>("email_dic"));
//            civitasCol.setCellValueFactory(new PropertyValueFactory<>("eic"));
//            civitasCol.setCellValueFactory(new PropertyValueFactory<>("email_eic"));
            tableCivitas.setItems(dataCivitas);
            tableCivitas.setEditable(true);
            
        } catch (Exception e) {
            
        }
    }

    public void setloadSelection() throws IOException, SQLException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InputCivitasO.fxml"));
        BorderPane newScene = loader.load();
        InputCivitasOController mct = loader.getController();
        viewInput.setRight(newScene);
        mct.setLoadData(idCivitas);
        btnBack.setVisible(true);
        btnAddNew.setVisible(false);
        //viewLoadRight.getChildren().setAll(pane);


    }

    @FXML
    private void loadSearchCivitas(KeyEvent event) throws SQLException {
        if (civitasCol1.getText() == null ){
            setLoadData();
        } else {
            model.loadSearch(civitasCol1.getText());
            dataCivitas=FXCollections.observableArrayList();
            kon.res=kon.stat.executeQuery(model.selected);
            try {
                while (kon.res.next()) {                
                    dataCivitas.add(new MasCivitas(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3), kon.res.getString(4), 
                            kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                            kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), kon.res.getString(14), 
                            kon.res.getString(15), kon.res.getString(16)));
                }
                tableCivitas.setItems(null);
                No.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(tableCivitas.getItems().indexOf(column.getValue())+1));
                civitasCol.setCellValueFactory(new PropertyValueFactory<>("civitasCol"));
                insisialCol.setCellValueFactory(new PropertyValueFactory<>("inisialCol"));
                lokasiCol.setCellValueFactory(new PropertyValueFactory<>("lokasiCol"));
                alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamatCol"));
                groupCol.setCellValueFactory(new PropertyValueFactory<>("groupCivitas"));
                controllerCol.setCellValueFactory(new PropertyValueFactory<>("controllerCol"));
                emailController.setCellValueFactory(new PropertyValueFactory<>("emailCol"));
                controllerCol.setCellValueFactory(new PropertyValueFactory<>("nohp_controller"));
                riskChampionCol.setCellValueFactory(new PropertyValueFactory<>("risk_champion"));
                emailRisk.setCellValueFactory(new PropertyValueFactory<>("email_risk_champion"));
                contactRisk.setCellValueFactory(new PropertyValueFactory<>("nohp_riskchampion"));
                dic.setCellValueFactory(new PropertyValueFactory<>("dicCol"));
                emailDic.setCellValueFactory(new PropertyValueFactory<>("email_dic"));
    //            civitasCol.setCellValueFactory(new PropertyValueFactory<>("eic"));
    //            civitasCol.setCellValueFactory(new PropertyValueFactory<>("email_eic"));
                tableCivitas.setItems(dataCivitas);
                tableCivitas.setEditable(true);

            } catch (Exception e) {

            }
        }
    }
    
}
