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
public class Date implements Serializable{
    int day;
    int month;
    int year;
    int cent;
    
    Date() {

    }

    Date(int day, int month, int year, int cent) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.cent = cent;
    }
    
    Date(Date date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
        this.cent = date.cent;
    }

}
