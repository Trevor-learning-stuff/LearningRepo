package com.trevorlearningrepo;
/**
 * Programmer: Trevor Campbell             CSC110AB Module 3 Selection Assignment 1
 * Date1: February 10, 2016
 * Description: This program prompts the user for the price of an object it then verifies that the value entered is at least 25, less than or equal to 100 and is a multiple of 5.
 * After verification, it calculates the difference of 100 and the given price. After the difference is found, it then calculates the minimum number of coins required as change.
 *
 * Input: price of an object
 * Output: change due for the product
 *
 * Pseudocode for this solution:
 *
 * Begin
 * Initialize the variable numQuarters to hold the value zero
 * Initialize the variable numDimes to hold the value zero
 * Initialize the variable numNickels to hold the value zero
 * Initialize the variable numPennies to hold the value zero
 * Initialize the variable price
 * Initialize the variable change
 * Prompt for and get price from user
 * If price is less than 25
 *      return an error message
 * If price is greater than 100
 *      return an error message
 * If price is not a multiple of 5
 *      return an error message
 * Otherwise
 *      Set change equal to 100 - price
 *      Set numQuarters equal to the value of numCents / 25
 *      Set change equal to the remainder of numCents / 25
 *      Set numDimes equal to the value of numCents / 10
 *      Set change equal to the remainder of numCents / 10
 *      Set numNickels equal to the value of numCents  / 5
 * Print "You bought an item for " + price + " cents and gave me a dollar.\nThe required change is:\n" + numQuarters + " quarters,\n" + numDimes + " dimes,\n" + numNickels + " nickels")
 * End
 */

import java.util.Scanner;

public class ChangeMaker2 {

    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;

    public static void main(String[] args) {

        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int price;
        int change;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter price of an item (from 25 cents to a dollar, in 5-cent increments: ");
        price = keyboard.nextInt();

        if (price < 25) {
            System.out.println("Error: The price you entered is less than 25");
        } else if (price > 100) {
            System.out.println("Error: The price you entered is greater than 1 dollar");
        } else if (price % 5 != 0) {
            System.out.println("Error: The price you entered is not a multiple of 5");
        } else {
            change = 100 - price;
            numQuarters = change / QUARTER;
            change = change % QUARTER;
            numDimes = change / DIME;
            change = change % DIME;
            numNickels = change / NICKEL;
        }

        System.out.format("You bought an item for %d cents and gave me a dollar.\nThe required change is:\n%d quarters,\n%d dimes,\n%d nickels", price, numQuarters, numDimes, numNickels);
    }
}
