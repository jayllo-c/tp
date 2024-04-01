package seedu.address.commons.util;

import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class CsvUtilTest {
    private final HashSet<String> compulsoryParameters =
            new HashSet<>(List.of(new String[]{"name", "phone", "email", "address"}));

    private final HashSet<String> optionalParameters = new HashSet<>(
            List.of(new String[]{"matric", "reflection", "studio", "tags"}));
    @Test
    public void readCsvFile_missingCompulsoryParameter_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/compulsoryParameterHeaderMissing.csv"),
                        compulsoryParameters,
                        optionalParameters));
    }

    @Test
    public void readCsvFile_mulitpleMissingCompulsoryParameters_success() throws DataLoadingException {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/multipleCompulsoryParameterHeadersMissing.csv"),
                        compulsoryParameters,
                        optionalParameters));
    }
    @Test
    public void readCsvFile_fileNotFound_failure() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/nonExistent.csv"),
                       compulsoryParameters,
                        optionalParameters));
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
