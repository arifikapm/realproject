/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

/**
 *
 * @author kuupie
 */
public class ListTaskDatePicker extends TableCell<ListTaskProject, Date> {

private DatePicker datePicker;
//private final DateTimeFormatter formatter ;
private final SimpleDateFormat formatter ;

public String queryToLoad;
public String selectAll="SELECT pro.idproject, mac.civitascol, pro.startmonth as StartMonth, \n" +
"pro.endmonth as EndMonth,pro.startmonth\n" +
"            FROM project as pro\n" +
"            INNER join master_civitas as mac on pro.civitas_idcivitas = mac.idcivitas\n" +
"            INNER join master_activity as mct on pro.master_activity_idactivity = mct.idactivity\n" +
"            INNER join master_status as mas on pro.status_idstatus = mas.idstatus\n" +
"\n" +
"            order by pro.idproject asc";

public String selectTerm="SELECT mt.idtask, mt.taskcol, pmt.est_datestart, "
        + "pmt.est_dateend, pmt.act_datestart, pmt.act_dateend\n" +
"from project_has_master_task as pmt\n" +
"LEFT join master_task as mt on pmt.master_task_idtask = mt.idtask ";

public String selectDateNull=" SELECT mt.idtask, mt.taskcol, \n" +
            "(CASE \n" +
            " 	WHEN pmt.est_datestart = '0000-00-00' THEN NULL\n" +
            "	ELSE pmt.est_datestart \n" +
            "end ) as est_datestart, \n" +
            "    (CASE \n" +
            " 	WHEN pmt.est_dateend = '0000-00-00' THEN NULL\n" +
            "	ELSE pmt.est_dateend  \n" +
            "end ) as est_dateend, \n" +
            "(CASE \n" +
            " 	WHEN pmt.act_datestart = '0000-00-00' THEN NULL\n" +
            "	ELSE pmt.act_datestart\n" +
            "end ) as act_datestart, \n" +
            "(CASE \n" +
            " 	WHEN pmt.act_dateend = '0000-00-00' THEN NULL\n" +
            "	ELSE pmt.act_dateend  \n" +
            "end ) as act_dateend\n" +
            "from project_has_master_task as pmt "
        + " LEFT join master_task as mt on pmt.master_task_idtask = mt.idtask ";



public String where;
public String groupBy=" GROUP by pmt.project_idproject, mt.idtask";

public void loadTaskProject(String idProject){
    where=" WHERE pmt.project_idproject = "+idProject+" ";
    queryToLoad= selectTerm+where+groupBy;
    
}

public void loadNeWTaskProject(String idProject){
    where=" WHERE pmt.project_idproject = "+idProject+" ";
    queryToLoad= selectDateNull+where+groupBy;
    
}

    public ListTaskDatePicker() {

        super();
//        System.out.println("DatePickerCell2");
         formatter = new SimpleDateFormat("yyyy-MM-dd");  

    }

    @Override
    public void updateItem(Date item, boolean empty) {
        super.updateItem(item, empty);
        
        if (empty) {
//            System.out.println("item empty2");
            setText(null);
            setGraphic(null);
             
        } else {

            if (isEditing()) {
                if(datePicker != null) {
                    System.out.println(" editing datepicker isnull2");
                    datePicker.setValue(getDate());
                } 
                    System.out.println(" editing datepicker notnull2");
                setText(null);
                setGraphic(datePicker);
                System.out.println("updateItem2 " +getDate());
                
            } else {
                if (item == null){
                    setText(null);
                    setGraphic(null);
                } else{
                    setText(formatter.format(item));

                    setGraphic(null);
                }
            }
        }
                           
    }

    private void createDatePicker() {
        this.datePicker = new DatePicker(getDate());
        //String str = new DatePicker(getDate());
//        System.out.println(" prepare for createdate picker2");
        datePicker.setPromptText("yyyy-MM-dd");
        datePicker.setEditable(true);


        datePicker.setOnAction(new EventHandler() {
                public void handle(Event t) {
//                    System.out.println(" setOnAction2");
                    LocalDate date = datePicker.getValue();
                    int index = getIndex();

                    SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
                    cal.set(Calendar.MONTH, date.getMonthValue() - 1);
                    cal.set(Calendar.YEAR, date.getYear());

                    setText(smp.format(cal.getTime()));
                    commitEdit(cal.getTime());

                }
            });

            setAlignment(Pos.CENTER);
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if(!isEmpty()) {
                    System.out.println("startEdit2");
            createDatePicker();
            setText(null);
            setGraphic(datePicker);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        System.out.println("cancelEdit2");
        if(getDate() == null){
            setGraphic(null);
        } else{
            setText(getDate().toString());
            setGraphic(null);
        }
        
    }

    public LocalDate getDate() {
        //System.out.println("getDate2");
        LocalDate date;
        if (getItem() instanceof java.sql.Date) {
            date = ((java.sql.Date) getItem()).toLocalDate();
//            System.out.println("sql2");
//            System.out.println(date);
        } else {
//            System.out.println("util2");
            if(getItem() == null ){
                return null;
            }else{
                date = getItem().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                System.out.println("test date 2 ="+date);
            }
            
        }
        return date;

    }
    
}
