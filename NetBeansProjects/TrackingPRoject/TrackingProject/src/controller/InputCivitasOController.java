/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import db.koneksi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.MasCivitas;
import model.MasCivitasDao;
import model.MasGroupCivitas;
import model.MasGroupCivitasDao;
import model.MasGroupCivitas;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class InputCivitasOController implements Initializable {
    
    public String txtcivitascol,txtinisialcol,txtlokasicol,txtalamatcol,txtgroupcivitas,txtcontrollercol, txtemailcol;
    public String txtnohpController,txtriskChampion,txtemailRisk,txtnoHpRisk,txtdiccol,txtemailDIc;
    
    @FXML
    private JFXButton btnSave;
    @FXML
    private TextField civitasCol;
    @FXML
    private TextField inisialCol;
    @FXML
    private TextField lokasiCol;
    @FXML
    private TextField namaController;
    @FXML
    private TextField contactController;
    @FXML
    private TextField emailController;
    @FXML
    private TextField riskCol;
    @FXML
    private TextField contatcriskCol;
    @FXML
    private TextField emailRiskCol;
    @FXML
    private TextField namaDIc;
    @FXML
    private TextField emailDIC;
    @FXML
    private JFXComboBox<MasGroupCivitas> comboGroup;
    @FXML
    private TextField groupCol;
    @FXML
    private TextArea alamatCol;
    
    koneksi kon = new koneksi();
    
    private ObservableList<MasCivitas> dataCivitas;
    private ObservableList<MasGroupCivitas> dataGroupCivitas;
    MasCivitasDao model = new MasCivitasDao();
    MasGroupCivitasDao modelGroup = new MasGroupCivitasDao();
    public int civitasid = 0;
    @FXML
    private JFXButton btnSave1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kon.db();
        try {
            comboBoxGroupCivitas();
        } catch (SQLException ex) {
            Logger.getLogger(InputCivitasOController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnSave(MouseEvent event) throws SQLException {
        try {
//            txtcivitascol = civitasCol.getText();
            if(cekForm() == true){
                if (civitasid == 0) {
                    insertMethode();
                } else {
                    update();
//                    updateMethode();
                }

            } else{
                
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void setLoadData(int IdCivitas) throws SQLException{
        civitasid = IdCivitas;
        model.loaddataByID(IdCivitas);
        dataCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(model.selected);
        try {
            while (kon.res.next()) {                
                dataCivitas.add(new MasCivitas(kon.res.getInt(1), kon.res.getString(2), kon.res.getString(3), kon.res.getString(4), 
                        kon.res.getString(5), kon.res.getString(6), kon.res.getString(7), kon.res.getString(8), kon.res.getString(9), 
                        kon.res.getString(10), kon.res.getString(11), kon.res.getString(12), kon.res.getString(13), kon.res.getString(14), 
                        kon.res.getString(15), kon.res.getString(16)));
                
                txtcivitascol = kon.res.getString(2);
                txtinisialcol = kon.res.getString(3);
                txtlokasicol= kon.res.getString(4);
                txtalamatcol = kon.res.getString(5);
                txtgroupcivitas = kon.res.getString(6);
                txtcontrollercol = kon.res.getString(7);
                txtemailcol = kon.res.getString(8);
                txtnohpController = kon.res.getString(9);
                txtriskChampion = kon.res.getString(10);
                txtemailRisk = kon.res.getString(11);
                txtnoHpRisk = kon.res.getString(12);
                txtdiccol = kon.res.getString(13);
                txtemailDIc = kon.res.getString(14);

            }
            
            civitasCol.setText(txtcivitascol);
            inisialCol.setText(txtinisialcol);
            lokasiCol.setText(txtlokasicol);
            alamatCol.setText(txtalamatcol);
            groupCol.setText(txtgroupcivitas);
            namaController.setText(txtcontrollercol);
            emailController.setText(txtemailcol);
            contactController.setText(txtnohpController);
            riskCol.setText(txtriskChampion);
            emailRiskCol.setText(txtemailRisk);
            contatcriskCol.setText(txtnoHpRisk);
            namaDIc.setText(txtdiccol);
            emailDIC.setText(txtemailDIc);
            
        }catch (Exception e) {
            
        }
    }
    
    public void comboBoxGroupCivitas() throws SQLException{
        
        //query set on class
        //int statusId= 5;
        //modelGroup.statusLoad(statusId);
        dataGroupCivitas=FXCollections.observableArrayList();
        kon.res=kon.stat.executeQuery(modelGroup.selectAll);
        try {
            while (kon.res.next()) {                
                dataGroupCivitas.add(new MasGroupCivitas(kon.res.getInt(1), kon.res.getString(2)));
            }
            
            //load all query result or model on combo box
            //you will show the container every query row
            comboGroup.getItems().addAll(dataGroupCivitas);
            
            //load the field value every query row
            comboGroup.setCellFactory(new Callback<ListView<MasGroupCivitas>, ListCell<MasGroupCivitas>>() {
            @Override public ListCell<MasGroupCivitas> call(ListView<MasGroupCivitas> param) {
                final ListCell<MasGroupCivitas> cell = new ListCell<MasGroupCivitas>() {

                    @Override public void updateItem(MasGroupCivitas item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getGroupCivitasCol());
                            
                        }else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
                    
            });
            
            //show the selected value
            groupCol.setText(null);
            comboGroup.setConverter(new StringConverter<MasGroupCivitas>() {
              @Override
              public String toString(MasGroupCivitas activityCol) {
                if (activityCol == null){
                  return null;
                } else {
                    groupCol.setText(activityCol.getGroupCivitasCol());
                  return activityCol.getGroupCivitasCol();
                }
              }

            @Override
            public MasGroupCivitas fromString(String userId) {
                return null;
            }
        });
            
        //combo box style
        comboGroup.setMaxHeight(25);    
        
        } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf(ex));
                    alert.showAndWait();
        }
    }

    private void insertMethode() throws SQLException {
        try {
                txtcivitascol = civitasCol.getText();
                txtinisialcol = inisialCol.getText();
                txtlokasicol= lokasiCol.getText();
                txtalamatcol = alamatCol.getText();
                txtgroupcivitas = Integer.toString(comboGroup.getSelectionModel().getSelectedItem().getIdCivitas());
                txtcontrollercol = namaController.getText();
                txtemailcol = emailController.getText();
                txtnohpController = contactController.getText();
                txtriskChampion = riskCol.getText();
                txtemailRisk = emailRiskCol.getText();
                txtnoHpRisk = contatcriskCol.getText();
                txtdiccol = namaDIc.getText();
                txtemailDIc = emailDIC.getText();
                
                
                
            model.insertData(getCivitasCol(),getInisialCol(),getLokasiCol(),getAlamatCol(),txtgroupcivitas,getControllerCol(),getEmailCol(),
                    getNohp_controller(),getRisk_champion(),getEmail_risk_champion(),getNohp_riskchampion(),getDicCol(),getEmail_dic()
                );
                kon.stat.executeUpdate(model.insert);
            //}
                
                
        } catch (Exception e) {
        
        }
        
//                txtcivitascol = null;
//                txtinisialcol = null;
//                txtlokasicol= null;
//                txtalamatcol = null;
//                //txtgroupcivitas = Integer.toString(comboGroup.getSelectionModel().getSelectedItem().getIdCivitas());
//                txtcontrollercol = null;
//                txtemailcol =null;
//                txtnohpController =null;
//                txtriskChampion = null;
//                txtemailRisk =null;
//                txtnoHpRisk = null;
//                txtdiccol = null;
//                txtemailDIc = null;
                

            
    }

//    public void updateMethode() throws SQLException {
//                txtcivitascol = civitasCol.getText();
//                txtinisialcol = inisialCol.getText();
//                txtlokasicol= lokasiCol.getText();
//                txtalamatcol = alamatCol.getText();
//                txtgroupcivitas = Integer.toString(comboGroup.getSelectionModel().getSelectedItem().getIdCivitas());
//                txtcontrollercol = namaController.getText();
//                txtemailcol = emailController.getText();
//                txtnohpController = contactController.getText();
//                txtriskChampion = riskCol.getText();
//                txtemailRisk = emailRiskCol.getText();
//                txtnoHpRisk = contatcriskCol.getText();
//                txtdiccol = namaDIc.getText();
//                txtemailDIc = emailDIC.getText();
//        try {
//
//            if (civitasid != 0 ) {
//                System.out.println(civitasid);
//                
//            model.insertData(getCivitasCol(),getInisialCol(),getLokasiCol(),getAlamatCol(),txtgroupcivitas,getControllerCol(),getEmailCol(),
//                    getNohp_controller(),getRisk_champion(),getEmail_risk_champion(),getNohp_riskchampion(),getDicCol(),getEmail_dic()
//                );
//            } else {
//                System.out.println("error");
//            }
//                
//            //System.out.println(model.update);
//                //kon.stat.executeUpdate(model.update);
//            //}
//                
//                
//        } catch (Exception e) {
//            System.out.println(e);
//        
//        }
//        
//                txtcivitascol = null;
//                txtinisialcol = null;
//                txtlokasicol= null;
//                txtalamatcol = null;
//                //txtgroupcivitas = Integer.toString(comboGroup.getSelectionModel().getSelectedItem().getIdCivitas());
//                txtcontrollercol = null;
//                txtemailcol =null;
//                txtnohpController =null;
//                txtriskChampion = null;
//                txtemailRisk =null;
//                txtnoHpRisk = null;
//                txtdiccol = null;
//                txtemailDIc = null;
//        
//        
//    }
    
    
    private boolean cekForm(){
        if (civitasCol.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("CIvitas kosong"));
                    alert.showAndWait();
                    return false;
        } else if (comboGroup.getValue() == null ){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(String.valueOf("combo Group kosong"));
                    alert.showAndWait();
                    return false;
        } else {
            return true;
        }
    }
    
    public String getCivitasCol() {
        String saString;
        if (civitasCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtcivitascol+"'";
        }
        return saString;
    }

    public String getInisialCol() {
        String saString;
        if (inisialCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtinisialcol+"'";
        }
        return saString;
    }

    public String getLokasiCol() {
        String saString;
        if (lokasiCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtlokasicol+"'";
        }
        return saString;
    }

    public String getAlamatCol() {
                String saString;
        if (alamatCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtalamatcol+"'";
        }
        return saString;
    }

    public String getGroupCivitas() {
        String saString;
        if (groupCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtgroupcivitas+"'";
        }
        return saString;
    }

    public String getControllerCol() {
        String saString;
        if (namaController.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtcontrollercol+"'";
        }
        return saString;
    }

    public String getEmailCol() {
        String saString;
        if (emailController.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtemailcol+"'";
        }
        return saString;
    }

    public String getNohp_controller() {
        String saString;
        if (contactController.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtnohpController+"'";
        }
        return saString;
    }

    public String getRisk_champion() {
        String saString;
        if (riskCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtriskChampion+"'";
        }
        return saString;
    }

    public String getEmail_risk_champion() {
        String saString;
        if (emailRiskCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtemailRisk+"'";
        }
        return saString;
    }

    public String getDicCol() {
        String saString;
        if (namaDIc.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtdiccol+"'";
        }
        return saString;
    }

    public String getNohp_riskchampion() {
        String saString;
        if (contatcriskCol.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtnoHpRisk+"'";
        }
        return saString;
    }

    public String getEmail_dic() {
        String saString;
        if (emailDIC.getText().equals("")) {
            saString = "''";
        } else {
            saString = "'"+txtemailDIc+"'";
        }
        return saString;
    }

//    public void setIdCivitas(Integer value) {
//        this.idCivitas.setValue(value);
//    }
//
//    public void setCivitasCol(String value) {
//        this.civitasCol.setValue(value);
//    }
//
//    public void setInisialCol(String value) {
//        this.inisialCol.setValue(value);
//    }
//
//    public void setLokasiCol(String value) {
//        this.lokasiCol.setValue(value);
//    }
//
//    public void setAlamatCol(String value) {
//        this.alamatCol.setValue(value);
//    }
//
//    public void setGroupCivitas(String value) {
//        this.groupCivitas.setValue(value);
//    }
//
//    public void setControllerCol(String value) {
//        this.controllerCol.setValue(value);
//    }
//
//    public void setEmailCol(String value) {
//        this.emailCol.setValue(value);
//    }
//
//    public void setNohp_controller(String value) {
//        this.nohp_controller.setValue(value);
//    }
//
//    public void setRisk_champion(String value) {
//        this.risk_champion.setValue(value);
//    }
//
//    public void setEmail_risk_champion(String value) {
//        this.email_risk_champion.setValue(value);
//    }
//
//    public void setDicCol(String value) {
//        this.dicCol.setValue(value);
//    }
//
//    public void setNohp_riskchampion(String value) {
//        this.nohp_riskchampion.setValue(value);
//    }
//
//    public void setEmail_dic(String value) {
//        this.email_dic.setValue(value);
//    }
//
//    public void setEic(String value) {
//        this.eic.setValue(value);
//    }
//
//    public void setEmail_eic(String value) {
//        this.email_eic.setValue(value);
//    }

    @FXML
    private void btnSave1(MouseEvent event) throws SQLException {
        update();
    }
    
    public void update(){
                        txtcivitascol = civitasCol.getText();
                txtinisialcol = inisialCol.getText();
                txtlokasicol= lokasiCol.getText();
                txtalamatcol = alamatCol.getText();
                txtgroupcivitas = Integer.toString(comboGroup.getSelectionModel().getSelectedItem().getIdCivitas());
                txtcontrollercol = namaController.getText();
                txtemailcol = emailController.getText();
                txtnohpController = contactController.getText();
                txtriskChampion = riskCol.getText();
                txtemailRisk = emailRiskCol.getText();
                txtnoHpRisk = contatcriskCol.getText();
                txtdiccol = namaDIc.getText();
                txtemailDIc = emailDIC.getText();
        try {
            model.updateData(civitasid, getCivitasCol(), getInisialCol(), getLokasiCol(), getAlamatCol(), 
                    txtgroupcivitas, getControllerCol(), getEmailCol(), getNohp_controller(), getRisk_champion(), 
                    getEmail_risk_champion(), getNohp_riskchampion(), getDicCol(), getEmail_dic());
            kon.stat.executeUpdate(model.update);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
