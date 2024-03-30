package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IMPORT;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import javafx.collections.ObservableList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Person;
import seedu.address.model.person.Score;

/**
 * Imports a CSV file containing details of existing exams into the application.
 */
public class ImportExamCommand extends Command {

    public static final String COMMAND_WORD = "importExam";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Imports exams from specified filepath."
            + " Must be an absolute CSV file path\n"
            + "[" + PREFIX_IMPORT + "FILEPATH]\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_IMPORT + "C:usr/lib/text.csv";
    public static final String MESSAGE_ERROR_READING_FILE = "Error reading file: ";
    public static final String MESSAGE_SCORE_NOT_NUMBER = "Score for %s is not a number";
    public static final String MESSAGE_PERSON_DOES_NOT_EXIST = "Person does not exist";
    public static final String MESSAGE_SUCCESS = "Imported exams from: %s";
    public static final String PREFIX_SCORE = " 1 s/";
    public static final String PREFIX_FIND_BY_EMAIL = " e/";
    public static final String PREFIX_ERROR_REPORT = "\nBelow are the errors that occurred while importing exams:\n";
    private StringBuilder errorReport;
    private Path filepath;

    /**
     * Creates an ImportExamCommand to import exams from the specified file path.
     * @param filePath the path of the file
     */
    public ImportExamCommand(Path filePath) {
        this.errorReport = new StringBuilder();
        this.filepath = filePath;
    }

    // Error report methods

    /**
     * Adds an error to the error report.
     * @param subject the subject of the error
     * @param error the error message
     */
    void addToErrorReport(String subject, String error) {
        errorReport.append(String.format("%s: %s\n", subject, error));
    }

    /**
     * Generates the error report.
     * @return the error report
     */
    String generateErrorReport() {
        String errorReportString = errorReport.toString();
        if (errorReportString.isBlank()) {
            return "";
        } else {
            return PREFIX_ERROR_REPORT + errorReportString;
        }
    }

    // CSV parsing methods

    /**
     * Reads all lines from a CSV file.
     * @param filePath the path of the file
     * @return a list of String arrays representing the lines of the CSV file
     * @throws CommandException if an error occurs while reading the file
     */
    public List<String[]> readAllLines(Path filePath) throws CommandException {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return readCsv(reader);
        } catch (IOException | CsvException exception) {
            throw new CommandException(MESSAGE_ERROR_READING_FILE + filePath.toString());
        }
    }

    /**
     * Reads a CSV file.
     * @param reader the reader to read the file
     * @return a list of String arrays representing the lines of the CSV file
     * @throws IOException if an error occurs while reading the file
     * @throws CsvException if an error occurs while parsing the CSV file
     */
    private List<String[]> readCsv(Reader reader) throws IOException, CsvException {
        CSVParser parser = new CSVParserBuilder().build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        return csvReader.readAll();
    }

    // Exam mapping methods

    /**
     * Reorganizes the parsed CSV data into a mapping of individual results from exams.
     * @param lst the list of String arrays representing the lines of the CSV file
     * @return a mapping of exam names to a mapping of student emails to their respective scores
     */
    private HashMap<String, HashMap<String, Double>> createExamsMapping(List<String[]> lst) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        // Check if there is at least a header row within the CSV file.
        if (hasHeader(lst)) {
            createExamNameHeaders(lst, map);
            updateExamResults(lst, map);
        }
        return map;
    }

    private void createExamNameHeaders(List<String[]> lst, HashMap<String, HashMap<String, Double>> map) {
        String[] examNames = getExamNames(lst);

        for (int i = 1; i < examNames.length; i++) {
            map.put(examNames[i], new HashMap<>());
        }
    }

    private void updateExamResults(List<String[]> lst, HashMap<String, HashMap<String, Double>> map) {
        String[] examNames = getExamNames(lst);

        for (int i = 1; i < lst.size(); i++) {
            String[] row = lst.get(i);
            updateExamResult(map, examNames, row);
        }
    }

    private void updateExamResult(HashMap<String, HashMap<String, Double>> map, String[] examNames, String[] row) {
        if (hasEmail(row)) {
            String email = row[0];
            addRows(map, examNames, row, email);
        }
    }

    private void addRows(
            HashMap<String, HashMap<String, Double>> map, String[] examNames, String[] row, String email) {
        for (int j = 1; j < row.length; j++) {
            addRow(map, examNames, row, email, j);
        }
    }

    private void addRow(
            HashMap<String, HashMap<String, Double>> map, String[] examNames, String[] row, String email, int j) {
        if (isValidScore(row[j])) {
            map.get(examNames[j]).put(email, new Score(Double.parseDouble(row[j])).getScore());
        } else {
            addToErrorReport(email, String.format(MESSAGE_SCORE_NOT_NUMBER, examNames[j]));
        }
    }

    private void addScores(HashMap<String, HashMap<String, Double>> headers, Model model) {
        Object[] examNames = headers.keySet().toArray();

        for (int i = 0; i < examNames.length; i++) {
            ObservableList<Exam> exams = model.getExamByName(examNames[i].toString().strip());
            if (exams.size() > 0) {
                Exam exam = exams.get(0);
                insertGrades(headers, model, exam, examNames[i]);
            } else {
                addToErrorReport((String) examNames[i], "Exam does not exist");
            }
        }
    }

    private void insertGrades(
            HashMap<String, HashMap<String, Double>> headers, Model model, Exam exam, Object examNames) {
        HashMap<String, Double> grades = headers.get((String) examNames);
        Object[] emails = grades.keySet().toArray();

        for (int j = 0; j < emails.length; j++) {
            String email = (String) emails[j];
            Double grade = grades.get(email);

            addScoreToPerson(model, email, exam, grade);
        }
    }

    private void addScoreToPerson(Model model, String email, Exam exam, Double grade) {
        ObservableList<Person> persons = model.getPersonByEmail(email);
        if (persons.size() > 0) {
            Person person = persons.get(0);
            if (grade <= exam.maxScore.value) {
                model.addExamScoreToPerson(person, exam, new Score(grade));
            } else {
                addToErrorReport(email, String.format("Grade for %s exceeds maximum score", exam.getName()));
            }
        } else {
            addToErrorReport(email, MESSAGE_PERSON_DOES_NOT_EXIST);
        }
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<String[]> lst = readAllLines(filepath);
        HashMap<String, HashMap<String, Double>> headers = createExamsMapping(lst);

        addScores(headers, model);

        return new CommandResult(
                String.format(MESSAGE_SUCCESS, filepath.toString()) + generateErrorReport());
    }


    // Trivial methods

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ImportExamCommand
                && filepath.equals(((ImportExamCommand) other).filepath));
    }

    private boolean isValidScore(String score) {
        try {
            return Integer.parseInt(score) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasHeader(List<String[]> lst) {
        return lst.size() > 0;
    }

    private String[] getExamNames(List<String[]> lst) {
        return lst.get(0);
    }

    private boolean hasEmail(String[] row) {
        return row.length > 0;
    }
}
