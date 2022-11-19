package entities;

import java.time.LocalDateTime;

public class Task {
    private LocalDateTime deadline;
    private LocalDateTime studyDeadline;
    private String name;
    private String course;
    private Priority priority;
    private boolean completion;

    //constructor
    public Task(String name, String course, LocalDateTime deadline, Priority priority){
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.priority = priority;
        this.studyDeadline = deadline.plusDays(3);
    }

    // getters and setters
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }
}
