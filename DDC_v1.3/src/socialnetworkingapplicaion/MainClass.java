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

        Scanner in = new Scanner(System.in);

        System.out.println("Greetings!");
        System.out.println("Welcome to program that count differance between to dates");
        System.out.println("Please enter the option you want to choose or it's number");
        System.out.println("1 - count difference in date");
        System.out.println("2 - count difference in days");
        System.out.println("3 - convert date to days");
        System.out.println("4 - exit");

        String controller;
        OUTER:
        while (true) {
            controller = in.nextLine();
            switch (controller) {
                case "count difference in date":
                case "1":
                    countDifferenceInDate(in);
                    break;
                case "count difference in days":
                case "2":
                    countDifferenceInDays(in);
                    break;
                case "convert date to days":
                case "3":
                    converDateToDays(in);
                    break;
                case "exit":
                case "4":
                    break OUTER;
                default:
                    break;
            }
        }

    }

    static void countDifferenceInDate(Scanner in) {

        int day, month, year, cent;
        Date Date1, Date2;
        do {
            // date 1
            System.out.println("Please, enter sentury of Elder date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Elder date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!Date.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!Date.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // date 2
            System.out.println("Please, enter sentury of Younger date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Younger date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
            } while (!Date.checkDate(day, month, year, cent - 1));

            Date2 = new Date(day, month, year, cent - 1);

            // difference
            if (Date.isYongerOrEqual(Date2, Date1)) {
                Date Difference = Date.countDifference(Date2, Date1);
                System.out.println("====================================");
                System.out.println("Difference between these dates is:");
                System.out.println(Difference.day + " days");
                System.out.println(Difference.month + " monthes");
                System.out.println(Difference.year + " years");
                System.out.println(Difference.cent + " centuries");
                System.out.println("====================================");
                break;
            } else {
                System.out.println("Exception: Yonger Date is elder then Elder one");
                System.out.println("Enter dates again");

            }

        } while (true);
    }

    static void countDifferenceInDays(Scanner in) {
        int day, month, year, cent;
        Date Date1, Date2;
        do {
            // date 1
            System.out.println("Please, enter sentury of Elder date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Elder date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!Date.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!Date.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // date 2
            System.out.println("Please, enter sentury of Younger date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Younger date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
            } while (!Date.checkDate(day, month, year, cent - 1));

            Date2 = new Date(day, month, year, cent - 1);

            // difference
            if (Date.isYongerOrEqual(Date2, Date1)) {
                long Difference = Date.dateToDays(Date.countDifference(Date2, Date1));
                System.out.println("====================================");
                System.out.println("Difference between these dates is:");
                System.out.println(Difference + " days");
                System.out.println("====================================");
                break;
            } else {
                System.out.println("Exception: Yonger Date is elder then Elder one");
                System.out.println("Enter dates again");

            }

        } while (true);
    }

    static void converDateToDays(Scanner in) {
        int day, month, year, cent;
        Date Date1;
        do {
            // date 1
            System.out.println("Please, enter the sentury of the date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter the date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!Date.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!Date.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // difference
            long Result = Date.dateToDays(Date1);
            System.out.println("====================================");
            System.out.println("Difference between these dates is:");
            System.out.println(Result + " days");
            System.out.println("====================================");
            break;

        } while (true);
    }

}
