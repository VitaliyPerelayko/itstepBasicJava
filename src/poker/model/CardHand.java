package poker.model;

import poker.model.enums.Combination;
import poker.model.enums.Suit;
import poker.model.list.CardList;

public class CardHand implements Comparable<CardHand> {

    private static final byte MAX_SIZE = 5;
    private final CardList hand;
    private final Card firstCard;
    private final Card secondCard;
    private final Card thirdCard;
    private final Card forthCard;
    private final Card fifthCard;

    //TODO throw Exception AND validate hand all cards must be different
    public CardHand(CardList hand) {
        if (hand.getSize() != MAX_SIZE) {
            System.out.println("Illegal state");
            //FIXME null is very bad
            this.hand = null;
            firstCard = null;
            secondCard = null;
            thirdCard = null;
            forthCard = null;
            fifthCard = null;
        } else {
            hand.sortByValue();
            this.hand = hand;
            firstCard = hand.get(0);
            secondCard = hand.get(1);
            thirdCard = hand.get(2);
            forthCard = hand.get(3);
            fifthCard = hand.get(4);
        }
    }

    /**
     * @param ch opponent hand
     * @return 0 if hands are equal,
     * 1 if this hand higher than opponent hand,
     * -1 otherwise
     * 5 in some unknown situation
     */
    @Override
    public int compareTo(CardHand ch) {
        Combination thisCombination = this.getCombination();
        Combination opponentCombination = ch.getCombination();
        if (thisCombination.ordinal() < opponentCombination.ordinal()) {
            return 1;
        } else if (thisCombination.ordinal() > opponentCombination.ordinal()) {
            return -1;
        } else {
            int result = Integer.compare(opponentCombination.getWeight(),
                    thisCombination.getWeight());
            switch (thisCombination) {
                case ROYAL_FLUSH:
                    return 0;
                case STRAIGHT_FLUSH:
                case FULL_HOUSE:
                case FOUR_OF_KIND:
                case STRAIGHT:
                case THREE_OF_KIND:
                case HIGH_CARD:
                    return result;
                case FLUSH:
                    return handleFlush(ch);
                case TWO_PAIRS:
                    return handleTwoPairs(result,
                            thisCombination,
                            opponentCombination);
                case PAIR:
                    return handlePair(result,
                            thisCombination,
                            opponentCombination);
            }
        }
        return 5;
    }

    private int handleFlush(CardHand opponentHand) {
        for (byte i = MAX_SIZE - 1; i >= 0; i--) {
            int thisValue = this.hand.get(i).getValue().ordinal();
            int opponentValue = opponentHand.hand.get(i).getValue().ordinal();
            if (thisValue < opponentValue) {
                return 1;
            } else if (thisValue > opponentValue) {
                return -1;
            }
        }
        return 0;
    }

    private int handleTwoPairs(int result,
                               Combination thisCombination,
                               Combination opponentCombination) {
        if (result == 0) {
            int nextResult =
                    Integer.compare(
                            opponentCombination.getJuniorWeight(),
                            thisCombination.getJuniorWeight()
                    );
            if (nextResult == 0) {
                return Integer.compare(
                        opponentCombination.getKicker(),
                        thisCombination.getKicker()
                );
            } else {
                return nextResult;
            }
        } else {
            return result;
        }
    }

    private int handlePair(int result,
                           Combination thisCombination,
                           Combination opponentCombination) {
        if (result == 0) {
            return Integer.compare(
                    opponentCombination.getKicker(),
                    thisCombination.getKicker()
            );
        } else {
            return result;
        }
    }

