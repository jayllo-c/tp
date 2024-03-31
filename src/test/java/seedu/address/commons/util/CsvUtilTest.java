package seedu.address.commons.util;

import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class CsvUtilTest {
    @Test
    public void readCsvFile_missingCompulsoryParameter_failure() {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/compulsoryParameterHeaderMissing.csv"),
                        new String[]{"name", "phone", "email", "address"}));
    }

    @Test
    public void readCsvFile_mulitpleMissingCompulsoryParameters_success() throws DataLoadingException {
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/multipleCompulsoryParameterHeadersMissing.csv"),
                        new String[]{"name", "phone", "email", "address"}));
    }
    @Test
    public void readCsvFile_fileNotFound_failure() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        assertThrows(DataLoadingException.class, () ->
                CsvUtil.readCsvFile(
                        Paths.get("src/test/data/CsvUtilTest/nonExistent.csv"),
                        new String[]{"name", "phone", "email", "address"}));
    }
}
