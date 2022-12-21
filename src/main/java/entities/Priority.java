package entities;

/**
 * The enum object that represents the priority of a task
 */
public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    // Integer value associated with each priority level
    private final int value;

    /**
     * Associate the priority level with its given value.
     * @param value : int value associated with a priority level
     */
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

    /**
     * Return the priority enum corresponding to the given string.
     * @param priority : the string representation of the priority
     * @return : the priority corresponding to the given string, or null if the given string has no matching priority.
     */
    public static Priority getPriority(String priority){
        switch (priority) {
            case "HIGH":
                return HIGH;
            case "MEDIUM":
                return MEDIUM;
            case "LOW":
                return LOW;
            default:
                return null;
        }
    }
}
