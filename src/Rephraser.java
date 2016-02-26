package com.trevorlearningrepo;

/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 2
 * Date: January 25, 2016
 * Description: Prompts the user for a line of text and then takes the first word and moves it to the end and makes the new
 * first word uppercase and the new last word lowercase
 *
 * Input: Line of text
 * Output: Rearranged line of text
 *
 * Pseudocode for this solution:
 *
 * Begin
 * prompt user for line of text
 * Find the originalFirstWord entered
 * Set the newSentence without originalFirstWord
 * Find newFirstWord
 * Set newFirstWord starting character to upper case
 * Set newSentence equal to newFirstWord + newSentence + originalFirstWord
 * Print "I have rephrased taht line to read: "
 * print newSentence
 * End
 */

import java.util.Scanner;

public class Rephraser {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a line of text. No punctuation please.");
        String textInput = keyboard.nextLine();

        int firstSpacePosition = textInput.indexOf(" ");
        String firstWord = textInput.substring(0, firstSpacePosition);

        String newSentence = textInput.substring(firstSpacePosition + 1);
        String newFirstWord = newSentence.substring(0, 1).toUpperCase();
        newSentence = newFirstWord + newSentence.substring(1) + " " + firstWord.toLowerCase();

        System.out.println("I have rephrased that line to read: ");
        System.out.println(newSentence);
    }
}
