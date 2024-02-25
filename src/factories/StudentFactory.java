package factories;

import models.ConcreteStudent;
import models.Student;

public class StudentFactory {
    public static Student createStudent(String id, double gpa) {
        return new ConcreteStudent(id, gpa);
    }
}
