package useCases.interactors;

import entities.User;

/**
 * Use case interactor class for the feature: Pet loses health when tasks are uncompleted past their deadline. This
 * use case is run everytime the program opens and will change the health of pet accordingly.
 */
public class CheckerUC {
    /**
     * Get the sum of points lost by the user for not completing tasks before their deadline. If there are no tasks
     * incomplete past their deadline, return 0. Otherwise, return the sum of the points devoted to each task according
     * to their priority. If the user has lost points, remove these points and reduce the health of their pet.
     * @param user The User singleton that holds this user's ToDoList
     */
    public void checkLostHealth(User user) {
        int lostHealth = user.getToDo().pastDeadLineSum();
        if (lostHealth > 0) {
            reducePetHealth(user, lostHealth);
        }
    }

    /**
     * Reduce the pet's health by the given amount
     * @param user The User object that holds the user's pet and points
     * @param pointsLost the number of points this user has lost
     */
    private void reducePetHealth(User user,int pointsLost) {
        if (user.getPet() != null) {
            user.getPet().ouch(pointsLost);
        }
    }
}
