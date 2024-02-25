package ca.sait.crs.services;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Registration;
import ca.sait.crs.contracts.RegistrationService;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO: Make this class immutable.

/**
 * Registers student with course.
 * This class is immutable.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class RealRegistrationService implements RegistrationService {
    private final List<Registration> registrations;

    /**
     * Constructs the RealRegistrationService with an empty list of registrations.
     */
    public RealRegistrationService() {
        this.registrations = new ArrayList<>();
    }

    /**
     * Registers student with course.
     * @param student Student instance
     * @param course Course instance
     * @return Registration instance.
     * @throws CannotCreateRegistrationException Thrown if registration cannot be created.
     */
    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        // TODO: Create instance of RegistrationFactory.
        // TODO: Call build() method in RegistrationFactory instance to handle validating parameters and creating new Registration object.
        // Do not catch CannotCreateRegistrationException in this method.
        Registration registration = new ca.sait.crs.models.Registration(course, student);

        // Create a new list with the additional registration
        List<Registration> newRegistrations = new ArrayList<>(registrations);
        newRegistrations.add(registration);

        // Return the new RealRegistrationService with the updated list of registrations
        return new RealRegistrationService(newRegistrations);
    }

    /**
     * Gets registrations.
     * @return All registrations as an unmodifiable list.
     */
    @Override
    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrations);
    }

    /**
     * Constructs a new RealRegistrationService with the given list of registrations.
     * This is a private constructor used for immutability.
     * @param registrations List of registrations.
     */
    private RealRegistrationService(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
