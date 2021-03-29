package poker.model.test;

import poker.model.list.DeckOfCards;

public class DeckOfCardTest {

    public static void main(String[] args) {
        DeckOfCards deck = DeckOfCards.newDeck();
        System.out.println(deck.getCard());
        System.out.println(deck.getCard());
        System.out.println(deck.getCard());
        System.out.println(deck.getCard());
        System.out.println(deck.getCard());
        System.out.println(deck.getCard());
    }
}
