package useCases;
import java.time.LocalDateTime;

public class CompleteTask {
    private Task task;
    /* checklists acquired from DataAccess */
    private TODOlist todo;
    private DONEList done;

    public CompleteTask (String taskName) {
        //go through the TODOlist to find the task
        this.task = task;
    }

    //Check if the task is finished before studyDeadline
    public Boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        deadline = task.StudyDeadline;
        return deadline.compareTo(now);
    }

    //remove the task from TODOlist
    public void removeFromTdl() {
        todo.remove(task);
    }

    //add the task to DONElist
    public void addToDl() {
        done.add(task);
    }
}
