package poker.model.test;

import poker.model.list.CardList;

import static poker.model.test.TestData.*;

public class CardListTest {
    public static void main(String[] args) {
        CardList cl = new CardList(ASE_HEARTS, TEN_HEARTS, QUEEN_HEARTS);
        System.out.println(cl.getSize());
        cl.forEach(System.out::println);
        cl.sortByValue();
        cl.forEach(System.out::println);
    }
}
