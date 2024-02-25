package pattern;

public class OptionalCourse implements Course {
    private final String code;

    public OptionalCourse(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}