package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MATRIC_NUMBER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REFLECTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDIO;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

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
        assertEquals(
                String.format("Imported Contacts from: %s", filePath.toString()), commandResult.getFeedbackToUser());
    }
    @Test
    public void execute_convertToAddCommandInput_success() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        Map<String, String> personData = Map.of(
                "studio", "S1",
                "matric", "A1111111A",
                "address", "123, Jurong West Ave 6, #08-111",
                "reflection", "R1",
                "phone", "94351253",
                "name", "Alice Pauline",
                "email", "alice@example.com",
                "tags", "friends"
                );
        ImportCommand importCommand = new ImportCommand(Paths.get("src/test/data/ImportCommandTest/valid.csv"));
        String actual = importCommand.convertToAddCommandInput(personData);
        String expected =
                " " + PREFIX_NAME + "Alice Pauline " + PREFIX_PHONE + "94351253 "
                        + PREFIX_EMAIL + "alice@example.com " + PREFIX_ADDRESS
                        + "123, Jurong West Ave 6, #08-111 " + PREFIX_MATRIC_NUMBER + "A1111111A "
                        + PREFIX_REFLECTION + "R1 " + PREFIX_STUDIO + "S1 " + PREFIX_TAG + "friends  ";
        assertEquals(expected, actual);
    }
    @Test
    public void execute_import_invalidPathFailure() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs());
        ImportCommand importCommand = new ImportCommand(Paths.get(
                "src/test/data/ImportCommandTest/nonexistent.csv"));
        assertThrows(CommandException.class, () -> importCommand.execute(model));
    }
    @Test
    public void equals() {
        Path filePath = Paths.get("src/test/data/ImportCommandTest/valid.csv");
        ImportCommand importCommand = new ImportCommand(filePath);
        ImportCommand importCommandCopy = new ImportCommand(filePath);
        assertEquals(importCommand, importCommandCopy);
    }
}
