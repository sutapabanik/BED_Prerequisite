package su20402117.corejava.ratingstudent;

public class Assignment {
    
    private String studentName;
    private String subject;
    private String assignmentCategory;
    private int points;
    private String dateOfSubmission;
    
    public Assignment(String studentName, String subject, String assignmentCategory, String dateOfSubmission, int points) {
        this.studentName = studentName;
        this.subject = subject;
        this.assignmentCategory = assignmentCategory;
        this.points = points;
        this.dateOfSubmission = dateOfSubmission;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getAssignmentCategory() {
        return assignmentCategory;
    }
    public void setAssignmentCategory(String assignmentCategory) {
        this.assignmentCategory = assignmentCategory;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getDateOfSubmission() {
        return dateOfSubmission;
    }
    public void setDateOfSubmission(String dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    

}
