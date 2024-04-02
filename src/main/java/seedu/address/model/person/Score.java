package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.DecimalFormat;

/**
 * Represents an Exam's score in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidScore(String)}
 */
public class Score implements Comparable<Score> {

    public static final String MESSAGE_CONSTRAINTS =
            "Scores should be numeric, and it should not be blank or less than zero. "
            + "Scores can have up to 2 decimal places.";

    /*
     * The score must be a non-negative integer. and only have
     */
    public static final String VALIDATION_REGEX = "^\\d+(\\.\\d{1,2})?$";

    public final double value;

    /**
     * Constructs a {@code Score}.
     *
     * @param score A valid score.
     */
    public Score(double score) {
        requireNonNull(score);
        checkArgument(isValidScore(score), MESSAGE_CONSTRAINTS);
        this.value = score;
    }

    /**
     * Returns true if a given string is a valid score.
     * IMPT: This method breaks when the score has more than 9 digits as
     * the string representation of the score will be in scientific notation. However, scores are
     * limited to 2 decimal places and 9 digits total.
     */
    public static boolean isValidScore(double test) {
        String str = Double.toString(test);
        return str.matches(VALIDATION_REGEX);
    }

    public static boolean isValidScoreString(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public double getScore() {
        return value;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Score)) {
            return false;
        }

        Score otherScore = (Score) other;
        return value == otherScore.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public int compareTo(Score o) {
        return Double.compare(this.value, o.value);
    }
}
