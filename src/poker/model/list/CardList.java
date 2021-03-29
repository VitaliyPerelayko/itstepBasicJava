package poker.model.list;

import poker.model.Card;

import java.util.Arrays;
import java.util.Iterator;

public class CardList implements Iterable<Card> {

    private Card[] cardList = new Card[5];
    private byte size = 0;

    public CardList() {
    }

    public CardList(Card... cards) {
        addAll(cards);
    }

    public byte getSize() {
        return size;
    }

    @Override
    public Iterator<Card> iterator() {
        return new Iterator<Card>() {

            byte currentInd;

            @Override
            public boolean hasNext() {
                return currentInd != CardList.this.size;
            }

            @Override
            public Card next() {
                return CardList.this.cardList[currentInd++];
            }
        };
    }

    public void add(Card card) {
        cardList[size++] = card;
    }

    public void addAll(Card... cards) {
        for (Card card : cards) {
            add(card);
        }
    }

    public Card get(int index) {
        return cardList[index];
    }

    public void sortByValue() {
        Arrays.sort(cardList, 0, size);
    }
}
