/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 4
 * Date1: February 29, 2016
 *
 * Description: Prompts user for exam scores until a negative number is entered. Prints out the total grades entered
 * and a count of each grade entered.
 *
 * Input: Exam scores from a user
 * Output: Total number of grades and how many of each grade
 *
 * Pseudocode for this solution:
 * start
 * Create constants for minimum grad requirements
 * Create integer variables numberOfGrades, numberOfA, numberOfB, numberOfC, numberOfD, numberOfF
 * Prompt user for exam points
 * Inform user to enter negative number when finished
 * While examScore is greater than or equal to 0
 *      increase numberOfGrades by 1
 *      check if the score is an A
 *      check if the score is a B
 *      check if the score is a C
 *      check if the score is a D
 *      if none of the above, score is an F
 * Print "Total number of grades = " + numberOfGrades
 * Print "Number of A's = " + numberOfA
 * Print "Number of B's = " + numberOfB
 * Print "Number of C's = " + numberOfC
 * Print "Number of D's = " + numberOfD
 * Print "Number of F's = " + numberOfF
 * end
 */

import java.util.Scanner;

public class ScoreProcessor {

    public static final int MIN_GRADE_FOR_A = 90;
    public static final int MIN_GRADE_FOR_B = 80;
    public static final int MIN_GRADE_FOR_C = 70;
    public static final int MIN_GRADE_FOR_D = 60;

    public static void main(String[] args) {

        int examScore;
        int numberOfGrades = 0;
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
