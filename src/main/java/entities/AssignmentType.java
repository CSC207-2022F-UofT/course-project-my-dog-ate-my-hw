package entities;

import java.util.Objects;

/**
 * AssignmentType contain the enums for different types of assignments, like essay, quiz, exam, lab reports.
 */
public enum AssignmentType {
    ESSAY,
    QUIZ,
    EXAM,
    LAB_REPORTS,
    REFLECTION,
    PROJECT;

    public static AssignmentType getAssignmentType(String aT){
        if(Objects.equals(aT, "ESSAY")){return ESSAY;}
        else if (Objects.equals(aT, "QUIZ")) { return QUIZ;}
        else if (Objects.equals(aT, "EXAM")) { return EXAM;}
        else if (Objects.equals(aT, "LAB_REPORTS")) {return LAB_REPORTS;}
        else if(Objects.equals(aT, "REFLECTION")) {return REFLECTION;}
        else if (Objects.equals(aT, "PROJECT")) { return PROJECT;}
        return null;


    }

}