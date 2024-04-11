package seedu.address.commons.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import javafx.util.Pair;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.commands.exceptions.CommandException;

/**
 * Utility class for processing CSV files.
 * Acknowledgement: The methods in this class were made possible with the help of
 * the [OpenCSV](http://opencsv.sourceforge.net/) library.
 */
public class CsvUtil {

    public static final String MESSAGE_ERROR_READING_FILE = "Error reading file: ";

    /**
     * Reads a CSV file.
     * Firstly, it checks if the compulsory parameters are present in the header of the csv file (the header
     * is the first line of the csv file).
     * Secondly, it only reads the columns that are in compulsoryParameters or optionalParameters.
     * Values in other headers will be ignored.
     * Thirdly, it checks if the number of values in each row is the same as the number of headers.
     * If the check for compulsory parameters fails, the error report will contain the missing compulsory parameters.
     * If the check for the number of values in each row fails, the error report will contain the rows that do not have
     * the same number of values as the number of headers.
     * It is crucial that a dataLoadingException is thrown in the
     * caller of this method if the error report is not empty.
     * @param filePath the path of the file
     * @param compulsoryParameters
     * @param optionalParameters
     * @return
     *     A pair in which the first value is the data and the second is the error report. Data can be null if
     *     the file is not read successfully or if any compulsory parameters are missing in the header row of csv file.
     * @throws IOException
     */
    public static Pair<Optional<List<Map<String, String>>>, String> readCsvFile(
            Path filePath, HashSet<String> compulsoryParameters, HashSet<String> optionalParameters)
            throws IOException {
        List<Map<String, String>> data = null;
        Optional<List<Map<String, String>>> nullableData = Optional.empty();
        String errorMsgs = "";
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(filePath.toString())).build();
            Optional<String[]> headers = Optional.ofNullable(reader.readNext()); // first line should be headers
            if (headers.isPresent()) {
                List<String> headersList = List.of(headers.get());
                List<Integer> columnsToSkip = columnsToSkip(headersList, compulsoryParameters, optionalParameters);
                List<String[]> rows = reader.readAll();
                Pair<List<Map<String, String>>, String> result = parseData(rows, headersList, columnsToSkip);
                data = result.getKey();
                errorMsgs = result.getValue();
                nullableData = Optional.of(data);
            }

