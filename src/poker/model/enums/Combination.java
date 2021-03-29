package poker.model.enums;

public enum Combination {
    ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR_OF_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_KIND, TWO_PAIRS, PAIR, HIGH_CARD;

    /**
     * weight is ordinal of highest card's value in combination
     */
    private int weight;
    /**
     * the second most important weight
     */
    private int juniorWeight;
    private int kicker;

    public int getWeight() {
        return weight;
    }

    public Combination setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int getJuniorWeight() {
        return juniorWeight;
    }

    public Combination setJuniorWeight(int juniorWeight) {
        this.juniorWeight = juniorWeight;
        return this;
    }

    public int getKicker() {
        return kicker;
    }

    public Combination setKicker(int kicker) {
        this.kicker = kicker;
        return this;
    }
}
