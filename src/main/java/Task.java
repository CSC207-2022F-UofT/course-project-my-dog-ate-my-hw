import java.util.Date;
public abstract class Task {
    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private Date deadline;
    private String name;
    private String course;
    private Priority priority;
    private boolean completion;
}
