package duke.command;

import duke.component.Storage;
import duke.exception.DukeException;
import duke.component.TaskList;
import duke.component.Ui;
import duke.component.GuiResponse;
import duke.exception.InvalidIndexException;

import java.io.IOException;
import java.util.List;

/**
 * Command Class for changing status of task to completed.
 */
public class DoneCommand extends Command {

    private int index;

    /**
     * Constructor for DoneCommand Object.
     * @param index index of the task whose status will be changed.
     */
    public DoneCommand(int index) {
        this.index = index;
    }


    /**
     * Executes the operation of changing the status of task to be completed.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
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
      
        taskList.replace(index, taskList.getAtIndex(index).changeToCompletedStatus());

        storage.save(taskList);

        return GuiResponse.getDoneAcknowledgement(taskList.getAtIndex(index));
    }
}
