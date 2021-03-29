package poker.model.test;

import poker.model.Card;
import poker.model.CardHand;
import poker.model.enums.Suit;
import poker.model.enums.Value;
import poker.model.list.CardList;

public interface TestData {
     // HEARTS
     Card ASE_HEARTS = new Card(Suit.HEARTS, Value.ACE);
     Card KING_HEARTS = new Card(Suit.HEARTS, Value.KING);
     Card QUEEN_HEARTS = new Card(Suit.HEARTS, Value.QUEEN);
     Card JACK_HEARTS = new Card(Suit.HEARTS, Value.JACK);
     Card TEN_HEARTS = new Card(Suit.HEARTS, Value.TEN);
     Card NINE_HEARTS = new Card(Suit.HEARTS, Value.NINE);
     Card EIGHT_HEARTS = new Card(Suit.HEARTS, Value.EIGHT);
     // DIAMONDS
     Card ASE_DIAMONDS = new Card(Suit.DIAMONDS, Value.ACE);
     Card KING_DIAMONDS = new Card(Suit.DIAMONDS, Value.KING);
     Card QUEEN_DIAMONDS = new Card(Suit.DIAMONDS, Value.QUEEN);
     Card JACK_DIAMONDS = new Card(Suit.DIAMONDS, Value.JACK);
     Card TEN_DIAMONDS = new Card(Suit.DIAMONDS, Value.TEN);
     Card NINE_DIAMONDS = new Card(Suit.DIAMONDS, Value.NINE);
     Card EIGHT_DIAMONDS = new Card(Suit.DIAMONDS, Value.EIGHT);

     CardHand ROYAL_FLUSH = new CardHand(new CardList(ASE_HEARTS, KING_HEARTS, QUEEN_HEARTS, JACK_HEARTS, TEN_HEARTS));
     CardHand PAIR = new CardHand(new CardList(ASE_HEARTS, ASE_DIAMONDS, QUEEN_HEARTS, JACK_HEARTS, TEN_HEARTS));
}
