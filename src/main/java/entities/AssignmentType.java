package entities;

/**
 * AssignmentType containing the enums for different types of assignments.
 * Currently, it holds: essay, quiz, exam, lab reports.
 */
public enum AssignmentType {
    ESSAY,
    QUIZ,
    EXAM,
    LAB_REPORTS,
    REFLECTION,
    PROJECT;

    /**
     * Getter for an AssignmentType.
     * @param assignedType : A string representing the type of assignment to be returned
     * @return : The assignment type corresponding to assignedType or null if assignedType does not have a corresponding
     * assignment
     */
    public static AssignmentType getAssignmentType(String assignedType){
        switch(assignedType) {
            case "QUIZ" : return QUIZ;
            case "EXAM" : return EXAM;
            case "PROJECT": return PROJECT;
            case "LAB_REPORTS": return LAB_REPORTS;
            case "REFLECTION": return REFLECTION;
            case "ESSAY": return ESSAY;
            default: return null;
        }
    }
}


