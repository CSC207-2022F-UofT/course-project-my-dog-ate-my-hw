package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Priority Enum class.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class PriorityTest {

    // Values associated with the different Priority levels used to test the getValue method
    public static final int HIGH_VALUE = 3;
    public static final int MEDIUM_VALUE = 2;
    public static final int LOW_VALUE = 1;

    @Test
    public void GetPriorityHighTypeTest() {
        Assertions.assertEquals(Priority.getPriority("HIGH"), Priority.HIGH);
    }

    @Test
    public void GetPriorityHighValueTest() {
        Assertions.assertEquals(Priority.HIGH.getValue(), HIGH_VALUE);
    }

    @Test
    public void GetPriorityMediumTypeTest() {
        Assertions.assertEquals(Priority.getPriority("MEDIUM"), Priority.MEDIUM);
    }

    @Test
    public void GetPriorityMediumValueTest() {
        Assertions.assertEquals(Priority.MEDIUM.getValue(), MEDIUM_VALUE);
    }

    @Test
    public void GetPriorityLowTypeTest() {
        Assertions.assertEquals(Priority.getPriority("LOW"), Priority.LOW);
    }

    @Test
    public void GetPriorityLowValueTest() {
        Assertions.assertEquals(Priority.LOW.getValue(), LOW_VALUE);
    }

    @Test
    public void GetAssignmentNullTest() {
        Assertions.assertNull(Priority.getPriority("Not A Priority"));
    }
}
