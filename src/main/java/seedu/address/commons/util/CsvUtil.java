package seedu.address.commons.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.commands.exceptions.CommandException;

/**
 * Utility class for reading csv files. Used in import Command
 */
public class CsvUtil {

    public static final String MESSAGE_ERROR_READING_FILE = "Error reading file: ";

    /**
     * Reads the csv file and returns a list of maps,
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
     * Parses the data from the csv file into a list of maps. Each map represents a person's data.
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
}
