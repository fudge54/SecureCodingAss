package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private static final String CSV_FILE_NAME = "resources/courses.csv";

    public static List<String> readCourseCodes() {
        List<String> courseCodes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                courseCodes.add(values[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseCodes;
    }
}
