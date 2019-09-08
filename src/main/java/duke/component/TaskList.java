package duke.component;

import duke.exception.DukeException;
import duke.task.Task;
import java.util.ArrayList;

/**
 * Class for temporary storage of tasks in the program.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor for empty TaskList object.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Constructor for TaskList object loaded with tasks from hard disk.
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Adds new task into the current task list.
     * @param newTask is the new task to be added.
     */
    public void add(Task newTask) {
        assert newTask != null : "A new task to be added cannot be a null object";
        this.taskList.add(newTask);
    }

    /**
     * Deletes task located at the certain index.
     * @param index index of the task to be deleted.
     * @return the deleted task.
     * @throws DukeException when index is invalid
     */
    public Task deleteAt(int index) throws DukeException {
        if (index >= taskList.size() || index < 0) {
            throw new DukeException("Invalid task number!");
        }
        return this.taskList.remove(index);
    }

    /**
     * Fetches task located at the certain index without deleting it.
     * @param index index of the task to be fetched.
     * @return the fetched task.
     */
    public Task getAtIndex(int index) {
        return taskList.get(index);
    }

    /**
     * Returns the size of the task list.
     * @return the size of the teas list.
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * Replaces the task located at certain index with new task.
     * @param index index of the task to be replaced.
     * @param newTask new task which replaces.
     */
    public void replace(int index, Task newTask) {
        this.taskList.set(index, newTask.changeToCompletedStatus());
    }

    /**
     * Removes all the tasks in the current list and adds all the tasks from the input task list.
     * @param newTaskList the task list whose tasks are to be appended.
     */
    public void replaceAll(TaskList newTaskList) {
        taskList.clear();
        for (Task t : newTaskList.taskList) {
            this.taskList.add(t);
        }
    }

    /**
     * Returns formatted and user-readable form of task list.
     * @return formatted and user-readable form of task list in String.
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < taskList.size(); i++) {
            result = result + "\n" + (i + 1) + ". " + taskList.get(i);
        }

        return result;
    }
}
