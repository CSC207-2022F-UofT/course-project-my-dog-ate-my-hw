package useCases;

import java.time.format.DateTimeFormatter;

public class TaskUIDS {
    public String deadline;
    public String name;
    public String course;
    public String priority;
    public String assignmentType;
    public Boolean completed;

    public TaskUIDS(entities.Task task){
        deadline = task.getDeadline().format(DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT));
        name = task.getName();
        course = task.getCourse();
        priority = task.getPriority().toString();
        assignmentType = task.getAssignmentType().toString();
        completed = task.isCompletion();
    }
}
