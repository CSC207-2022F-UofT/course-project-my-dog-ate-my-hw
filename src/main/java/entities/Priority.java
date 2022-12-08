package entities;

/**
 * The enum object that represents the priority of a task
 */
public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int value;
    private Priority(int value) {
        this.value = value;
    }

    /**
     * Getter for the points value of the enum
     * @return Number of points represented by the enum
     */
    public int getValue() {
        return value;
    }
}
