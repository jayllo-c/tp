package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.commons.util.CsvUtil.readCsvFile;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IMPORT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MATRIC_NUMBER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REFLECTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDIO;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.util.Pair;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddCommandParser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Changes the  of an existing person in the address book.
 */
public class ImportCommand extends Command {

    public static final String COMMAND_WORD = "import";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Imports persons from specified filepath."
            + " Must be an absolute CSV file path\n"
            + "Parameters: filePath\n"
            + "[" + PREFIX_IMPORT + "import]\n"
            + "Example: " + COMMAND_WORD + PREFIX_IMPORT + "C:usr/lib/text.csv";
    private static final String MESSAGE_IMPORT_SUCCESS = "Imported persons successfully!\n";
    private final Path filePath;
    private final AddCommandParser addCommandParser = new AddCommandParser();

    /**
     * Represents the order of the data that should be parsed into the addCommandParser
     */
    private final HashSet<String> compulsoryParameters =
            new HashSet<>(List.of(new String[]{"name", "phone", "email", "address"}));
    private final HashSet<String> optionalParameters = new HashSet<>(
            List.of(new String[]{"matric", "reflection", "studio", "tags"}));

    private String errorMsgsFromReadingCsv = "";
    private String errorMsgsFromAddingPersons = "";

    private int successfulImports = 0;
    private int unsuccessfulImports = 0;

    /**
     * Represents a mapping of String to prefix of the data that should be parsed into the addCommandParser.
     */
    private final Map<String, Prefix> prefixMap = Map.of(
            "name", PREFIX_NAME,
            "phone", PREFIX_PHONE,
            "email", PREFIX_EMAIL,
            "address", PREFIX_ADDRESS,
            "matric", PREFIX_MATRIC_NUMBER,
            "reflection", PREFIX_REFLECTION,
            "studio", PREFIX_STUDIO,
            "tags", PREFIX_TAG
    );

    /**
     * @param filePath absolute path of file (path starts from C:...)
     */
    public ImportCommand(Path filePath) {
        requireNonNull(filePath);

        this.filePath = filePath;
    }

    /**
     * Generates a report of the import process.
     */
    private String generateReport() {
        String importSuccessMsg = (
                !errorMsgsFromReadingCsv.isEmpty() | !errorMsgsFromAddingPersons.isEmpty()
                        ? "Import completed with errors\n"
                        : successfulImports == 0
                        ? "No persons were imported\n"
                        : MESSAGE_IMPORT_SUCCESS);

        String reportForAddingPersons = "\n" + (
                errorMsgsFromAddingPersons.isEmpty() && successfulImports > 0
                        ? "All valid persons have been added!\n"
                        : successfulImports == 0
                        ? "No valid persons were found. Csv file is empty or error occurred reading from csv file\n"
                        : "Errors found in adding persons!\n")
            + String.format("Successful imports: %d\n", successfulImports)
            + String.format("Unsuccessful imports: %d\n", unsuccessfulImports)
            + errorMsgsFromAddingPersons;

        String reportForReadingCsv =
                errorMsgsFromReadingCsv.isEmpty()
                        ? ""
                        : "\nErrors found from reading csv!\n" + errorMsgsFromReadingCsv;

        return importSuccessMsg + reportForReadingCsv + reportForAddingPersons;
    }
    /**
     * Generates an error report from adding persons. The index refers to the index of the person in personsData.
     * @param e
     * @param index
     */
    private void generateErrorReportFromAddingPersons(Exception e, int index) {
        errorMsgsFromAddingPersons += String.format("Person %s: ", index) + e.getMessage() + "\n";
    }

    private void generateErrorReportFromReadingCsv(DataLoadingException e) {
        errorMsgsFromReadingCsv += e.getMessage() + "\n";
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Pair<Integer, Integer> importResults;
        try {
            Pair<Optional<List<Map<String, String>>>, String> result =
                    readCsvFile(filePath, compulsoryParameters, optionalParameters);
            Optional<List<Map<String, String>>> personsData = result.getKey();
            if (personsData.isPresent()) {
                importResults = addToModel(model, personsData.get());
                successfulImports = importResults.getKey();
                unsuccessfulImports = importResults.getValue();
            }
            if (!result.getValue().isEmpty()) {
                generateErrorReportFromReadingCsv(new DataLoadingException(result.getValue()));
            }
        } catch (IOException e) {
            throw new CommandException(e.getMessage());
        }

        return new CommandResult(generateReport());
    }

    /**
     * Adds the persons data to the model using a series of addCommands.
     * @param model
     * @param personsData
     * @throws CommandException
     */
    public Pair<Integer, Integer> addToModel(Model model, List<Map<String, String>> personsData) {
        requireAllNonNull(model, personsData);
        int successfulImports = 0;
        int unsuccessfulImports = 0;
        for (Map<String, String> personData : personsData) {
            try {
                String addCommandInput = convertToAddCommandInput(personData);
                AddCommand addCommand = parseAddCommandInput(addCommandInput);
                addCommand.execute(model);
                successfulImports++;
            } catch (ParseException | CommandException e) {
                generateErrorReportFromAddingPersons(e, successfulImports + unsuccessfulImports);
                unsuccessfulImports++;
            }
        }
        return new Pair<>(successfulImports, unsuccessfulImports);
    }

    /**
     * Converts a map of person data to a string that can be parsed by the addCommandParser
     * @param personData
     * @return
     */
    private String convertToAddCommandInput(Map<String, String> personData) {
        // Changed this method to private to prevent malicious use
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (Map.Entry<String, String> entry : personData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.isEmpty()) {
                // skip empty values
                continue;
            }
            if (key.equals("tags")) {
                // tag is a special case, it can have multiple values
                String tags = personData.get(key);
                String[] tagArray = tags.split(";");
                for (String tag : tagArray) {
                    sb.append(prefixMap.get(key).getPrefix());
                    sb.append(tag);
                    sb.append(" ");
                }
            } else {
                sb.append(prefixMap.get(key).getPrefix());
                sb.append(personData.get(key));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    private AddCommand parseAddCommandInput(String input) throws ParseException {
        return addCommandParser.parse(input);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ImportCommand)) {
            return false;
        }

        ImportCommand e = (ImportCommand) other;
        return filePath.equals(e.filePath);
    }

}
