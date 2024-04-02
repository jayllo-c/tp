package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import javafx.util.Pair;
import seedu.address.commons.exceptions.DataLoadingException;

public class CsvUtilTest {
    private final HashSet<String> compulsoryParameters =
            new HashSet<>(List.of(new String[]{"name", "phone", "email", "address"}));

    private final HashSet<String> optionalParameters = new HashSet<>(
            List.of(new String[]{"matric", "reflection", "studio", "tags"}));
    @Test
    public void readCsvFile_success() throws DataLoadingException {
        Pair<Optional<List<Map<String, String>>>, String> result = CsvUtil.readCsvFile(
                Paths.get("src/test/data/ImportCommandTest/valid.csv"),
                compulsoryParameters,
                optionalParameters);
        String expected = "";
        assertEquals(expected, result.getValue());
    }

    @Test
    public void checkCompulsoryParameters_missingCompulsoryParameter_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.checkCompulsoryParameters(
                        compulsoryParameters,
                        List.of(new String[]{"name", "phone", "email"})));
    }

    @Test
    public void checkCompulsoryParameters_multipleMissingCompulsoryParameters_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.checkCompulsoryParameters(
                        compulsoryParameters,
                        List.of(new String[]{"name"})));
    }

    @Test
    public void checkCompulsoryParameters_success() throws DataLoadingException {
        CsvUtil.checkCompulsoryParameters(
                compulsoryParameters,
                List.of(new String[]{"name", "phone", "email", "address"}));
    }

    @Test
    public void checkCompulsoryParameters_optionalParameter_success() throws DataLoadingException {
        CsvUtil.checkCompulsoryParameters(
                compulsoryParameters,
                List.of(new String[]{"name", "phone", "email", "address", "matric"}));
    }

    @Test
    public void coloumnsToSkip_success() throws DataLoadingException {
        CsvUtil.coloumnsToSkip(
                List.of(new String[]{"name", "phone", "email", "address"}),
                compulsoryParameters,
                optionalParameters);
    }

    @Test
    public void coloumnsToSkip_optionalParameter_success() throws DataLoadingException {
        CsvUtil.coloumnsToSkip(
                List.of(new String[]{"name", "phone", "email", "address", "matric"}),
                compulsoryParameters,
                optionalParameters);
    }

    @Test
    public void coloumnsToSkip_missingCompulsoryParameter_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.coloumnsToSkip(
                        List.of(new String[]{"name", "phone", "email"}),
                        compulsoryParameters,
                        optionalParameters));
    }


}
