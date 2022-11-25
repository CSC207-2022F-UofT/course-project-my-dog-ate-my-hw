package entities;

import java.time.LocalDateTime;

public class DefaultTask extends Task {
    private LocalDateTime deadline;
    private LocalDateTime studyDeadline;
    private String name;
    private String course;
    private Priority priority;
    private boolean completion;

    //constructor
    public DefaultTask(String name, String course, LocalDateTime deadline, Priority priority){
        super(name, course, deadline, priority);
        this.studyDeadline = deadline.minusDays(3);
    }

}
