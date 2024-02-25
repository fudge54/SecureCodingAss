package factories;

import models.Course;
import models.OptionalCourse;
import models.RequiredCourse;

public class CourseFactory {
    public static Course createCourse(String code, boolean isForCredit) {
        if (isForCredit) {
            return new RequiredCourse(code);
        } else {
            return new OptionalCourse(code);
        }
    }
}