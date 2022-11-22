package entities;

import java.time.LocalDateTime;

public class CustomTask extends Task {
    private AssignmentType assignmentType;
    private String studyTechniques;

    public CustomTask(String name, String course, LocalDateTime deadline, Priority priority, AssignmentType assignmentType, String studyTechniques) {
        super(name, course, deadline, priority);
        this.assignmentType = assignmentType;
        this.studyTechniques = studyTechniques;
    }

    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(AssignmentType assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getStudyTechniques() {
        return studyTechniques;
    }

    public void setStudyTechniques(String studyTechniques) {
        this.studyTechniques = studyTechniques;
    }
}