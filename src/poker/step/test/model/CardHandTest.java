package poker.step.test.model;


import poker.step.model.CardHand;

import static poker.step.test.model.ModelTestData.KING_PAIR;
import static poker.step.test.model.ModelTestData.TEN_PAIR;


public class CardHandTest {

    private static void printHandInfo(CardHand cardHand) {
        System.out.println("=================");
        cardHand.printHand();

        System.out.println("COMBINATION  " + cardHand.getCombination());
        System.out.println("WEIGHT  " + cardHand.getCombination().getWeight());
        System.out.println("SECOND WEIGHT  " + cardHand.getCombination().getJuniorWeight());
        System.out.println("KICKER  " + cardHand.getCombination().getKicker());
    }

    public static void main(String[] args) {
        printHandInfo(TEN_PAIR);
        printHandInfo(KING_PAIR);
        System.out.println(KING_PAIR.compareTo(TEN_PAIR));
    }
}
