package controllers;

import useCases.inputBoundaries.CreateTaskInputBoundary;
import java.time.LocalDateTime;

public class CreateTaskController {
    private static CreateTaskInputBoundary uc;
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignmentType;
    public static void setUc(CreateTaskInputBoundary useCase){ uc = useCase; }

        public CreateTaskController(LocalDateTime deadline, String name, String course, String priority, String assignmentType){
            this.deadline = deadline;
            this.name = name.strip();
            this.course = course.strip();
            this.priority = priority;
            this.assignmentType = assignmentType;
            create();
        }

        public void create(){
                uc.createTask(name, course, deadline, priority, assignmentType);
                uc.refreshTask();
        }

    }


