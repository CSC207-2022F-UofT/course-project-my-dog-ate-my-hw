package databaseBoundaries;

import java.time.LocalDateTime;

/**
 * This class is an interface for the TaskDB object
 */
public interface TaskDBBoundary {

    /**
     * A Getter for the deadline
     * @return deadline
     */
    LocalDateTime getDeadline();

    /**
     * A Getter for the name
     * @return name
     */
    String getName();

    /**
     * A Getter for the course
     * @return course
     */
    String getCourse();

    /**
     * A Getter for the priorityString
     * @return priority
     */
    String getPriority();

    /**
     * A Getter for the assignmentTypeString
     * @return assignmentType
     */
    String getAssignmentType();
}
