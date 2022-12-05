package entities;

import java.time.LocalDateTime;

public class CustomTask extends Task {
    /**
     * A custom task that user can change the assignment type and the study technique for the task.
     */
    private AssignmentType assignmentType;
    private String studyTechniques;

    /**
     * Creates a custom task entity.
     * @param name task's name
     * @param course task's course
     * @param deadline deadline for task
     * @param priority task's priority
     * @param assignmentType task's assignment type
     * @param studyTechniques task's study techniques
     */
    public CustomTask(String name, String course, LocalDateTime deadline, Priority priority, AssignmentType assignmentType, String studyTechniques) {
        super(name, course, deadline, priority);
        this.assignmentType = assignmentType;
        this.studyTechniques = studyTechniques;
    }

    /**
     * Gets the task's assignment type.
     * @return the assignment type of task
     */
    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    /**
     * Sets the assignment type of task.
     * @param assignmentType the assignment type of task
     */
    public void setAssignmentType(AssignmentType assignmentType) {
        this.assignmentType = assignmentType;
    }

    /**
     * Gets the study technique of task
     * @return the study technique of task
     */
    public String getStudyTechniques() {
        return studyTechniques;
    }

    /**
     * sets the study technique of task
     * @param studyTechniques the study technique for task
     */
    public void setStudyTechniques(String studyTechniques) {
        this.studyTechniques = studyTechniques;
    }
}