package Program4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by trevor.campbell on 10/20/16.
 * Class to play Go Fish
 */
public class Program4Phase2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        System.out.println("Program to play Go Fish!");
        do {

            System.out.println("1. Test the DeckHand");
            System.out.println("2. Play \"Go Fish\"");
            System.out.println("3. Quit");

            option = input.nextInt();

            if (option == 1) {
                new Program4.Program4();
            } else if (option == 2) {
                Program4.DeckHand stock = initStock();
                Program4.DeckHand playerHand = new Program4.DeckHand();
                Program4.DeckHand compHand = new Program4.DeckHand();
                int playerBooks = 0;
                int compBooks = 0;
                boolean continueGame = stock.getSize() > 0 &&
                        (compHand.getSize() > 0 && playerHand.getSize() > 0);

                //deal cards 7 cards
                for (int i = 0; i < 8; ++i) {
                    playerHand.insertCard(dealCard(stock));
                    compHand.insertCard(dealCard(stock));
                }

                boolean correctGuess = false;
                do {
                    //players turn
                    do {
                        System.out.println("Your hand:");
                        for (int i = 0; i < playerHand.getSize(); ++i) {
                            System.out.print(playerHand.toString());

                        }
                        System.out.print("Enter card value to guess(1-13): ");
                        int guessedValue = input.nextInt();
                        int countOfValue = compHand.countOfValue(guessedValue);

                        if (countOfValue > 0) {
                            for (int i = 0; i < countOfValue; ++i) {
                                playerHand.insertCard(
                                        compHand.deleteCardWithValueX(
                                                guessedValue));
                                correctGuess = true;
                            }
                        } else {
                            System.out.println("Go Fish!");
                            Card drawnCard = stock.deleteAnyCard();
                            if (drawnCard.getValue() == guessedValue) {
                                correctGuess = true;
                                System.out.print(drawnCard.toString() + "was"
                                        + "drawn! Take another turn!");
                            } else {
                                correctGuess = false;
                            }
                        }
                        playerBooks += findBooks(playerHand);
                        hold();

                    } while (correctGuess);

                    //computer's turn
                    do {
                        int guessedValue = generateGuess();
                        int countOfValues = playerHand.countOfValue(
                                guessedValue);
                        System.out.println("The computer asked for " +
                                guessedValue);

                        if (countOfValues > 0) {
                            compHand.insertCard(
                                    playerHand.deleteCardWithValueX(
                                            guessedValue));
                            correctGuess = true;
                        } else {
                            Card drawnCard = stock.deleteAnyCard();
                            if (drawnCard.getValue() == guessedValue) {
                                correctGuess = true;
                                System.out.println("The computer drew the " +
                                        "asked for card!");
                            } else {
                                correctGuess = false;
                            }
                        }
                        compBooks += findBooks(compHand);
                        hold();

                    } while (correctGuess);

                    if (!continueGame) {
                        //find the winner
                        if (playerBooks > compBooks) {
                            System.out.println("Congrats! You won!");
                            hold();
                        } else {
                            System.out.println("You lost. Try again next " +
                                    "time!");
                            hold();
                        }
                    }

                } while (continueGame);

            }

        } while (option != 3);
    }

    private static void hold() {
        System.out.print("Press enter to continue: ");
        input.next();
    }

    private static int generateGuess() {
        int val = 0;
        Random generator = new Random();
        for (int i = 0; i == 0; ++i) {
            val = generator.nextInt(14);
        }
        return val;
    }

    private static Program4.DeckHand initStock() {
        Program4.DeckHand fullDeck = new Program4.DeckHand();
        for (int i = 1; i <= 4; ++i) {
            for (int k = 1; k <= 13; ++k) {
                fullDeck.insertCard(new Card(i, k));
            }
        }
        return fullDeck;
    }

    private static Card dealCard(Program4.DeckHand fullDeck) {
        return fullDeck.deleteAnyCard();
    }

    private static int findBooks(Program4.DeckHand deckHand) {
        int totalbooks = 0;
        for (int i = 1; i <= 13; ++i) {
            if (deckHand.countOfValue(i) == 4) {
                for (int k = 0; k < 4; ++k) {
                    deckHand.deleteCardWithValueX(i);
                }
                totalbooks++;
                System.out.println("Laid down a book of " + i + "'s");
            }
        }
        return totalbooks;
    }

}
