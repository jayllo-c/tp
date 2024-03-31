package seedu.address.commons.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import seedu.address.commons.exceptions.DataLoadingException;

/**
 * Utility class for processing CSV files.
 */
public class CsvUtil {

    /**
     * Reads the CSV file and returns a list of maps,
     * where each map represents a row of person's data in the csv file.
     * @throws DataLoadingException
     */
    public static List<Map<String, String>> readCsvFile(Path filePath) throws DataLoadingException {
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(filePath.toString())).build();
            List<String[]> rows = reader.readAll();
            return parseData(rows);
        } catch (IOException | CsvException e) {
            throw new DataLoadingException(e);
        }
    }

    /**
     * Parses the data from the CSV file into a list of maps. Each map represents a person's data.
     * @param rows
     * @return
     */
    public static List<Map<String, String>> parseData(List<String[]> rows) {
        List<Map<String, String>> data = new ArrayList<>();
        String[] header = rows.get(0);
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            Map<String, String> map = new HashMap<>();
            for (int j = 0; j < header.length; j++) {
                map.put(header[j], row[j]);
            }
            data.add(map);
        }
        return data;
    }

    /**
     * Builds the CSV schema from a JSON array.
     *
     * @param personsArray The JSON persons array to derive the schema from.
     * @param examsArray The JSON exams array to derive the schema from.
     * @return The CSV schema.
     */
    public CsvSchema buildCsvSchema(JsonNode personsArray, JsonNode examsArray) {
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = personsArray.elements().next();
        Set<String> addedColumns = new HashSet<>();

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
    public void writeToCsvFile(File csvFile, JsonNode personsArray, JsonNode examsArray) throws IOException {
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
