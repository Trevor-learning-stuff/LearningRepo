package Program4;

import java.util.Scanner;

/**
 * Created by trevor.campbell on 10/17/16.
 * Test class to test the hierarchy of Card.java and DeckHand.java
 */
public class Program4 {
    private static final int USE_EMPTY_HAND = 1;
    private static final int TOTAL_SUIT = 4;
    private static final int TOTAL_VALUE = 13;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char cont;
        Program4.DeckHand deckHand = new Program4.DeckHand();
        Program4.DeckHand fullDeck = initializeHand();

        do {

            System.out.println("Simple class to test the interaction of a " +
                    "deck deckHand.");

            System.out.println("Which deck would you like to modify:");
            System.out.println("1. Empty deckHand.");
            System.out.println("2. Full deck.");

            int handToUse = in.nextInt();

            System.out.println("Choose a menu option below.");
            System.out.println("1. Insert Card.");
            System.out.println("2. Delete specific card.");
            System.out.println("3. Delete any random card.");
            System.out.println("4. Get total number of cards.");
            System.out.println("5. Print all cards in deckHand.");
            System.out.println("6. Get count of a specific value.");

            int option = in.nextInt();

            if (option == 1) {
                System.out.print("Enter a card suit(1-4): ");
                int suit = in.nextInt();
                System.out.print("Enter a card value(1-13): ");
                int value = in.nextInt();

                Card cardToInsert = new Card(suit, value);

                if (handToUse == USE_EMPTY_HAND) {
                    deckHand.insertCard(cardToInsert);
                    System.out.print(cardToInsert.toString() + " was " +
                            "inserted.");
                } else {
                    fullDeck.insertCard(cardToInsert);
                    System.out.print(cardToInsert.toString() + " was " +
                            "inserted.");
                }

            } else if (option == 2) {
                System.out.println("Enter a card value to delete(1-13): ");
                int valueToDelete = in.nextInt();
                Card deletedCard;

                if (handToUse == USE_EMPTY_HAND) {
                    deletedCard = deckHand.deleteCardWithValueX(valueToDelete);
                    if (isCardNull(deletedCard)) {
                        System.out.println("Nothing to delete.");
                    } else {
                        System.out.print(deletedCard.toString() + " was " +
                                "deleted.");
                    }
                } else {
                    deletedCard = fullDeck.deleteCardWithValueX(valueToDelete);
                    System.out.print(deletedCard.toString() + " was " +
                            "deleted.");
                }
            } else if (option == 3) {
                Card deletedCard;
                if (handToUse == USE_EMPTY_HAND) {
                    deletedCard = deckHand.deleteAnyCard();
                    if (isCardNull(deletedCard)) {
                        System.out.print("Nothing to delete.");
                    } else {
                        System.out.print(deletedCard.toString() + " was " +
                                "deleted.");
                    }
                } else {
                    deletedCard = fullDeck.deleteAnyCard();
                    System.out.print(deletedCard.toString() + " was " +
                            "deleted.");
                }

            } else if (option == 4){
                if (handToUse == USE_EMPTY_HAND) {
                    System.out.println(deckHand.getSize() + " cards.");
                } else {
                    System.out.println(fullDeck.getSize() + " cards.");
                }

            } else if (option == 5){
                if (handToUse == USE_EMPTY_HAND) {
                    if (deckHand.getSize() > 0) {
                        System.out.println(deckHand.toString());
                    } else {
                        System.out.println("DeckHand is empty.");
                    }
                } else {
                    System.out.println(fullDeck.toString());
                }

            } else if (option == 6){
                System.out.print("Enter value to be searched: ");
                int value = in.nextInt();
                if (handToUse == USE_EMPTY_HAND) {
                    if (deckHand.getSize() > 0) {
                        System.out.println(deckHand.countOfValue(value) + " of " +
                                value + "'s");
                    }
                } else {
                    System.out.println(fullDeck.countOfValue(value) + " of " +
                            value + "'s");
                }
            }

            System.out.println("\nWould you like to continue(Y/N)? ");
            cont = in.next().charAt(0);

        } while (cont == 'Y' || cont == 'y');
    }

    private static boolean isCardNull(Card card) {
        return card == null;
    }

    private static Program4.DeckHand initializeHand() {
        //init full deckHand
        Program4.DeckHand fullDeck = new Program4.DeckHand();
        for (int i = 1; i <= TOTAL_SUIT; ++i) {
            for (int k = 1; k <= TOTAL_VALUE; ++k) {
                fullDeck.insertCard(new Card(i, k));
            }
        }
        return fullDeck;
    }
}
