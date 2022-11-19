package entities;

public class CustomTask extends Task {
    private String AssignmentType;
    private String StudyTechniques;

    public String getAssignmentType() {
        return AssignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        AssignmentType = assignmentType;
    }

    public String getStudyTechniques() {
        return StudyTechniques;
    }

    public void setStudyTechniques(String studyTechniques) {
        StudyTechniques = studyTechniques;
    }
}
