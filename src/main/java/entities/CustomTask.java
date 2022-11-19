package entities;

import java.time.LocalDateTime;

public class CustomTask extends Task {
    private String assignmentType;
    private String studyTechniques;

    public CustomTask(String name, String course, LocalDateTime deadline, Priority priority, String assignmentType, String studyTechniques) {
        super(name, course, deadline, priority);
        this.assignmentType = assignmentType;
        this.studyTechniques = studyTechniques;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getStudyTechniques() {
        return studyTechniques;
    }

    public void setStudyTechniques(String studyTechniques) {
        this.studyTechniques = studyTechniques;
    }
}