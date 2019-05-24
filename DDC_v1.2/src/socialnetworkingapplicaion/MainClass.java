/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkingapplicaion;
import java.util.Scanner;
/**
 *
 * @author Дмитрий
 */
public class MainClass {
    
    

    public static void main(String[] args) {
        
        
        
        int day, month, year, cent;
        LocalDate Date1, Date2;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Greetings!");
        System.out.println("Welcome to program that count differance detween to dates");
        
        do{
            // date 1
            System.out.println("Please, enter sentury of Elder date");
            cent = in.nextInt();
                
            do
            {
                System.out.println("Please, enter Elder date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if(!LocalDate.checkDate(day, month, year, cent-1))
                System.out.println("Error, invalid date, try again");
            }
            while(!LocalDate.checkDate(day, month, year, cent-1));
        
            Date1 = new LocalDate(day, month, year, cent-1);
        
            // date 2
            System.out.println("Please, enter sentury of Younger date");
            cent = in.nextInt();
            
            do
            {
                System.out.println("Please, enter Younger date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
            }
            while(!LocalDate.checkDate(day, month, year, cent-1));
        
            Date2 = new LocalDate(day, month, year, cent-1);
        
            // difference
            if(LocalDate.isYongerOrEqual(Date2, Date1))
            {
                LocalDate Difference = LocalDate.countDifference(Date2, Date1);
                System.out.println("====================================");
                System.out.println("Difference between these dates is:");
                System.out.println(Difference.day+" days");
                System.out.println(Difference.month+" monthes");
                System.out.println(Difference.year+" years");
                System.out.println(Difference.cent+" centuries");
                System.out.println("====================================");
                break;
            }
        
            else
            {
                System.out.println("Exception: Yonger Date is elder then Elder one");
                System.out.println("Enter dates again");
            
            
            }
            

        }while(true);
    }
}
