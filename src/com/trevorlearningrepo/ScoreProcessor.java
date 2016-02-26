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

public class ScoreProcessor {

    public static final int MIN_GRADE_FOR_A = 90;
    public static final int MIN_GRADE_FOR_B = 80;
    public static final int MIN_GRADE_FOR_C = 70;
    public static final int MIN_GRADE_FOR_D = 60;

    public static void main(String[] args) {

        int numberOfGrades = 0;
        int examScore;
        int numberOfA = 0;
        int numberOfB = 0;
        int numberOfC = 0;
        int numberOfD = 0;
        int numberOfF = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter total exam points");
        System.out.println("Enter a negative number when finished");
        examScore = keyboard.nextInt();

        while (examScore >= 0) {
            numberOfGrades++;

            if (examScore >= MIN_GRADE_FOR_A) {
                numberOfA++;
            } else if (examScore >= MIN_GRADE_FOR_B) {
                numberOfB++;
            } else if (examScore >= MIN_GRADE_FOR_C) {
                numberOfC++;
            } else if (examScore >= MIN_GRADE_FOR_D) {
                numberOfD++;
            } else {
                numberOfF++;
            }
            System.out.println("Enter next score or -1 to end: ");
            examScore = keyboard.nextInt();
        }

        System.out.println("Total number of grades = " + numberOfGrades);
        System.out.println("Number of A's = " + numberOfA);
        System.out.println("Number of B's = " + numberOfB);
        System.out.println("Number of C's = " + numberOfC);
        System.out.println("Number of D's = " + numberOfD);
        System.out.println("Number of F's = " + numberOfF);
    }
}
