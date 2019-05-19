/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkingapplicaion;

/**
 *
 * @author Дмитрий
 */
public class LocalDate {
    
    int day;
    int month;
    int year;
    int cent;
    
    LocalDate(){
    
    }
    
    LocalDate(int day, int month, int year, int cent){
        this.day = day;
        this.month = month;
        this.year = year;
        this.cent = cent;
    }
    
    static boolean isBiggerOrEqual(LocalDate firstDate, LocalDate secondDate){
        return dateToDays(firstDate)+36530*firstDate.cent>=dateToDays(secondDate)+36530*secondDate.cent;
    }
    
    static long differanceInDays(LocalDate firstDate, LocalDate secondDate){
        long differance;
        long days1, days2;
        
        days1 = dateToDays(firstDate);
        days2 = dateToDays(secondDate);
        
        if((days1-days2)>0&&firstDate.cent<=secondDate.cent)
        {
            differance =days1-days2;
        }
        else
        {
            differance = days1+36530-days2;
            firstDate.cent--;
        }
        
        
        return differance;
    }
    
    static long dateToDays(LocalDate date){
        long Days=0;
        
        int years = date.year;
        int monthes = date.month;
        int days = date.day;
        int cents = date.cent;
                
        int leapYearConter=(years+cents*100)%4;
        while(years>0){    
            Days += (leapYearConter==0) ? 366 : 365;
            years--;
            leapYearConter = (leapYearConter==3)? 0 : leapYearConter+1;
        }
        
        int leapMonthCounter=monthes%2;
        int doubleLeaping = 0;
        while(monthes>0){
            Days+= (leapMonthCounter==0) ? 30 : 31;
            monthes--;
            leapMonthCounter = (leapMonthCounter==1)? 0:leapMonthCounter+1;
            if(doubleLeaping==6) leapMonthCounter = 0;
            doubleLeaping++;
        }
        
        Days+=days;

        return Days;
    }
    
    static LocalDate countDifferance(LocalDate firstDate, LocalDate secondDate){
        
        LocalDate differance = new LocalDate();
        long dayDifferance;
        dayDifferance = LocalDate.dateToDays(firstDate)-LocalDate.dateToDays(secondDate);
        
        int leapYearCounter = (secondDate.year+secondDate.cent*100+1)%4;
        int yearCapacity = 366;
        while(dayDifferance/yearCapacity!=0){
            
            dayDifferance-= (leapYearCounter==0) ? 366 : 365;
            differance.year++;
            leapYearCounter = (leapYearCounter==3) ? 0 : leapYearCounter+1;
            yearCapacity = (leapYearCounter==3) ? 366 : 365;
            
        }
        
        int doubleLeaping = 0;
        int monthCapacity = 31;
        while(dayDifferance/monthCapacity!=0){
            
            dayDifferance-= (monthCapacity==31) ? 31 : 30;
            differance.month++;
            monthCapacity = (monthCapacity==31) ? 30 : 31;
            if(doubleLeaping==6) monthCapacity = 31;
            doubleLeaping++;
        }
        
        differance.day = (differance.month>=2) ? (int)dayDifferance+2 : (int)dayDifferance;
        
        differance.cent = firstDate.cent - secondDate.cent;
        
        return differance;
    }
    
    public static boolean checkDate(int day, int month, int year, int cent){
        
            if(0<month&&month<13)
            {
                if(month%2==0)
                {
                    if(0<day&&day<=30)
                    {
                        if((cent*100+year)%4==0)
                        {
                            if(month==2)
                            {
                                if(0<day&&day<=29)
                                {
                                    return true;
                                }
                            }
                            else return true;
                        }
                        else
                        {
                            if(month==2)
                            {
                                if(0<day&&day<=28)
                                {
                                    return true;
                                }
                            }
                            else return true;
                        }
                    }
                }
                else if(month%2==1)
                {
                    if(0<day&&day<=31)
                    {
                        if((cent*100+year)%4==0)
                        {
                            if(month==2)
                            {
                                if(0<day&&day<=29)
                                {
                                    return true;
                                }
                            }
                            else return true;
                        }
                        else
                        {
                            if(month==2)
                            {
                                if(0<day&&day<=28)
                                {
                                    return true;
                                }
                            }
                            else return true;
                        }
                    }
                                
                }
            }
        return false;
    }
    
}
