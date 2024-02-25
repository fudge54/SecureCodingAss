package ca.sait.crs;

import java.io.FileNotFoundException;

public class AppDriver {
    /**
     * Entry point to program.
     * @param args
     */
    public static void main(String[] args) {
        try {
            CourseRegistrationSystem crs = new CourseRegistrationSystem();
            crs.start();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Exiting...");
        }
    }
}
