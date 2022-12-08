package presenters;

public interface ViewRefresherBoundary {
    void refresh(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, boolean petAdopted, TaskVM[] tasks);

    void refresh(TaskVM[] tasks);

}
