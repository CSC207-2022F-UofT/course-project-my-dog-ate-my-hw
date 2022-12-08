package database;

import databaseBoundaries.TaskDBBoundary;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TaskDB implements Serializable, TaskDBBoundary {

    private static final long serialVersionUID = 4L;

    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public boolean completion;
    public String assignmentType;

    public TaskDB(LocalDateTime deadline, String name, String course, String priority, boolean completion,
                  String assignmentType){
        this.deadline = deadline;
        this.name = name;
        this.course = course;
        this.priority = priority;
        this.completion = completion;
        this.assignmentType = assignmentType;
    }

    public LocalDateTime getDeadline(){return this.deadline;}
    public String getName(){return this.name; }
    public String getCourse(){return this.course;}
    public String getPriority(){return this.priority;}
    public boolean getCompletion(){return this.completion;}
    public String getAssignmentType() {
        return this.assignmentType;
    }

}
