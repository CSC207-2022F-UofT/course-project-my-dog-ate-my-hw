package useCases;

import java.time.LocalDateTime;

public class TaskUIDS {
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignenmentType;

    public TaskUIDS(entities.Task task){
        deadline = task.getDeadline();
        name = task.getName();
        course = task.getCourse();
        assignenmentType = task.getAssignmentType().toString();
    }
}
