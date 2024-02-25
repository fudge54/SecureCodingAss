package registration;

import checks.GPAVerifier;
import models.Course;
import models.Student;

public class RegistrationProxy {
    private final RegistrationService registrationService;

    public RegistrationProxy(RegistrationService service) {
        this.registrationService = service;
    }

    public void register(Student student, Course course) {
        if (!GPAVerifier.verify(student.getGpa())) {
            System.out.println("Registration failed: GPA requirement not met.");
        } else {
            registrationService.register(student, course);
            System.out.println("Registration successful!");
        }
    }
}