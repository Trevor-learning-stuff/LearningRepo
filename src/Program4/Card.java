package Program4;

/**
 * Created by trevor.campbell on 10/2/16.
 * This class describes a card.
 */
public class Card {
    private static final int ACE = 1;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private int _suit;
    private int _value;

    public Card(int suit, int value) {
        _suit = suit;
        _value = value;
    }

    public int getSuit() {
        return _suit;
    }

    public int getValue() {
        return _value;
    }

    public String toString() {
        String suit;

        if (_suit == 1) {
            suit = "Hearts";
        } else if (_suit == 2) {
            suit = "Spades";
        } else if (_suit == 3) {
            suit = "Diamonds";
        } else {
            suit = "Clubs";
        }

        if (_value == ACE) {
            return "Ace of " + suit;
        } else if (_value == JACK) {
            return "Jack of " + suit;
        } else if (_value == QUEEN) {
            return "Queen of " + suit;
        } else if (_value == KING) {
            return "King of " + suit;
        } else if (_value > 0 && _value < 11) {
            return _value + " of " + suit;
        } else {
            return "Nothing";
        }
    }
}
