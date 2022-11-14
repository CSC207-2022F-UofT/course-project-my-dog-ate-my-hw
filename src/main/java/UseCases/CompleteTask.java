package UseCases;
import java.time.LocalDateTime;

public class CompleteTask {
    private Task task;
    /* checklists acquired from DataAccess */
    private CheckList TODOlist;
    private Checklist DONElist;

    public CompleteTask (String taskName) {

        this.task = task;
    }
    public Boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        deadline = task.StudyDeadline;
        return deadline.compareTo(now);
    }

    public void removeFromTdl() {
        TODOlist.remove(task);
    }

    public void addToDl() {
        DONElist.add(task);
    }
}
