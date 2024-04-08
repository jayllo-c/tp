package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class ScoreStatisticsTest {

    @Test
    void testConstructor() {
        ScoreStatistics stats = new ScoreStatistics(50.0, 50.0);
        assertEquals(50.0, stats.getMean());
        assertEquals(50.0, stats.getMedian());
    }

    @Test
    void testNoScoresConstructor() {
        ScoreStatistics stats = new ScoreStatistics();
        assertEquals(-1, stats.getMean());
        assertEquals(-1, stats.getMedian());
    }

    @Test
    void testToString() {
        ScoreStatistics stats = new ScoreStatistics(50.0, 50.0);
        String expected = "Mean: 50, Median: 50";
        assertEquals(expected, stats.toString());

        ScoreStatistics noScoresStats = new ScoreStatistics();
        assertEquals("No scores available", noScoresStats.toString());
    }
}
