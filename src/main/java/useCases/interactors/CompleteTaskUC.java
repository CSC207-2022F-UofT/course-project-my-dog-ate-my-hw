package useCases.interactors;

import entities.AbsentTaskNameException;
import entities.Task;
import entities.User;
import useCases.inputBoundaries.CompleteTaskInputBoundary;
import useCases.refreshers.PetRefresher;
import useCases.refreshers.TasklistRefresher;

public class CompleteTaskUC implements CompleteTaskInputBoundary {

    /**
     * Remove the task from ToDoList and add the task to DoneList
     * @param taskName The String of the task that has been completed
     * @param user The user that we are changing
     */
    public void completeTask(String taskName, User user) throws RuntimeException {
        try{
            Task task = user.getToDo().searchFor(taskName);
            GainPointsUC.Gain(taskName, user);
            user.getToDo().removeTask(task);
            user.getDone().addTask(task);
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Refresh method that refreshes the view with the changes made
     */
    @Override
    public void refreshCompleteTask() {
        new TasklistRefresher().refresh();
        //also need to refresh user's points
        new PetRefresher().refresh();
    }

    /**
     * Another version of the method that deals with the User use-case
     * @param taskName The name of the task that has been completed
     */
    public void completeTask(String taskName) { this.completeTask(taskName, UserUC.u());}

}