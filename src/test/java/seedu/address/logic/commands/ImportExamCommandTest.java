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
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Score;

public class ImportExamCommandTest {
    public static final String VALID_PATH = "src\\test\\data\\ImportExamCommandTest\\testimportexam.csv";
    public static final String EXTRA_PATH = "src\\test\\data\\ImportExamCommandTest\\testimportexamextra.csv";
    private ImportExamCommand importExamCommand;
    private Model model;

    @BeforeEach
    public void setUp() throws CommandException, ParseException {
        model = mock(Model.class);
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_validFilePath_success() throws CommandException {
        Path filePath = Paths.get("src/test/data/ImportExamCommandTest/valid.csv");
        String expectedMessage = String.format(ImportExamCommand.MESSAGE_SUCCESS, filePath);
        importExamCommand = new ImportExamCommand(filePath);

        assertCommandSuccess(importExamCommand, model, expectedMessage, model);
    }

    @Test
    public void execute_invalidFilePath_throwsCommandException() throws CommandException {
        Path invalidFilePath = Paths.get("invalid/path/to/file.csv");
        importExamCommand = new ImportExamCommand(invalidFilePath);

        assertThrows(CommandException.class, () -> importExamCommand.execute(model));
    }

    @Test
    public void testAddToErrorReport() {
        Path invalidFilePath = Paths.get("invalid/path/to/file.csv");
        importExamCommand = new ImportExamCommand(invalidFilePath);

        importExamCommand.addToErrorReport("Email", "Invalid email format");
        assertEquals(
                "\nBelow are the errors that occurred while importing exams:\nEmail: Invalid email format\n",
                importExamCommand.generateErrorReport());
    }

    @Test
    public void testGenerateErrorReportEmpty() {
        String result = new ImportExamCommand(Paths.get(VALID_PATH)).generateErrorReport();
        assertEquals("", result);
    }

    @Test
    public void testSuccess() throws CommandException {
        Path filePath = Paths.get(VALID_PATH);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);
        String expectedMessage = String.format(ImportExamCommand.MESSAGE_SUCCESS, filePath);
        assertCommandSuccess(importExamCommand, model, expectedMessage, model);
    }

    @Test
    public void testEquals() {
        Path filePath = Paths.get(VALID_PATH);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);
        ImportExamCommand importExamCommandCopy = new ImportExamCommand(filePath);
        assertEquals(importExamCommand, importExamCommandCopy);
    }

    @Test
    public void testFailing() throws CommandException {
        Path filePath = Paths.get(EXTRA_PATH);
        Exam midterm = new Exam("MidtermTestFailing", new Score(100));
        model.addExam(midterm);
        ImportExamCommand importExamCommand = new ImportExamCommand(filePath);

        String expectedError = String.format(ImportExamCommand.MESSAGE_SUCCESS, EXTRA_PATH)
                + ImportExamCommand.PREFIX_ERROR_REPORT;
        expectedError += "non@example.com: Person does not exist\n";
        expectedError += "johnd@example.com: Grade for Midterm exceeds maximum score\n";
        expectedError += "NonExistent: Exam does not exist\n";
        assertCommandSuccess(importExamCommand, model, expectedError, model);
    }

}
