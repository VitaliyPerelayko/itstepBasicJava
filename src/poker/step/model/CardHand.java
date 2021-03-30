package poker.step.model;

import poker.step.model.enums.Combinations;
import poker.step.model.enums.Suit;

import java.util.Arrays;

public class CardHand implements Comparable<CardHand> {
    public static final byte MAX_SIZE = 5;
    private Card[] hand = new Card[5];

    // TODO verify hand size = 5 and all cards must be different
    public CardHand(Card[] hand) {
        this.hand = hand;
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
        Combination thisCombination = getCombination();
        Combination opponentCombination = ch.getCombination();
        if (thisCombination.getCombination().ordinal() <
                opponentCombination.getCombination().ordinal()) {
            return 1;
        } else if (thisCombination.getCombination().ordinal() >
                opponentCombination.getCombination().ordinal()) {
            return -1;
        } else {
            int result = Integer.compare(opponentCombination.getWeight(),
                    thisCombination.getWeight());
            switch (thisCombination.getCombination()) {
                case ROYAL_FLUSH:
                    return 0;
                case STRAIGHT_FLUSH:
                case FULL_HOUSE:
                case FOR_OF_KIND:
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

    public Combination getCombination() {
        sortHand();
        int weight;
        int[] weights;
        if (isRoyalFlush()) return new Combination(
                Combinations.ROYAL_FLUSH, 0);
        if ((weight = isStraightFlush()) != -1)
            return new Combination(
                    Combinations.STRAIGHT_FLUSH, weight);
        if ((weight = isForOfKind()) != -1)
            return new Combination(Combinations.FOR_OF_KIND, weight);
        if ((weight = isFullHouse()) != -1)
            return new Combination(Combinations.FULL_HOUSE, weight);
        if (isFlush())
            return new Combination(Combinations.FLUSH, 20);
        if ((weight = isStraight()) != -1)
            return new Combination(Combinations.STRAIGHT, weight);
        if ((weight = isThreeOfKind()) != -1)
            return new Combination(Combinations.THREE_OF_KIND, weight);
        if ((weights = isTwoPairs())[0] != -1)
            return new Combination(Combinations.TWO_PAIRS,
                    weights[0], weights[1], weights[2]);
        if ((weights = isPair())[0] != -1)
            return new Combination(Combinations.PAIR,
                    weights[0], weights[1]);
        return new Combination(Combinations.HIGH_CARD,
                hand[4].getValue().ordinal());
    }

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    private int handleFlush(CardHand opponentHand) {
        for (int i = MAX_SIZE - 1; i >= 0; i--) {
            int thisValue = this.hand[i].getValue().ordinal();
            int opponentValue = opponentHand.hand[i].getValue().ordinal();
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

    private boolean isRoyalFlush() {
        return isStraightFlush() == 0;
    }

    private int isStraightFlush() {
        int straightWeight = isStraight();
        if (isFlush() && straightWeight != -1) {
            return straightWeight;
        }
        return -1;
    }

    private int isForOfKind() {
        if (hand[0].getValue() == hand[3].getValue()
                || hand[1].getValue() == hand[4].getValue()) {
            return hand[2].getValue().ordinal();
        }
        return -1;
    }

    private int isFullHouse() {
        if ((hand[0].getValue() == hand[2].getValue()
                && hand[3].getValue() == hand[4].getValue())
                ||
                (hand[0].getValue() == hand[1].getValue()
                        && hand[2].getValue() == hand[4].getValue())) {
            return hand[3].getValue().ordinal();
        }
        return -1;
    }

    private boolean isFlush() {
        int count = 1;
        Suit suit = hand[0].getSuit();
        for (int i = 1; i < MAX_SIZE; i++) {
            if (hand[i].getSuit() == suit) count++;
        }
        return count == 5;
    }

    private int isStraight() {
        int firstValue = hand[0].getValue().ordinal();
        for (int i = 1; i < MAX_SIZE; i++) {
            int nextValue = hand[i].getValue().ordinal();
            if (firstValue + 1 == nextValue) {
                firstValue = nextValue;
            } else {
                return -1;
            }
        }
        return hand[4].getValue().ordinal();
    }

    private int isThreeOfKind() {
        if (hand[0].getValue() == hand[2].getValue()
                || hand[1].getValue() == hand[3].getValue()
                || hand[2].getValue() == hand[4].getValue()) {
            return hand[2].getValue().ordinal();
        }
        return -1;
    }

    private int[] isTwoPairs() {
        int[] not = {-1, 0, 0};
        int[] values = {hand[0].getValue().ordinal(),
                hand[1].getValue().ordinal(),
                hand[2].getValue().ordinal(),
                hand[3].getValue().ordinal(),
                hand[4].getValue().ordinal()};
        if (values[0] == values[1]) {
            if (values[2] == values[3]) {
                return new int[]{values[2], values[0], values[4]};
            } else if (values[3] == values[4]) {
                return new int[]{values[3], values[0], values[2]};
            } else {
                return not;
            }
        } else if (values[1] == values[2] && values[3] == values[4]) {
            return new int[]{values[3], values[1], values[0]};
        }
        return not;
    }

    private int[] isPair() {
        int[] values = {hand[0].getValue().ordinal(),
                hand[1].getValue().ordinal(),
                hand[2].getValue().ordinal(),
                hand[3].getValue().ordinal(),
                hand[4].getValue().ordinal()};
        if (values[0] == values[1])
            return new int[]{values[0], values[4]};
        if (values[1] == values[2])
            return new int[]{values[1], values[4]};
        if (values[2] == values[3])
            return new int[]{values[2], values[4]};
        if (values[3] == values[4])
            return new int[]{values[3], values[2]};
        return new int[]{-1, 0};
    }

    private void sortHand() {
        Arrays.sort(hand);
    }
}
