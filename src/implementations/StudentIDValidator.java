package implementations;
public class StudentIDValidator implements Validator {
    @Override
    public boolean validate(String studentId) {
        return studentId.matches("\\d{8}");
    }
}