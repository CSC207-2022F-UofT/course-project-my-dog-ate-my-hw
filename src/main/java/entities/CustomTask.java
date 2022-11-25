package entities;

import java.time.LocalDateTime;

public class CustomTask extends Task {
    private AssignmentType assignmentType;
    private String studyTechnique;

    public CustomTask(String name, String course, LocalDateTime deadline, Priority priority, AssignmentType assignmentType, String studyTechnique) {
        super(name, course, deadline, priority);
        this.assignmentType = assignmentType;
        this.studyTechnique = studyTechnique;
    }

    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(AssignmentType assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getStudyTechnique() {
        return studyTechnique;
    }

    public void setStudyTechnique(String studyTechniques) {
        this.studyTechnique = studyTechniques;
    }
    }