package useCases;
import java.time.LocalDateTime;
import entities.Priority;

public class CompleteTaskUC {
    private Task task;
    /* checklists acquired from DataAccess */
    private ToDolist todo;
    private DoneList done;

    public CompleteTaskUC(String taskName) {
        //go through the TODOlist to find the task
        this.task = todo.searchFor(taskName);
    }

    //Check if the task is finished before studyDeadline
    public Boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        deadline = task.StudyDeadline;
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
