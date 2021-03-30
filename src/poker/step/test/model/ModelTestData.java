package poker.step.test.model;


import poker.step.model.Card;
import poker.step.model.CardHand;
import poker.step.model.enums.Suit;
import poker.step.model.enums.Value;

public interface ModelTestData {
    //HEARTS
    Card ASE_HEART = new Card(Suit.HEARTS, Value.ACE);
    Card KING_HEART = new Card(Suit.HEARTS, Value.KING);
    Card QUEEN_HEART = new Card(Suit.HEARTS, Value.QUEEN);
    Card LACK_HEART = new Card(Suit.HEARTS, Value.JACK);
    Card TEN_HEART = new Card(Suit.HEARTS, Value.TEN);
    Card NINE_HEART = new Card(Suit.HEARTS, Value.NINE);
    Card EIGHT_HEART = new Card(Suit.HEARTS, Value.EIGHT);
    Card SEVEN_HEART = new Card(Suit.HEARTS, Value.SEVEN);
    Card SIX_HEART = new Card(Suit.HEARTS, Value.SIX);
    Card FIVE_HEART = new Card(Suit.HEARTS, Value.FIVE);
    Card FOUR_HEART = new Card(Suit.HEARTS, Value.FOUR);
    Card THREE_HEART = new Card(Suit.HEARTS, Value.THREE);
    Card TWO_HEART = new Card(Suit.HEARTS, Value.THO);
    //CLUBS
    Card ASE_CLUBS = new Card(Suit.CLUBS, Value.ACE);
    Card KING_CLUBS = new Card(Suit.CLUBS, Value.KING);
    Card QUEEN_CLUBS = new Card(Suit.CLUBS, Value.QUEEN);
    Card LACK_CLUBS = new Card(Suit.CLUBS, Value.JACK);
    Card TEN_CLUBS = new Card(Suit.CLUBS, Value.TEN);
    Card NINE_CLUBS = new Card(Suit.CLUBS, Value.NINE);
    Card EIGHT_CLUBS = new Card(Suit.CLUBS, Value.EIGHT);
    Card SEVEN_CLUBS = new Card(Suit.CLUBS, Value.SEVEN);
    Card SIX_CLUBS = new Card(Suit.CLUBS, Value.SIX);
    Card FIVE_CLUBS = new Card(Suit.CLUBS, Value.FIVE);
    Card FOUR_CLUBS = new Card(Suit.CLUBS, Value.FOUR);
    Card THREE_CLUBS = new Card(Suit.CLUBS, Value.THREE);
    Card TWO_CLUBS = new Card(Suit.CLUBS, Value.THO);
    //

    CardHand TEN_PAIR = new CardHand(
            new Card[]{TEN_CLUBS, TEN_HEART, TWO_CLUBS,
                    KING_CLUBS, ASE_HEART});
    CardHand KING_PAIR = new CardHand(
            new Card[]{KING_CLUBS, KING_CLUBS, TWO_CLUBS,
                    QUEEN_CLUBS, ASE_HEART});
}
