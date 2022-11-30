package useCases;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;

import javax.swing.*;
import java.time.LocalDateTime;

public interface CreateTaskInputBoundary {

    void createTask(String name, String course, LocalDateTime deadline, Priority priority);

    void createTask(String name, String course, LocalDateTime deadline, Priority priority, String studyTechniques, AssignmentType assignmentType);

    public void addToTDL(Task task);

    public Task getTask();

    void refreshTask();
}
