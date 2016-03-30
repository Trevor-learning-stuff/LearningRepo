package com.trevorlearningrepo; /**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 2
 * Date1: January 25, 2016
 * Description: This program prompts for the price of an object it then calculates the difference of 100 and the given
 * price. After the difference is found, it then calculates the minimum number of coins required as change.
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
 * Initialize the variable change to hold the value zero
 * Prompt for and get price from user
 *      Set change equal to 100 - price
 * Set numQuarters equal to the value of numCents / 25
 * Set change equal to the remainder of numCents / 25
 * Set numDimes equal to the value of numCents / 10
 * Set change equal to the remainder of numCents / 10
 * Set numNickels equal to the value of numCents  / 5
 * Print "The required change is: " + numQuarters + " quarters, " + numDimes + " dimes, " + numNickels + " nickels")
 * End
 */

import java.util.Scanner;

public class ChangeMaker {

    public static void main(String[] args) {
        int price = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter change of item in increments of 5: ");
        price = keyboard.nextInt();
        int change = (100 - price);

        int numQuarters = change / 25;
        change = change % 25;
        int numDimes = change / 10;
        change = change % 10;
        int numNickels = change / 5;

        System.out.println("The required change is: " + numQuarters + " quarters, " + numDimes + " dimes, " + numNickels + " nickels");
    }
}
