package entities;

import java.time.LocalDateTime;


/**
 * The task entity that has information of the task's deadline, study deadline, name, course, priority,
 * and completion status.
 */
public class Task {
    private LocalDateTime deadline;
    private LocalDateTime studyDeadline;
    private String name;
    private String course;
    private Priority priority;
    private boolean completion;

    /**
     * The task's constructor to create a task.
     *
     * @param name     the task's name.
     * @param course   the task's belonging course.
     * @param deadline the task's deadline.
     * @param priority the task's priority.
     */
    public Task(String name, String course, LocalDateTime deadline, Priority priority) {
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.priority = priority;
        this.studyDeadline = deadline.minusDays(3);
        this.completion = false;
    }

    /**
     * Gets the deadline.
     * @return deadline in LocalDateTime
     */

    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * Sets the deadline.
     *
     * @param deadline task's deadline
     */
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    /**
     * Gets the task's name.
     *
     * @return task's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name task's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the task's course.
     *
     * @return task's course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the task's course.
     *
     * @param course the task's course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Gets the task's priority.
     *
     * @return task's priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets the task's Priority.
     *
     * @param priority the task's priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Returns if the task is completed or not.
     *
     * @return True if task is completed and false otherwise.
     */
    public boolean isCompletion() {
        return completion;
    }

    /**
     * Sets the completion status of a task.
     *
     * @param completion the task's completion status.
     */
    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    /**
     * Gets the task's study deadline.
     *
     * @return task's study deadline
     */
    public LocalDateTime getStudyDeadline() {
        return studyDeadline;
    }

    /**
     * Sets the study deadline.
     *
     * @param studyDeadline the task's study deadline
     */
    public void setStudyDeadline(LocalDateTime studyDeadline) {
        this.studyDeadline = studyDeadline;
    }

    /**
     * Return whether the given task is incompleted and the task is past its deadline. This method uses the current
     * time from the system clock based on the default time-zone.
     *
     * @return false if the task is completed before its deadline or if it is incompleted
     * and it is before the studyDeadline. Return true otherwise.
     */
    public boolean pastDeadline() {
        return this.deadline.isBefore(LocalDateTime.now());
    }

    /**
     * Return a task in a string representation.
     *
     * @return task in string representation
     */
    public String toString() {
        return name + " " + course + " " + String.valueOf(deadline) + " " + String.valueOf(priority);
    }

    /**
     * Return a task in a string array representation.
     *
     * @return task in list representation
     */
    public String[] taskToList() {
        String[] result;
        result = new String[]{name, course, String.valueOf(deadline), String.valueOf(priority)};
        return result;
    }

}
