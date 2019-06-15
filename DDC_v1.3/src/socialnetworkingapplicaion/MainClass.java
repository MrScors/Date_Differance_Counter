/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkingapplicaion;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Дмитрий
 */
public class MainClass {

    static ArrayList<HistoryRecord> history;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        history = getHistory();
        // menu
        System.out.println("Greetings!");
        System.out.println("Welcome to program that count differance between to dates");
        System.out.println("Please enter the option you want to choose or it's number");
        printMenu();

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
                    convertDateToDays(in);
                    break;
                case "show history":
                case "4":
                    showHistory();
                    break;
                case "exit":
                case "5":
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
            // date 1 input
            System.out.println("Please, enter sentury of Elder date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Elder date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!DateManipulation.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!DateManipulation.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // date 2 input
            System.out.println("Please, enter sentury of Younger date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter Younger date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
            } while (!DateManipulation.checkDate(day, month, year, cent - 1));

            Date2 = new Date(day, month, year, cent - 1);

            // Relust
            if (DateManipulation.isYongerOrEqual(Date2, Date1)) {
                Date Difference = DateManipulation.countDifference(Date2, Date1);
                System.out.println("====================================");
                System.out.println("Difference between these dates is:");
                System.out.println(Difference.day + " days");
                System.out.println(Difference.month + " monthes");
                System.out.println(Difference.year + " years");
                System.out.println(Difference.cent + " centuries");
                System.out.println("====================================");
                // recording to history
                writeToHistory("countDifferenceInDate", Date1, Date2);
                // printring menu
                printMenu();
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
            // date 1 input
            System.out.println("Please, enter sentury of Elder date");
            cent = in.nextInt();
            do {
                System.out.println("Please, enter Elder date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!DateManipulation.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!DateManipulation.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // date 2 input
            System.out.println("Please, enter sentury of Younger date");
            cent = in.nextInt();
            do {
                System.out.println("Please, enter Younger date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!DateManipulation.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!DateManipulation.checkDate(day, month, year, cent - 1));

            Date2 = new Date(day, month, year, cent - 1);

            // Relust
            if (DateManipulation.isYongerOrEqual(Date2, Date1)) {
                System.out.println(Date1.cent);
                System.out.println(Date2.cent);
                long Difference = DateManipulation.dateToDays(DateManipulation.countDifference(Date2, Date1)) + (Date2.cent - Date1.cent) * 36530;
                System.out.println("====================================");
                System.out.println("Difference between these dates is:");
                System.out.println(Difference + " days");
                System.out.println("====================================");
                // recording to history
                writeToHistory("countDifferenceInDays", Date1, Date2);
                // printring menu
                printMenu();
                break;
            } else {
                System.out.println("Exception: Yonger Date is elder then Elder one");
                System.out.println("Enter dates again");

            }

        } while (true);
    }

    static void convertDateToDays(Scanner in) {
        int day, month, year, cent;
        Date Date1;
        do {
            // date input
            System.out.println("Please, enter the sentury of the date");
            cent = in.nextInt();

            do {
                System.out.println("Please, enter the date in format \"DD MM YY\"");
                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                if (!DateManipulation.checkDate(day, month, year, cent - 1)) {
                    System.out.println("Error, invalid date, try again");
                }
            } while (!DateManipulation.checkDate(day, month, year, cent - 1));

            Date1 = new Date(day, month, year, cent - 1);

            // Relust
            long Result = DateManipulation.dateToDays(Date1);
            Result += cent * 36530;
            System.out.println("====================================");
            System.out.println("Сonvertion this date to days:");
            System.out.println(Result + " days");
            System.out.println("====================================");
            // recording to history
            writeToHistory("convertDateToDays", Date1);
            // printring menu
            printMenu();

            break;

        } while (true);
    }

    static void printMenu() {
        System.out.println();
        System.out.println("1 - count difference in date");
        System.out.println("2 - count difference in days");
        System.out.println("3 - convert date to days");
        System.out.println("4 - show history");
        System.out.println("5 - exit");
    }

    static void writeToHistory(String type, Date... arrayOfDates) {

        HistoryRecord newRecord = new HistoryRecord(arrayOfDates[0], arrayOfDates[1], type);
        if (new File("history.txt").exists()) {
            try (AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream("history.txt", true))) {
                oos.writeObject(newRecord);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("SOMTH WENT WRONG WHILE SERIALIZATION");
            }
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("history.txt"))) {
                oos.writeObject(newRecord);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("SOMTH WENT WRONG WHILE SERIALIZATION");
            }
        }
        history = getHistory();

    }

    static ArrayList<HistoryRecord> getHistory() {
        ArrayList<HistoryRecord> recorded = new ArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("history.txt"))) {
            try {
                while (true) {
                    recorded.add((HistoryRecord) ois.readObject());
                }

            } catch (EOFException eofex) {
                System.out.println(eofex.getMessage());
                System.out.println("eofex");
            }
            return recorded;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("SOMTH WENT WRONG WHILE DESERIALIZATION");
        }
        return null;
    }

    static void showHistory() {
        history.forEach((d) -> {
            System.out.println("=====================");
            System.out.println("Request:");
            System.out.println(d.getOption());
            DateManipulation.printDateInfo(d.getDate1());
            DateManipulation.printDateInfo(d.getDate2());
            System.out.println("======================");
        });
    }

}
