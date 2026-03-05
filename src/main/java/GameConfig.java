public class GameConfig {

    private int numberOfGuesses;
    private int numberOfRounds;
    private int minValue;
    private int maxValue;

    public GameConfig(int maxPerRound, int maxRounds, int minNumber, int maxNumber) {
        this.numberOfGuesses = maxPerRound;
        this.numberOfRounds = maxRounds;
        this.minValue = minNumber;
        this.maxValue = maxNumber;
    }

    public int getMaxGuessNumber() {
        return numberOfGuesses;
    }

    public int getMaxRoundNumber() {
        return numberOfRounds;
    }

    public int getMin() {
        return minValue;
    }

    public int getMax() {
        return maxValue;
    }

}
