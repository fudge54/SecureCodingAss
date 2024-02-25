package driver;

import java.util.Scanner;
import implementations.*;
import pattern.*;


public class RegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator studentIdValidator = new StudentIDValidator();
        Validator courseCodeValidator = new CourseCodeValidator();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (!studentIdValidator.validate(studentId)) {
            System.out.println("Invalid student ID format.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        if (!courseCodeValidator.validate(courseCode)) {
            System.out.println("Invalid course code format.");
            return;
        }

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        Student student = StudentFactory.createStudent(studentId, gpa);
        Course course = CourseFactory.createCourse(courseCode, true); // Assuming all courses are for credit in this example

        RegistrationProxy registrationProxy = new RegistrationProxy(new RegistrationService());
        registrationProxy.register(student, course);
    }
}
