package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static model.TaskType.*;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    private ToDoList testTaskSet;
    private final Task testTaskOne = new Task(true, "Doing dishes", "12/6/2023", CHORE) ;
    private final Task testTaskTwo = new Task(true, "Finish assignment", "1/1/2024", SCHOOL) ;
    private final Task testTaskThree = new Task(false, "Soccer", "2/2/2022", EXTRACURRICULAR) ;

    @BeforeEach
    public void setUp() {
        testTaskSet = new ToDoList();
    }

    @Test
    public void testToDoListConstructor() {
        assertEquals(testTaskSet.size(), 0);
        assertFalse(testTaskSet.contains(testTaskOne));
    }

    @Test
    public void testRetrieveNumberCompletedTasks() {
        assertEquals(testTaskSet.retrieveNumberCompletedTasks(),0);
        testTaskSet.insert(testTaskThree);
        assertEquals(testTaskSet.retrieveNumberCompletedTasks(), 0);
        testTaskSet.insert(testTaskTwo);
        assertEquals(testTaskSet.retrieveNumberCompletedTasks(), 1);
        testTaskSet.insert(testTaskOne);
        assertEquals(testTaskSet.retrieveNumberCompletedTasks(),2);

    }

    @Test
    public void testRetrieveNumberIncompleteTasks() {
        assertEquals(testTaskSet.retrieveNumberIncompleteTasks(),0);
        testTaskSet.insert(testTaskThree);
        assertEquals(testTaskSet.retrieveNumberIncompleteTasks(), 1);
        testTaskSet.insert(testTaskTwo);
        assertEquals(testTaskSet.retrieveNumberIncompleteTasks(), 1);
        testTaskSet.insert(testTaskOne);
        assertEquals(testTaskSet.retrieveNumberIncompleteTasks(),1);

    }

    @Test
    public void testInsert() {
        assertEquals(testTaskSet.size(), 0);
        testTaskSet.insert(testTaskThree);
        assertEquals(testTaskSet.size(), 1);
        testTaskSet.insert(testTaskTwo);
        assertEquals(testTaskSet.size(), 2);
        testTaskSet.insert(testTaskOne);
        testTaskSet.insert(testTaskThree);
        assertEquals(testTaskSet.size(), 3);

    }

    @Test
    public void testRemove() {
        testTaskSet.insert(testTaskThree);
        testTaskSet.insert(testTaskTwo);
        testTaskSet.insert(testTaskOne);
        assertEquals(testTaskSet.size(), 3);
        testTaskSet.remove(testTaskOne);
        assertEquals(testTaskSet.size(), 2);
        testTaskSet.remove(testTaskOne);
        assertEquals(testTaskSet.size(), 2);
        testTaskSet.remove(testTaskTwo);
        testTaskSet.remove(testTaskThree);
        assertEquals(testTaskSet.size(), 0);

    }

    @Test
    public void testContains() {
        assertFalse(testTaskSet.contains(testTaskOne));
        testTaskSet.insert(testTaskThree);
        testTaskSet.insert(testTaskTwo);
        assertFalse(testTaskSet.contains(testTaskOne));
        assertTrue(testTaskSet.contains(testTaskTwo));
        testTaskSet.insert(testTaskOne);
        assertTrue(testTaskSet.contains(testTaskOne));
        testTaskSet.remove(testTaskOne);
        assertFalse(testTaskSet.contains(testTaskOne));
    }

    @Test
    public void testGetTaskList() {
        testTaskSet.insert(testTaskThree);
        testTaskSet.insert(testTaskTwo);
        testTaskSet.insert(testTaskOne);

    }

}
