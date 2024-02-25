package models;

public class RequiredCourse implements Course {
    private final String code;

    public RequiredCourse(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}