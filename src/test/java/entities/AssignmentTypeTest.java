package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing the getAssignmentType method of the AssignmentType Enum class.
 * Code coverage for the AssignmentType class: 100% class, 100% methods, 100% lines
 */
public class AssignmentTypeTest {

    @Test
    public void GetAssignmentQuizTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("QUIZ"), AssignmentType.QUIZ);
    }

    @Test
    public void GetAssignmentExamTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("EXAM"), AssignmentType.EXAM);
    }

    @Test
    public void GetAssignmentProjectTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("PROJECT"), AssignmentType.PROJECT);
    }

    @Test
    public void GetAssignmentLabReportTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("LAB_REPORTS"),
                AssignmentType.LAB_REPORTS);
    }

    @Test
    public void GetAssignmentReflectionTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("REFLECTION"), AssignmentType.REFLECTION);
    }

    @Test
    public void GetAssignmentEssayTest() {
        Assertions.assertEquals(AssignmentType.getAssignmentType("ESSAY"), AssignmentType.ESSAY);
    }

    @Test
    public void GetAssignmentNullTest() {
        Assertions.assertNull(AssignmentType.getAssignmentType("Not an assigned type"));
    }
}
