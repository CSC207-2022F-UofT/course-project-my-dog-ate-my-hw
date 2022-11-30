package useCases;

import entities.Priority;

import javax.swing.*;
import java.time.LocalDateTime;

public interface CreateTaskInputBoundary {

    void createTask(String name, String course, LocalDateTime deadline, Priority priority);

    void refreshTask();
}
