/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkingapplicaion;
import java.io.*;
/**
 *
 * @author Дмитрий
 */
public class HistoryRecord implements Serializable{
    String typeOfAction;
    Date date1;
    Date date2;
    HistoryRecord(Date date, String type){
        this.date1 = new Date(date);
        this.date2 = null;
        this.typeOfAction = type;
    }
    HistoryRecord(Date date1, Date date2, String type){
        this.date1 = new Date(date1);
        this.date2 = new Date(date2);
        this.typeOfAction = type;
    }
    
}
