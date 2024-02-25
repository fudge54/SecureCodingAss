package pattern;

public class CourseFactory {
    public static Course createCourse(String code, boolean isForCredit) {
        if (isForCredit) {
            return new RequiredCourse(code);
        } else {
            return new OptionalCourse(code);
        }
    }
}