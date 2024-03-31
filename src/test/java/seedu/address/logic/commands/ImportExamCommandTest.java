package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Score;

public class ImportExamCommandTest {
    public static final String PATH_VALID = "src/test/data/ImportExamCommandTest/valid.csv";
    public static final String PATH_EXTRA = "src/test/data/ImportExamCommandTest/extra.csv";
    public static final String PATH_EMPTY_CSV = "src/test/data/ImportExamCommandTest/valid_empty_csv.csv";
    public static final String PATH_INVALID = "invalid/path/to/file.csv";
    public static final String PATH_SCORE_NOT_NUMBER = "src/test/data/ImportExamCommandTest/not_number.csv";
    public static final String PATH_DUPLICATE_EXAMS = "src/test/data/ImportExamCommandTest/duplicate_exams.csv";
    private ImportExamCommand importExamCommand;
    private Model model;

    @BeforeEach
    public void setUp() {
        model = mock(Model.class);
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_validFilePath_success() {
        Path filePath = Paths.get(PATH_EMPTY_CSV);
        String expectedMessage = String.format(ImportExamCommand.MESSAGE_SUCCESS, filePath);
        importExamCommand = new ImportExamCommand(filePath);

        assertCommandSuccess(importExamCommand, model, expectedMessage, model);
    }

    @Test
    public void execute_invalidFilePath_throwsCommandException() {
        Path invalidFilePath = Paths.get(PATH_INVALID);
        importExamCommand = new ImportExamCommand(invalidFilePath);

        assertThrows(CommandException.class, () -> importExamCommand.execute(model));
    }

    @Test
    public void testGenerateErrorReportEmpty() {
        String result = new ImportExamCommand(Paths.get(PATH_VALID)).generateErrorReport();
        assertEquals("", result);
    }

    @Test
    public void testSuccess() {
        Path filePath = Paths.get(PATH_VALID);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);
        String expectedMessage = String.format(ImportExamCommand.MESSAGE_SUCCESS, filePath);
        assertCommandSuccess(importExamCommand, model, expectedMessage, model);
    }

    @Test
    public void testEquals() {
        Path filePath = Paths.get(PATH_VALID);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);
        ImportExamCommand importExamCommandCopy = new ImportExamCommand(filePath);
        assertEquals(importExamCommand, importExamCommandCopy);
    }

    @Test
    public void testFailing() {
        Path filePath = Paths.get(PATH_EXTRA);
        Exam midterm = new Exam("MidtermTestFailing", new Score(100));
        model.addExam(midterm);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);

        String expectedError = buildErrorReport(filePath.toString(),
                "non@example.com: " + ImportExamCommand.MESSAGE_PERSON_DOES_NOT_EXIST,
                "johnd@example.com: " + String.format(ImportExamCommand.MESSAGE_GRADE_TOO_HIGH, "Midterm"),
                "NonExistent: " + ImportExamCommand.MESSAGE_EXAM_DOES_NOT_EXIST);

        assertCommandSuccess(importExamCommand, model, expectedError, model);
    }

    @Test
    public void test_notNumber() {
        Path filePath = Paths.get(PATH_SCORE_NOT_NUMBER);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);

        String expectedError = buildErrorReport(filePath.toString(),
                "alice@example.com: "
                        + String.format(ImportExamCommand.MESSAGE_SCORE_NOT_NUMBER, "Midterm"));

        assertCommandSuccess(importExamCommand, model, expectedError, model);
    }

    @Test
    public void test_duplicateExamHeaders() {
        Path filePath = Paths.get(PATH_DUPLICATE_EXAMS);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);

        String expectedError = buildErrorReport(filePath.toString(),
                "Midterm: " + ImportExamCommand.MESSAGE_DUPLICATE_EXAM);
        assertCommandSuccess(importExamCommand, model, expectedError, model);
    }

    private String buildErrorReport(String filePath, String... errors) {
        StringBuilder errorReport = new StringBuilder();
        errorReport.append(String.format(ImportExamCommand.MESSAGE_SUCCESS, filePath));
        errorReport.append(ImportExamCommand.PREFIX_ERROR_REPORT);
        for (String error : errors) {
            errorReport.append(error + "\n");
        }
        return errorReport.toString();
    }

}
