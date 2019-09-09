package duke.command;

import duke.component.Storage;
import duke.exception.DukeException;
import duke.component.TaskList;
import duke.component.Ui;
import duke.component.GuiResponse;

import duke.exception.InvalidIndexException;
import duke.task.Task;

import java.io.IOException;
import java.util.List;

/**
 * Command Class for delete tasks.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructor for DeleteCommand Object.
     * @param index the index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes deletion of task from task list.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo.
     * @return boolean indication of successful or unsuccessful running of command.
     * @throws DukeException when index is invalid.
     * @throws IOException when error occurs while writing to hard disk.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists)
            throws DukeException, IOException {

        if (index >= taskList.getSize() || index < 0) {
            throw new InvalidIndexException("Invalid task number!");
        }

        TaskList record = new TaskList();
        record.replaceAll(taskList);

        historicalTaskLists.add(record);
        Task deletedTask = taskList.deleteAt(index);
        storage.save(taskList);

        assert deletedTask != null : "A task which has been deleted cannot be a null object.";

        return GuiResponse.getRemovedAcknowledgement(deletedTask, taskList.getSize());
    }
}
