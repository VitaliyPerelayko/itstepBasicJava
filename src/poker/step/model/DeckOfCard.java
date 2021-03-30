package poker.step.model;


import poker.step.model.enums.Suit;
import poker.step.model.enums.Value;

import java.util.Random;

public class DeckOfCard {

    private Card[] deck = new Card[52];
    private int size = 52;
    private Random random = new Random();

    public DeckOfCard() {
        int counter = 0;
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck[counter++] = new Card(suit, value);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Card getCard() {
        int index = random.nextInt(size);
        Card res = deck[index];
        deck[index] = deck[size - 1];
        size--;
        return res;
    }
}