    private Combination getCombination() {
        //sortHand();
        int weight;
        int[] weights;
        if (isRoyalFlush()) return Combination.ROYAL_FLUSH;
        if ((weight = isStraightFlush()) != -1)
            return Combination.STRAIGHT_FLUSH.setWeight(weight);
        if ((weight = isFourOfKind()) != -1)
            return Combination.FOUR_OF_KIND.setWeight(weight);
        if ((weight = isFullHouse()) != -1)
            return Combination.FULL_HOUSE.setWeight(weight);
        if (isFlush())
            return Combination.FLUSH;
        if ((weight = isStraight()) != -1)
            return Combination.STRAIGHT.setWeight(weight);
        if ((weight = isThreeOfKind()) != -1)
            return Combination.THREE_OF_KIND.setWeight(weight);
        if ((weights = isTwoPairs())[0] != -1)
            return Combination.TWO_PAIRS
                    .setWeight(weights[0])
                    .setJuniorWeight(weights[1])
                    .setKicker(weights[2]);
        if ((weights = isPair())[0] != -1)
            return Combination.PAIR
                    .setWeight(weights[0])
                    .setKicker(weights[1]);
        return Combination.HIGH_CARD.setKicker(fifthCard.getValue().ordinal());
    }

    private boolean isRoyalFlush() {
        return isStraightFlush() == 0;
    }

    private int isStraightFlush() {
        int straightWeight = isStraight();
        if (straightWeight != -1 && isFlush()) {
            return straightWeight;
        }
        return -1;
    }

    private int isFourOfKind() {
        if (firstCard.getValue() == forthCard.getValue()
                || secondCard.getValue() == fifthCard.getValue()) {
            return thirdCard.getValue().ordinal();
        }
        return -1;
    }

    private int isFullHouse() {
        if ((firstCard.getValue() == secondCard.getValue()
                && thirdCard.getValue() == fifthCard.getValue())
                ||
                (firstCard.getValue() == thirdCard.getValue()
                        && forthCard.getValue() == fifthCard.getValue())) {
            return thirdCard.getValue().ordinal();
        }
        return -1;
    }

    private boolean isFlush() {
        byte count = 0;
        Suit suit = firstCard.getSuit();
        for (Card card : hand) {
            if (suit == card.getSuit()) {
                count++;
            }
        }
        return count == 5;
    }

    private int isStraight() {
        int startValue = firstCard.getValue().ordinal();
        for (byte i = 1; i < MAX_SIZE; i++) {
            int value = hand.get(i).getValue().ordinal();
            if (startValue - 1 == value) {
                startValue = value;
            } else {
                return -1;
            }
        }
        return fifthCard.getValue().ordinal();
    }

    private int isThreeOfKind() {
        if (firstCard.getValue() == thirdCard.getValue()
                || secondCard.getValue() == forthCard.getValue()
                || thirdCard.getValue() == fifthCard.getValue()) {
            return thirdCard.getValue().ordinal();
        }
        return -1;
    }

    private int[] isTwoPairs() {
        int[] notTwoPairs = {-1, 0, 0};
        int[] values = {firstCard.getValue().ordinal(), secondCard.getValue().ordinal(),
                thirdCard.getValue().ordinal(), forthCard.getValue().ordinal(), fifthCard.getValue().ordinal()};
        if (values[0] == values[1]) {
            if (values[2] == values[3]) {
                return new int[]{values[2], values[0], values[4]};
            } else if (values[3] == values[4]) {
                return new int[]{values[3], values[0], values[2]};
            } else {
                return notTwoPairs;
            }
        } else if (values[1] == values[2] && values[3] == values[4]) {
            return new int[]{values[3], values[1], values[0]};
        }
        return notTwoPairs;
    }

    private int[] isPair() {
        if (firstCard.getValue() == secondCard.getValue()) {
            return new int[]{firstCard.getValue().ordinal(), fifthCard.getValue().ordinal()};
        }
        if (secondCard.getValue() == thirdCard.getValue()) {
            return new int[]{secondCard.getValue().ordinal(), fifthCard.getValue().ordinal()};
        }
        if (thirdCard.getValue() == forthCard.getValue()) {
            return new int[]{thirdCard.getValue().ordinal(), fifthCard.getValue().ordinal()};
        }
        if (forthCard.getValue() == fifthCard.getValue()) {
            return new int[]{forthCard.getValue().ordinal(), thirdCard.getValue().ordinal()};
        }
        return new int[]{-1, 0};
    }

    private void sortHand() {
        hand.sortByValue();
    }
}
