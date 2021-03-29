package poker.model.test;

import static poker.model.test.TestData.PAIR;
import static poker.model.test.TestData.ROYAL_FLUSH;

public class CardHandTest {

    public static void main(String[] args) {
        System.out.println(PAIR.compareTo(ROYAL_FLUSH));
    }

}
