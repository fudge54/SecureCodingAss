package ca.sait.crs;

import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.*;
import ca.sait.crs.factories.*;
import ca.sait.crs.services.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Course Registration System
 * Written by: Nick Hamnett
 * Since: June 1, 2023
 */
public class CourseRegistrationSystem {
    private final Scanner scanner;
    private final CourseService courseService;
    private final RegistrationService registrationService;

    public CourseRegistrationSystem() throws FileNotFoundException {
        this.scanner = new Scanner(System.in);
        this.courseService = new CourseService();
        this.registrationService = new RealRegistrationService();
    }

    public void start() {
        System.out.println("Course Registration System");
        System.out.println("Written by: Nick Hamnett");
        System.out.println();

        int option;

        while (true) {
            printMenu();

            System.out.print("Enter option: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Consume the invalid input
                continue;
            }

            switch (option) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    listRegistrations();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    closeScanner();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }

    private void closeScanner() {
        scanner.close();
    }

    private void printMenu() {
        System.out.println("Option\tDescription");
        System.out.println("1\tList courses");
        System.out.println("2\tList registrations");
        System.out.println("3\tRegister");
        System.out.println("4\tExit");
        System.out.println();
    }

    private void listCourses() {
        System.out.println("Code\tName");
        System.out.println();

        for (Course course : this.courseService.getCourses()) {
            System.out.printf("%s\t%s\n", course.getCode(), course.getName());
        }

        System.out.println();
    }

    private void listRegistrations() {
        System.out.println("Course Code\tName");
        System.out.println();

        for (Registration registration : this.registrationService.getRegistrations()) {
            System.out.printf("%s\t%s\n", registration.getCourse().getCode(), registration.getStudent().getName());
        }

        System.out.println();
    }

    private void register() {
        System.out.print("Enter course code: ");
        String courseCode = this.scanner.nextLine();

        Course course = this.courseService.find(courseCode);

        System.out.print("Enter student name: ");
        String studentName = this.scanner.nextLine();

        System.out.print("Enter student GPA: ");
        double studentGpa;

        try {
            studentGpa = this.scanner.nextDouble();
            this.scanner.nextLine();  // Consume the newline character
        } catch (Exception e) {
            System.out.println("Invalid GPA. Please enter a valid number.");
            this.scanner.nextLine();  // Consume the invalid input
            return;
        }

        try {
            Student student = new StudentFactory().build(studentName, studentGpa);
            Registration registration = this.registrationService.register(student, course);

            System.out.println("Student \"" + registration.getStudent() + "\" has been registered in \"" + registration.getCourse() + "\" course.");
        } catch (CannotCreateStudentException | CannotCreateRegistrationException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please try again.");
        }
    }
}
