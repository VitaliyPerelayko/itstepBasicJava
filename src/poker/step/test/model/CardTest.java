package poker.step.test.model;


import static poker.step.test.model.ModelTestData.*;

public class CardTest {
    public static void main(String[] args) {
        // equals test
        System.out.println(ASE_HEART.equals(ASE_HEART));
        System.out.println(ASE_HEART.equals(ASE_CLUBS));
        // compare test
        System.out.println(ASE_HEART.compareTo(ASE_CLUBS));
        System.out.println(ASE_HEART.compareTo(TEN_CLUBS));
    }
}
