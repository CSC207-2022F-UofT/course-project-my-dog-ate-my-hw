package databaseBoundaries;

import java.time.LocalDateTime;

public interface TaskDBBoundary {
    LocalDateTime getDeadline();
    String getName();
    String getCourse();
    String getPriority();
    boolean getCompletion();
    String getAssignmentType();
}
