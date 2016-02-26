package com.trevorlearningrepo;

/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 4
 * Date: February 29, 2016
 *
 * Description: Prompts user for exam scores until a negative number is entered. Prints out the total grades entered
 * and a count of each grade entered.
 *
 * Input: Exam scores from a user
 * Output: Total number of grades and how many of each grade
 *
 * Pseudocode for this solution:
 *
 *
 */

import java.util.Scanner;

public class BackWord {

    public static void main(String[] args) {

        String inputWord;
        String newWord;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a line of text. No punctuation please.");
        inputWord = keyboard.nextLine();

        while (!inputWord.equalsIgnoreCase("quit")) {
            String firstLetter;
            String backwardsWord = "";

            firstLetter = inputWord.substring(0, 1);
            newWord = inputWord.substring(1) + firstLetter;

            for (int i = inputWord.length() - 1; i > 0; i--) {
                backwardsWord += newWord.charAt(i--);
            }

            if (backwardsWord.equalsIgnoreCase(inputWord)) {
                System.out.println("The word " + inputWord + " has the backward property.");
            } else {
                System.out.println("The word " + inputWord + " does not have the backward property.");
            }
        }
    }
}
