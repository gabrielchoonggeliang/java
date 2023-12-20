public class Lecture extends Course {

    private int courseDurationHour;

    public Lecture(int courseId, String courseTitle, int totalCredits, int courseDurationHour) {
        super(courseId, courseTitle, totalCredits);
        this.courseDurationHour = courseDurationHour;
    }

    public String getType() {
        return "Lecturer";
    }

    public String getDetails() {
        return "Duration: " + this.getDurationHour() + " hours\n";
    }

    public int getDurationHour() {
        return this.courseDurationHour;
    }

    // Override toString method for Lecture
    @Override
    public String toString() {
        return super.toString() + getType() + getDetails();
    }

}