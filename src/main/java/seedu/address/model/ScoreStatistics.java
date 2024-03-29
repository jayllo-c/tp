package seedu.address.model;

/**
 * Represents the statistics of a list of scores.
 */
public class ScoreStatistics {
    private final double mean;
    private final double median;
    private final double min;
    private final double max;
    private final double q1;
    private final double q3;

    /**
     * Constructs a {@code ScoreStatistics} object with the given statistics.
     */
    public ScoreStatistics(double mean, double median, double min, double max, double q1, double q3) {
        this.mean = mean;
        this.median = median;
        this.min = min;
        this.max = max;
        this.q1 = q1;
        this.q3 = q3;
    }

    /**
     * Constructs a {@code ScoreStatistics} object with no scores available.
     */
    public ScoreStatistics() {
        this.mean = -1;
        this.median = -1;
        this.min = -1;
        this.max = -1;
        this.q1 = -1;
        this.q3 = -1;
    }

    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getQ1() {
        return q1;
    }

    public double getQ3() {
        return q3;
    }

    @Override
    public String toString() {
        if (mean == -1) {
            return "No scores available";
        }
        return "Mean: " + mean
                + ", Median: " + median
                + ", Min: " + min
                + ", Max: " + max
                + ", Q1: " + q1
                + ", Q3: " + q3;
    }
}
