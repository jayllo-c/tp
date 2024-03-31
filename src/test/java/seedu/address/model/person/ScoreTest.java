package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    public void constructor_invalidScore_throwsIllegalArgumentException() {
        int invalidScore = -1;
        assertThrows(IllegalArgumentException.class, () -> new Score(invalidScore));
    }

    @Test
    public void isValidScore() {
        // negative score
        assertFalse(Score.isValidScore(-1));
        // zero score
        assertTrue(Score.isValidScore(0));
        // positive score
        assertTrue(Score.isValidScore(1));
        // zero with 1 decimal place
        assertTrue(Score.isValidScore(0.1));
        // zero with 2 decimal places
        assertTrue(Score.isValidScore(0.01));
        // zero with 3 decimal places
        assertFalse(Score.isValidScore(0.001));
        // negative with 1 decimal place
        assertFalse(Score.isValidScore(-0.1));
        // negative with 2 decimal places
        assertFalse(Score.isValidScore(-0.01));
        // 1 with 1 decimal place
        assertTrue(Score.isValidScore(1.1));
        // 1 with 2 decimal places
        assertTrue(Score.isValidScore(1.01));
        // 1 with 3 decimal places
        assertFalse(Score.isValidScore(1.001));

    }

    @Test
    public void getScore() {
        int scoreValue = 100;
        Score score = new Score(scoreValue);
        assertEquals(scoreValue, score.getScore());
    }

    @Test
    public void testToString() {
        double scoreValue = 100;
        Score score = new Score(scoreValue);
        assertEquals("100", score.toString());
    }

    @Test
    public void testEquals() {
        Score scoreA = new Score(100);
        Score scoreB = new Score(100);
        Score scoreC = new Score(200);

        // same object -> returns true
        assertTrue(scoreA.equals(scoreA));

        // same values -> returns true
        assertTrue(scoreA.equals(scoreB));

        // different types -> returns false
        assertFalse(scoreA.equals(1));

        // null -> returns false
        assertFalse(scoreA.equals(null));

        // different score -> returns false
        assertFalse(scoreA.equals(scoreC));
    }

    @Test
    public void testHashCode() {
        double scoreValue = 100.25;
        Score score = new Score(scoreValue);
        assertEquals(Double.hashCode(scoreValue), score.hashCode());
    }
}
