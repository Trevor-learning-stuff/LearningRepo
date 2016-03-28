import java.util.Scanner;

/**
 * Programmer: Trevor Campbell             CSC110AB programming assignment module 5 part 1
 * Date: March 27, 2016
 * Description: runs a simple hangman game, prompting the user for letter guess and printing if the guesses
 * are correct or now
 *
 * Input: single characters only
 * Output: prints the character into the hidden word or into a list of wrong characters.
 * Also prints the total number of guesses and the total number of bad guesses
 *
 * Pseudocode for this solution:
 *
 * Begin
 * Initialize all of the required variables for the game
 * Prompts the user for a single character input
 * Checks if the users input is valid
 * repeat the following until the secret word is decoded
 *      if the input is valid, checks if the character is correct or not
 *      if the character is in the secret word, decode the hidden word for that character
 *      if the character is not in the word, add it to a list of bad guesses
 * Once the secret word is decoded, Print a congratulations message
 * End
 */


public class Hangman {

    private String secretWord = "";
    private String disguisedWord = "";
    private String incorrectGuesses = "";
    private int numberOfGuesses = 0;
    private int numberOfIncorrectGuesses = 0;

    public String getSecretWord() {
        return secretWord;
    }

    public String getDisguisedWord() {
        return disguisedWord;
    }

    private boolean isFound() {
        return disguisedWord.equals(secretWord);
    }

    public void initialize(String word){
        secretWord = word.toLowerCase();

        for (int i = 0; i <= secretWord.length() - 1; i++) {
            disguisedWord += "?";
        }

        incorrectGuesses = "";
        numberOfGuesses = 0;
        numberOfIncorrectGuesses = 0;
    }

    private void makeGuess(char c) {
        if (secretWord.contains("" + c)) {
            disguisedWord = reformatDisguisedWord(c);
            numberOfGuesses++;
        }else{
            numberOfGuesses++;
            numberOfIncorrectGuesses++;
            incorrectGuesses += c;
        }

    }

    private String reformatDisguisedWord(char c1) {
        String newDisguisedSecret = "";

        for (int i = 0; i < secretWord.length(); i++)
            if (secretWord.charAt(i) == c1)
                newDisguisedSecret += secretWord.charAt(i);
            else
                newDisguisedSecret += disguisedWord.charAt(i);

        return disguisedWord = newDisguisedSecret;
    }

    private char promptLetterGuess() {
        Scanner keyboard = new Scanner(System.in);
        String guessedLetter;

        System.out.print("Guess a letter: ");
        guessedLetter = keyboard.next().toLowerCase();

        if (disguisedWord.contains(guessedLetter) || incorrectGuesses.contains(guessedLetter)){
            while (disguisedWord.contains(guessedLetter) || incorrectGuesses.contains(guessedLetter)) {
                System.out.println("Already guessed that one, try again.");
                System.out.print("Guess a letter: ");
                guessedLetter = keyboard.next().toLowerCase();
                numberOfGuesses++;
            }
        }
        if (("" + guessedLetter).length() > 1){
            System.out.println("Sorry, bad guess. Need a single letter.");
            System.out.print("Guess a letter: ");
            guessedLetter = keyboard.next().toLowerCase();
        }

        return guessedLetter.charAt(0);
    }

    public void playGame() {

        while (!isFound()) {
            System.out.println("\nThe disguised word is <" + getDisguisedWord() + ">");
            makeGuess(promptLetterGuess());
            System.out.println("Guess made " + numberOfGuesses + " with " + numberOfIncorrectGuesses + " wrong (" + incorrectGuesses + ")");

        }

        System.out.println("Congratulations, you found the secret word: " + getSecretWord());
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.initialize("Happiness");
        System.out.println("Lets play a round of hangman.");
        game.playGame();
    }
}
