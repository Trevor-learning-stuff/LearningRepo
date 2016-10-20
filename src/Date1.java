package com.trevorlearningrepo;
/**
 * Programmer: Trevor Campbell             CSC110AB Module 3 Selection Assignment 2
 * Date1: February 11, 2016
 * Description: This program prompts the user for a date and then validates that the date is legitimate.
 *
 * Input: date in format of mm/dd/yyyy
 * Output: Whether the date is valid or not
 *
 * Pseudocode for this solution:
 * Begin
 * Instantiate the string variables date and monthAndYear
 * Instantiate the integer variables day, month, and year
 * Prompt the user for date input
 * Parse the day
 *      convert day to an integer
 *      store day in the variable day
 * Parse the month and year
 *      store it in the variable monthAndYear
 * Parse the month from the monthAndYear variable
 *      store it in the variable month
 * Parse the year from the monthAndYear variable
 *      store it in the variable year
 * create boolean criteria for invalid day ranges of each month
 *      store in variables invalid31DayRange, invalid30DayRange, invalid29DayRange, invalid28DayRange
 * create boolean criteria for validating leap year
 *      store in variable isLeapYear
 * create boolean criteria for validating invalid months
 *      store in variable invalidMonthRange
 * if month is invalid
 *      check if day is invalid
 *      if neither are valid print month and day invalid response
 *      else print month is invalid response
 * if 31 day range is invalid
 *      print response
 * if 30 day range is invalid
 *      print response
 * if 29 day range is invalid
 *      print response
 * if 28 day range is invalid
 *      print response
 * else print date is valid response
 * end
 */

import java.util.Scanner;

public class Date1 {

    public static void main(String[] args) {

        String date, monthAndYear;
        int day, month, year;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a date (mm/dd/yyyy): ");
        date = keyboard.nextLine();

        day = Integer.valueOf(date.substring(0, date.indexOf("/")));
        monthAndYear = date.substring(date.indexOf("/") + 1);
        month = Integer.valueOf(monthAndYear.substring(0, monthAndYear.indexOf("/")));
        year = Integer.valueOf(monthAndYear.substring(monthAndYear.indexOf("/") + 1));

        boolean invalid31DayRange = day < 1 || day > 31;
        boolean invalid30DayRange = day < 1 || day > 30 && month == 4 || month == 6 || month == 9 || month == 11;
        boolean invalid29DayRange = day < 1 || day > 29 && month == 2;
        boolean isLeapYear = invalid29DayRange && year % 4 == 0 && (year % 400 == 0 && year % 100 == 0);
        boolean invalid28DayRange = day < 1 || day > 28 && month == 2 && !(isLeapYear);
        boolean invalidMonthRange = month < 1 || month > 12;

        if (invalidMonthRange) {
            if (invalid31DayRange) {
                System.out.println("The month and day is out of range");
            } else {
                System.out.println("The month is out of range");
            }
        } else if (invalid31DayRange) {
            System.out.println("The day should be between 1 and 31");
        } else if (invalid30DayRange) {
            System.out.println("The day should be between 1 and 30");
        } else if (invalid29DayRange) {
            System.out.println("The day should be between 1 and 29");
        } else if (invalid28DayRange) {
            System.out.println("The day should be between 1 and 28");
        } else {
            System.out.println("The date " + date + " is a valid date");
        }
    }
}
