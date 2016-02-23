package com.trevorlearningrepo;

/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 2
 * Date: January 23, 2016
 * Description: This program takes an input of degrees Fahrenheit from the user, converts it to degrees Celsius
 *      and displays the result.
 * Input: User is prompted for the temperature of type, integer
 * Output: The temperature Celsius of type, float
 *
 * Pseudocode for this solution:
 * Begin
 * Prompt user for temperature in Fahrenheit
 * Calculate user input into Celsius using 5 * (degreesF - 32)/9
 * Print degreesF + " degrees Fahrenheit is " + degreesC + " degrees Celsius"
 * End
 */

import java.util.Scanner;

public class TempConverter {

    public static void main(String[] args) {

        int degreesF;
        double degreesC;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a temperature in degrees Fahrenheit: ");
        degreesF = keyboard.nextInt();
        degreesC = 5 * (degreesF -32)/9;

        System.out.println(degreesF + " degrees Fahrenheit is " + degreesC + " degrees Celsius");

        double first = 0;
        int second = 0;
        System.out.println("first is " + first + " second =" + second);

    }
}
