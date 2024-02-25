package checks;
public class CourseCodeValidator implements Validator {
    @Override
    public boolean validate(String courseCode) {
        return courseCode.matches("[A-Z]{4}\\d{3}");
    }
}