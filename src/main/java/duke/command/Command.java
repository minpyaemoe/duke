package duke.command;

import duke.exception.DukeException;
import duke.component.Storage;
import duke.component.TaskList;
import duke.component.Ui;

import java.io.IOException;
import java.util.List;

/**
 * Abstract Command Class.
 */
public abstract class Command {
    /**
     * Abstract method to execute respective command.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
     * @return boolean indication of successful or unsuccessful running of command.
     * @throws DukeException when Duke error occurs.
     * @throws IOException when IO error occurs.
     */
    public abstract String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists)
            throws DukeException, IOException;
}
