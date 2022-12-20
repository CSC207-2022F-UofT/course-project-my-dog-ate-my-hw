package presenters;

import useCases.TaskUIDS;

public class TaskVM {
    public String deadline;
    public String name;
    public String course;
    public String priority;
    public String assignmentType;
    public Boolean completed;

    public TaskVM(TaskUIDS task){
        deadline = task.deadline;
        name = task.name;
        course = task.course;
        priority = task.priority;
        assignmentType = task.assignmentType;
        completed = task.completed;
    }
}
