package useCases;
import entities.Task;
public class CheckerUC {
    /**
     * Checker Use case interactor.
     * When the user opens the program this will check if any deadlines are past their due date and remove health
     * from the pet accordingly.
     */
    public void checkDeadlines() {

        for (Task task : User.u().getTodo()) {

        }
    }


}
