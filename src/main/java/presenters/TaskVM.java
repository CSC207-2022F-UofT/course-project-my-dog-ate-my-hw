package presenters;

import useCases.TaskUIDS;

import java.time.LocalDateTime;

public class TaskVM {
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignenmentType;

    public TaskVM(TaskUIDS task){
        deadline = task.deadline;
        name = task.name;
        course = task.course;
        priority = task.priority;
        assignenmentType = task.assignenmentType;
    }
}
