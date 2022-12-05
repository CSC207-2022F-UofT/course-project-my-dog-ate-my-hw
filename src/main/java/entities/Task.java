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
        this.studyDeadline = deadline.minusDays(3);
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

    public LocalDateTime getStudyDeadline() {
        return studyDeadline;
    }

    public void setStudyDeadline(LocalDateTime studyDeadline) {
        this.studyDeadline = studyDeadline;
    }

    /**
     * Return whether the given task is incompleted and the task is past its deadline. This method uses the current
     * time from the system clock based on the default time-zone.
     * @return the number of points lost to the pet, depending on the priority of the task. Return 3 if the task is high
     * priority, return 2 if it is medium priority, return 1 if it is low priority, return 0 if it is not past the
     * deadline.
     */
    public int pastDeadline() {
        if (this.deadline.isBefore(LocalDateTime.now()) && !(this.isCompletion())) {
            if (this.priority == Priority.HIGH) {
                return 3;
            } else if (this.priority == Priority.MEDIUM) {
                return 2;
            } else {
                return 1;
            }
        }
        return 0;
    }

}
