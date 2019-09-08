package duke.component;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Task;
import duke.task.Todo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class for testing TaskList class.
 */
class TaskListTest {

    private  TaskList taskList;

    /**
     * Tests add method of TaskList class.
     */
    @Test
    void addTest() {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        assertEquals(1, taskList.getSize());
    }

    /**
     * Tests deleteAt method of TaskList class.
     * @throws DukeException if index is out of bound
     */
    @Test
    void deleteAtTest() throws DukeException {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        Task deletedTask = taskList.deleteAt(0);
        assertEquals("read book", deletedTask.getDescription());
    }

    /**
     * Tests getAtIndex method of TaskList class.
     */
    @Test
    void getAtIndexTest() {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        assertEquals("read book", taskList.getAtIndex(0).getDescription());
    }

    /**
     * Tests getSize method of TaskList class.
     */
    @Test
    void getSizeTest() {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        taskList.add(new Deadline("return book", LocalDateTime.now()));
        assertEquals(2, taskList.getSize());
    }

    /**
     * Tests replace method of TaskList class.
     */
    @Test
    void replaceTest() {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        taskList.replace(0, new Todo("buy break"));
        assertEquals("buy break", taskList.getAtIndex(0).getDescription());
    }

    /**
     * Test ToString method of TaskList class.
     */
    @Test
    void toStringTest() {
        taskList = new TaskList();
        taskList.add(new Todo("read book"));
        String expected = "";

        expected = expected + "\n\t 1. " + taskList.getAtIndex(0).toString();

        assertEquals(expected, taskList.toString());
    }
}