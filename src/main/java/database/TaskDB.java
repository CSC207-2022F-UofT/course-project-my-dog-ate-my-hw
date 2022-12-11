package database;

import databaseBoundaries.TaskDBBoundary;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class contains a Serializable Task DB object,
 * for saving and loading the Task object
 */
public class TaskDB implements Serializable, TaskDBBoundary {

    private static final long serialVersionUID = -7944924548233221204L;

    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public boolean completion;
    public String assignmentType;

    /**
     * Assign default values for Task, since it is contained within the User DB
     */
    public TaskDB(LocalDateTime deadline, String name, String course, String priority, boolean completion,
                  String assignmentType){
        this.deadline = deadline;
        this.name = name;
        this.course = course;
        this.priority = priority;
        this.completion = completion;
        this.assignmentType = assignmentType;
    }

    /**
     * A Getter for Deadline
     * @return deadline
     */
    public LocalDateTime getDeadline(){return this.deadline;}

    /**
     * A Getter for name
     * @return name
     */
    public String getName(){return this.name; }

    /**
     * A Getter for course
     * @return course
     */
    public String getCourse(){return this.course;}

    /**
     * A Getter for priority
     * @return priority
     */
    public String getPriority(){return this.priority;}

    /**
     * A Getter for completion
     * @return completion
     */
    public boolean getCompletion(){return this.completion;}

    /**
     * A Getter for assignmentType
     * @return assignmentType
     */
    public String getAssignmentType() {
        return this.assignmentType;
    }

}
