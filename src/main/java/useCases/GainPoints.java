package useCases;
import entities.User;

public class GainPoints {
    CompleteTask ct;
    User user;

    public GainPoints (CompleteTask completeTask) {
        this.ct = completeTask;
    }
    public void Gain() {
        if (ct.finishedBeforeDDL()) {
            pr = ct.getTask.Priority;
            if (pr.equals("High")) {
                user.GainPoints(3);
            }
            else if (pr.equals("Medium")) {
                user.GainPoints(2);
            }
            else if (pr.equals("Low")) {
                user.GainPoints(1);
            }
        }
    }
}
