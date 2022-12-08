package presenters;

public interface ViewRefresherBoundary {
    void refresh(PetVM pet, TaskVM[] tasks);

    void refresh(TaskVM[] tasks);

    void refresh(PetVM pet);
}
