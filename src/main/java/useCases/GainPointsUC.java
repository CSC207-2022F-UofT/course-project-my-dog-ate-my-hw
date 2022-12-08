package useCases;
import entities.AbsentTaskNameException;
import entities.Priority;
import entities.Task;
import entities.User;

public class GainPointsUC {

    /**
     * Receive the task from input String taskName
     * Check if the task is finished before studyDeadline
     * Reward points to user according to the priority of the task
     * @param taskName The task that has been completed
     * @throws RuntimeException If the task name is not in the ToDoList
     */
    public static void Gain(String taskName, User user) throws RuntimeException {
        try {
            Task task = user.getToDo().searchFor(taskName);
            if (task.pastDeadline() == 0) {
                user.GainPoints(task.getPriority().getValue());
            }
        }
        catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Another version of the gain method that deals with the User use case
     * @param taskName Name of the task that has been completed
     */
    public static void Gain(String taskName) { GainPointsUC.Gain(taskName, UserUC.u());}

    /**
     * The refresh method that refreshes view after changes being made
     */
    public void refreshPoints() {
        new PetRefresher().refresh();
    }
}