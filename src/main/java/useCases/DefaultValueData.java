package useCases;

import entities.AssignmentType;
import entities.Customization;
import entities.Priority;
import entities.Task;

import java.time.LocalDateTime;

public class DefaultValueData {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final int DEADLINE_HOUR = 23;
    public static final int DEADLINE_MIN = 59;

    public static final String DEFAULT_CURR_CUSTOM = Customization.NO_ITEM.getName();
    public static final String DEFAULT_NAME = "Name";
    public static final int DEFAULT_HEALTH = 10;
    public static final String DEFAULT_SKIN = "";
    public static final String[] DEFAULT_CUSTOMS = {DEFAULT_CURR_CUSTOM};
    public static final int DEFAULT_POINTS = 0;

    public static final Task EMPTY_TASK = new Task("No Task In List", "", LocalDateTime.now(), Priority.LOW, AssignmentType.ESSAY);

}
