package com.trevorlearningrepo;

/**
 * Programmer: Trevor Campbell             CSC110AB Module 3 Selection Assignment 2
 * Date: February 12, 2016
 * Description: This program prompts the user for a date and then validates that the date is legitimate.
 *
 * Input: total exam points, total homework points, total assignment points
 * Output: total points entered, final letter grade and WHY the grade was assigned
 *
 * Pseudocode for this solution:
 * Begin
 * Create constants for the minimum points required for each grade and combined exam score
 * Initialize the integer variables totalExamPoints, totalHomeworkPoints, totalAssignmentPoints, and totalPoints
 * Initialize the string variable finalLetterGrade
 * Prompt for and get the user's total exam points
 *      store the value in the variable totalExamPoints
 * Check if the total exam points are greater than zero
 *      if not, throw an error string
 * Check if total homework points is greater than or equal to zero
 *      if not, throw an error string
 * Check if total assignment points is greater than or equal to zero
 *      if not, throw an error string
 * If all of the above are greater than or equal to zero
 *      add them all together
 *      check if the total points is greater than the minimum for an A
 *          if yes, set finalGrade equal to A
 *      check if the total points is greater than the minimum for a B
 *          if yes, set finalGrade equal to B
 *      check if the total points is greater than the minimum for a C
 *          if yes, set finalGrade equal to C
 *      check if the total points is greater than the minimum for a D
 *          if yes, set finalGrade equal to D
 *      check if the total points is greater than the minimum for an F
 *          if yes, set finalGrade equal to F
 * Print The total points entered is: " + totalPoints
 * Print Your final grade is: " + finalLetterGrade + ".
 * Print You received this grade because you scored " + totalPoints + " out of " + MAX_POINTS + ".
 * End
 */

import java.util.Scanner;

public class MyGrade {

    public static final int MAX_POINTS = 1000;
    public static final int MIN_POINTS_FOR_GRADE_A = 900;
    public static final int MIN_POINTS_FOR_GRADE_B = 800;
    public static final int MIN_POINTS_FOR_GRADE_C = 700;
    public static final int MIN_POINTS_FOR_GRADE_D = 600;
    public static final int MIN_POINTS_FOR_GRADE_F = 0;
    public static final int MIN_COMBINED_EXAM_POINTS_TO_PASS = 240;

    public static void main(String[] args) {

        int totalExamPoints;
        int totalHomeworkPoints;
        int totalAssignmentPoints;
        int totalPoints;
        String finalLetterGrade = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter total exam points (midterm and final): ");
        totalExamPoints = keyboard.nextInt();

        if (totalExamPoints >= 0) {
            if (totalExamPoints >= MIN_COMBINED_EXAM_POINTS_TO_PASS) {
                System.out.println("Enter total homework points: ");
                totalHomeworkPoints = keyboard.nextInt();

                if (totalHomeworkPoints >= 0) {
                    System.out.println("Enter total assignment points: ");
                    totalAssignmentPoints = keyboard.nextInt();

                    if (totalAssignmentPoints >= 0) {
                        totalPoints = totalExamPoints + totalHomeworkPoints + totalAssignmentPoints;
                        
                        if (totalPoints >= MIN_POINTS_FOR_GRADE_A) {
                            finalLetterGrade = "A";
                        } else if (totalPoints >= MIN_POINTS_FOR_GRADE_B) {
                            finalLetterGrade = "B";
                        } else if (totalPoints >= MIN_POINTS_FOR_GRADE_C) {
                            finalLetterGrade = "C";
                        } else if (totalPoints >= MIN_POINTS_FOR_GRADE_D) {
                            finalLetterGrade = "D";
                        } else if (totalPoints >= MIN_POINTS_FOR_GRADE_F) {
                            finalLetterGrade = "F";
                        } else {
                            System.out.println("You entered an invalid point range.");
                        }

                        System.out.println("The total points entered is: " + totalPoints);
                        System.out.println("Your final grade is: \"" + finalLetterGrade + "\".");
                        System.out.println("You received this grade because you scored " + totalPoints + " out of " + MAX_POINTS + ".");
                    } else {
                        System.out.println("Assignment points cannot be negative.");
                    }
                } else {
                    System.out.println("Homework points cannot be negative.");
                }
            } else {
                System.out.println("You received an \"F\" because your combined midterm and final points are less than 240 points.");
            }
        } else {
            System.out.println("Exam points cannot be negative.");
        }
    }
}
