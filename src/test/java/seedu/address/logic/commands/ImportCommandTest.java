package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ImportCommandTest {
    @Test
    public void execute_import_success() throws CommandException, ParseException, DataLoadingException {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        Path filePath = Paths.get("src/test/data/ImportCommandTest/valid.csv");
        ImportCommand importCommand = new ImportCommand(filePath);
        CommandResult commandResult = importCommand.execute(model);
        String expected = String.format("Imported Contacts from: %s\n", filePath.toString()) + "\n"
                + "Successful imports: 7\n"
                + "Unsuccessful imports: 0\n";
        String actual = commandResult.getFeedbackToUser();
        assertEquals(expected , actual);
    }
    @Test
    public void execute_invalidPath_failure() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        ImportCommand importCommand = new ImportCommand(Paths.get(
                "src/test/data/ImportCommandTest/nonexistent.csv"));
        assertThrows(CommandException.class, () -> importCommand.execute(model));
    }
    @Test
    public void equals_success() {
        Path filePath = Paths.get("src/test/data/ImportCommandTest/valid.csv");
        ImportCommand importCommand = new ImportCommand(filePath);
        ImportCommand importCommandCopy = new ImportCommand(filePath);
        assertEquals(importCommand, importCommandCopy);
    }
}
