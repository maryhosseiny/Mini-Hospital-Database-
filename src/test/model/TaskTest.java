package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static model.TaskType.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task testTaskOne;
    private Task testTaskTwo;
    private Task testTaskThree;

    @BeforeEach
    public void setUp() {
        testTaskOne = new Task(false, "Doing dishes", "12/6/2023", CHORE) ;
        testTaskTwo = new Task(false, "Finish assignment", "1/1/2024", SCHOOL) ;
        testTaskThree = new Task(true, "Soccer", "2/2/2022", EXTRACURRICULAR) ;
    }

    @Test
    public void testGetters() {
        assertFalse(testTaskOne.getStatus());
        assertEquals(testTaskOne.getTitle(), "Doing dishes");
        assertEquals(testTaskTwo.getTaskType(), SCHOOL);
        assertEquals(testTaskThree.getDate(), "2/2/2022");
    }

    @Test
    public void testUpdateStatus() {
        testTaskOne.updateStatus(true);
        assertTrue(testTaskOne.getStatus());
        testTaskOne.updateStatus(false);
        assertFalse(testTaskOne.getStatus());
    }

    @Test
    public void testUpdateDate() {
        testTaskOne.updateDate("23/4/2025");
        assertEquals(testTaskOne.getDate(), "23/4/2025");
    }

    @Test
    public void testUpdateTitle() {
        testTaskOne.updateTitle("Vacuum");
        assertEquals(testTaskOne.getTitle(), "Vacuum");
    }

    @Test
    public void testUpdateTaskType() {
        testTaskOne.updateTaskType(SCHOOL);
        assertEquals(testTaskOne.getTaskType(), SCHOOL);
        testTaskOne.updateTaskType(CHORE);
        assertEquals(testTaskOne.getTaskType(), CHORE);
        testTaskTwo.updateTaskType(EXTRACURRICULAR);
        assertEquals(testTaskTwo.getTaskType(), EXTRACURRICULAR);
        testTaskOne.updateTaskType(EXERCISE);
        assertEquals(testTaskOne.getTaskType(), EXERCISE);
    }


}
