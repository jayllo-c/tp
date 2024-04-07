package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.io.IOException;
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
    public void readCsvFile_success() throws IOException {
        Pair<Optional<List<Map<String, String>>>, String> result = CsvUtil.readCsvFile(
                Paths.get("src/test/data/ImportCommandTest/valid.csv"),
                compulsoryParameters,
                optionalParameters);
        String expected = "";
        assertEquals(expected, result.getValue());
    }

    @Test
    public void readCsvFile_multipleMissingCompulsoryParameter_failure() throws IOException {
        String expected = "Missing compulsory header(s) in Csv file: phone, name,";
        assertEquals(expected,
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/ImportCommandTest/multipleCompulsoryParameterHeadersMissing.csv"),
                        compulsoryParameters,
                        optionalParameters).getValue());
    }

    @Test
    public void readCsvFile_inconsistentLengthInRow_failure() throws IOException {
        String expected =
                "Row 0 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n"
                + "Row 1 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n"
                + "Row 2 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n"
                + "Row 4 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n"
                + "Row 5 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n"
                + "Row 6 does not have the same number of values as the number of headers.Given: 8, Expected: 7\n";
        assertEquals(expected,
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/ImportCommandTest/inconsistentRowLength.csv"),
                        compulsoryParameters,
                        optionalParameters).getValue());
    }

    @Test
    public void readCsvFile_missingOptionalHeader_success() throws IOException {
        Pair<Optional<List<Map<String, String>>>, String> result = CsvUtil.readCsvFile(
                Paths.get("src/test/data/ImportCommandTest/missingOptionalHeader.csv"),
                compulsoryParameters,
                optionalParameters);
        String expected = "";
        assertEquals(expected, result.getValue());
    }

    @Test
    public void readCsvFile_emptyCsv_success() throws IOException {
        Optional<List<Map<String, String>>> expected = Optional.empty();
        assertEquals(expected,
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/ImportCommandTest/empty.csv"),
                        compulsoryParameters,
                        optionalParameters).getKey());
    }

    @Test
    public void readCsvFile_extraHeader_success() throws IOException {
        String expected = "";
        assertEquals(expected,
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/ImportCommandTest/extraHeader.csv"),
                        compulsoryParameters,
                        optionalParameters).getValue());
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
    public void columnsToSkip_success() throws DataLoadingException {
        CsvUtil.columnsToSkip(
                List.of(new String[]{"name", "phone", "email", "address"}),
                compulsoryParameters,
                optionalParameters);
    }

    @Test
    public void columnsToSkip_optionalParameter_success() throws DataLoadingException {
        CsvUtil.columnsToSkip(
                List.of(new String[]{"name", "phone", "email", "address", "matric"}),
                compulsoryParameters,
                optionalParameters);
    }

    @Test
    public void columnsToSkip_missingCompulsoryParameter_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.columnsToSkip(
                        List.of(new String[]{"name", "phone", "email"}),
                        compulsoryParameters,
                        optionalParameters));
    }


}
