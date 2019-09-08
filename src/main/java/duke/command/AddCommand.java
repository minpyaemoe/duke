package duke.command;

import duke.component.TaskList;
import duke.component.Storage;
import duke.component.Ui;
import duke.component.GuiResponse;

import duke.task.Task;

import java.io.IOException;
import java.util.List;

/**
 * Command Class for adding tasks.
 */
public class AddCommand extends Command {

    private Task newTask;

    /**
     * Constructor for AddCommand Object.
     * @param task task to be added.
     */
    public AddCommand(Task task) {
        this.newTask = task;
    }

    /**
     * Executes the operation of adding task into the task list.
     * @param taskList the list of tasks to be added to.
     * @param storage the storage to store inside hard disk.
     * @param ui the ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo.
     * @return boolean indication of successful or unsuccessful running of command.
     * @throws IOException when error occurs while writing to hard disk.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists)
            throws IOException {

        assert newTask != null : "A new task being added should not be a null object.";
      
        TaskList record = new TaskList();
        record.replaceAll(taskList);
        historicalTaskLists.add(record);

        taskList.add(newTask);
        storage.save(taskList);

        return GuiResponse.getAddedAcknowledgement(newTask, taskList.getSize());
    }
}
