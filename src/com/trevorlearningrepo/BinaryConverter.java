package com.trevorlearningrepo; /**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 2
 * Date: January 29, 2016
 * Description: Prompts the user for a 4 digit binary number, stores the number as a string,
 * breaks the string into substrings and then converts each substring into a decimal value.
 *
 * Input: Number from user as a string
 * Output: Integer value
 *
 * Pseudocode for this solution:
 * Start
 * Set variables char1, char2, char3, char4, decimalValue to 0
 * Prompt for and get 4-bit binary number as a string
 * Convert each digit within the string to an individual substring
 * Convert each substring into type integer
 * Multiply each integer by it's bit value
 * print "The decimal equivalent of the binary number is: " + decimalValue
 * end
 */

import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int char1, char2, char3, char4, decimalValue;

        System.out.println("Please enter a 4-bit binary number: ");
        String userInput = keyboard.next();

        char1 = Integer.parseInt(userInput.substring(0, 1));
        char2 = Integer.parseInt(userInput.substring(1, 2));
        char3 = Integer.parseInt(userInput.substring(2, 3));
        char4 = Integer.parseInt(userInput.substring(3));

        decimalValue = (8 * char1) + (4 * char2) + (2 * char3) + char4;

        System.out.println("The decimal equivalent of the binary number is: " + decimalValue);
    }
}
