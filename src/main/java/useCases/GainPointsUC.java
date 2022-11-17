package useCases;
import entities.User;
import entities.Priority;

public class GainPointsUC {
    CompleteTaskUC ct;
    User user;

    public GainPointsUC(CompleteTaskUC completeTaskUC) {
        this.ct = completeTaskUC;
    }
    public void Gain() {
        if (ct.finishedBeforeDDL()) {
            pr = ct.getPriority();
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
