package databaseBoundaries;

import java.util.ArrayList;

public interface UserDBBoundary {
    PetDBBoundary getPet();
    int getPoints();
    ArrayList<TaskDBBoundary> getTodo();
    ArrayList<TaskDBBoundary> getDone();
}
