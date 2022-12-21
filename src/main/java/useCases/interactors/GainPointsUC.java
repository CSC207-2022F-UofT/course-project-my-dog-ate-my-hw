package useCases.interactors;

import entities.AbsentTaskNameException;
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
                user.gainPoints(task.getPriority().getValue());
            }
        }
        catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }
}