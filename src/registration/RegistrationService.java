package registration;

import models.Course;
import models.Student;

public class RegistrationService {
    public void register(Student student, Course course) {
        System.out.println("Student " + student.getId() + " registered for course " + course.getCode());
    }
}