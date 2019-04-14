/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;



/**
 *
 * @author kuupie
 */
public class MasCivitasDao {
    
//    @FXML
//    private JFXComboBox<Civitas> comboCivitas;
    
    public String selectNameId="SELECT `idcivitas`, `civitascol` FROM `master_civitas`";
    public String Select="SELECT mc.`idcivitas`, mc.`civitascol`,mc.`inisial_`, mc.`lokasi`, "
            + "mc.`alamat`, gc.group_civitascol, mc.`controller`, mc.`email`, mc.`nohp_controller`, "
            + "mc.`risk_champion`, mc.`email_risk_champion`, mc.`dic`, mc.`nohp_riskchampion`, mc.`email_dic`, "
            + "mc.`eic`, mc.`email_eic` FROM `master_civitas` as mc "
            + "Inner join group_civitas as gc on mc.`group_civitas_idgroup_civitas` = gc.idgroup_civitas ";
    public String where;
    public String insert;
    public String update;
    public String delete;
    public String selected;
    
    public void insertData(){
        
    }
    
    public void deleteData(){
        delete = "DELETE FROM `master_civitas` WHERE idcivitas =";
    }
    
    public void loaddataByID(int Id){
        where = " WHERE idcivitas = "+Id+""; 
        selected = Select+where;
    }
    
    public void loadSearch(String civitas){
        where = " WHERE civitascol LIKE '%"+civitas+"%'" ; 
        selected = Select+where;
    }
    
    public void insertData(String text, String text0, String text1, String text2, String text3, String text4, String text5, 
            String text6, String text7, String text8, String text9, String text10, String text11) {
        insert = "INSERT INTO `master_civitas` (`idcivitas`, `civitascol`, `inisial_`, `lokasi`, `alamat`, "
                + "`group_civitas_idgroup_civitas`, `controller`, `email`, `nohp_controller`, `risk_champion`, "
                + "`email_risk_champion`, `dic`, `nohp_riskchampion`, `email_dic`, `eic`, `email_eic`) "
                + "VALUES (NULL, "+text+", "+text0+", "+text1+", "+text2+", "+text3+", "+text4+", "+text5+", "+text6+", "+text7+", "
                + ""+text8+", "+text9+", "+text10+", "+text11+", NULL, NULL)";
        System.out.println(insert);
        
    }

//    public void updateData(int Civitas, String civitasCol, String inisialCol, String lokasiCol, String alamatCol, 
//            String txtgroupcivitas, String controllerCol, String emailCol, String nohp_controller, String risk_champion, 
//            String email_risk_champion, String nohp_riskchampion, String dicCol, String email_dic) {
//        update = " UPDATE `master_civitas` SET `civitascol`= "+civitasCol+",`inisial_`="+inisialCol+",`lokasi`="+lokasiCol+", "
//                + " `alamat`="+alamatCol+",`group_civitas_idgroup_civitas`="+txtgroupcivitas+", "
//                + " `controller`="+controllerCol+",`email`="+emailCol+",`nohp_controller`="+nohp_controller+", "
//                + " `risk_champion`="+risk_champion+",`email_risk_champion`="+email_risk_champion+", "
//                + " `dic`="+dicCol+",`nohp_riskchampion`="+nohp_riskchampion+",`email_dic`="+email_dic+"  " 
//                + " WHERE "+Civitas+" ";
//        System.out.println(update);
//    }

//    public void updateData(int civitasid, String civitasCol, String inisialCol, String lokasiCol, 
//            String alamatCol, String txtgroupcivitas, String controllerCol, String emailCol, String nohp_controller, String risk_champion, String email_risk_champion, String nohp_riskchampion, String dicCol, String email_dic) {
//        System.out.println("ksdjflksjdlkfjs");
//    }

    public void updateData(int civitasid, String civitasCol, String inisialCol, String lokasiCol, String alamatCol, String txtgroupcivitas, String controllerCol, String emailCol, String nohp_controller, String risk_champion, String email_risk_champion, String nohp_riskchampion, String dicCol, String email_dic) {
        update = " UPDATE `master_civitas` SET `civitascol`= "+civitasCol+",`inisial_`="+inisialCol+",`lokasi`="+lokasiCol+", "
                + " `alamat`="+alamatCol+",`group_civitas_idgroup_civitas`="+txtgroupcivitas+", "
                + " `controller`="+controllerCol+",`email`="+emailCol+",`nohp_controller`="+nohp_controller+", "
                + " `risk_champion`="+risk_champion+",`email_risk_champion`="+email_risk_champion+", "
                + " `dic`="+dicCol+",`nohp_riskchampion`="+nohp_riskchampion+",`email_dic`="+email_dic+"  " 
                + " WHERE idcivitas = "+civitasid+" ";
        System.out.println(update);
    }
    
    
}
