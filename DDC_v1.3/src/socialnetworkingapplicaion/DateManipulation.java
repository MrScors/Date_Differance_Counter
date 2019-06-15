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
public class DateManipulation {
    static boolean isYongerOrEqual(Date firstDate, Date secondDate) {
        return dateToDays(firstDate) + 36530 * firstDate.cent >= dateToDays(secondDate) + 36530 * secondDate.cent;
    }

    static long differenceInDays(Date firstDate, Date secondDate) {
         
        return  dateToDays(firstDate)+firstDate.cent*36530 - dateToDays(secondDate)-secondDate.cent*36530;

    }

    static long dateToDays(Date date) {
        long Days = 0;

        int years = date.year;
        int monthes = date.month;
        int days = date.day;
        int cents = date.cent;

        int leapYearConter = (years + cents * 100) % 4;
        while (years > 0) {
            Days += (leapYearConter == 0) ? 366 : 365;
            years--;
            leapYearConter = (leapYearConter == 3) ? 0 : leapYearConter + 1;
        }

        int leapMonthCounter = monthes % 2;
        int doubleLeaping = 0;
        while (monthes > 0) {
            Days += (leapMonthCounter == 0) ? 30 : 31;
            monthes--;
            leapMonthCounter = (leapMonthCounter == 1) ? 0 : leapMonthCounter + 1;
            if (doubleLeaping == 6) {
                leapMonthCounter = 0;
            }
            doubleLeaping++;
        }

        Days += days;
        return Days;
    }

    static Date countDifference(Date firstDate, Date secondDate) {

        Date difference = new Date();
        long dayDifference;
        dayDifference = DateManipulation.differenceInDays(firstDate, secondDate);
        while(dayDifference/36530!=0){
            difference.cent += 1;
            dayDifference -= 36530;
        }
        int leapYearCounter = (secondDate.year + secondDate.cent * 100 + 1) % 4;
        int yearCapacity = 366;
        while (dayDifference / yearCapacity != 0) {

            dayDifference -= (leapYearCounter == 0) ? 366 : 365;
            difference.year++;
            leapYearCounter = (leapYearCounter == 3) ? 0 : leapYearCounter + 1;
            yearCapacity = (leapYearCounter == 3) ? 366 : 365;

        }

        int doubleLeaping = 0;
        int monthCapacity = 31;
        while (dayDifference / monthCapacity != 0) {

            dayDifference -= (monthCapacity == 31) ? 31 : 30;
            difference.month++;
            monthCapacity = (monthCapacity == 31) ? 30 : 31;
            if (doubleLeaping == 6) {
                monthCapacity = 31;
            }
            doubleLeaping++;
        }

        difference.day = (difference.month >= 2) ? (int) dayDifference + 2 : (int) dayDifference;

        difference.cent += difference.year / 100;
        difference.year %= 100;

        return difference;
    }

    public static boolean checkDate(int day, int month, int year, int cent) {

        if (0 < month && month < 13) {
            if (month % 2 == 0) {
                if (0 < day && day <= 30) {
                    if ((cent * 100 + year) % 4 == 0) {
                        if (month == 2) {
                            if (0 < day && day <= 29) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        if (month == 2) {
                            if (0 < day && day <= 28) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                }
            } else if (month % 2 == 1) {
                if (0 < day && day <= 31) {
                    if ((cent * 100 + year) % 4 == 0) {
                        if (month == 2) {
                            if (0 < day && day <= 29) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        if (month == 2) {
                            if (0 < day && day <= 28) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }
    
    static void printDateInfo(Date date){
        System.out.println(date.day + "/" + date.month + "/" + date.year + "/" + date.cent);
    }
}
