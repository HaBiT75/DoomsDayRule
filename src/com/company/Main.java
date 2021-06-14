package com.company;

/*
The Doomsday rule is an algorithm of determination of the day of the week for a given date.
It provides a perpetual calendar because the Gregorian calendar moves in cycles of 400 years.
The algorithm for mental calculation was devised by John Conway in 1973,[1][2] drawing inspiration from Lewis Carroll's perpetual calendar algorithm.
It takes advantage of each year having a certain day of the week upon which certain easy-to-remember dates, called the doomsdays, fall; for example,
the last day of February, 4/4, 6/6, 8/8, 10/10, and 12/12 all occur on the same day of the week in any year. Applying the Doomsday algorithm involves three steps:
Determination of the anchor day for the century, calculation of the anchor day for the year from the one for the century, and selection of the closest date out of those that always fall on the doomsday,
e.g., 4/4 and 6/6, and count of the number of days (modulo 7) between that date and the date in question to arrive at the day of the week. The technique applies to both the Gregorian calendar and the Julian calendar,
although their doomsdays are usually different days of the week.

This program will take a date and give you the day of the week that the date occurs on.
 */

public class Main {

final static int SUNDAY = 0;

final static int MONDAY = 1;

final static int TUESDAY = 2;

final static int WEDNESDAY = 3;

final static int THURSDAY = 4;

final static int FRIDAY = 5;

final static int SATURDAY = 6;

final static int JAN = 1;

final static int FEB = 2;

final static int MAR = 3;

final static int APR = 4;

final static int MAY = 5;

final static int JUN = 6;

final static int JUL = 7;

final static int AUG = 8;

final static int SEP = 9;

final static int OCT = 10;

final static int NOV = 11;

final static int DEC = 12;

private static int getCentury(int year){ // This method gets the anchor day for the century

    int temp;
    int cent;

    cent = year / 100;

    temp = cent % 4;

    switch (temp){
        case 0:
            return TUESDAY;
        case 1:
            return SUNDAY;
        case 2:
            return FRIDAY;
        case 3:
            return WEDNESDAY;
    }
    return temp;

}

private static int getYear(int year){ // This method gets the anchor day for the year

    int temp = ((year + (year / 4))  % 7);
    return temp;
}

private static void getDay(int date){ // This method get the anchor day and prints out the day to console

    int temp = date % 7;

 switch (temp){
     case SUNDAY:
         System.out.println("Sunday");
         break;
     case MONDAY:
         System.out.println("Monday");
         break;
     case TUESDAY:
         System.out.println("Tuesday");
         break;
     case WEDNESDAY:
         System.out.println("Wednesday");
         break;
     case THURSDAY:
         System.out.println("Thursday");
         break;
     case FRIDAY:
         System.out.println("Friday");
         break;
     case SATURDAY:
         System.out.println("Saturday");
         break;
 }



}
    private static int getMonth(int month, int date, boolean leap){ // This method finds the month's anchor date

    int num = date;
    int day = 0;
    int temp;

    switch (month){

        case JAN:
            if (leap){
                day = 4;
                break;
            }
            day = 3;
            break;
        case FEB:
            if (leap){
                day = 8;
                break;
            }
            day = 7;
            break;
        case MAR:
            day = 7;
            break;
        case APR:
            day = 4;
            break;
        case MAY:
            day = 2;
            break;
        case JUN:
            day = 6;
            break;
        case JUL:
            day = 4;
            break;
        case AUG:
            day = 1;
            break;
        case SEP:
            day = 5;
            break;
        case OCT:
            day = 3;
            break;
        case NOV:
            day = 7;
            break;
        case DEC:
            day = 5;
            break;

    }

    while (num > 10) {
        num = num - 7;
    }

    if (num < day){
        num = num +  7;
    }

    temp = num % day;

    while (temp > 7)
        temp = temp % 7;

    return temp;

    }
    public static void main(String[] args) { // Main method
        int anchor;
        int day;
        int temp;
        int cent = 2000;
        int year = 17;
        int month = 6;
        int date = 14;
        boolean leap;
        anchor = (getCentury(cent) + getYear(year));
        leap = (year % 4 == 0);
        day = getMonth(month, date,leap);
        temp = anchor + day;
        while (temp > 7) {
            temp = temp % 7;
        }
        getDay(temp);
    }

}

