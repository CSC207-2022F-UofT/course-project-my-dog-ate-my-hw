package entities;

import java.util.Objects;

/**
 * The enum object that represents the priority of a task
 */
public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int value;
    Priority(int value) {
        this.value = value;
    }

    /**
     * Getter for the points value of the enum
     * @return Number of points represented by the enum
     */
    public int getValue() {
        return value;
    }

    public static Priority getPriority(String priority){
        if (Objects.equals(priority, "HIGH")){return HIGH;}
        else if (Objects.equals(priority, "MEDIUM")) { return MEDIUM;}
        else {return LOW;}

    }
}