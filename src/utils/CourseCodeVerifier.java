package utils;

import java.util.List;

public class CourseCodeVerifier {
    public static boolean verifyCourseCode(String inputCourseCode) {
        List<String> courseCodes = CsvReader.readCourseCodes();
        return courseCodes.contains(inputCourseCode);
    }
}
