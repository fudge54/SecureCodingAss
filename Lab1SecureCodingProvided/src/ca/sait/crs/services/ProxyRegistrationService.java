package ca.sait.crs.services;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.RegistrationService;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.models.Registration;

import java.util.Collections;
import java.util.List;

// TODO: Define the ProxyRegistrationService
// TODO: Implement the RegistrationService interface
// TODO: Check student can be registered before passing to RealRegistrationService
// TODO: Make this class immutable.

/**
 * ProxyRegistrationService handles registration requests by checking eligibility before delegating to RealRegistrationService.
 * This class is immutable.
 * @author Your Name
 * @since Date
 */
public final class ProxyRegistrationService implements RegistrationService {
    private final RegistrationService realRegistrationService;

    /**
     * Constructs the ProxyRegistrationService with the real registration service.
     * @param realRegistrationService The actual registration service to delegate to.
     */
    public ProxyRegistrationService(RegistrationService realRegistrationService) {
        this.realRegistrationService = realRegistrationService;
    }

    /**
     * Attempts to register a student for a course.
     * Checks eligibility before delegating to the real registration service.
     * @param student The student to register.
     * @param course The course to register for.
     * @return Registration object if successful.
     * @throws CannotCreateRegistrationException Thrown if registration fails.
     */
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        // TODO: Implement logic to check student eligibility before proceeding with real registration.

        // If eligibility check passes, delegate to the real registration service.
        return realRegistrationService.register(student, course);
    }

    /**
     * Gets a list of all registrations.
     * @return Unmodifiable list of registrations.
     */
    public List<Registration> getRegistrations() {
        // TODO: Implement logic to return the list of registrations from the real registration service.
        return Collections.emptyList(); // Placeholder, replace with actual implementation.
    }
}
