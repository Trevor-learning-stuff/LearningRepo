package Program4;

import java.util.Random;

/**
 * Created by trevor.campbell on 10/2/16.
 * This class contains functions to manipulate a hand of cards.
 */
public class DeckHand {
    private Card[] _deck;
    private int _handSize;
    private static int ALLOC = 52;
    private static Random generator = new Random();

    public DeckHand() {
        _deck = new Card[ALLOC];
        _handSize = 0;
    }

    public int getSize() {
        return _handSize;
    }

    public int countOfValue(int value) {
        int count = 0;
        for (int i = 0; i < _handSize; ++i) {
            if (_deck[i].getValue() == value) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < _handSize; ++i) {
            s = _deck[i].toString() + "\n";
        }
        return s;
    }

    public void insertCard(Card card) {
        int position = _deck.length - 1;
        if (_handSize == _deck.length) {
            Card[] temp = new Card[_deck.length + ALLOC];
            for (int i = 0; i < _handSize; ++i) {
                temp[i] = _deck[i];
                _deck = temp;
            }
        }
        _deck[position] = card;
        ++_handSize;
    }

    public Card deleteCardWithValueX(int value) {
        Card deletedCard;
        if (_handSize != 0) {
            for (int i = 0; i < _handSize; ++i) {
                if (_deck[i].getValue() == value) {
                    deletedCard = _deck[i];
                    for (int k = i; k < _deck.length - 1; ++k) {
                        _deck[k] = _deck[k + 1];
                    }
                    --_handSize;
                    return deletedCard;
                }
            }
        }
        return null;
    }

    public Card deleteAnyCard() {
        int cardToDelete = generator.nextInt(14);
        Card deletedCard;
        if (_handSize != 0) {
            for (int i = 0; i < _handSize; ++i) {
                if (_deck[i].getValue() == cardToDelete) {
                    deletedCard = _deck[i];
                    for (int k = i; k < _deck.length - 1; ++k) {
                        _deck[k] = _deck[k + 1];
                    }
                    --_handSize;
                    return deletedCard;
                }
            }
        }
        return null;
    }


}
