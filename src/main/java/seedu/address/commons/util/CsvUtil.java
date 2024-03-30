package seedu.address.commons.util;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import seedu.address.commons.exceptions.DataLoadingException;

/**
 * Utility class for reading csv files. Used in import Command
 */
public class CsvUtil {
    /**
     * Reads the csv file and returns a list of maps,
     * where each map represents a row of person's data in the csv file.
     * @throws DataLoadingException
     */
    public static List<Map<String, String>> readCsvFile(Path filePath, String[] compulsory_parameters)
            throws DataLoadingException {
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(filePath.toString())).build();
            List<String[]> rows = reader.readAll();
            return parseData(rows, compulsory_parameters);
        } catch (IOException | CsvException e) {
            throw new DataLoadingException(e);
        }
    }

    /**
     * Parses the data from the csv file into a list of maps. Each map represents a person's data.
     *
     * @param rows
     * @param compulsory_parameters
     * @return
     */
    public static List<Map<String, String>> parseData(List<String[]> rows, String[] compulsory_parameters)
            throws DataLoadingException {

        List<Map<String, String>> data = new ArrayList<>();
        String[] header = rows.get(0);
        List<String> headerList = List.of(header);
        check_compulsory_parameters(compulsory_parameters, header);
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

    public static void check_compulsory_parameters(String[] compulsory_parameters, String[] header)
            throws DataLoadingException {
        List<String> headerList = List.of(header);
        for (String compulsory_parameter : compulsory_parameters) {
            if (!headerList.contains(compulsory_parameter)) {
                throw new DataLoadingException(
                        new Exception("Missing compulsory parameter: " + compulsory_parameter));
            }
        }
    }
}
