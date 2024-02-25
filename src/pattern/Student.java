package pattern;

public abstract class Student {
    private final String id;
    private final double gpa;

    public Student(String id, double gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }
}