package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArgumentMultiMapTest {

    private ArgumentMultimap testArgumentMultimap = new ArgumentMultimap();
    private Prefix testPrefix = new Prefix("n/");
    private Prefix testPrefix2 = new Prefix("e/");
    private Prefix preamblePrefix = new Prefix("");

    @Test
    public void testisSinglePrefix_onePrefix_returnTrue() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(testPrefix, "Alice");
        assertEquals(true, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_multiplePrefixes_returnFalse() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(testPrefix, "Alice");
        testArgumentMultimap.put(testPrefix2, "alice@gmail.com");
        assertEquals(false, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_emptyMultimap_returnFalse() {
        testArgumentMultimap = new ArgumentMultimap();
        assertEquals(false, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_onlyPreamble_returnFalse() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(preamblePrefix, "preamble");
        assertEquals(false, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_preambleAndPrefix_returnFalse() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(preamblePrefix, "preamble");
        testArgumentMultimap.put(testPrefix, "Alice");
        assertEquals(false, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_emptyPreambleAndPrefix_returnTrue() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(preamblePrefix, "");
        testArgumentMultimap.put(testPrefix, "Alice");
        assertEquals(true, testArgumentMultimap.isSinglePrefix());
    }

    @Test
    public void testisSinglePrefix_emptyPreambleAndMultiplePrefix_returnFalse() {
        testArgumentMultimap = new ArgumentMultimap();
        testArgumentMultimap.put(preamblePrefix, "");
        testArgumentMultimap.put(testPrefix, "Alice");
        testArgumentMultimap.put(testPrefix2, "alice@gmail.com");
        assertEquals(false, testArgumentMultimap.isSinglePrefix());
    }
}
