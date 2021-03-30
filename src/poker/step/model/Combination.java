package poker.step.model;


import poker.step.model.enums.Combinations;

public class Combination {

    private Combinations combination;
    /**
     * weight is ordinal of highest card's value in combination
     */
    private int weight = 20;
    /**
     * the second most important weight
     */
    private int juniorWeight = 20;
    private int kicker = 20;

    public Combination(Combinations combination, int weight,
                       int juniorWeight, int kicker) {
        this.combination = combination;
        this.weight = weight;
        this.juniorWeight = juniorWeight;
        this.kicker = kicker;
    }

    public Combination(Combinations combination, int weight) {
        this.combination = combination;
        this.weight = weight;
    }

    public Combination(Combinations combination, int weight, int kicker) {
        this.combination = combination;
        this.weight = weight;
        this.kicker = kicker;
    }

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

    public Combinations getCombination() {
        return combination;
    }

    public void setCombination(Combinations combination) {
        this.combination = combination;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "combination=" + combination +
                ", weight=" + weight +
                ", juniorWeight=" + juniorWeight +
                ", kicker=" + kicker +
                '}';
    }
}
