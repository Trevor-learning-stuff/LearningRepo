/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment 4
 * Date: February 29, 2016
 *
 * Description: Prompts user for a word, moves the first letter to the back of the word and checks to see if the reverse
 * word is equal to the input word
 *
 * Input: word from a user
 * Output: The word with the first letter moved to the back and read backwards is equal to the input word
 *
 * Pseudocode for this solution:
 * start
 * create string variables inputWord and newWord
 * prompt user for a word
 * while inputWord does not equal quit
 *      create string variables firstLetter and backwardsWord
 *      move the first letter of inputWord to the end of the word
 *      store the results in newWord
 *      add each letter starting from the end of newWord to backwardsWord
 *      check if backwardsWord is equal to inputWord
 *      if it is, print "The word " + inputWord + " has the backward property."
 *      otherwise print "The word " + inputWord + " does not have the backward property."
 *      prompt the user for another word or the word "quit"
 * end
 */
import java.util.Scanner;

public class BackWord {

    public static void main(String[] args) {
        String inputWord;
        String newWord;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a word: ");
        inputWord = keyboard.nextLine();

        while (!inputWord.equalsIgnoreCase("quit")) {
            String firstLetter;
            String backwardsWord = "";

            firstLetter = inputWord.substring(0, 1);
            newWord = inputWord.substring(1) + firstLetter;

            for (int i = newWord.length() - 1; i >= 0; i--) {
                backwardsWord += newWord.charAt(i);
            }

            if (backwardsWord.equalsIgnoreCase(inputWord)) {
                System.out.println("The word " + inputWord + " has the backward property.");
            } else {
                System.out.println("The word " + inputWord + " does not have the backward property.");
            }

            System.out.println("Enter another word or \"quit\".");
            inputWord = keyboard.nextLine();
        }
    }
}