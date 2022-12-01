package entities;

import java.time.LocalDateTime;

public class Task {
    // Task is a public class which contains a String name, String course, Priority priority,


    // ==PRIVATE ATTRIBUTES==

    private LocalDateTime deadline;
    private LocalDateTime studyDeadline;
    private String name;
    private String course;
    private Priority priority;
    private boolean completion;

    // ==CONSTRUCTORS==

    public Task(String name, String course, LocalDateTime deadline, Priority priority){
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.priority = priority;
        this.studyDeadline = deadline.minusDays(3);
    }

    // ==GETTERS/SETTERS==

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

    public LocalDateTime getStudyDeadline() {
        return studyDeadline;
    }

    public void setStudyDeadline(LocalDateTime studyDeadline) {
        this.studyDeadline = studyDeadline;
    }

    // ==CLASS METHODS==

    /**
     * Return whether the given task is incompleted and the task is past its deadline. This method uses the current
     * time from the system clock based on the default time-zone.
     * @return false if the task is completed before its deadline or if it is incompleted
     * and it is before the studyDeadline. Return true otherwise.
     */
    public boolean pastDeadline() {
        return this.deadline.isBefore(LocalDateTime.now());
    }
}
