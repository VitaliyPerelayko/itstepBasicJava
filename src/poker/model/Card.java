package poker.model;

import poker.model.enums.Suit;
import poker.model.enums.Value;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card() {
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public int compareTo(Card card) {
        int value1 = this.value.ordinal();
        int value2 = card.value.ordinal();
        return Integer.compare(value2, value1);
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
