package seedu.address.model;

/**
 * Represents the statistics of a list of scores.
 */
public class ScoreStatistics {
    private final double mean;
    private final double median;

    /**
     * Constructs a {@code ScoreStatistics} object with the given statistics.
     */
    public ScoreStatistics(double mean, double median) {
        this.mean = mean;
        this.median = median;
    }

    /**
     * Constructs a {@code ScoreStatistics} object with no scores available.
     */
    public ScoreStatistics() {
        this.mean = -1;
        this.median = -1;
    }

    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    @Override
    public String toString() {
        if (mean == -1) {
            return "No scores available";
        }
        return "Mean: " + mean
                + ", Median: " + median;
    }
}
