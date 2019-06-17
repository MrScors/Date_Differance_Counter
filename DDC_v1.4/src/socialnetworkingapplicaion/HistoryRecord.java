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
    
    //fields
    private final String option;
    private final Date date1;
    private final Date date2;
    
    //constructors
    HistoryRecord(Date date, String option){
        this.date1 = new Date(date);
        this.date2 = null;
        this.option = option;
    }
    HistoryRecord(Date date1, Date date2, String option){
        this.date1 = new Date(date1);
        this.date2 = new Date(date2);
        this.option = option;
    }
    
    //gets
    Date getDate1(){
        return date1;
    }
    Date getDate2(){
        return date2;
    }
    String getOption(){
        return option;
    }
    
}
