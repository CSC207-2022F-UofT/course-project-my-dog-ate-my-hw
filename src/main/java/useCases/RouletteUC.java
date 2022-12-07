package useCases;

import entities.Task;

public class RouletteUC implements RouletteInputBoundary{

    /**
     * Returns a randomized task in the user's ToDoList
     * @param user The user who performs the action
     * @return A randomized task from ToDoList
     */
    public Task Roulette(entities.User user) {
        return user.getToDo().randomTask();
    }

    /**
     * Another version of the roulette method
     * @return A randomized task from ToDoList
     */
    public Task Roulette() {return this.Roulette(User.u());}

    /**
     * Refresh method that refreshes the UI
     */
    @Override
    public void RefreshRoulette() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Tasklist").refresh();
    }
}
