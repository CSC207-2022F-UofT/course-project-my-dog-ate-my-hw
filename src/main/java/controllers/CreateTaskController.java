package controllers;

import useCases.CreateTaskInputBoundary;

import java.time.LocalDateTime;

public class CreateTaskController {
    private static CreateTaskInputBoundary uc;
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignenmentType;
    public static void setUc(CreateTaskInputBoundary useCase){ uc = useCase; }

        public CreateTaskController(LocalDateTime deadline, String name, String course, String priority, String assignenmentType){
            this.deadline = deadline;
            this.name = name.strip();
            this.course = course.strip();
            this.priority = priority;
            this.assignenmentType = assignenmentType;
            create();
        }

        public void create(){
                uc.createTask(name, course, deadline, priority, assignenmentType);
                uc.refreshTask();
        }

    }


