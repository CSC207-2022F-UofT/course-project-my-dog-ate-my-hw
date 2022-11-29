package useCases;
import entities.User;
import entities.Priority;

public class GainPointsUC {
    CompleteTaskUC ct;
    User user;

    public GainPointsUC(CompleteTaskUC completeTaskUC) {
        this.ct = completeTaskUC;
    }

    //if the task is finished before studyDeadline
    //assign points based on the task's Priority
    public void Gain() {
        if (ct.finishedBeforeDDL()) {
            Priority pr = ct.getPriority();
            if (pr.equals(Priority.HIGH)) {
                user.GainPoints(3);
            }
            else if (pr.equals(Priority.MEDIUM)) {
                user.GainPoints(2);
            }
            else if (pr.equals(Priority.LOW)) {
                user.GainPoints(1);
            }
        }
    }

    public void saveData() {
        ct.save();
    }
}
