package useCases;
import entities.AbsentTaskNameException;
import entities.Task;


public class CompleteTaskUC implements CompleteTaskInputBoundary{

    /**
     * Remove the task from ToDoList and add the task to DoneList
     * @param taskName The String of the task that has been completed
     * @param user The user that we are changing
     */
    public static void completeTask(String taskName, entities.User user) throws RuntimeException {
        try{
            Task task = User.u().getToDo().searchFor(taskName);
            user.getToDo().removeTask(task);
            user.getDone().addTask(task);
            GainPointsUC.Gain(taskName, user);
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Refresh method that refreshes the view with the changes made
     */
    @Override
    public void refreshTasklist() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Tasklist").refresh();
    }

    /**
     * Another version of the method that deals with the User user case
     * @param taskName The name of the task that has been completed
     */
    public static void completeTask(String taskName) { CompleteTaskUC.completeTask(taskName, User.u());}

}
