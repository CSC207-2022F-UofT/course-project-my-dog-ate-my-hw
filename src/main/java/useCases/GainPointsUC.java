package useCases;
import entities.AbsentTaskNameException;
import entities.Priority;
import entities.Task;

import java.time.LocalDateTime;

public class GainPointsUC {

    /**
     * Receive the task from input String taskName
     * Check if the task is finished before studyDeadline
     * Reward points to user according to the priority of the task
     * @param taskName The task that has been completed
     * @throws RuntimeException If the task name is not in the ToDoList
     */
    public static void Gain(String taskName, entities.User user) throws RuntimeException {
        try {
            Task task = user.getToDo().searchFor(taskName);
            if (!task.pastDeadline()) {
                Priority priority = task.getPriority();
                if (priority.equals(Priority.HIGH)) {
                    user.GainPoints(3);
                } else if (priority.equals(Priority.MEDIUM)) {
                    user.GainPoints(2);
                } else if (priority.equals(Priority.LOW)) {
                    user.GainPoints(1);
                }
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
    public static void Gain(String taskName) { GainPointsUC.Gain(taskName, User.u());}

    /**
     * The refresh method that refreshes view after changes being made
     */
    public void refreshPoints() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }
}
