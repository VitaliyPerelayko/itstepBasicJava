package poker.model.list;

import poker.model.Card;
import poker.model.enums.Suit;
import poker.model.enums.Value;

import java.util.Random;

public class DeckOfCards {
    public static final int MAX_SIZE = 52;
    private int size = 0;
    private final Random random = new Random();
    private Element last;

    private DeckOfCards() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                add(new Card(suit, value));
            }
        }
    }

    public static DeckOfCards newDeck() {
        return new DeckOfCards();
    }

    public int getSize() {
        return size;
    }

    public Card getCard() {
        int index = random.nextInt(size);
        Element element = last;
        for (int i = size - 1; i > index; i--) {
            element = element.prev;
        }
        return remove(element);
    }

    private void add(Card card) {
        Element newEl = new Element(card, last, null);
        if (last != null) {
            last.next = newEl;
        }
        last = newEl;
        size++;
    }

    // FIXME add validations on element
    private Card remove(Element element) {
        Card rez = element.card;
        Element prev = element.prev;
        Element next = element.next;
        if (prev != null) {
            prev.next = next;
            element.prev = null;
        }
        if (next != null) {
            next.prev = prev;
            element.next = null;
        }
        element.card = null;
        size--;
        return rez;
    }

    private static class Element {
        Card card;
        Element prev;
        Element next;

        Element(Card card, Element prev, Element next) {
            this.card = card;
            this.prev = prev;
            this.next = next;
        }

        boolean isEqual(Element el) {
            return card.equals(el.card);
        }
    }
}
