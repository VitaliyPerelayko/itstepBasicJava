package poker.step;


import poker.step.model.Card;
import poker.step.model.CardHand;
import poker.step.model.DeckOfCard;

public class Game {
    public static void main(String[] args) {
        DeckOfCard deck = new DeckOfCard();
        CardHand hand1 = new CardHand(new Card[]{deck.getCard(),
                deck.getCard(), deck.getCard(),
                deck.getCard(), deck.getCard()});
        System.out.println("Hand 1:");
        hand1.printHand();
        System.out.println(hand1.getCombination());
        System.out.println("==========================");
        CardHand hand2 = new CardHand(new Card[]{deck.getCard(),
                deck.getCard(), deck.getCard(),
                deck.getCard(), deck.getCard()});
        System.out.println("Hand 2:");
        hand2.printHand();
        System.out.println(hand2.getCombination());
        System.out.println(hand1.compareTo(hand2));
    }
}
