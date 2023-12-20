public abstract class Course {
  
    private int courseId;
    private String courseTitle;
    private int totalCredits;

    // Constructor
    protected Course(int courseId, String courseTitle, int totalCredits) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.totalCredits = totalCredits;
    }

    // Get details of course
    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public int getTotalCredits() {
        return this.totalCredits;
    }

    public abstract String getType();

    public abstract String getDetails();

    // Override toString method
    @Override
    public String toString() {
        return "Lecture " + this.getCourseId() + ": " +
                            this.getCourseTitle() + " - " +
                            this.getTotalCredits() + " credits\n";
    }

}