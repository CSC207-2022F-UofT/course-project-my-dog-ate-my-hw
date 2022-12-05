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
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Tasklist").refresh();
        //also need to refresh user's points
        factory.createRefresher("Pet").refresh();
    }

    /**
     * Another version of the method that deals with the User user case
     * @param taskName The name of the task that has been completed
     */
    public static void completeTask(String taskName) { CompleteTaskUC.completeTask(taskName, User.u());}

}