            return new Pair<>(nullableData, errorMsgs);
        } catch (DataLoadingException | CsvException e) {
            return new Pair<>(nullableData, e.getMessage());
        }
    }

    /**
     * Returns a list of columns to skip in the CSV file. The columns to skip are the headers that are not in
     * compulsoryParameters or optionalParameters.
     * @param headers
     * @param compulsoryParameters
     * @param optionalParameters
     * @return columnsToSkip
     * @throws DataLoadingException
     */
    public static List<Integer> columnsToSkip(
            List<String> headers, HashSet<String> compulsoryParameters, HashSet<String> optionalParameters)
            throws DataLoadingException {
        // first check if the compulsory parameters are present in the header
        checkCompulsoryParameters(compulsoryParameters, headers);
        List<Integer> columnsToSkip = new ArrayList<>();
        HashSet<String> uniqueHeaders = new HashSet<>();
        for (int i = 0; i < headers.size(); i++) {
            if ((!compulsoryParameters.contains(headers.get(i))
                    && !optionalParameters.contains(headers.get(i)))
                    | uniqueHeaders.contains(headers.get(i))) {
                columnsToSkip.add(i);
            } else {
                uniqueHeaders.add(headers.get(i));
            }

        }

        return columnsToSkip;
    }

    /**
     * Parses the data from the CSV file.
     * @param rows
     * @param headers
     * @param columnsToSkip
     * @return
     */
    public static Pair<List<Map<String, String>>, String> parseData(
            List<String[]> rows, List<String> headers, List<Integer> columnsToSkip) {
        List<Map<String, String>> data = new ArrayList<>();
        StringBuilder errorMsgs = new StringBuilder(); // to store which rows do not have the same size as the header
        Queue<Integer> columnsToSkipQueue;
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            Map<String, String> map = new HashMap<>();
            columnsToSkipQueue = new LinkedList<>(columnsToSkip);
            if (row.length != headers.size()) {
                errorMsgs.append(
                        String.format("Row %d does not have the same number of values as the number of headers."
                                + "Given: %d, Expected: %d\n", i, row.length, headers.size()));
                continue;
            }
            for (int j = 0; j < row.length; j++) {
                if (!columnsToSkipQueue.isEmpty() && columnsToSkipQueue.peek() == j) {
                    columnsToSkipQueue.remove();
                    continue;
                }
                map.put(headers.get(j), row[j]);
            }
            data.add(map);
        }

        return new Pair<>(data, errorMsgs.toString());
    }

    /**
     * Checks if the compulsory parameters are present in the header of the csv file.
     * @param compulsoryParameters
     * @param headers
     * @throws DataLoadingException
     */
    public static void checkCompulsoryParameters(HashSet<String> compulsoryParameters, List<String> headers)
            throws DataLoadingException {
        StringBuilder missingParameters = new StringBuilder("Missing compulsory header(s) in Csv file:");
        boolean hasMissingParameters = false;
        for (String compulsoryParameter : compulsoryParameters) {
            if (!headers.contains(compulsoryParameter)) {
                hasMissingParameters = true;
                missingParameters.append(String.format(" %s,", compulsoryParameter));
            }
        }
        if (hasMissingParameters) {
            throw new DataLoadingException(missingParameters.toString());
        }
    }
    /**
     * Reads all lines from a CSV file.
     * @param filePath the path of the file
     * @return a list of String arrays representing the lines of the CSV file
     * @throws CommandException if an error occurs while reading the file
     */
    public static List<String[]> readAllLinesForImportExamScores(Path filePath) throws CommandException {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return readCsvForImportExamScores(reader);
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
    private static List<String[]> readCsvForImportExamScores(Reader reader) throws IOException, CsvException {
        CSVParser parser = new CSVParserBuilder().build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        List<String[]> lst = csvReader.readAll();
        return lst;
    }

    /**
     * Builds the CSV schema from a JSON array.
     *
     * @param personsArray The JSON persons array to derive the schema from.
     * @param examsArray The JSON exams array to derive the schema from.
     * @return The CSV schema.
     */
    public static CsvSchema buildCsvSchema(JsonNode personsArray, JsonNode examsArray) {
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = personsArray.elements().next();
        Set<String> addedColumns = new HashSet<>(); // Should addedColumns be Hashset<String>?

        firstObject.fieldNames().forEachRemaining(fieldName -> {
            if (!fieldName.equals("examScores")) {
                csvSchemaBuilder.addColumn(fieldName);
                addedColumns.add(fieldName);
            }
        });

        if (examsArray != null && examsArray.size() != 0) {
            for (JsonNode exam : examsArray) {
                String examName = "Exam:" + exam.get("name").asText();
                if (!addedColumns.contains(examName)) {
                    csvSchemaBuilder.addColumn(examName);
                    addedColumns.add(examName);
                }
            }
        }

        CsvSchema csvSchema = csvSchemaBuilder
                .build()
                .withHeader();
        return csvSchema;
    }

    /**
     * Writes JSON data to a CSV file.
     *
     * @param csvFile The CSV file to write to.
     * @param personsArray The JSON person array to be written to CSV.
     * @param examsArray The JSON exams array to be written to CSV.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public static void writeToCsvFile(File csvFile, JsonNode personsArray, JsonNode examsArray) throws IOException {
        CsvSchema csvSchema = buildCsvSchema(personsArray, examsArray);
        CsvMapper csvMapper = new CsvMapper();

        ArrayNode modifiedJsonTree = JsonNodeFactory.instance.arrayNode();
        for (JsonNode person : personsArray) {
            ObjectNode modifiedJsonNode = ((ObjectNode) person).deepCopy();
            JsonNode examScores = modifiedJsonNode.get("examScores");
            modifiedJsonNode.remove("examScores");
            if (examScores != null && examScores.isArray()) {
                examScores.forEach(exam -> {
                    String fieldName = "Exam:" + exam.get("examName").asText();
                    Double score = exam.get("score").asDouble();
                    ObjectNode scoreNode = JsonNodeFactory.instance.objectNode();
                    scoreNode.put(fieldName, score);
                    modifiedJsonNode.setAll(scoreNode);
                });
            }
            modifiedJsonTree.add(modifiedJsonNode);
        }

        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(csvFile, modifiedJsonTree);
    }
}
