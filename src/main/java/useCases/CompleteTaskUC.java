package useCases;
import java.time.LocalDateTime;
import entities.Priority;

public class CompleteTaskUC {
    private Task task;
    /* checklists acquired from DataAccess */
    private ToDolist todo;
    private DoneList done;

    //edited the use case so that now it takes in a Task object as constructor parameter
    public CompleteTaskUC(Task task) {
        //go through the TODOlist to find the task
        this.task = task;
    }

    //Check if the task is finished before studyDeadline
    public Boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        deadline = task.StudyDeadline;//StudyDeadline attribute of Task, which is a date/time
        return deadline.compareTo(now);
    }

    //return the task priority
    public Priority getPriority () {
        return task.Priority;
    }

    //remove the task from ToDolist
    public void removeFromTdl() {
        todo.removeTask(task);
    }

    //add the task to Donelist
    public void addToDl() {
        done.addTask(task);
    }
}
